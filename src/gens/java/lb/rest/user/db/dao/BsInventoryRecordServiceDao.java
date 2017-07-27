package lb.rest.user.db.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsInventoryRecord;
import lb.rest.user.db.entity.BsInventoryRecordExample;
import lb.rest.user.db.entity.BsInventoryRecordKey;
import lb.rest.user.db.mapper.BsInventoryRecordMapper;
import lb.rest.user.db.mapper.CommonMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Repository;

import com.mlb.util.SequenceUtil;

import fc.wpf.rest.utils.BeanFactory;
import fc.wpf.rest.utils.DateStyle;
import fc.wpf.rest.utils.DateUtil;

@Slf4j
@Repository
public class BsInventoryRecordServiceDao {

	private BsInventoryRecordMapper bsInventoryRecordMapper = (BsInventoryRecordMapper) BeanFactory
			.getBean("bsInventoryRecordMapper");

	private BsSequenceDao bsSequenceDao = (BsSequenceDao) BeanFactory.getBean("bsSequenceDao");

	@Resource
	private CommonMapper commonMapper;

	/**
	 * 插入记录
	 * 
	 * @param @param record
	 * @param @return
	 * @return int
	 * @throws
	 * @date 2017年3月28日下午6:48:33
	 */
	public int insert(BsInventoryRecord record) {
		int flag = 0;
		try {
			String dateTime = record.getDate() + " " + "00:00:00";
			record.setRecordTime(DateUtil.getDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue(), dateTime));
			// BsInventoryRecord bs =
			// getBsInventoryRecordOrdreByTime(record.getGrainType(),record.getUserId(),record.getRecordTime());
			int depotId = record.getDepotId() == null ? 0 : record.getDepotId();

			record.setRecordNumber(bsSequenceDao.nextValue(depotId, record.getUserId(), record.getGrainType(),
					record.getRecordType())
					+ "");

			BsInventoryRecord bs = getBsInventoryRecordOrdreNumber(depotId, record.getGrainType(), record.getUserId(),
					record.getRecordTime());
			int number = 1;
			if (bs != null) {
				number = bs.getIntColumn1() + 1;
			} else {
				bs = getBsInventoryRecordOrdreNumberAndRecordTimeDesc(depotId, record.getGrainType(),
						record.getUserId(), record.getRecordTime());
			}
			record.setIntColumn1(number);

			double net_weight_in = 0; // '净重（入库）',
			double money_in = 0; // '金额（入库）',
			double net_weight_out = 0; // '净重（出库',
			double money_out = 0; // '金额（出库',

			double money_in_total = 0; // '累计金额（入库）',
			double in_total = 0; // '累计入库公斤数',
			double average_price_in = 0; // '入库均价（入库总金额/入库吨数）', 平均成本 入库金额总和 /
											// 入库净重总和。
			double money_out_total = 0; // '累计金额（出库）',

			double balance = 0; // 库存公斤数 = 剩余公斤+当前入库公斤-当前出库公斤
			double inventory_cost = 0; // 库存成本（金额） （累计入库金额 - 累计出库金额）
			double inventory_money = 0; // 库存（金额） 当前剩余公斤*当前平成本
			double total_profit = 0; // 累计利润 库存金额+截止累计出库金额-截止累计入库金额
			double profit = 0; // 交易利润 每笔利润 当前批次累积利润-上批次累积利润

			if (record.getRecordType() == 1) {// '出库或入库{1:入库,2:出库;}',
				net_weight_in = record.getNetWeightIn(); // '净重（入库）',
				money_in = record.getMoneyIn(); // '金额（入库）',
				if (bs != null) {
					in_total = bs.getInTotal() + net_weight_in;// '累计入库公斤数',
					money_in_total = bs.getMoneyInTotal() + money_in;// '累计金额（入库）',
					average_price_in = Doublediv(money_in_total, in_total, 3);// '入库均价（入库总金额/入库吨数）',
																				// 平均成本
																				// 入库金额总和
																				// /
																				// 入库净重总和。
					money_out_total = bs.getMoneyOutTotal();// '累计金额（出库）',
					balance = bs.getBalance() + net_weight_in;// 库存公斤数 =
																// 剩余公斤+当前入库公斤-当前出库公斤
					inventory_cost = money_in_total - money_out_total;// 库存成本（金额）
																		// （累计入库金额
																		// -
																		// 累计出库金额）
					if (in_total != 0) {
						inventory_money = balance * money_in_total / in_total; // 库存（金额）
																				// 当前剩余公斤*当前平成本
					}
					total_profit = inventory_money + money_out_total - money_in_total; // 累计利润
																						// 库存金额+截止累计出库金额-截止累计入库金额
					profit = total_profit - bs.getTotalProfit(); // 当前批次累积利润-上批次累积利润
				} else {
					in_total = net_weight_in;// '累计入库公斤数',
					money_in_total = money_in;// '累计金额（入库）',
					average_price_in = Doublediv(money_in_total, in_total, 3);// '入库均价（入库总金额/入库吨数）',
																				// 平均成本
																				// 入库金额总和
																				// /
																				// 入库净重总和。
					// money_out_total = bs.getMoneyOutTotal();//'累计金额（出库）',
					balance = net_weight_in;// 库存公斤数 = 剩余公斤+当前入库公斤-当前出库公斤
					inventory_cost = money_in_total - money_out_total;// 库存成本（金额）
																		// （累计入库金额
																		// -
																		// 累计出库金额）
					if (in_total != 0) {
						inventory_money = balance * money_in_total / in_total; // 库存（金额）
																				// 当前剩余公斤*当前平成本
					}
					total_profit = inventory_money + money_out_total - money_in_total; // 累计利润
																						// 库存金额+截止累计出库金额-截止累计入库金额
					profit = total_profit; // 当前批次累积利润-上批次累积利润
				}
				record.setInTotal(in_total);
				record.setMoneyInTotal(money_in_total);
				record.setAveragePriceIn(average_price_in);
				if (record.getPaidMoney() == null) {
					record.setPaidMoney(0.0);
				}
				
				record.setUnpaidMoney(record.getMoneyIn() - record.getPaidMoney());
			} else {
				net_weight_out = record.getNetWeightOut(); // '净重（出库',
				money_out = record.getMoneyOut(); // '金额（出库',
				if (bs != null) {
					money_out_total = money_out + bs.getMoneyOutTotal();
					balance = bs.getBalance() - net_weight_out; // 库存公斤数 =
																// 剩余公斤+当前入库公斤-当前出库公斤
					inventory_cost = bs.getMoneyInTotal() - money_out_total; // 库存成本（金额）
																				// （累计入库金额
																				// -
																				// 累计出库金额）
					if (bs.getInTotal() != null && bs.getInTotal() != 0) {
						inventory_money = balance * bs.getMoneyInTotal() / bs.getInTotal(); // 库存（金额）
																							// 当前剩余公斤*当前平成本*
																							// bs.getAveragePriceIn()
					}
					total_profit = inventory_money + money_out_total - bs.getMoneyInTotal(); // 累计利润
																								// 库存金额+截止累计出库金额-截止累计入库金额
					profit = total_profit - bs.getTotalProfit(); // 当前批次累积利润-上批次累积利润
					record.setInTotal(bs.getInTotal());// 累计入库公斤数
					record.setMoneyInTotal(bs.getMoneyInTotal());// 累计金额（入库）
					record.setAveragePriceIn(bs.getAveragePriceIn());// 平均成本
				} else {
					money_out_total = money_out;
					balance = 0 - net_weight_out; // 库存公斤数 = 剩余公斤+当前入库公斤-当前出库公斤
					inventory_cost = 0 - money_out_total; // 库存成本（金额） （累计入库金额 -
															// 累计出库金额）
					inventory_money = balance * 0; // 库存（金额） 当前剩余公斤*当前平成本
					total_profit = inventory_money + money_out_total; // 累计利润
																		// 库存金额+截止累计出库金额-截止累计入库金额
					profit = total_profit; // 当前批次累积利润-上批次累积利润

					record.setInTotal(0.0);// 累计入库公斤数
					record.setMoneyInTotal(0.0);// 累计金额（入库）
					record.setAveragePriceIn(0.0);// 平均成本

				}
				if (record.getPaidMoney() == null) {
					record.setPaidMoney(0.0);
				}
				record.setUnpaidMoney(record.getMoneyOut() - record.getPaidMoney());
			}
			record.setMoneyOutTotal(money_out_total);
			record.setBalance(balance);
			record.setInventoryCost(inventory_cost);
			record.setInventoryMoney(inventory_money);
			record.setTotalProfit(total_profit);
			record.setProfit(profit);

			flag = bsInventoryRecordMapper.insert(record);

			// //查询此人录入的出入库大于当前时间并且ID不等于当前ID的出入库记录，并且按照时间和ID进行排序操作。
			// List<BsInventoryRecord> list =
			// getBsInventoryRecordOrdreByTimeAsc(record.getGrainType(),record.getUserId(),record.getRecordTime(),record.getId());
			List<BsInventoryRecord> list = getBsInventoryRecordOrdreNumberAndRecordTimeAsc(depotId,
					record.getGrainType(), record.getUserId(), record.getRecordTime());
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					if (i == 0) {
						update2(list.get(i), record);
					} else {
						update2(list.get(i), list.get(i - 1));
					}
				}
			}

		} catch (Exception e) {
			log.error("保存 出入库记录 " + e);
			return 0;
		}
		return flag;
	}

	/**
	 * 更新记录
	 * 
	 * @param @param record
	 * @param @return
	 * @return int
	 * @throws
	 * @date 2017年3月28日下午6:48:15
	 */
	public int update(BsInventoryRecord record) {
		int flag = 0;
		try {
			int depotId = record.getDepotId() == null ? 0 : record.getDepotId();

			String dateTime = record.getDate() + " " + "00:00:00";
			record.setRecordTime(DateUtil.getDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue(), dateTime));
			BsInventoryRecordKey key = new BsInventoryRecordKey();
			key.setId(record.getId());
			BsInventoryRecord history = bsInventoryRecordMapper.selectByPrimaryKey(key);
			record.setIntColumn1(history.getIntColumn1());
			record.setPaidMoney(history.getPaidMoney() != null ? history.getPaidMoney() : 0.0);
			// 判断是否修改了类型
			if (history.getGrainType() != record.getGrainType()) {
				// 删除原有记录
				deleteByExample(record.getId());
				record.setId(SequenceUtil.getInstance().nextValue("bs_inventory_record"));
				record.setCreateTime(new Date());
				flag = insert(record);
			} else {
				if (record.getRecordTime().getTime() < history.getRecordTime().getTime()) {
					// 如果修改时间在本条时间的前，计算，获取前一条数据，并查询之后的数据
					// 获取前一条数据
					BsInventoryRecord bs = getBsInventoryRecordOrdreNumber(depotId, record.getGrainType(),
							record.getUserId(), record.getRecordTime());
					int number = 1;
					if (bs != null) {
						number = bs.getIntColumn1() + 1;
					} else {
						// 获取前一条数据
						bs = getBsInventoryRecordOrdreNumberAndRecordTimeDesc(depotId, record.getGrainType(),
								record.getUserId(), record.getRecordTime());
					}
					record.setIntColumn1(number);
					flag = update2(record, bs);
					// 获取之后的
					List<BsInventoryRecord> list = getBsInventoryRecordOrdreNumberAndRecordTimeAsc(depotId,
							record.getGrainType(), record.getUserId(), record.getRecordTime());
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							if (i == 0) {
								update2(list.get(i), record);
							} else {
								update2(list.get(i), list.get(i - 1));
							}
						}
					}
				} else if (record.getRecordTime().getTime() > history.getRecordTime().getTime()) {
					// 获取前一条数据
					BsInventoryRecord bs = getBsInventoryRecordOrdreNumber(depotId, record.getGrainType(),
							record.getUserId(), record.getRecordTime());
					int number = 1;
					if (bs != null) {
						number = bs.getIntColumn1() + 1;
					} else {
						// 获取前一条数据
						bs = getBsInventoryRecordOrdreNumberAndRecordTimeDesc(depotId, record.getGrainType(),
								record.getUserId(), record.getRecordTime());
					}
					record.setIntColumn1(number);
					flag = update2(record, bs);
					// 从历史的 往后算，不用计算 ，查询之后的数据 并计算。
					// 1/计算当天的数据
					List<BsInventoryRecord> list = getBsInventoryRecordOrdreNumberAndRecordEq(history.getDepotId(),
							history.getGrainType(), history.getUserId(), history.getRecordTime(),
							history.getIntColumn1());
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							if (i == 0) {
								// 当天有没有比次序号小的一条
								record = getDtByNumber(list.get(i).getDepotId(), list.get(i).getGrainType(), list
										.get(i).getUserId(), list.get(i).getRecordTime(), list.get(i).getIntColumn1());
								if (record == null) {
									record = getBsInventoryRecordOrdreNumberAndRecordTimeDesc(list.get(i).getDepotId(),
											list.get(i).getGrainType(), list.get(i).getUserId(), list.get(i)
													.getRecordTime());
								}
								update2(list.get(i), record);
							} else {
								update2(list.get(i), list.get(i - 1));
							}
						}
					}
					// 如果当天没有，就算后一天的数据
					// 查询比当前日期大一天的数据
					list = new ArrayList<BsInventoryRecord>();
					list = getBsInventoryRecordOrdreNumberAndRecordTimeAsc(history.getDepotId(),
							history.getGrainType(), history.getUserId(), history.getRecordTime());
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							if (i == 0) {
								BsInventoryRecord br = getBsInventoryRecordOrdreNumberAndRecordTimeDesc(list.get(i)
										.getDepotId(), list.get(i).getGrainType(), list.get(i).getUserId(), list.get(i)
										.getRecordTime());
								update2(list.get(i), br);
							} else {
								update2(list.get(i), list.get(i - 1));
							}
						}
					}
				} else {
					// 时间没有修改，查前一条数据，要查之后的数据
					/**
					 * 2017/04/09 15:57 修改原因，record.getIntColumn1() 为空，
					 * 保存空指针。现修改record.getIntColumn1()为 1；后续根据逻辑修改，之前代码注释掉
					 * history
					 */
					// BsInventoryRecord bs =
					// getDtByNumber(record.getGrainType(),record.getUserId(),record.getRecordTime(),record.getIntColumn1());
					BsInventoryRecord bs = getDtByNumber(depotId, record.getGrainType(), record.getUserId(),
							record.getRecordTime(), record.getIntColumn1());
					if (bs == null) {
						bs = getBsInventoryRecordOrdreNumberAndRecordTimeDesc(depotId, record.getGrainType(),
								record.getUserId(), record.getRecordTime());
					}
					flag = update2(record, bs);
					// 查询 比当前时间大的序号
					List<BsInventoryRecord> list = getDtByNumberGreaterThan(depotId, record.getGrainType(),
							record.getUserId(), record.getRecordTime(), record.getIntColumn1());
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							if (i == 0) {
								update2(list.get(i), record);
							} else {
								update2(list.get(i), list.get(i - 1));
							}
							record = list.get(i);
						}
					}
					List<BsInventoryRecord> list2 = getBsInventoryRecordOrdreNumberAndRecordTimeAsc(depotId,
							record.getGrainType(), record.getUserId(), record.getRecordTime());
					if (list2 != null && list2.size() > 0) {
						for (int i = 0; i < list2.size(); i++) {
							if (i == 0) {
								update2(list2.get(i), record);
							} else {
								update2(list2.get(i), list2.get(i - 1));
							}
						}
					}
				}

				// BsInventoryRecord bs =
				// getBsInventoryRecordOrdreByTime(record.getGrainType(),record.getUserId(),record.getRecordTime(),record.getId(),record.getCreateTime());
				// BsInventoryRecord bs =
				// getBsInventoryRecordOrdreByTime(record.getGrainType(),record.getUserId(),record.getRecordTime(),record.getId(),record.getCreateTime());
				//
				//
				// //查询此人录入的出入库大于当前时间并且ID不等于当前ID的出入库记录，并且按照时间和ID进行排序操作。
				// List<BsInventoryRecord> list =
				// getBsInventoryRecordOrdreByTimeAsc(record.getGrainType(),record.getUserId(),record.getRecordTime(),record.getId());
				//
				// if(list != null && list.size() > 0){
				// for (int i = 0;i<list.size() ;i++) {
				// if(i == 0){
				// update2(list.get(i),record);
				// }else{
				// update2(list.get(i),list.get(i-1));
				// }
				// }
				// }

			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("更新出入库记录update " + e);
			return 0;
		}
		return flag;
	}

	/**
	 * 更新记录
	 * 
	 * @param @param record
	 * @param @return
	 * @return int
	 * @throws
	 * @date 2017年3月28日下午6:48:15
	 */
	public int update2(BsInventoryRecord record, BsInventoryRecord bs) {
		int flag = 0;
		try {
			// String dateTime = record.getDate()+" "+"00:00:00";
			// record.setRecordTime(DateUtil.getDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue(),
			// dateTime));
			// BsInventoryRecord bs =
			// getBsInventoryRecordOrdreByTime(record.getGrainType(),record.getUserId(),record.getRecordTime(),record.getId(),record.getCreateTime());
			double net_weight_in = 0; // '净重（入库）',
			double money_in = 0; // '金额（入库）',
			double net_weight_out = 0; // '净重（出库',
			double money_out = 0; // '金额（出库',

			double money_in_total = 0; // '累计金额（入库）',
			double in_total = 0; // '累计入库公斤数',
			double average_price_in = 0; // '入库均价（入库总金额/入库吨数）', 平均成本 入库金额总和 /
											// 入库净重总和。
			double money_out_total = 0; // '累计金额（出库）',

			double balance = 0; // 库存公斤数 = 剩余公斤+当前入库公斤-当前出库公斤
			double inventory_cost = 0; // 库存成本（金额） （累计入库金额 - 累计出库金额）
			double inventory_money = 0; // 库存（金额） 当前剩余公斤*当前平成本
			double total_profit = 0; // 累计利润 库存金额+截止累计出库金额-截止累计入库金额
			double profit = 0; // 交易利润 每笔利润 当前批次累积利润-上批次累积利润

			if (record.getRecordType() == 1) {// '出库或入库{1:入库,2:出库;}',
				net_weight_in = record.getNetWeightIn(); // '净重（入库）',
				money_in = record.getMoneyIn(); // '金额（入库）',
				if (bs != null) {
					in_total = bs.getInTotal() + net_weight_in;// '累计入库公斤数',
					money_in_total = bs.getMoneyInTotal() + money_in;// '累计金额（入库）',
					average_price_in = Doublediv(money_in_total, in_total, 3);// '入库均价（入库总金额/入库吨数）',
																				// 平均成本
																				// 入库金额总和
																				// /
																				// 入库净重总和。
					money_out_total = bs.getMoneyOutTotal();// '累计金额（出库）',
					balance = bs.getBalance() + net_weight_in;// 库存公斤数 =
																// 剩余公斤+当前入库公斤-当前出库公斤
					inventory_cost = money_in_total - money_out_total;// 库存成本（金额）
																		// （累计入库金额
																		// -
																		// 累计出库金额）
					if (in_total != 0) {
						inventory_money = balance * money_in_total / in_total; // 库存（金额）
																				// 当前剩余公斤*当前平成本
					}
					total_profit = inventory_money + money_out_total - money_in_total; // 累计利润
																						// 库存金额+截止累计出库金额-截止累计入库金额
					profit = total_profit - bs.getTotalProfit(); // 当前批次累积利润-上批次累积利润
				} else {
					in_total = net_weight_in;// '累计入库公斤数',
					money_in_total = money_in;// '累计金额（入库）',
					if (in_total != 0) {
						average_price_in = Doublediv(money_in_total, in_total, 3);// '入库均价（入库总金额/入库吨数）',
																					// 平均成本
																					// 入库金额总和
																					// /
																					// 入库净重总和。
					}
					// money_out_total = bs.getMoneyOutTotal();//'累计金额（出库）',
					balance = net_weight_in;// 库存公斤数 = 剩余公斤+当前入库公斤-当前出库公斤
					inventory_cost = money_in_total - money_out_total;// 库存成本（金额）
																		// （累计入库金额
																		// -
																		// 累计出库金额）
					if (in_total != 0) {
						inventory_money = balance * money_in_total / in_total; // 库存（金额）
																				// 当前剩余公斤*当前平成本
					}
					total_profit = inventory_money + money_out_total - money_in_total; // 累计利润
																						// 库存金额+截止累计出库金额-截止累计入库金额
					profit = total_profit; // 当前批次累积利润-上批次累积利润
				}
				record.setInTotal(in_total);
				record.setMoneyInTotal(money_in_total);
				record.setAveragePriceIn(average_price_in);
				record.setUnpaidMoney(record.getMoneyIn() - record.getPaidMoney());

			} else {
				net_weight_out = record.getNetWeightOut(); // '净重（出库',
				money_out = record.getMoneyOut(); // '金额（出库',
				if (bs != null) {
					money_out_total = money_out + bs.getMoneyOutTotal();
					balance = bs.getBalance() - net_weight_out; // 库存公斤数 =
																// 剩余公斤+当前入库公斤-当前出库公斤
					inventory_cost = bs.getMoneyInTotal() - money_out_total; // 库存成本（金额）
																				// （累计入库金额
																				// -
																				// 累计出库金额）
					if (bs.getInTotal() != null && bs.getInTotal() != 0) {
						inventory_money = balance * bs.getMoneyInTotal() / bs.getInTotal(); // 库存（金额）
																							// 当前剩余公斤*当前平成本*
																							// bs.getAveragePriceIn()
					}
					total_profit = inventory_money + money_out_total - bs.getMoneyInTotal(); // 累计利润
																								// 库存金额+截止累计出库金额-截止累计入库金额
					profit = total_profit - bs.getTotalProfit(); // 当前批次累积利润-上批次累积利润
					record.setInTotal(bs.getInTotal());// 累计入库公斤数
					record.setMoneyInTotal(bs.getMoneyInTotal());// 累计金额（入库）
					record.setAveragePriceIn(bs.getAveragePriceIn());// 平均成本
				} else {
					money_out_total = money_out;
					balance = 0 - net_weight_out; // 库存公斤数 = 剩余公斤+当前入库公斤-当前出库公斤
					inventory_cost = 0 - money_out_total; // 库存成本（金额） （累计入库金额 -
															// 累计出库金额）
					inventory_money = balance * 0; // 库存（金额） 当前剩余公斤*当前平成本
					total_profit = inventory_money + money_out_total; // 累计利润
																		// 库存金额+截止累计出库金额-截止累计入库金额
					profit = total_profit; // 当前批次累积利润-上批次累积利润

					record.setInTotal(0.0);// 累计入库公斤数
					record.setMoneyInTotal(0.0);// 累计金额（入库）
					record.setAveragePriceIn(0.0);// 平均成本

				}
				record.setUnpaidMoney(record.getMoneyOut() - record.getPaidMoney());
			}
			record.setMoneyOutTotal(money_out_total);
			record.setBalance(balance);
			record.setInventoryCost(inventory_cost);
			record.setInventoryMoney(inventory_money);
			record.setTotalProfit(total_profit);
			record.setProfit(profit);
			flag = bsInventoryRecordMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			log.error("更新出入库记录update1 " + e);
		}
		return flag;
	}

	// /**
	// * 更新记录
	// * @param @param record
	// * @param @return
	// * @return int
	// * @throws
	// * @date 2017年3月28日下午6:48:15
	// */
	// public int update1(BsInventoryRecord record) {
	// int flag = 0;
	// try {
	// String dateTime = record.getDate()+" "+"00:00:00";
	// record.setRecordTime(DateUtil.getDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue(),
	// dateTime));
	// BsInventoryRecord bs =
	// getBsInventoryRecordOrdreByTime(record.getGrainType(),record.getUserId(),record.getRecordTime(),record.getId(),record.getCreateTime());
	// double net_weight_in = 0; //'净重（入库）',
	// double money_in = 0; //'金额（入库）',
	// double net_weight_out = 0; //'净重（出库',
	// double money_out = 0; //'金额（出库',
	//
	// double money_in_total = 0; //'累计金额（入库）',
	// double in_total = 0; //'累计入库公斤数',
	// double average_price_in = 0; //'入库均价（入库总金额/入库吨数）', 平均成本 入库金额总和 / 入库净重总和。
	// double money_out_total = 0; //'累计金额（出库）',
	//
	// double balance = 0; //库存公斤数 = 剩余公斤+当前入库公斤-当前出库公斤
	// double inventory_cost = 0; //库存成本（金额） （累计入库金额 - 累计出库金额）
	// double inventory_money = 0; //库存（金额） 当前剩余公斤*当前平成本
	// double total_profit = 0; //累计利润 库存金额+截止累计出库金额-截止累计入库金额
	// double profit = 0; //交易利润 每笔利润 当前批次累积利润-上批次累积利润
	//
	// if(record.getRecordType() == 1){//'出库或入库{1:入库,2:出库;}',
	// net_weight_in = record.getNetWeightIn(); //'净重（入库）',
	// money_in = record.getMoneyIn(); //'金额（入库）',
	// if(bs != null){
	// in_total = bs.getInTotal() + net_weight_in;//'累计入库公斤数',
	// money_in_total = bs.getMoneyInTotal() + money_in;//'累计金额（入库）',
	// average_price_in = Doublediv(money_in_total
	// ,in_total,3);//'入库均价（入库总金额/入库吨数）', 平均成本 入库金额总和 / 入库净重总和。
	// money_out_total = bs.getMoneyOutTotal();//'累计金额（出库）',
	// balance = bs.getBalance() + net_weight_in ;//库存公斤数 = 剩余公斤+当前入库公斤-当前出库公斤
	// inventory_cost = money_in_total - money_out_total;//库存成本（金额） （累计入库金额 -
	// 累计出库金额）
	// if(in_total != 0){
	// inventory_money = balance * money_in_total / in_total ; //库存（金额）
	// 当前剩余公斤*当前平成本
	// }
	// total_profit = inventory_money + money_out_total - money_in_total; //累计利润
	// 库存金额+截止累计出库金额-截止累计入库金额
	// profit = total_profit - bs.getTotalProfit(); // 当前批次累积利润-上批次累积利润
	// }else{
	// in_total = net_weight_in;//'累计入库公斤数',
	// money_in_total = money_in;//'累计金额（入库）',
	// average_price_in = Doublediv(money_in_total
	// ,in_total,3);//'入库均价（入库总金额/入库吨数）', 平均成本 入库金额总和 / 入库净重总和。
	// // money_out_total = bs.getMoneyOutTotal();//'累计金额（出库）',
	// balance = net_weight_in ;//库存公斤数 = 剩余公斤+当前入库公斤-当前出库公斤
	// inventory_cost = money_in_total - money_out_total;//库存成本（金额） （累计入库金额 -
	// 累计出库金额）
	// if(in_total != 0){
	// inventory_money = balance * money_in_total / in_total ; //库存（金额）
	// 当前剩余公斤*当前平成本
	// }
	// total_profit = inventory_money + money_out_total - money_in_total; //累计利润
	// 库存金额+截止累计出库金额-截止累计入库金额
	// profit = total_profit ; // 当前批次累积利润-上批次累积利润
	// }
	// record.setInTotal(in_total);
	// record.setMoneyInTotal(money_in_total);
	// record.setAveragePriceIn(average_price_in);
	// }else{
	// net_weight_out = record.getNetWeightOut(); //'净重（出库',
	// money_out = record.getMoneyOut(); //'金额（出库',
	// if(bs != null){
	// money_out_total = money_out + bs.getMoneyOutTotal();
	// balance = bs.getBalance() - net_weight_out; //库存公斤数 = 剩余公斤+当前入库公斤-当前出库公斤
	// inventory_cost = bs.getMoneyInTotal()- money_out_total; // 库存成本（金额）
	// （累计入库金额 - 累计出库金额）
	// if(bs.getInTotal() != null && bs.getInTotal() != 0){
	// inventory_money = balance * bs.getMoneyInTotal() / bs.getInTotal() ;
	// //库存（金额） 当前剩余公斤*当前平成本* bs.getAveragePriceIn()
	// }
	// total_profit = inventory_money + money_out_total - bs.getMoneyInTotal();
	// //累计利润 库存金额+截止累计出库金额-截止累计入库金额
	// profit = total_profit - bs.getTotalProfit(); // 当前批次累积利润-上批次累积利润
	// record.setInTotal(bs.getInTotal());//累计入库公斤数
	// record.setMoneyInTotal(bs.getMoneyInTotal());//累计金额（入库）
	// record.setAveragePriceIn(bs.getAveragePriceIn());// 平均成本
	// }else{
	// money_out_total = money_out ;
	// balance = 0-net_weight_out; //库存公斤数 = 剩余公斤+当前入库公斤-当前出库公斤
	// inventory_cost = 0-money_out_total; // 库存成本（金额） （累计入库金额 - 累计出库金额）
	// inventory_money = balance * 0; //库存（金额） 当前剩余公斤*当前平成本
	// total_profit = inventory_money + money_out_total ; //累计利润
	// 库存金额+截止累计出库金额-截止累计入库金额
	// profit = total_profit ; // 当前批次累积利润-上批次累积利润
	//
	// record.setInTotal(0.0);//累计入库公斤数
	// record.setMoneyInTotal(0.0);//累计金额（入库）
	// record.setAveragePriceIn(0.0);// 平均成本
	//
	// }
	// }
	// record.setMoneyOutTotal(money_out_total);
	// record.setBalance(balance);
	// record.setInventoryCost(inventory_cost);
	// record.setInventoryMoney(inventory_money);
	// record.setTotalProfit(total_profit);
	// record.setProfit(profit);
	// flag = bsInventoryRecordMapper.updateByPrimaryKeySelective(record);
	// } catch (Exception e) {
	// log.error("更新出入库记录update1 "+e);
	// }
	// return flag;
	// }

	/**
	 * 查询 玉米 小麦 出入库的编号和时间
	 * 
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 * @date 2017年3月28日上午11:02:20
	 */
	public Map<String, Object> getBsInventoryRecordOrdreByTimeAll(int depotId, int userid, int type) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mp = new HashMap<String, Object>();
		List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();
		try {
			if (type == 1) {
				int rkym = bsSequenceDao.nextValue(depotId, userid, 2, 1);// 玉米入库
				int rkxm = bsSequenceDao.nextValue(depotId, userid, 1, 1);// 小麦入库
				int rksd = bsSequenceDao.nextValue(depotId, userid, 3, 1);// 水稻入库
				mp.put("rk_ym_number", rkym);// 入库
				mp.put("rk_xm_number", rkxm);// 入库
				mp.put("rk_sd_number", rksd);// 入库
			} else {
				// int userId, int grainType, int recordType
				int ckym = bsSequenceDao.nextValue(depotId, userid, 2, 2);// 玉米出库
				int ckxm = bsSequenceDao.nextValue(depotId, userid, 1, 2);// 小麦出库
				int cksd = bsSequenceDao.nextValue(depotId, userid, 3, 2);// 水稻出库
				mp.put("ck_ym_number", ckym);// 出库
				mp.put("ck_xm_number", ckxm);// 出库
				mp.put("ck_sd_number", cksd);// 出库
			}
			maplist.add(mp);
			map.put("dataList", maplist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * 查询比本条数据时间大的出入库条数
	 * 
	 * @param @param grainType
	 * @param @return
	 * @return BsInventoryRecord
	 * @throws
	 * @date 2017年3月28日上午11:01:53
	 */
	public List<BsInventoryRecord> getBsInventoryRecordOrdreByTimeAsc(int depotId, int grainType, int userid,
			Date recordTime) {
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeGreaterThanOrEqualTo(recordTime);
		recordExample.setOrderByClause("record_time,create_time ");
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		return ckxm;
	}

	/**
	 * 查询比本条数据时间大的出入库条数
	 * 
	 * @param @param grainType
	 * @param @return
	 * @return BsInventoryRecord
	 * @throws
	 * @date 2017年3月28日上午11:01:53
	 */
	public List<BsInventoryRecord> getBsInventoryRecordOrdreByTimeAsc(int depotId, int grainType, int userid,
			Date recordTime, int id) {
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeGreaterThanOrEqualTo(recordTime).andIdNotEqualTo(id);
		recordExample.setOrderByClause("record_time,create_time ");
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		return ckxm;
	}

	/**
	 * 查询比本条数据时间大的出入库条数
	 * 
	 * @param @param grainType
	 * @param @return
	 * @return BsInventoryRecord
	 * @throws
	 * @date 2017年3月28日上午11:01:53
	 */
	public List<BsInventoryRecord> getBsInventoryRecordOrdreByTimeAsc(int depotId, int grainType, int userid,
			Date recordTime, int id, Date createTime) {
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeGreaterThanOrEqualTo(recordTime).andIdNotEqualTo(id)
				.andCreateTimeGreaterThanOrEqualTo(createTime);
		recordExample.setOrderByClause("record_time,create_time ");
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		return ckxm;
	}

	/**
	 * 查询最新的一条记录
	 * 
	 * @param @param grainType
	 * @param @return
	 * @return BsInventoryRecord
	 * @throws
	 * @date 2017年3月28日上午11:01:53
	 */
	public BsInventoryRecord getBsInventoryRecordOrdreByTime(int depotId, int grainType, int userid, Date recordTime) {
		BsInventoryRecord bsInventoryRecord = null;
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeLessThanOrEqualTo(recordTime);
		recordExample.setOrderByClause("record_time desc,create_time desc");
		recordExample.setLimit(1);
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		if (ckxm != null && ckxm.size() > 0) {
			bsInventoryRecord = new BsInventoryRecord();
			bsInventoryRecord = ckxm.get(0);
		}
		return bsInventoryRecord;
	}

	public BsInventoryRecord getBsInventoryRecordOrdreNumber(int depotId, int grainType, int userid, Date recordTime) {
		BsInventoryRecord bsInventoryRecord = null;
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeEqualTo(recordTime);
		recordExample.setOrderByClause("int_column1 desc");
		recordExample.setLimit(1);
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		if (ckxm != null && ckxm.size() > 0) {
			bsInventoryRecord = new BsInventoryRecord();
			bsInventoryRecord = ckxm.get(0);
		}
		return bsInventoryRecord;
	}

	public BsInventoryRecord getBsInventoryRecordOrdreNumberAndRecordTimeDesc(int depotId, int grainType, int userid,
			Date recordTime) {
		BsInventoryRecord bsInventoryRecord = null;
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeLessThan(recordTime);
		recordExample.setOrderByClause("record_time desc,int_column1 desc");
		recordExample.setLimit(1);
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		if (ckxm != null && ckxm.size() > 0) {
			bsInventoryRecord = new BsInventoryRecord();
			bsInventoryRecord = ckxm.get(0);
		}
		return bsInventoryRecord;
	}

	public List<BsInventoryRecord> getBsInventoryRecordOrdreNumberAndRecordTimeAsc(int depotId, int grainType,
			int userid, Date recordTime) {
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeGreaterThan(recordTime);
		recordExample.setOrderByClause("record_time ,int_column1 ");
		// recordExample.setLimit(1);
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		return ckxm;
	}

	/**
	 * 获取当前日期比自己大的序号
	 * 
	 * @Description: TODO
	 * @param @param grainType
	 * @param @param userid
	 * @param @param recordTime
	 * @param @param number
	 * @param @return
	 * @return List<BsInventoryRecord>
	 * @throws
	 * @date 2017年4月8日下午11:20:55
	 */
	public List<BsInventoryRecord> getBsInventoryRecordOrdreNumberAndRecordEq(int depotId, int grainType, int userid,
			Date recordTime, int number) {
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeEqualTo(recordTime).andIntColumn1GreaterThan(number);
		recordExample.setOrderByClause("record_time ,int_column1 ");
		// recordExample.setLimit(1);
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		return ckxm;
	}

	public BsInventoryRecord getBsInventoryRecordOrdreNumberAndRecordTimeEqDesc(int depotId, int grainType, int userid,
			Date recordTime) {
		BsInventoryRecord bsInventoryRecord = null;
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeLessThanOrEqualTo(recordTime);
		recordExample.setOrderByClause("record_time desc,int_column1 desc");
		recordExample.setLimit(1);
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		if (ckxm != null && ckxm.size() > 0) {
			bsInventoryRecord = new BsInventoryRecord();
			bsInventoryRecord = ckxm.get(0);
		}
		return bsInventoryRecord;
	}

	/**
	 * 查询当天的比前一位的序号
	 * 
	 * @param @param grainType
	 * @param @param userid
	 * @param @param recordTime
	 * @param @param number
	 * @param @return
	 * @return BsInventoryRecord
	 * @throws
	 * @author 常鹏飞
	 * @date 2017年4月8日下午11:41:20
	 */
	public BsInventoryRecord getDtByNumber(int depotId, int grainType, int userid, Date recordTime, int number) {
		BsInventoryRecord bsInventoryRecord = null;
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeEqualTo(recordTime).andIntColumn1LessThan(number);
		recordExample.setOrderByClause("record_time desc,int_column1 desc");
		recordExample.setLimit(1);
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		if (ckxm != null && ckxm.size() > 0) {
			bsInventoryRecord = new BsInventoryRecord();
			bsInventoryRecord = ckxm.get(0);
		}
		return bsInventoryRecord;
	}

	public List<BsInventoryRecord> getDtByNumberGreaterThan(int depotId, int grainType, int userid, Date recordTime,
			int number) {
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeEqualTo(recordTime).andIntColumn1GreaterThan(number);
		recordExample.setOrderByClause("record_time ,int_column1 ");
		// recordExample.setLimit(1);
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		return ckxm;
	}

	/**
	 * 查询最新的一条记录
	 * 
	 * @param @param grainType
	 * @param @return
	 * @return BsInventoryRecord
	 * @throws
	 * @date 2017年3月28日上午11:01:53
	 */
	public BsInventoryRecord getBsInventoryRecordOrdreByTime(int depotId, int grainType, int userid, Date recordTime,
			int id) {
		BsInventoryRecord bsInventoryRecord = null;
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		// 种类，userid，称重日期，创建时间
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeLessThanOrEqualTo(recordTime).andIdNotEqualTo(id);
		recordExample.setOrderByClause("record_time desc,create_time desc");
		recordExample.setLimit(1);
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		if (ckxm != null && ckxm.size() > 0) {
			bsInventoryRecord = new BsInventoryRecord();
			bsInventoryRecord = ckxm.get(0);
		}
		return bsInventoryRecord;
	}

	/**
	 * 查询最新的一条记录
	 * 
	 * @param @param grainType
	 * @param @return
	 * @return BsInventoryRecord
	 * @throws
	 * @date 2017年3月28日上午11:01:53
	 */
	public BsInventoryRecord getBsInventoryRecordOrdreByTime(int depotId, int grainType, int userid, Date recordTime,
			int id, Date createTime) {
		BsInventoryRecord bsInventoryRecord = null;
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		// 种类，userid，称重日期，创建时间
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId).andRecordTimeLessThanOrEqualTo(recordTime).andIdNotEqualTo(id)
				.andCreateTimeLessThanOrEqualTo(createTime);
		recordExample.setOrderByClause("record_time desc,create_time desc");
		recordExample.setLimit(1);
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		if (ckxm != null && ckxm.size() > 0) {
			bsInventoryRecord = new BsInventoryRecord();
			bsInventoryRecord = ckxm.get(0);
		}
		return bsInventoryRecord;
	}

	/**
	 * 查询最新的一条记录
	 * 
	 * @param @param grainType
	 * @param @return
	 * @return BsInventoryRecord
	 * @throws
	 * @date 2017年3月28日上午11:01:53
	 */
	public Map<String, Object> getRecordOrdreByTime(int depotId, int grainType, int userid) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mp = null;
		List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();
		BsInventoryRecordExample recordExample = new BsInventoryRecordExample();
		recordExample.createCriteria().andGrainTypeEqualTo(grainType).andUserIdEqualTo(userid)
				.andDepotIdEqualTo(depotId);
		recordExample.setOrderByClause("record_time desc");
		recordExample.setLimit(1);
		List<BsInventoryRecord> ckxm = bsInventoryRecordMapper.selectByExample(recordExample);
		// 出库小麦
		if (ckxm != null && ckxm.size() > 0) {
			mp = new HashMap<String, Object>();
			mp.put("recordId", ckxm.get(0).getId());
			maplist.add(mp);
		}
		map.put("dataList", maplist);
		return map;
	}

	/**
	 * 两个Double数相除，并保留scale位小数
	 * 
	 * @param @param v1
	 * @param @param v2
	 * @param @param scale
	 * @param @return
	 * @return double
	 * @throws
	 * @date 2017年3月28日下午7:00:30
	 */
	public double Doublediv(Double v1, Double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("Thescalemustbeapositiveintegerorzero");
		}
		if (v1 == 0) {
			return 0;
		}
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public int deleteByExample(int id) {
		BsInventoryRecordKey key = new BsInventoryRecordKey();
		key.setId(id);
		BsInventoryRecord record = bsInventoryRecordMapper.selectByPrimaryKey(key);
		// 查询此条数据之后的所有数据
		// List<BsInventoryRecord> list =
		// getBsInventoryRecordOrdreByTimeAsc(bs.getGrainType(),bs.getUserId(),bs.getRecordTime(),bs.getId());
		commonMapper.insertDeleteAsRecord(id);
		int fage = bsInventoryRecordMapper.deleteByPrimaryKey(key);
		// 查询当前时间的序号大于
		List<BsInventoryRecord> list = getDtByNumberGreaterThan(record.getDepotId(), record.getGrainType(),
				record.getUserId(), record.getRecordTime(), record.getIntColumn1());
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					BsInventoryRecord bs = getDtByNumber(list.get(i).getDepotId(), list.get(i).getGrainType(), list
							.get(i).getUserId(), list.get(i).getRecordTime(), list.get(i).getIntColumn1());
					if (bs == null) {
						bs = getBsInventoryRecordOrdreNumberAndRecordTimeDesc(list.get(i).getDepotId(), list.get(i)
								.getGrainType(), list.get(i).getUserId(), list.get(i).getRecordTime());
					}
					update2(list.get(i), bs);
				} else {
					update2(list.get(i), list.get(i - 1));
				}
			}
		}
		List<BsInventoryRecord> list2 = getBsInventoryRecordOrdreNumberAndRecordTimeAsc(record.getDepotId(),
				record.getGrainType(), record.getUserId(), record.getRecordTime());
		if (list2 != null && list2.size() > 0) {
			for (int i = 0; i < list2.size(); i++) {
				if (i == 0) {
					BsInventoryRecord bs = getDtByNumber(list2.get(i).getDepotId(), list2.get(i).getGrainType(), list2
							.get(i).getUserId(), list2.get(i).getRecordTime(), list2.get(i).getIntColumn1());
					if (bs == null) {
						bs = getBsInventoryRecordOrdreNumberAndRecordTimeDesc(list2.get(i).getDepotId(), list2.get(i)
								.getGrainType(), list2.get(i).getUserId(), list2.get(i).getRecordTime());
					}
					update2(list2.get(i), bs);
				} else {
					update2(list2.get(i), list2.get(i - 1));
				}
			}
		}

		// if(list != null && list.size() > 0){
		// for (BsInventoryRecord b : list) {
		// update1(b);
		// }
		// }
		return fage;
	}

}
