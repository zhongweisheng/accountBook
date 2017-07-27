package lb.rest.user.db.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsInventoryStorage;
import lb.rest.user.db.entity.BsInventoryStorageExample;
import lb.rest.user.db.entity.BsInventoryStorageExample.Criteria;
import lb.rest.user.db.entity.BsInventoryStorageKey;
import lb.rest.user.db.mapper.BsInventoryStorageMapper;
import lb.rest.user.db.mapper.CommonMapper;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mlb.bo.InventoryRecordBO;
import com.mlb.enums.GrainTypeEnum;
import com.mlb.enums.RecordTypeEnum;
import com.mlb.util.JsonDataUtils;
import com.mlb.util.SequenceUtil;
import com.mlb.util.TDateTimeUnits;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;
import fc.wpf.rest.utils.BeanFactory;
import fc.wpf.rest.utils.DateStyle;
import fc.wpf.rest.utils.DateUtil;
import fc.wpf.rest.utils.NumberFormatUtil;

@Repository
public class BsInventoryStorageDao implements
		StaticTableDaoSupport<BsInventoryStorage, BsInventoryStorageExample, BsInventoryStorageKey> {

	@Resource
	private BsInventoryStorageMapper mapper;
	@Resource
	private CommonMapper commonMapper;
	@Resource
	private BsInventoryDepotDao bsInventoryDepotDao;

	private BsSequenceDao bsSequenceDao = (BsSequenceDao) BeanFactory.getBean("bsSequenceDao");

	public JsonDataUtils searchList(boolean isExcel, int ownerId, int userId, int grainType, int recordType,
			int searchType, int staffId, String staffName, int isPay, int depotId, int currentPage, int pageSize) {

		JsonDataUtils jsonUtils = new JsonDataUtils();
		jsonUtils.setSearchType(searchType);
		jsonUtils.setGrainType(grainType);
		jsonUtils.setRecordType(recordType);
		int offset = (currentPage - 1) * pageSize;
		int limit = pageSize;
		int number = offset + 1;

		if (searchType == 1) {
			BsInventoryStorageExample example = new BsInventoryStorageExample();
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

			List<BsInventoryStorage> list = mapper.selectByExample(example);

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
				map.put("money", "金额（元）");
				map.put("grainType", "品种");
				map.put("licensePlate", "车号");
				map.put("grossWeight", "毛重（公斤）");
				map.put("tareWeight", "皮重（公斤）");
				map.put("deduction", "扣重（公斤）");

				if (recordType == RecordTypeEnum.代储.getCode()) {
					map.put("paidMoney", "已付款");
					map.put("unpaidMoney", "未付款");
				} else {
					map.put("paidMoney", "已收款");
					map.put("unpaidMoney", "未收款");
				}
				map.put("hasSettled", "已结算");
				map.put("notSettled", "未结算");
				map.put("staffId", "人员编号");
				map.put("staffName", "人员姓名");

				if (recordType == RecordTypeEnum.代储.getCode()) {
					jsonUtils.addTitle("number", "id", "type", "recordType", "recordNumber", "grainType", "date",
							"time", "licensePlate", "grossWeight", "tareWeight", "netWeight", "money", "deduction",
							"paidMoney", "unpaidMoney", "hasSettled", "notSettled", "staffId", "staffName");
				}

				jsonUtils.setTitleMap(map);
				jsonUtils.setSuccess(true);
				for (BsInventoryStorage item : list) {
					String grainName = GrainTypeEnum.getName(grainType);
					String recordName = RecordTypeEnum.getName(recordType);

					if (recordType == RecordTypeEnum.代储.getCode()) {
						// excel 导出 不添加 逗号
						if (isExcel) {
							jsonUtils.addOneRow(number++, item.getId(), searchType, recordName, item.getRecordNumber(),
									grainName, dateReplace(item.getDate()), item.getTime(), item.getLicensePlate(),
									formatMoneyPercent(item.getGrossWeightIn()),
									formatMoneyPercent(item.getTareWeightIn()),
									formatMoneyPercent(item.getNetWeightIn()), formatMoneyPercent(item.getMoneyIn()),
									formatMoneyPercent(item.getDeduction()), formatMoneyPercent(item.getPaidMoney()),
									formatMoneyPercent(item.getUnpaidMoney()),
									formatMoneyPercent(item.getHasSettled()), formatMoneyPercent(item.getNotSettled()),
									item.getStaffId(), item.getStaffName());
						} else {
							jsonUtils
									.addOneRow(number++, item.getId(), searchType, recordName, item.getRecordNumber(),
											grainName, dateReplace(item.getDate()), item.getTime(),
											item.getLicensePlate(), formatMoneyPercentCMA(item.getGrossWeightIn()),
											formatMoneyPercentCMA(item.getTareWeightIn()),
											formatMoneyPercentCMA(item.getNetWeightIn()),
											formatMoneyPercentCMA(item.getMoneyIn()),
											formatToPercentP3CMA(item.getDeduction()),
											formatMoneyPercentCMA(item.getPaidMoney()),
											formatMoneyPercentCMA(item.getUnpaidMoney()),
											formatMoneyPercentCMA(item.getHasSettled()),
											formatMoneyPercentCMA(item.getNotSettled()), item.getStaffId(),
											item.getStaffName());
						}
					} else {
					}
				}
			}
		} else {
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
			BsInventoryStorageExample example = new BsInventoryStorageExample();
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

			List<BsInventoryStorage> list = mapper.selectByExample(example);
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

				for (BsInventoryStorage item : list) {
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

	// 所有者下 有无 公司
	public BsInventoryStorage getStorageByOwnerId(int ownerId) {
		BsInventoryStorage storage = null;
		BsInventoryStorageExample exampleStorage = new BsInventoryStorageExample();
		exampleStorage.createCriteria().andIdEqualTo(ownerId);
		List<BsInventoryStorage> storageList = mapper.selectByExample(exampleStorage);
		if (storageList != null && storageList.size() > 0) {
			storage = storageList.get(0);
		} else {
			storage = new BsInventoryStorage();
			int id = 0;
			try {
				id = SequenceUtil.getInstance().nextValue("bs_inventory_storage");
				storage.setId(id);
				storage.setCreateTime(new Date());
				storage.setUpdateTime(new Date());
				mapper.insert(storage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return storage;
	}

	@Override
	public int countByExample(BsInventoryStorageExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BsInventoryStorageExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(BsInventoryStorageKey key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(BsInventoryStorage record) {
		double netWeight = record.getNetWeightIn();
		// 已结算未计算
		record.setHasSettled(0d);
		record.setNotSettled(netWeight);
		String dateTime = record.getDate() + " " + "00:00:00";
		record.setRecordTime(DateUtil.getDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue(), dateTime));
		int depotId = record.getDepotId() == null ? 0 : record.getDepotId();
		try {
			record.setRecordNumber(bsSequenceDao.nextValue(depotId, record.getUserId(), record.getGrainType(),
					record.getRecordType())
					+ "");
		} catch (Exception e) {
		}

		return mapper.insert(record);
	}

	@Override
	public int insertSelective(BsInventoryStorage record) {
		return mapper.insertSelective(record);
	}

	@Override
	@Transactional
	public int batchInsert(List<BsInventoryStorage> records) {
		for (BsInventoryStorage record : records) {
			mapper.insert(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchUpdate(List<BsInventoryStorage> records) {
		for (BsInventoryStorage record : records) {
			mapper.updateByPrimaryKeySelective(record);
		}
		return records.size();
	}

	@Override
	@Transactional
	public int batchDelete(List<BsInventoryStorage> records) {
		for (BsInventoryStorage record : records) {
			mapper.deleteByPrimaryKey(record);
		}
		return records.size();
	}

	@Override
	public List<BsInventoryStorage> selectByExample(BsInventoryStorageExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public BsInventoryStorage selectByPrimaryKey(BsInventoryStorageKey key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<BsInventoryStorage> findAll(List<BsInventoryStorage> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsInventoryStorageExample());
		}
		List<BsInventoryStorage> list = new ArrayList<>();
		for (BsInventoryStorage record : records) {
			BsInventoryStorage result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsInventoryStorage record, BsInventoryStorageExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BsInventoryStorage record, BsInventoryStorageExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BsInventoryStorage record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BsInventoryStorage record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int sumByExample(BsInventoryStorageExample example) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsInventoryStorageExample());
	}

	@Override
	public BsInventoryStorageExample getExample(BsInventoryStorage record) {
		BsInventoryStorageExample example = new BsInventoryStorageExample();
		if (record != null) {
			Criteria criteria = example.createCriteria();
			if (record.getId() != null) {
				criteria.andIdEqualTo(record.getId());
			}

		}
		return example;
	}
}