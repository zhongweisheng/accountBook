package lb.rest.user.db.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsInventoryStorageTemp;
import lb.rest.user.db.entity.BsInventoryStorageTempExample;
import lb.rest.user.db.entity.BsInventoryStorageTempExample.Criteria;
import lb.rest.user.db.entity.BsInventoryStorageTempKey;
import lb.rest.user.db.mapper.BsInventoryStorageTempMapper;
import lb.rest.user.db.mapper.CommonMapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.mlb.enums.GrainTypeEnum;
import com.mlb.enums.RecordTypeEnum;
import com.mlb.util.JsonDataUtils;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;
import fc.wpf.rest.utils.DateStyle;
import fc.wpf.rest.utils.DateUtil;
import fc.wpf.rest.utils.NumberFormatUtil;

@Repository
public class BsInventoryStorageTempDao implements
		StaticTableDaoSupport<BsInventoryStorageTemp, BsInventoryStorageTempExample, BsInventoryStorageTempKey> {

	@Resource
	private BsInventoryStorageTempMapper mapper;

	@Resource
	private CommonMapper commonMapper;

	@Resource
	private BsInventoryDepotDao bsInventoryDepotDao;

	public int updateByExampleSelective(int depotId, int ownerId) {
		BsInventoryStorageTempExample example = new BsInventoryStorageTempExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(ownerId).andDepotIdEqualTo(0);
		BsInventoryStorageTemp record = new BsInventoryStorageTemp();
		record.setDepotId(depotId);
		return mapper.updateByExampleSelective(record, example);
	}

	public JsonDataUtils searchList(boolean isExcel, int ownerId, int userId, int grainType, int recordType,
			int searchType, int staffId, String staffName, int isPay, String recordNumber, String licensePlate,
			int driverId, String strTime, String endTime, int depotId, int currentPage, int pageSize) {

		JsonDataUtils jsonUtils = new JsonDataUtils();
		jsonUtils.setSearchType(searchType);
		jsonUtils.setGrainType(grainType);
		jsonUtils.setRecordType(recordType);
		int offset = (currentPage - 1) * pageSize;
		int limit = pageSize;
		int number = offset + 1;

		if (searchType == 1) {
			BsInventoryStorageTempExample example = new BsInventoryStorageTempExample();
			example.setOrderByClause(" create_time desc ");
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
			if (StringUtils.isNotEmpty(recordNumber)) {
				criteria.andRecordNumberLike("%" + recordNumber + "%");
			}
			if (StringUtils.isNotEmpty(licensePlate)) {
				criteria.andLicensePlateLike("%" + licensePlate + "%");
			}
			if (driverId > 0) {
				criteria.andDriverIdEqualTo(driverId);
			}
			if (strTime != null && !"".equals(strTime) && endTime != null && !"".equals(endTime)) {
				Date stime = DateUtil.getDate(DateStyle.YYYY_MM_DD.getValue(), strTime);
				Date etime = DateUtil.getDate(DateStyle.YYYY_MM_DD.getValue(), endTime);
				criteria.andRecordTimeBetween(stime, etime);
			}
			if (isPay > -1) {
				criteria.andIfPaymentEqualTo(isPay);
			}
			if (depotId > 0) {
				criteria.andDepotIdEqualTo(depotId);
			}
			criteria.andUserIdEqualTo(ownerId);
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

			List<BsInventoryStorageTemp> list = mapper.selectByExample(example);

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
				map.put("driverName", "司机姓名");

				if (recordType == RecordTypeEnum.代储.getCode()) {
					jsonUtils.addTitle("number", "id", "type", "recordType", "recordNumber", "grainType", "date",
							"time", "licensePlate", "grossWeight", "tareWeight", "netWeight", "money", "deduction",
							"paidMoney", "unpaidMoney", "hasSettled", "notSettled", "staffId", "staffName",
							"driverName");
				}

				jsonUtils.setTitleMap(map);
				jsonUtils.setSuccess(true);
				for (BsInventoryStorageTemp item : list) {
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
									item.getStaffId(), item.getStaffName(), item.getDriverName());
						} else {
							jsonUtils.addOneRow(number++, item.getId(), searchType, recordName, item.getRecordNumber(),
									grainName, dateReplace(item.getDate()), item.getTime(), item.getLicensePlate(),
									formatMoneyPercentCMA(item.getGrossWeightIn()),
									formatMoneyPercentCMA(item.getTareWeightIn()),
									formatMoneyPercentCMA(item.getNetWeightIn()),
									formatMoneyPercentCMA(item.getMoneyIn()),
									formatToPercentP3CMA(item.getDeduction()),
									formatMoneyPercentCMA(item.getPaidMoney()),
									formatMoneyPercentCMA(item.getUnpaidMoney()),
									formatMoneyPercentCMA(item.getHasSettled()),
									formatMoneyPercentCMA(item.getNotSettled()), item.getStaffId(),
									item.getStaffName(), item.getDriverName());
						}
					} else {
					}
				}
			}
		} else {
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

	@Override
	public int countByExample(BsInventoryStorageTempExample paramD) {
		return mapper.countByExample(paramD);
	}

	@Override
	public int deleteByExample(BsInventoryStorageTempExample paramD) {
		return mapper.deleteByExample(paramD);
	}

	@Override
	public int deleteByPrimaryKey(BsInventoryStorageTempKey paramK) {
		return mapper.deleteByPrimaryKey(paramK);
	}

	@Override
	public int insert(BsInventoryStorageTemp paramT) {
		return mapper.insert(paramT);
	}

	@Override
	public int insertSelective(BsInventoryStorageTemp paramT) {
		return mapper.insertSelective(paramT);
	}

	@Override
	public int batchInsert(List<BsInventoryStorageTemp> paramList) {
		for (BsInventoryStorageTemp BsInventoryStorageTemp : paramList) {
			mapper.insert(BsInventoryStorageTemp);
		}
		return paramList.size();
	}

	@Override
	public int batchUpdate(List<BsInventoryStorageTemp> paramList) {
		for (BsInventoryStorageTemp BsInventoryStorageTemp : paramList) {
			mapper.updateByPrimaryKeySelective(BsInventoryStorageTemp);
		}
		return paramList.size();
	}

	@Override
	public int batchDelete(List<BsInventoryStorageTemp> paramList) {
		for (BsInventoryStorageTemp BsInventoryStorageTemp : paramList) {
			mapper.deleteByPrimaryKey(BsInventoryStorageTemp);
		}
		return 0;
	}

	@Override
	public List<BsInventoryStorageTemp> selectByExample(BsInventoryStorageTempExample paramD) {
		return mapper.selectByExample(paramD);
	}

	@Override
	public BsInventoryStorageTemp selectByPrimaryKey(BsInventoryStorageTempKey paramK) {
		return mapper.selectByPrimaryKey(paramK);
	}

	@Override
	public List<BsInventoryStorageTemp> findAll(List<BsInventoryStorageTemp> records) {
		if (records == null || records.size() <= 0) {
			return mapper.selectByExample(new BsInventoryStorageTempExample());
		}
		List<BsInventoryStorageTemp> list = new ArrayList<>();
		for (BsInventoryStorageTemp record : records) {
			BsInventoryStorageTemp result = mapper.selectByPrimaryKey(record);
			if (result != null) {
				list.add(result);
			}
		}
		return list;
	}

	@Override
	public int updateByExampleSelective(BsInventoryStorageTemp paramT, BsInventoryStorageTempExample paramD) {
		return mapper.updateByExampleSelective(paramT, paramD);
	}

	@Override
	public int updateByExample(BsInventoryStorageTemp paramT, BsInventoryStorageTempExample paramD) {
		return mapper.updateByExample(paramT, paramD);
	}

	@Override
	public int updateByPrimaryKeySelective(BsInventoryStorageTemp paramT) {
		return mapper.updateByPrimaryKey(paramT);
	}

	@Override
	public int updateByPrimaryKey(BsInventoryStorageTemp paramT) {
		return mapper.updateByPrimaryKey(paramT);
	}

	@Override
	public int sumByExample(BsInventoryStorageTempExample paramD) {
		return 0;
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(new BsInventoryStorageTempExample());
	}

	@Override
	public BsInventoryStorageTempExample getExample(BsInventoryStorageTemp record) {
		BsInventoryStorageTempExample example = new BsInventoryStorageTempExample();
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

}
