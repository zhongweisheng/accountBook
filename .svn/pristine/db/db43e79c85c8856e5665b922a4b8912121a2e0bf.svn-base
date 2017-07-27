package lb.rest.user.db.dao;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsInventoryRecord;
import lb.rest.user.db.entity.BsInventoryRecordExample;
import lb.rest.user.db.entity.BsInventoryRecordExample.Criteria;
import lb.rest.user.db.entity.BsInventoryRecordKey;
import lb.rest.user.db.mapper.BsInventoryRecordMapper;
import lb.rest.user.db.mapper.CommonMapper;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mlb.bo.InventoryRecordBO;
import com.mlb.enums.GrainTypeEnum;
import com.mlb.enums.RecordTypeEnum;
import com.mlb.util.DateListUtil;
import com.mlb.util.JsonDataUtils;
import com.mlb.util.TDateTimeUnits;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;
import fc.wpf.rest.utils.DateStyle;
import fc.wpf.rest.utils.DateUtil;
import fc.wpf.rest.utils.NumberFormatUtil;

@Repository
public class BsInventoryRecordDao implements
		StaticTableDaoSupport<BsInventoryRecord, BsInventoryRecordExample, BsInventoryRecordKey> {

	@Resource
	private BsInventoryRecordMapper mapper;
	@Resource
	private CommonMapper commonMapper;

	@Resource
	private BsInventoryDepotDao bsInventoryDepotDao;

	@Resource
	private BsInventoryTemporaryDao bsInventoryTemporaryDao;

	/***
	 * 该用户下，所有粮库ID为0的记录，修改成指定 粮库 ID.
	 * 
	 * @param depotId
	 * @param ownerId
	 * @return
	 */
	public int updateByExampleSelective(int depotId, int ownerId) {
		BsInventoryRecordExample example = new BsInventoryRecordExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(ownerId).andDepotIdEqualTo(0);
		BsInventoryRecord record = new BsInventoryRecord();
		record.setDepotId(depotId);
		try {
			// 未完成订单 修改 指定 粮库ID .
			bsInventoryTemporaryDao.updateByExampleSelective(depotId, ownerId);
		} catch (Exception e) {
		}

		return mapper.updateByExampleSelective(record, example);
	}

	public JsonDataUtils searchList(boolean isExcel, int ownerId, int userId, int grainType, int recordType,
			int searchType, int staffId, String staffName, int isPay, int depotId, String startDate, String endDate,
			int currentPage, int pageSize) {

		
		JsonDataUtils jsonUtils = new JsonDataUtils();
		jsonUtils.setSearchType(searchType);
		jsonUtils.setGrainType(grainType);
		jsonUtils.setRecordType(recordType);
		int offset = (currentPage - 1) * pageSize;
		int limit = pageSize;
		int number = offset + 1;

		if (searchType == 1) {
			BsInventoryRecordExample example = new BsInventoryRecordExample();
			example.setOrderByClause(" record_time desc , int_column1 desc ");
			Criteria criteria = example.createCriteria();
			if (grainType > 0) {
				criteria.andGrainTypeEqualTo(grainType);
			}
			if (recordType > 0) {
				criteria.andRecordTypeEqualTo(recordType);
			}
			if (staffId > 0) {
				criteria.andStaffIdEqualTo(staffId);
			}
			if (StringUtils.isNotEmpty(staffName)) {
				criteria.andStaffNameLike("%" + staffName + "%");
			}
			criteria.andUserIdEqualTo(ownerId);
			if (isPay > -1) {
				criteria.andIfPaymentEqualTo(isPay);
			}
			if (depotId > 0) {
				criteria.andDepotIdEqualTo(depotId);
			}

			if (StringUtils.isNotEmpty(startDate) && StringUtils.isNotEmpty(endDate)) {
				Date sDate = DateUtil.getDate(DateStyle.YYYY_MM_DD.getValue(), startDate);
				Date eDate = DateUtil.getDate(DateStyle.YYYY_MM_DD.getValue(), endDate);
				criteria.andRecordTimeBetween(sDate, eDate);
			}

			// 通过userId ,获取他的粮库ID列表
			List<Integer> depotIdList = bsInventoryDepotDao.getIdList(userId);
			if (depotIdList != null && depotIdList.size() > 0) {
				criteria.andDepotIdIn(depotIdList);
			} else {
				criteria.andDepotIdEqualTo(0);
			}

			// 翻页
			example.setLimit(pageSize);
			example.setOffset(offset);

			List<BsInventoryRecord> list = mapper.selectByExample(example);

			int total = mapper.countByExample(example);
			jsonUtils.setTotal(total);

			if (list != null && list.size() > 0) {
				/*
				 * 车号 毛重 皮重 净重 单价 金额 平均成本 粮质
				 */
				Map<String, String> map = new HashMap<String, String>();
				map.put("number", "序号");
				map.put("id", "ID");
				map.put("type", "按查询");
				map.put("recordType", "单种类");
				map.put("recordNumber", "单号");
				map.put("date", "称重日期");
				map.put("time", "称重时间");
				map.put("timeUnit", "称重时间");
				map.put("netWeight", "净重（公斤）");
				map.put("averageCost", "平均成本（元/斤）");
				map.put("money", "金额（元）");
				map.put("profit", "利润（元）");
				map.put("grainType", "品种");
				map.put("licensePlate", "车号");
				map.put("grossWeight", "毛重（公斤）");
				map.put("tareWeight", "皮重（公斤）");
				map.put("unitPrice", "单价（元/斤）");
				map.put("deduction", "扣重（公斤）");

				if (recordType == RecordTypeEnum.入库.getCode()) {
					map.put("paidMoney", "已付款");
					map.put("unpaidMoney", "未付款");
				} else {
					map.put("paidMoney", "已收款");
					map.put("unpaidMoney", "未收款");
				}

				map.put("ifClear", "是否清零");

				// map.put("weifuk", "未付款（元）");
				map.put("quality", "粮质");
				map.put("remark", "备注");
				map.put("staffId", "人员编号");
				map.put("staffName", "人员姓名");

				if (recordType == RecordTypeEnum.入库.getCode()) {
					jsonUtils.addTitle("number", "id", "type", "recordType", "recordNumber", "grainType", "date",
							"time", "licensePlate", "grossWeight", "tareWeight", "deduction", "netWeight", "unitPrice",
							"money", "paidMoney", "unpaidMoney", "ifClear", "averageCost", "quality", "remark",
							"staffId", "staffName");
				} else {
					jsonUtils
							.addTitle("number", "id", "type", "recordType", "recordNumber", "grainType", "date",
									"time", "licensePlate", "grossWeight", "tareWeight", "deduction", "netWeight",
									"unitPrice", "money", "paidMoney", "unpaidMoney", "ifClear", "quality", "remark",
									"staffId", "staffName");
				}

				jsonUtils.setTitleMap(map);
				jsonUtils.setSuccess(true);
				for (BsInventoryRecord item : list) {
					String grainName = GrainTypeEnum.getName(grainType);
					String recordName = RecordTypeEnum.getName(recordType);

					String str1 = "";
					String str2 = "";
					String str3 = "";
					String str4 = "";
					// if (grainType == GrainTypeEnum.玉米.getCode()) {
					str1 = "水分：" + item.getMoistureContent();
					str2 = "霉变：" + item.getMildew();
					str3 = "容重：" + item.getBulkDensity();
					str4 = "不完善粒：" + item.getImperfectGrains();
					// }
					String quality = str1 + " " + str2 + " " + str3 + " " + str4;
					String remark = item.getRemark();
					String ifPayment = "";
					if (item.getIfPayment() != null) {
						if (item.getIfPayment() == 1) {
							ifPayment = "已付";
						} else {
							ifPayment = "未付";
						}
					}

					Double shifuk = item.getShifuk();

					if (recordType == RecordTypeEnum.入库.getCode()) {
						// excel 导出 不添加 逗号
						if (isExcel) {
							jsonUtils.addOneRow(number++, item.getId(), searchType, recordName, item.getRecordNumber(),
									grainName, dateReplace(item.getDate()), item.getTime(), item.getLicensePlate(),
									formatMoneyPercent(item.getGrossWeightIn()),
									formatMoneyPercent(item.getTareWeightIn()),
									formatMoneyPercent(item.getDeduction()), formatMoneyPercent(item.getNetWeightIn()),
									formatToPercentP3(item.getUnitPrice()), formatMoneyPercent(item.getMoneyIn()),
									formatMoneyPercent(item.getPaidMoney()), formatMoneyPercent(item.getUnpaidMoney()),
									item.getIfClear(), formatToPercentP3(item.getAveragePriceIn() / 2), quality,
									remark, item.getStaffId(), item.getStaffName());
						} else {
							jsonUtils.addOneRow(number++, item.getId(), searchType, recordName, item.getRecordNumber(),
									grainName, dateReplace(item.getDate()), item.getTime(), item.getLicensePlate(),
									formatMoneyPercentCMA(item.getGrossWeightIn()),
									formatMoneyPercentCMA(item.getTareWeightIn()),
									formatToPercentP3CMA(item.getDeduction()),
									formatMoneyPercentCMA(item.getNetWeightIn()),
									formatToPercentP3CMA(item.getUnitPrice()),
									formatMoneyPercentCMA(item.getMoneyIn()),
									formatMoneyPercentCMA(item.getPaidMoney()),
									formatMoneyPercentCMA(item.getUnpaidMoney()), item.getIfClear(),
									formatToPercentP3CMA(item.getAveragePriceIn() / 2), quality, remark,
									item.getStaffId(), item.getStaffName());
						}
					} else {
						// excel 导出 不添加 逗号
						if (isExcel) {
							jsonUtils.addOneRow(number++, item.getId(), searchType, recordName, item.getRecordNumber(),
									grainName, dateReplace(item.getDate()), item.getTime(), item.getLicensePlate(),
									formatMoneyPercent(item.getGrossWeightOut()),
									formatMoneyPercent(item.getTareWeightOut()),
									formatMoneyPercent(item.getDeduction()),
									formatMoneyPercent(item.getNetWeightOut()), formatToPercentP3(item.getUnitPrice()),
									formatMoneyPercent(item.getMoneyOut()), formatMoneyPercent(item.getPaidMoney()),
									formatMoneyPercent(item.getUnpaidMoney()), item.getIfClear(), quality, remark,
									item.getStaffId(), item.getStaffName());
						} else {
							jsonUtils.addOneRow(number++, item.getId(), searchType, recordName, item.getRecordNumber(),
									grainName, dateReplace(item.getDate()), item.getTime(), item.getLicensePlate(),
									formatMoneyPercentCMA(item.getGrossWeightOut()),
									formatMoneyPercentCMA(item.getTareWeightOut()),
									formatMoneyPercentCMA(item.getDeduction()),
									formatMoneyPercentCMA(item.getNetWeightOut()),
									formatToPercentP3CMA(item.getUnitPrice()),
									formatMoneyPercentCMA(item.getMoneyOut()),
									formatMoneyPercentCMA(item.getPaidMoney()),
									formatMoneyPercentCMA(item.getUnpaidMoney()), item.getIfClear(), quality, remark,
									item.getStaffId(), item.getStaffName());
						}
					}
				}
			}
		} else {
			// 添加 粮库查询
			String depotIds = bsInventoryDepotDao.getIds(userId);
			if (depotId > 0) {
				depotIds = depotId + "";
			}

			List<InventoryRecordBO> list = commonMapper.getSearchList(depotIds, ownerId, grainType, recordType,
					searchType, staffId, startDate, endDate, offset, limit);
			int total = commonMapper.getSearchCount(depotIds, ownerId, grainType, recordType, searchType, staffId,
					startDate, endDate);

			jsonUtils.setTotal(total);

			if (list != null && list.size() > 0) {
				Map<String, String> map = new HashMap<String, String>();
				// if (wxList == 1) {
				// if (recordType == RecordTypeEnum.入库.getCode()) {
				// jsonUtils.addTitle("type", "timeUnit", "money", "netWeight",
				// "averageCost");
				// } else {
				// jsonUtils.addTitle("type", "timeUnit", "money", "netWeight");
				// }
				// map.put("type", "品种");
				// map.put("timeUnit", "称重时间");
				// map.put("grossWeight", "毛重");
				// map.put("tareWeight", "皮重");
				// map.put("netWeight", "净重");
				// if (recordType == RecordTypeEnum.入库.getCode()) {
				// map.put("averageCost", "平均成本");
				// }
				// } else {

				jsonUtils.addTitle("number", "type", "recordType", "grainType", "timeUnit", "grossWeight",
						"tareWeight", "deduction", "netWeight", "money", "unpaidMoney");
				map.put("number", "序号");
				map.put("recordType", "单种类");
				map.put("grainType", "品种");
				map.put("timeUnit", "称重时间");
				map.put("grossWeight", "毛重（公斤）");
				map.put("tareWeight", "皮重（公斤）");
				map.put("netWeight", "净重（公斤）");
				map.put("money", "金额（元）");
				if (recordType == RecordTypeEnum.入库.getCode()) {
					map.put("unpaidMoney", "未付款（元）");
				} else {
					map.put("unpaidMoney", "未收款（元）");
				}
				map.put("deduction", "扣重（公斤）");

				// 入库的时候多平均成本
				// if (recordType == RecordTypeEnum.入库.getCode()) {
				// map.put("averageCost", "平均成本");
				// jsonUtils.addTitle("averageCost");
				// }
				// 出库时多 出库平均价格
				if (recordType == RecordTypeEnum.出库.getCode()) {
					map.put("averagePrice", "平均价格（元/斤）");
					jsonUtils.addTitle("averagePrice");
				}

				jsonUtils.setTitleMap(map);
				jsonUtils.setSuccess(true);

				for (InventoryRecordBO item : list) {
					String dateStr = StringUtils.trim(item.getDateStr());
					String unpaidMoney = "";
					if (searchType == 3) {
						int year = item.getYear();
						int weekIndex = NumberUtils.toInt(dateStr);
						String[] bEdate = TDateTimeUnits.getDayOfWeek(year, weekIndex);
						if (bEdate != null && bEdate.length == 2) {
							dateStr = dateReplace(bEdate[0]) + "~" + dateReplace(bEdate[1]);
						}
					} else if (searchType == 4) {
						int year = item.getYear();
						dateStr = year + "年" + dateStr + "月";
					}

					String grainName = GrainTypeEnum.getName(grainType);
					String recordName = RecordTypeEnum.getName(recordType);

					if (recordType == RecordTypeEnum.入库.getCode()) {

						// jsonUtils.addOneRow(number++, searchType, recordName,
						// grainName, dateStr,
						// formatMoneyPercent(item.getGrossInTotal()),
						// formatMoneyPercent(item.getTareInTotal()),
						// formatMoneyPercent(item.getNetInTotal()),
						// formatMoneyPercent(item.getMoneyInTotal()),
						// formatMoneyPercent(item.getAverageCost()));
						// excel 导出 不添加 逗号
						if (isExcel) {
							jsonUtils.addOneRow(number++, searchType, recordName, grainName, dateStr,
									formatMoneyPercent(item.getGrossInTotal()),
									formatMoneyPercent(item.getTareInTotal()), formatMoneyPercent(item.getDeduction()),
									formatMoneyPercent(item.getNetInTotal()),
									formatMoneyPercent(item.getMoneyInTotal()),
									formatMoneyPercent(item.getUnpaidMoney()));
						} else {
							jsonUtils.addOneRow(number++, searchType, recordName, grainName, dateStr,
									formatMoneyPercentCMA(item.getGrossInTotal()),
									formatMoneyPercentCMA(item.getTareInTotal()),
									formatMoneyPercentCMA(item.getDeduction()),
									formatMoneyPercentCMA(item.getNetInTotal()),
									formatMoneyPercentCMA(item.getMoneyInTotal()),
									formatMoneyPercentCMA(item.getUnpaidMoney()));
						}
						// }
					} else {
						// if (wxList == 1) {
						// jsonUtils.addOneRow(searchType, dateStr,
						// item.getMoneyInTotal(), item.getNetInTotal());
						// } else {
						if (isExcel) {
							jsonUtils.addOneRow(number++, searchType, recordName, grainName, dateStr,
									formatMoneyPercent(item.getGrossOutTotal()),
									formatMoneyPercent(item.getTareOutTotal()),
									formatMoneyPercent(item.getDeduction()), formatMoneyPercent(item.getNetOutTotal()),
									formatMoneyPercent(item.getMoneyOutTotal()),
									formatMoneyPercent(item.getUnpaidMoney()),
									formatToPercentP3(item.getAveragePrice()));// 出库平均价元/斤
						} else {
							jsonUtils.addOneRow(number++, searchType, recordName, grainName, dateStr,
									formatMoneyPercentCMA(item.getGrossOutTotal()),
									formatMoneyPercentCMA(item.getTareOutTotal()),
									formatToPercentP3CMA(item.getDeduction()),
									formatMoneyPercentCMA(item.getNetOutTotal()),
									formatMoneyPercentCMA(item.getMoneyOutTotal()),
									formatToPercentP3CMA(item.getUnpaidMoney()),
									formatToPercentP3CMA(item.getAveragePrice()));// 出库平均价元/斤
						}
						// }
					}
				}
			}
		}
		return jsonUtils;
	}

	public JsonDataUtils searchStat(boolean isExcel, int ownerId, int userId, int grainType, int recordType,
			int searchType, int staffId, int depotId, int currentPage, int pageSize) {
		int offset = (currentPage - 1) * pageSize;
		int limit = pageSize;
		int number = offset + 1;
		JsonDataUtils jsonUtils = new JsonDataUtils();
		jsonUtils.setSearchType(searchType);
		jsonUtils.setGrainType(grainType);
		jsonUtils.setRecordType(recordType);
		if (searchType == 1) {
			BsInventoryRecordExample example = new BsInventoryRecordExample();
			example.setOrderByClause(" record_time desc , int_column1 desc ");
			Criteria criteria = example.createCriteria();
			if (grainType > 0) {
				criteria.andGrainTypeEqualTo(grainType);
			}
			if (recordType > 0) {
				criteria.andRecordTypeEqualTo(recordType);
			}
			if (staffId > 0) {
				criteria.andStaffIdEqualTo(staffId);
			}
			if (depotId > 0) {
				criteria.andDepotIdEqualTo(depotId);
			}
			// 通过userId ,获取他的粮库ID列表
			List<Integer> depotIdList = bsInventoryDepotDao.getIdList(userId);
			if (depotIdList != null && depotIdList.size() > 0) {
				criteria.andDepotIdIn(depotIdList);
			} else {
				criteria.andDepotIdEqualTo(0);
			}
			criteria.andUserIdEqualTo(ownerId);
			example.setOffset(offset);
			example.setLimit(limit);

			List<BsInventoryRecord> list = mapper.selectByExample(example);
			int total = mapper.countByExample(example);
			jsonUtils.setTotal(total);
			if (list != null && list.size() > 0) {
				/*
				 * 单种类 单号 品种 称重时间 剩余公斤 平均成本 库存金额 累计利润 每笔毛利
				 */
				Map<String, String> map = new HashMap<String, String>();
				map.put("number", "序号");
				map.put("type", "按查询");
				map.put("recordType", "单种类");
				map.put("recordNumber", "单号");
				map.put("grainType", "品种");
				map.put("timeUnit", "称重时间");

				map.put("balance", "剩余公斤（公斤）");
				map.put("averageCost", "平均成本（元/斤）");
				map.put("money", "金额（元）");
				map.put("totalProfit", "累计利润（元）");
				map.put("profit", "每笔利润（元）");

				// 是微信
				// if (wxList == 1) {
				// jsonUtils.addTitle("type", "date", "time", "timeUnit",
				// "money", "netWeight", "averageCost",
				// "profit");
				// } else {
				jsonUtils.addTitle("number", "type", "recordType", "recordNumber", "grainType", "timeUnit", "balance",
						"averageCost", "money", "totalProfit", "profit");
				// }

				jsonUtils.setTitleMap(map);
				jsonUtils.setSuccess(true);

				for (BsInventoryRecord item : list) {
					String grainName = GrainTypeEnum.getName(grainType);
					int recordT = item.getRecordType();
					String recordName = RecordTypeEnum.getName(recordT);
					// excel 导出 不添加 逗号
					if (isExcel) {
						jsonUtils.addOneRow(number++, searchType, recordName, item.getRecordNumber(), grainName,
								dateReplace(item.getDate()), formatMoneyPercent(item.getBalance()),
								formatToPercentP3(item.getAveragePriceIn() / 2),
								formatMoneyPercent(item.getInventoryMoney()),
								formatMoneyPercent(item.getTotalProfit()), formatMoneyPercent(item.getProfit()));
					} else {
						jsonUtils.addOneRow(number++, searchType, recordName, item.getRecordNumber(), grainName,
								dateReplace(item.getDate()), formatMoneyPercentCMA(item.getBalance()),
								formatToPercentP3CMA(item.getAveragePriceIn() / 2),
								formatMoneyPercentCMA(item.getInventoryMoney()),
								formatMoneyPercentCMA(item.getTotalProfit()), formatMoneyPercentCMA(item.getProfit()));
					}
				}

			}
		} else {
			// 添加 粮库查询
			String depotIds = bsInventoryDepotDao.getIds(userId);
			if (depotId > 0) {
				depotIds = depotId + "";
			}
			List<InventoryRecordBO> list = commonMapper.getSearchStat(depotIds, ownerId, grainType, recordType,
					searchType, offset, limit);
			int total = commonMapper.getSearchStatCount(depotIds, ownerId, grainType, recordType, searchType);
			jsonUtils.setTotal(total);
			if (list != null && list.size() > 0) {
				jsonUtils.addTitle("number", "type", "grainType", "timeUnit", "balance", "averageCost", "money",
						"profit");
				Map<String, String> map = new HashMap<String, String>();
				map.put("number", "序号");
				map.put("type", "按查询");
				map.put("grainType", "品种");
				map.put("timeUnit", "称重时间");
				map.put("balance", "剩余公斤（公斤）");
				map.put("averageCost", "平均成本（元/斤）");
				// map.put("totalProfit", "累计利润");
				map.put("money", "金额（元）");
				map.put("profit", "每笔利润（元）");

				jsonUtils.setTitleMap(map);
				jsonUtils.setSuccess(true);
				for (InventoryRecordBO item : list) {
					String grainName = GrainTypeEnum.getName(grainType);
					// String recordName = RecordTypeEnum.getName(recordType);
					String dateStr = StringUtils.trim(item.getDateStr());
					if (searchType == 3) {
						int year = item.getYear();
						int weekIndex = NumberUtils.toInt(dateStr);
						String[] bEdate = TDateTimeUnits.getDayOfWeek(year, weekIndex);

						if (bEdate != null && bEdate.length == 2) {
							dateStr = dateReplace(bEdate[0]) + "~" + dateReplace(bEdate[1]);
						}
					} else if (searchType == 4) {
						int year = item.getYear();
						dateStr = year + "年" + dateStr + "月";
					}
					dateStr = dateReplace(dateStr);
					// excel 导出 不添加 逗号
					if (isExcel) {
						jsonUtils.addOneRow(number++, searchType, grainName, dateStr,
								formatMoneyPercent(item.getBalance()), formatMoneyPercent(item.getAverageCost()),
								formatMoneyPercent(item.getInventoryMoney()), formatMoneyPercent(item.getProfit()));
					} else {
						jsonUtils.addOneRow(number++, searchType, grainName, dateStr,
								formatMoneyPercentCMA(item.getBalance()), formatMoneyPercentCMA(item.getAverageCost()),
								formatMoneyPercentCMA(item.getInventoryMoney()),
								formatMoneyPercentCMA(item.getProfit()));
					}

				}
			}
		}
		return jsonUtils;
	}

	@Override
	public int countByExample(BsInventoryRecordExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsInventoryRecordExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsInventoryRecordKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsInventoryRecord record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsInventoryRecord record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsInventoryRecord> records) {
		for (BsInventoryRecord record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsInventoryRecord> records) {
		for (BsInventoryRecord record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsInventoryRecord> records) {
		for (BsInventoryRecord record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsInventoryRecord> selectByExample(BsInventoryRecordExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public BsInventoryRecord selectByPrimaryKey(BsInventoryRecordKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsInventoryRecord> findAll(List<BsInventoryRecord> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsInventoryRecordExample());
		}
		List<BsInventoryRecord> list = new ArrayList<>();
		for (BsInventoryRecord record : records) {
			BsInventoryRecord result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsInventoryRecord record, BsInventoryRecordExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsInventoryRecord record, BsInventoryRecordExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsInventoryRecord record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsInventoryRecord record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsInventoryRecordExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsInventoryRecordExample());
	}

	@Override
	public BsInventoryRecordExample getExample(BsInventoryRecord record) {
		BsInventoryRecordExample example = new BsInventoryRecordExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}
			if (record.getUserId() != null) {
				criteria.andUserIdEqualTo(record.getUserId());
			}
		}
		return example;
	}

	public static String dateReplace(String date) {
		if (StringUtils.isEmpty(date)) {
			return "";
		}
		return date.replaceAll("-", "/");
	}

	public static final DecimalFormat dfP2 = new DecimalFormat("###0.00");
	public static final DecimalFormat dfP3 = new DecimalFormat("###0.000");

	public static final DecimalFormat dfP2CMA = new DecimalFormat("###,###,###,##0.00");
	public static final DecimalFormat dfP3CMA = new DecimalFormat("###,###,###,##0.000");

	public static String formatMoneyPercentCMA(Double doubleVal) {
		if (doubleVal == null) {
			return "";
		}
		return NumberFormatUtil.formatToPercent(dfP2CMA, doubleVal);
	}

	public static String formatToPercentP3CMA(Double doubleVal) {
		if (doubleVal == null) {
			return "";
		}
		return NumberFormatUtil.formatToPercent(dfP3CMA, doubleVal);
	}

	public static String formatMoneyPercent(Double doubleVal) {
		if (doubleVal == null) {
			return "";
		}
		return NumberFormatUtil.formatToPercent(dfP2, doubleVal);
	}

	public static String formatToPercentP3(Double doubleVal) {
		if (doubleVal == null) {
			return "";
		}
		return NumberFormatUtil.formatToPercent(dfP3, doubleVal);
	}

	// public static String formatToPercent(Double doubleVal) {
	// if (doubleVal == null) {
	// return "";
	// }
	// return NumberFormatUtil.formatToPercent(doubleVal);
	// }

	/**
	 * 经营统计
	 * 
	 * @param @param userId 用户ID
	 * @param @param grainType 小麦 玉米 水稻
	 * @param @param type 按金额、按公斤
	 * @param @param searchType 日 周 月
	 * @param @param currentPage
	 * @param @param pageSize
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 * @date 2017年4月5日下午7:54:24
	 */
	public Map<String, Object> findRecordDao(int depotId, int userId, int grainType, int type, int searchType,
			int currentPage, int pageSize) {
		Map<String, Object> m = new HashMap<String, Object>();
		String datetime = DateUtil.format(new Date(), DateStyle.YYYY_MM_DD);

		// 添加 粮库查询
		String depotIds = "";
		if (depotId > 0) {
			depotIds = "" + depotId;
		} else {
			depotIds = bsInventoryDepotDao.getIds(userId);
		}

		List<InventoryRecordBO> mqkcqk = commonMapper.findRmkcqk(depotIds, userId, grainType, type, datetime,
				searchType, 0, 12);

		List<InventoryRecordBO> mqdr = commonMapper.findRmAmountAndJe(depotIds, userId, grainType, type, datetime,
				searchType, 0, 12);
		Map<String, Object> mp = new HashMap<String, Object>();
		List<Map<String, Object>> maplist = new ArrayList<Map<String, Object>>();
		mp.put("ymkc", 0);
		// mp.put("ymPercentage", 0);
		// mp.put("ymPrice", 0);
		mp.put("xmkc", 0);
		// mp.put("xmPercentage", 0);
		// mp.put("xmPrice", 0);
		mp.put("sdkc", 0);
		// mp.put("sdPercentage", 0);
		// mp.put("sdPrice", 0);
		mp.put("sumBalance", 0);

		mp.put("ymNetWeightIn", 0);
		mp.put("ymMoneyIn", 0);
		mp.put("ymNetWeightOut", 0);
		mp.put("ymMoneyOut", 0);

		mp.put("xmNetWeightIn", 0);
		mp.put("xmMoneyIn", 0);
		mp.put("xmNetWeightOut", 0);
		mp.put("xmMoneyOut", 0);

		mp.put("sdNetWeightIn", 0);
		mp.put("sdMoneyIn", 0);
		mp.put("sdNetWeightOut", 0);
		mp.put("sdMoneyOut", 0);

		mp.put("sumRkAmount", 0);
		mp.put("sumCkAmount", 0);
		mp.put("sumRkMoney", 0);
		mp.put("sumCkMoney", 0);

		if (mqdr != null && mqdr.size() > 0) {
			double sumRkAmount = 0.0;
			double sumCkAmount = 0.0;
			double sumRkMoney = 0.0;
			double sumCkMoney = 0.0;
			for (InventoryRecordBO b : mqdr) {
				if (b.getGrainType() == 1) {// 小麦
					if (b.getNetWeightIn() != null) {
						mp.put("xmNetWeightIn", Doublediv(b.getNetWeightIn(), 1000.0, 4));
						sumRkAmount += b.getNetWeightIn();
					}
					if (b.getMoneyIn() != null) {
						mp.put("xmMoneyIn", b.getMoneyIn());
						sumRkMoney += b.getMoneyIn();
					}
					if (b.getNetWeightOut() != null) {
						mp.put("xmNetWeightOut", Doublediv(b.getNetWeightOut(), 1000.0, 4));
						sumCkAmount += b.getNetWeightOut();
					}
					if (b.getMoneyOut() != null) {
						mp.put("xmMoneyOut", b.getMoneyOut());
						sumCkMoney += b.getMoneyOut();
					}

				} else if (b.getGrainType() == 2) {// 玉米

					if (b.getNetWeightIn() != null) {
						mp.put("ymNetWeightIn", Doublediv(b.getNetWeightIn(), 1000.0, 4));
						sumRkAmount += b.getNetWeightIn();
					}
					if (b.getMoneyIn() != null) {
						mp.put("ymMoneyIn", b.getMoneyIn());
						sumRkMoney += b.getMoneyIn();
					}
					if (b.getNetWeightOut() != null) {
						mp.put("ymNetWeightOut", Doublediv(b.getNetWeightOut(), 1000.0, 4));
						sumCkAmount += b.getNetWeightOut();
					}
					if (b.getMoneyOut() != null) {
						mp.put("ymMoneyOut", b.getMoneyOut());
						sumCkMoney += b.getMoneyOut();
					}
				} else if (b.getGrainType() == 3) {// 水稻
					if (b.getNetWeightIn() != null) {
						mp.put("sdNetWeightIn", Doublediv(b.getNetWeightIn(), 1000.0, 4));
						sumRkAmount += b.getNetWeightIn();
					}
					if (b.getMoneyIn() != null) {
						mp.put("sdMoneyIn", b.getMoneyIn());
						sumRkMoney += b.getMoneyIn();
					}
					if (b.getNetWeightOut() != null) {
						mp.put("sdNetWeightOut", Doublediv(b.getNetWeightOut(), 1000.0, 4));
						sumCkAmount += b.getNetWeightOut();
					}
					if (b.getMoneyOut() != null) {
						mp.put("sdMoneyOut", b.getMoneyOut());
						sumCkMoney += b.getMoneyOut();
					}
				}

			}
			mp.put("sumRkAmount", Doublediv(sumRkAmount, 1000.0, 4));
			mp.put("sumCkAmount", Doublediv(sumCkAmount, 1000.0, 4));
			mp.put("sumRkMoney", formatMoneyPercentCMA(sumRkMoney));
			mp.put("sumCkMoney", formatMoneyPercentCMA(sumCkMoney));
		}

		if (mqkcqk != null && mqkcqk.size() > 0) {
			// double sum = 0.0;
			// double xm = 0.0;
			// double ym = 0.0;
			// double sd = 0.0;
			double sumBalance = 0.0;
			for (InventoryRecordBO b : mqkcqk) {
				if (b.getGrainType() == 1) {// 小麦
					if (b.getBalance() != null) {
						// xm = b.getBalance();
						sumBalance += b.getBalance();
						mp.put("xmkc", Doublediv(b.getBalance(), 1000.0, 4));
					} else {
						mp.put("xmkc", 0);
					}
					// if (b.getAveragePrice() != null) {
					// mp.put("xmPrice", b.getAveragePrice());
					// }

				} else if (b.getGrainType() == 2) {// 玉米
					if (b.getBalance() != null) {
						// ym = b.getBalance();
						sumBalance += b.getBalance();
						mp.put("ymkc", Doublediv(b.getBalance(), 1000.0, 4));
					} else {
						mp.put("ymkc", 0);
					}
					// if (b.getAveragePrice() != null) {
					// mp.put("ymPrice", b.getAveragePrice());
					// }

				} else if (b.getGrainType() == 3) {// 水稻
					if (b.getBalance() != null) {
						sumBalance += b.getBalance();
						// sd = b.getBalance();
						mp.put("sdkc", Doublediv(b.getBalance(), 1000.0, 4));
					} else {
						mp.put("sdkc", 0);
					}
					// if (b.getAveragePrice() != null) {
					// mp.put("sdPrice", b.getAveragePrice());
					// }

				}
				// if (b.getBalance() > 0) {
				// sum += b.getBalance();
				// }

			}
			// if (xm > 0) {
			// mp.put("xmPercentage", NumberFormatUtil.formatToPercent(dfP2, xm
			// / sum * 100));
			// } else {
			// mp.put("xmPercentage", 0);
			// }
			// if (sd > 0) {
			// mp.put("sdPercentage", NumberFormatUtil.formatToPercent(dfP2, sd
			// / sum * 100));
			// } else {
			// mp.put("sdPercentage", 0);
			// }
			// if (ym > 0) {
			// mp.put("ymPercentage", NumberFormatUtil.formatToPercent(dfP2, ym
			// / sum * 100));
			// } else {
			// mp.put("ymPercentage", 0);
			// }
			mp.put("sumBalance", Doublediv(sumBalance, 1000.0, 4));
		}
		String[] xData = null;
		String[] xDataz = null;
		String[] yinPriceData = null;
		double[] yinAmountData = null;

		String[] outData = null;
		String[] outDataz = null;
		String[] outPriceData = null;
		double[] outAmoountData = null;

		String[] hasData = null;
		String[] hasDataz = null;
		double[] hasAmountData = null;
		if (searchType == 1) {// 日
			// var xData =
			// ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'];
			// 入库
			// var yinPriceData = [0.2, 0.8, 0.3, 0.2, 0.3, 0.2, 0.3, 0.2, 0.3,
			// 0.2, 0.3, 0.6];
			// var yinAmountData = [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6,
			// 162.2, 32.6, 20.0, 6.4, 3.3];
			// 日的入库情况
			List<InventoryRecordBO> rrkqk = commonMapper.findRrkqk(depotIds, userId, grainType, type, searchType, 0, 7);
			if (rrkqk != null && rrkqk.size() > 0) {
				xData = new String[rrkqk.size()];
				yinPriceData = new String[rrkqk.size()];
				yinAmountData = new double[rrkqk.size()];
				int i = 0;
				for (int j = rrkqk.size() - 1; j >= 0; j--) {

					xData[i] = rrkqk.get(j).getDateStr();
					if (rrkqk.get(j).getPrice() != null) {
						yinPriceData[i] = formatToPercentP3(rrkqk.get(j).getPrice());
					} else {
						yinPriceData[i] = "0";
					}

					if (type == 1) {// 按公斤
						if (rrkqk.get(j).getNetWeightIn() != null) {
							yinAmountData[i] = Doublediv(rrkqk.get(j).getNetWeightIn(), 1000.0, 4);
						} else {
							yinAmountData[i] = 0;
						}

					} else {// 按金额
						if (rrkqk.get(j).getMoneyIn() != null) {
							yinAmountData[i] = rrkqk.get(j).getMoneyIn();
						} else {
							yinAmountData[i] = 0;
						}

					}
					i++;

				}
			}

			// 出库
			// var outPriceData = [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6,
			// 162.2, 32.6, 20.0, 6.4, 3.3];
			// var outAmoountData = [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4,
			// 23.0, 16.5, 12.0, 6.2];
			// 日的出库情况
			List<InventoryRecordBO> rckqk = commonMapper.findRckqk(depotIds, userId, grainType, type, searchType, 0, 7);
			if (rckqk != null && rckqk.size() > 0) {
				outData = new String[rckqk.size()];
				outPriceData = new String[rckqk.size()];
				outAmoountData = new double[rckqk.size()];
				int i = 0;

				for (int j = rckqk.size() - 1; j >= 0; j--) {
					outData[i] = rckqk.get(j).getDateStr();
					if (rckqk.get(j).getPrice() != null) {
						outPriceData[i] = formatToPercentP3(rckqk.get(j).getPrice());
					} else {
						outPriceData[i] = "0";
					}

					if (type == 1) {// 按公斤
						if (rckqk.get(j).getNetWeightOut() != null) {
							outAmoountData[i] = Doublediv(rckqk.get(j).getNetWeightOut(), 1000.0, 4);
						} else {
							outAmoountData[i] = 0;
						}

					} else {// 按金额
						if (rckqk.get(j).getMoneyOut() != null) {
							outAmoountData[i] = rckqk.get(j).getMoneyOut();
						} else {
							outAmoountData[i] = 0;
						}

					}
					i++;
				}

			}

			// 库存
			// var hasAmountData = [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6,
			// 162.2, 32.6, 20.0, 6.4, 3.3];
			// 日的库存情况
			// List<InventoryRecordBO> rkcqk = commonMapper.findRkcqk(userId,
			// grainType, type, searchType, 0, 7);

			// 1.当前时间往前推迟7天
			List<String> dateList = DateListUtil
					.getDateList(DateListUtil.getLastNDays(6), DateListUtil.getLastNDays(0));
			hasData = new String[dateList.size()];
			hasAmountData = new double[dateList.size()];
			for (int i = 0; i < dateList.size(); i++) {
				hasData[i] = dateList.get(i);
				// findRkcqkTime
				String dateTime = dateList.get(i) + " " + "00:00:00";
				List<InventoryRecordBO> list = commonMapper.findRkcqkTime(depotIds, userId, grainType, type,
						searchType, dateTime, 0, 1);
				if (type == 1) {// 按公斤
					if (list != null && list.size() > 0) {
						hasAmountData[i] = Doublediv(list.get(0).getBalance(), 1000.0, 4);
					} else {
						hasAmountData[i] = 0;
					}
				} else {
					if (list != null && list.size() > 0) {
						if (list.get(0).getPrice() != null) {
							hasAmountData[i] = list.get(0).getPrice();
						} else {
							hasAmountData[i] = 0;
						}
					}

				}
			}

			// if (rkcqk != null && rkcqk.size() > 0) {
			// hasData = new String[rkcqk.size()];
			// hasAmountData = new double[rkcqk.size()];
			// int i = 0;
			// for(int j = rkcqk.size()-1;j >= 0;j--){
			//
			// hasData[i] = rkcqk.get(j).getDateStr();
			// if (type == 1) {// 按公斤
			// if (rkcqk.get(j).getBalance() != null) {
			// hasAmountData[i] = Doublediv(rkcqk.get(j).getBalance(), 1000.0,
			// 4);
			// } else {
			// hasAmountData[i] = 0;
			// }
			//
			// } else {// 按金额
			// if (rkcqk.get(j).getPrice() != null) {
			// hasAmountData[i] = rkcqk.get(j).getPrice();
			// } else {
			// hasAmountData[i] = 0;
			// }
			//
			// }
			// i++;
			//
			// }
			// }

		} else if (searchType == 2) { // 周
			// 周的入库情况
			List<InventoryRecordBO> zrkqk = commonMapper.findZrkqk(depotIds, userId, grainType, type, searchType, 0, 7);
			if (zrkqk != null && zrkqk.size() > 0) {
				xData = new String[zrkqk.size()];
				xDataz = new String[zrkqk.size()];
				yinPriceData = new String[zrkqk.size()];
				yinAmountData = new double[zrkqk.size()];
				int i = 0;
				for (int j = zrkqk.size() - 1; j >= 0; j--) {
					xData[i] = zrkqk.get(j).getYear() + "年第" + zrkqk.get(j).getDateStr() + "周";
					String[] bEdate = TDateTimeUnits.getDayOfWeek(zrkqk.get(j).getYear(),
							Integer.parseInt(zrkqk.get(j).getDateStr()));
					if (bEdate != null && bEdate.length == 2) {
						xDataz[i] = dateReplace(bEdate[0]) + "~" + dateReplace(bEdate[1]);
					}

					if (zrkqk.get(j).getPrice() != null) {
						yinPriceData[i] = formatToPercentP3(zrkqk.get(j).getPrice());
					} else {
						yinPriceData[i] = "0";
					}
					if (type == 1) {// 按公斤
						if (zrkqk.get(j).getNetWeightIn() != null) {
							yinAmountData[i] = Doublediv(zrkqk.get(j).getNetWeightIn(), 1000.0, 4);
						} else {
							yinAmountData[i] = 0;
						}

					} else {// 按金额
						if (zrkqk.get(j).getMoneyIn() != null) {
							yinAmountData[i] = zrkqk.get(j).getMoneyIn();
						} else {
							yinAmountData[i] = 0;
						}

					}
					i++;

				}
			}

			// 周的出库情况
			List<InventoryRecordBO> zckqk = commonMapper.findZckqk(depotIds, userId, grainType, type, searchType, 0, 7);
			if (zckqk != null && zckqk.size() > 0) {
				outData = new String[zckqk.size()];
				outDataz = new String[zckqk.size()];
				outPriceData = new String[zckqk.size()];
				outAmoountData = new double[zckqk.size()];
				int i = 0;
				for (int j = zckqk.size() - 1; j >= 0; j--) {
					outData[i] = zckqk.get(j).getYear() + "年第" + zckqk.get(j).getDateStr() + "周";
					String[] bEdate = TDateTimeUnits.getDayOfWeek(zckqk.get(j).getYear(),
							Integer.parseInt(zckqk.get(j).getDateStr()));
					if (bEdate != null && bEdate.length == 2) {
						outDataz[i] = dateReplace(bEdate[0]) + "~" + dateReplace(bEdate[1]);
					}
					if (zckqk.get(j).getPrice() != null) {
						outPriceData[i] = formatToPercentP3(zckqk.get(j).getPrice());
					} else {
						outPriceData[i] = "0";
					}

					if (type == 1) {// 按公斤
						if (zckqk.get(j).getNetWeightOut() != null) {
							outAmoountData[i] = Doublediv(zckqk.get(j).getNetWeightOut(), 1000.0, 4);
						} else {
							outAmoountData[i] = 0;
						}
					} else {// 按金额
						if (zckqk.get(j).getMoneyOut() != null) {
							outAmoountData[i] = zckqk.get(j).getMoneyOut();
						} else {
							outAmoountData[i] = 0;
						}

					}
					i++;

				}

			}

			List<InventoryRecordBO> zkcqk = commonMapper.findZkcqkTime(depotIds, userId, grainType, type, searchType,
					null, 0, 7);
			if (zkcqk != null && zkcqk.size() > 0) {
				Map<String, List<String>> dateMap = TDateTimeUnits.getDateWeek(new Date());
				hasData = new String[7];
				hasDataz = new String[7];
				hasAmountData = new double[7];
				int a = 0;
				List<String> str = new ArrayList<String>();
				for (Map.Entry<String, List<String>> entry : dateMap.entrySet()) {
					str = entry.getValue();
					for (int i = 0; i < str.size(); i++) {
						hasData[a] = entry.getKey() + "年第" + str.get(i) + "周";
						String[] bEdate = TDateTimeUnits.getDayOfWeek(Integer.parseInt(entry.getKey()),
								Integer.parseInt(str.get(i)));
						if (bEdate != null && bEdate.length == 2) {
							hasDataz[a] = dateReplace(bEdate[0]) + "~" + dateReplace(bEdate[1]);
						}

						int year = Integer.parseInt(entry.getKey());
						int week = Integer.parseInt(str.get(i));

						int searchSize = zkcqk.size();
						for (int j = searchSize - 1; j >= 0; j--) {

							InventoryRecordBO inventoryRecordBO = zkcqk.get(j);

							int searchYear = inventoryRecordBO.getYear();
							int searchWeek = Integer.parseInt(inventoryRecordBO.getDateStr());

							if (searchYear < year) {
								if (type == 1) {// 按公斤
									if (inventoryRecordBO.getBalance() != null) {
										hasAmountData[a] = Doublediv(inventoryRecordBO.getBalance(), 1000.0, 4);
									}
								} else {// 按金额
									if (inventoryRecordBO.getPrice() != null) {
										hasAmountData[a] = inventoryRecordBO.getPrice();
									}
								}
								break;
							}
							if (year == searchYear && searchWeek < week) {
								if (type == 1) {// 按公斤
									if (inventoryRecordBO.getBalance() != null) {
										hasAmountData[a] = Doublediv(inventoryRecordBO.getBalance(), 1000.0, 4);
									}
								} else {// 按金额
									if (inventoryRecordBO.getPrice() != null) {
										hasAmountData[a] = inventoryRecordBO.getPrice();
									}
								}
								break;
							}

							if (year == searchYear && week == searchWeek) {
								if (type == 1) {// 按公斤
									if (inventoryRecordBO.getBalance() != null) {
										hasAmountData[a] = Doublediv(inventoryRecordBO.getBalance(), 1000.0, 4);
									}
								} else {// 按金额
									if (inventoryRecordBO.getPrice() != null) {
										hasAmountData[a] = inventoryRecordBO.getPrice();
									}
								}
								break;
							}

						}
						a++;
					}

					//
					// if(cqMap.get(entry.getKey()) != null &&
					// cqMap.get(entry.getKey()).get(str.get(i)) != null){
					// bo =cqMap.get(entry.getKey()).get(str.get(i));
					// if (type == 1) {// 按公斤
					// if (bo.getBalance() != null) {
					// hasAmountData[a] = Doublediv(bo.getBalance(), 1000.0, 4);
					// }
					// } else {// 按金额
					// if (bo.getPrice() != null) {
					// hasAmountData[a]= bo.getPrice();
					// }
					// }
					// }else{
					// if(Integer.parseInt(entry.getKey()) == bo.getYear()){
					// if(Integer.parseInt(bo.getDateStr())<
					// Integer.parseInt(str.get(i))){
					// if (type == 1) {// 按公斤
					// if (bo.getBalance() != null) {
					// hasAmountData[a] = Doublediv(bo.getBalance(), 1000.0, 4);
					// }
					// } else {// 按金额
					// if (bo.getPrice() != null) {
					// hasAmountData[a]= bo.getPrice();
					// }
					// }
					// }else{
					// hasAmountData[a] = 0;
					// }
					// }else if(bo.getYear() <
					// Integer.parseInt(entry.getKey())){
					// if (type == 1) {// 按公斤
					// if (bo.getBalance() != null) {
					// hasAmountData[a] = Doublediv(bo.getBalance(), 1000.0, 4);
					// }
					// } else {// 按金额
					// if (bo.getPrice() != null) {
					// hasAmountData[a]= bo.getPrice();
					// }
					// }
					// }
					//
					// }
					// hasAmountData[a] = value;

				}
			}

			// List<String> str =new ArrayList<String>();
			// hasData = new String[7];
			// hasDataz = new String[7];
			// hasAmountData = new double[7];
			// for (Map.Entry<String, List<String>> entry : dateMap.entrySet())
			// {
			// String years = entry.getKey();
			// str =new ArrayList<String>();
			// str = entry.getValue();
			// for (int i = 0; i < str.size(); i++) {
			// hasData[i] = years + "年第" + str.get(i) + "周";
			// String[] bEdate =
			// TDateTimeUnits.getDayOfWeek(Integer.parseInt(years),
			// Integer.parseInt(str.get(i)));
			// if (bEdate != null && bEdate.length == 2) {
			// hasDataz[i] = dateReplace(bEdate[0]) + "~" +
			// dateReplace(bEdate[1]);
			// }
			// InventoryRecordBO bo = null;
			// if(cqMap.get(years) != null && cqMap.get(years).get(str.get(i))
			// != null){
			// bo = cqMap.get(years).get(str.get(i));
			// }else{
			// int week = Integer.parseInt(str.get(i));
			// for(int j = 0 ; j < zkcqk.size();j++){
			// int year = Integer.parseInt(years);
			// week = week -1;
			// if(week == 0){
			// week = 53;
			// year = year -1;
			// }
			// if(cqMap.get(year) != null && cqMap.get(year).get(week) != null){
			// bo = cqMap.get(years).get(str.get(i));
			// }
			// }
			// }
			// if(bo != null){
			// if (type == 1) {// 按公斤
			// if (bo.getBalance() != null) {
			// hasAmountData[i] = Doublediv(bo.getBalance(), 1000.0, 4);
			// } else {
			// hasAmountData[i] = 0;
			// }
			//
			// } else {// 按金额
			// if (bo.getPrice() != null) {
			// hasAmountData[i] = bo.getPrice();
			// } else {
			// hasAmountData[i] = 0;
			// }
			// }
			// }
			// }
			// }

			// // 周的库存情况
			//
			// if (zkcqk != null && zkcqk.size() > 0) {
			// hasData = new String[zkcqk.size()];
			// hasDataz = new String[zkcqk.size()];
			// hasAmountData = new double[zkcqk.size()];
			// int i = 0;
			// for(int j = zkcqk.size()-1;j >= 0;j--){
			//
			// hasData[i] = zkcqk.get(j).getYear() + "年第" +
			// zkcqk.get(j).getDateStr() + "周";
			//
			// String[] bEdate =
			// TDateTimeUnits.getDayOfWeek(zkcqk.get(j).getYear(),
			// Integer.parseInt(zkcqk.get(j).getDateStr()));
			// if (bEdate != null && bEdate.length == 2) {
			// hasDataz[i] = dateReplace(bEdate[0]) + "~" +
			// dateReplace(bEdate[1]);
			// }
			//
			//
			// if (type == 1) {// 按公斤
			// if (zkcqk.get(j).getBalance() != null) {
			// hasAmountData[i] = Doublediv(zkcqk.get(j).getBalance(), 1000.0,
			// 4);
			// } else {
			// hasAmountData[i] = 0;
			// }
			//
			// } else {// 按金额
			// if (zkcqk.get(j).getPrice() != null) {
			// hasAmountData[i] = zkcqk.get(j).getPrice();
			// } else {
			// hasAmountData[i] = 0;
			// }
			//
			// }
			// i++;
			//
			// }
			// }

		} else if (searchType == 3) { // 月
			// 月的入库情况
			List<InventoryRecordBO> rrkqk = commonMapper.findYrkqk(depotIds, userId, grainType, type, searchType, 0, 7);
			if (rrkqk != null && rrkqk.size() > 0) {
				xData = new String[rrkqk.size()];
				yinPriceData = new String[rrkqk.size()];
				yinAmountData = new double[rrkqk.size()];
				int i = 0;
				for (int j = rrkqk.size() - 1; j >= 0; j--) {

					xData[i] = rrkqk.get(j).getYear() + "年" + rrkqk.get(j).getDateStr() + "月";
					if (rrkqk.get(j).getPrice() != null) {
						yinPriceData[i] = formatToPercentP3(rrkqk.get(j).getPrice());
					} else {
						yinPriceData[i] = "0";
					}

					if (type == 1) {// 按公斤
						if (rrkqk.get(j).getNetWeightIn() != null) {
							yinAmountData[i] = Doublediv(rrkqk.get(j).getNetWeightIn(), 1000.0, 4);
						} else {
							yinAmountData[i] = 0;
						}

					} else {// 按金额
						if (rrkqk.get(j).getMoneyIn() != null) {
							yinAmountData[i] = rrkqk.get(j).getMoneyIn();
						} else {
							yinAmountData[i] = 0;
						}
					}
					i++;

				}
			}
			// 月的出库情况
			List<InventoryRecordBO> rckqk = commonMapper.findYckqk(depotIds, userId, grainType, type, searchType, 0, 7);
			if (rckqk != null && rckqk.size() > 0) {
				outData = new String[rckqk.size()];
				outPriceData = new String[rckqk.size()];
				outAmoountData = new double[rckqk.size()];
				int i = 0;
				for (int j = rckqk.size() - 1; j >= 0; j--) {
					outData[i] = rckqk.get(j).getYear() + "年" + rckqk.get(j).getDateStr() + "月";
					if (rckqk.get(j).getPrice() != null) {
						outPriceData[i] = formatToPercentP3(rckqk.get(j).getPrice());
					} else {
						outPriceData[i] = "0";
					}

					if (type == 1) {// 按公斤
						if (rckqk.get(j).getNetWeightOut() != null) {
							outAmoountData[i] = Doublediv(rckqk.get(j).getNetWeightOut(), 1000.0, 4);
						} else {
							outAmoountData[i] = 0;
						}
					} else {// 按金额
						if (rckqk.get(j).getMoneyOut() != null) {

							outAmoountData[i] = rckqk.get(j).getMoneyOut();
						} else {
							outAmoountData[i] = 0;
						}
					}
					i++;

				}

			}

			// 月的库存情况
			List<InventoryRecordBO> ykcqk = commonMapper.findYkcqkTime(depotIds, userId, grainType, type, searchType,
					0, 7);
			if (ykcqk != null && ykcqk.size() > 0) {
				List<String> dateList = TDateTimeUnits.getDateMonth(new Date());
				hasData = new String[7];
				hasAmountData = new double[7];
				int a = 0;
				for (String dateStr : dateList) {
					String[] time = dateStr.split("-");
					hasData[a] = time[0] + "年" + time[1] + "月";

					int year = Integer.parseInt(time[0]);
					int month = Integer.parseInt(time[1]);

					int searchSize = ykcqk.size();
					for (int j = searchSize - 1; j >= 0; j--) {

						InventoryRecordBO inventoryRecordBO = ykcqk.get(j);

						int searchYear = inventoryRecordBO.getYear();
						int searchMonth = Integer.parseInt(inventoryRecordBO.getDateStr());

						if (searchYear < year) {
							if (type == 1) {// 按公斤
								if (inventoryRecordBO.getBalance() != null) {
									hasAmountData[a] = Doublediv(inventoryRecordBO.getBalance(), 1000.0, 4);
								}
							} else {// 按金额
								if (inventoryRecordBO.getPrice() != null) {
									hasAmountData[a] = inventoryRecordBO.getPrice();
								}
							}
							break;
						}
						if (year == searchYear && searchMonth < month) {
							if (type == 1) {// 按公斤
								if (inventoryRecordBO.getBalance() != null) {
									hasAmountData[a] = Doublediv(inventoryRecordBO.getBalance(), 1000.0, 4);
								}
							} else {// 按金额
								if (inventoryRecordBO.getPrice() != null) {
									hasAmountData[a] = inventoryRecordBO.getPrice();
								}
							}
							break;
						}

						if (year == searchYear && month == searchMonth) {
							if (type == 1) {// 按公斤
								if (inventoryRecordBO.getBalance() != null) {
									hasAmountData[a] = Doublediv(inventoryRecordBO.getBalance(), 1000.0, 4);
								}
							} else {// 按金额
								if (inventoryRecordBO.getPrice() != null) {
									hasAmountData[a] = inventoryRecordBO.getPrice();
								}
							}
							break;
						}

					}
					a++;
				}
			}

			// 月的库存情况
			// List<InventoryRecordBO> rkcqk = commonMapper.findYkcqk(userId,
			// grainType, type, searchType, 0, 7);
			// if (rkcqk != null && rkcqk.size() > 0) {
			// hasData = new String[rkcqk.size()];
			// hasAmountData = new double[rkcqk.size()];
			// int i = 0;
			// for(int j = rkcqk.size()-1;j >= 0;j--){
			//
			// hasData[i] = rkcqk.get(j).getYear() + "年" +
			// rkcqk.get(j).getDateStr() + "月";
			// if (type == 1) {// 按公斤
			// if (rkcqk.get(j).getPrice() != null) {
			// hasAmountData[i] = Doublediv(rkcqk.get(j).getBalance(), 1000.0,
			// 4);
			// } else {
			// hasAmountData[i] = 0;
			// }
			//
			// } else {// 按金额
			// if (rkcqk.get(j).getPrice() != null) {
			// hasAmountData[i] = rkcqk.get(j).getPrice();
			// } else {
			// hasAmountData[i] = 0;
			// }
			//
			// }
			// i++;
			//
			// }
			// }
		}

		// String[] xData1 =
		// {"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
		// double[] yinPriceData1 = {0.78, 0.8, 0.78, 0.9, 0.8, 0.9, 0.65, 0.67,
		// 0.86, 0.78, 0.67, 0.6};
		// double[] yinAmountData1 = {2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6,
		// 162.2, 32.6, 20.0, 6.4, 3.3};
		// double[] hasAmountData1 = {2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6,
		// 162.2, 32.6, 20.0, 6.4, 3.3};
		// double[] outPriceData1 = {2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6,
		// 162.2, 32.6, 20.0, 6.4, 3.3};
		// double[] outAmoountData1 = {2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3,
		// 23.4, 23.0, 16.5, 12.0, 6.2};
		//
		// mp.put("xData", xData1);
		// mp.put("yinPriceData", yinPriceData1);
		// mp.put("yinAmountData", yinAmountData1);
		// mp.put("outPriceData", hasAmountData1);
		// mp.put("outAmoountData", outPriceData1);
		// mp.put("hasAmountData", outAmoountData1);
		mp.put("xData", xData);
		mp.put("outData", outData);
		mp.put("hasData", hasData);
		mp.put("xDataz", xDataz);
		mp.put("outDataz", outDataz);
		mp.put("hasDataz", hasDataz);
		mp.put("yinPriceData", yinPriceData);
		mp.put("yinAmountData", yinAmountData);
		mp.put("outPriceData", outPriceData);
		mp.put("outAmoountData", outAmoountData);
		mp.put("hasAmountData", hasAmountData);

		// if(yinPriceData != null && yinPriceData.length > 0){
		// double yinPriceDataMin = getMin(yinPriceData);
		// double yinPriceDataMax = getMax(yinPriceData);
		// mp.put("yinPriceDataMax", yinPriceDataMax);
		// mp.put("yinPriceDataMin", yinPriceDataMin);
		//
		// }else{
		// mp.put("yinPriceDataMax", 0);
		// mp.put("yinPriceDataMin", 0);
		// }
		// if(yinAmountData != null && yinAmountData.length > 0){
		// double yinAmountDataMin = getMin(yinAmountData);
		// double yinAmountDataMax = getMax(yinAmountData);
		// mp.put("yinAmountDataMin", yinAmountDataMin);
		// mp.put("yinAmountDataMax", yinAmountDataMax);
		// }else{
		// mp.put("yinAmountDataMin", 0);
		// mp.put("yinAmountDataMax", 0);
		// }
		// if(outPriceData != null && outPriceData.length > 0){
		// double outPriceDataMin = getMin(outPriceData);
		// double outPriceDataMax = getMax(outPriceData);
		// mp.put("outPriceDataMin", outPriceDataMin);
		// mp.put("outPriceDataMax", outPriceDataMax);
		// }else{
		// mp.put("outPriceDataMin", 0);
		// mp.put("outPriceDataMax", 0);
		// }
		//
		// if(outAmoountData != null && outAmoountData.length > 0){
		// double outAmoountDataMin = getMin(outPriceData);
		// double outAmoountDataMax = getMax(outPriceData);
		// mp.put("outAmoountDataMin", outAmoountDataMin);
		// mp.put("outAmoountDataMax", outAmoountDataMax);
		// }else{
		// mp.put("outAmoountDataMin", 0);
		// mp.put("outAmoountDataMax", 0);
		// }
		//
		// if(hasAmountData != null && hasAmountData.length > 0){
		// double hasAmountDataMin = getMin(hasAmountData);
		// double hasAmountDataMax = getMax(hasAmountData);
		// mp.put("hasAmountDataMin", hasAmountDataMin);
		// mp.put("hasAmountDataMax", hasAmountDataMax);
		// }else{
		// mp.put("hasAmountDataMin", 0);
		// mp.put("hasAmountDataMax", 0);
		// }

		maplist.add(mp);
		m.put("dataList", maplist);
		return m;
	}

	public static double getMax(double[] arr) {
		double max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static double getMin(double[] arr) {
		double max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < max) {
				max = arr[i];
			}
		}
		return max;
	}

	/**
	 * double计算 保留位数
	 */
	public double Doublediv(Double v1, Double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("Thescalemustbeapositiveintegerorzero");
		}
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}
