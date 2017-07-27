package lb.rest.trade.db.dao;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import javax.annotation.Resource;

import lb.rest.trade.db.entity.BsGoodsInfo;
import lb.rest.trade.db.entity.BsGoodsInfoExample;
import lb.rest.trade.db.entity.BsGoodsInfoExample.Criteria;
import lb.rest.trade.db.entity.BsGoodsInfoKey;
import lb.rest.trade.db.entity.CommonAttrValue;
import lb.rest.trade.db.entity.CommonAttrValueExample;
import lb.rest.trade.db.mapper.BsGoodsInfoMapper;
import lb.rest.trade.db.mapper.CommonAttrValueMapper;
import lb.rest.user.db.dao.CommonDao;
import lb.rest.user.db.dao.ImageDao;
import lb.rest.user.db.dao.MlbuserDao;
import lb.rest.user.db.entity.Image;
import lb.rest.user.db.entity.ImageKey;
import lb.rest.user.db.entity.Mlbuser;
import lb.rest.user.db.entity.MlbuserKey;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Repository;

import com.mlb.bo.UserAuthBO;
import com.mlb.util.CommonAttrValueUtil;

import fc.wpf.rest.utils.BeanFactory;
import fc.wpf.rest.utils.DateStyle;
import fc.wpf.rest.utils.DateUtil;

@Slf4j
@Repository
public class BsGoodsInfoServiceDao {

	private static BsGoodsInfoMapper bsGoodsInfoMapper = (BsGoodsInfoMapper) BeanFactory.getBean("bsGoodsInfoMapper");

	private static CommonAttrValueMapper commonAttrValueMapper = (CommonAttrValueMapper) BeanFactory
			.getBean("commonAttrValueMapper");

	@Resource
	private MlbuserDao mlbuserDao;

	private static ImageDao imageDao = (ImageDao) BeanFactory.getBean("imageDao");
	private static CommonDao commonDao = (CommonDao) BeanFactory.getBean("commonDao");

	public Map<String, Object> selectGoodsInfoList(Map<String, Object> map, int userLocation) {
		List<BsGoodsInfo> list = null;
		List<Map<String, Object>> listMap = null;
		Map<String, Object> maplist = new HashMap<String, Object>();
		// String map1 = req.getParameter("map");
		try {
			BsGoodsInfoExample example = new BsGoodsInfoExample();

			Criteria criteria = example.or();
			criteria.andUserIdIsNotNull();
			criteria.andUserIdNotEqualTo(0);

			// criteria.andCheckStatusEqualTo(1);
			criteria.andProcessStatusNotEqualTo(2);// 过滤掉删除的/下架的
			criteria.andCheckStatusNotEqualTo(2);// 过滤掉审核不通过的
			// 0全部，1小麦 或 2玉米
			if (map.get("type") != null && !"".equals(map.get("type"))) {
				int type = NumberUtils.toInt(map.get("type").toString());
				if (type > 0) {
					criteria.andFoodTypeEqualTo(type);
				}
			}
			Date time1 = DateUtil.addDays(new Date(), -30);
			// 时间、0全部，1近3天，2近5天，3近7天
			if (map.get("dateTime") != null && !"".equals(map.get("dateTime"))) {
				int dateTime = NumberUtils.toInt(map.get("dateTime").toString());
				if (dateTime > 0) {
					if (dateTime == 1) {
						time1 = DateUtil.addDays(new Date(), -3);
					} else if (dateTime == 2) {
						time1 = DateUtil.addDays(new Date(), -5);
					} else if (dateTime == 3) {
						time1 = DateUtil.addDays(new Date(), -7);
					}
				}
			}
			time1.setHours(0);
			time1.setMinutes(0);
			time1.setSeconds(0);
			criteria.andModifyTimeGreaterThanOrEqualTo(time1);
			String userName = "";
			if (map.get("userName") != null && !"".equals(map.get("userName"))) {
				userName = map.get("userName").toString();
				userName = StringUtils.trimToEmpty(userName);
				String name = URLDecoder.decode(userName);
				criteria.andUserNameLikeInsensitive("%" + name + "%");
			}

			String startDate = "";
			if (map.get("startDate") != null && !"".equals(map.get("startDate"))) {
				startDate = map.get("startDate").toString();
			}
			String endDate = "";
			if (map.get("endDate") != null && !"".equals(map.get("endDate"))) {
				endDate = map.get("endDate").toString();
			}
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println(startDate);

			if (StringUtils.isNotEmpty(startDate) && StringUtils.isNotEmpty(endDate)) {
				Date sDate = DateUtil.getDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue(), startDate + " 00:00:00");
				Date eDate = DateUtil.getDate(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue(), endDate + " 23:59:59");
				criteria.andModifyTimeBetween(sDate, eDate);
			}
			// 0全部，1国标一等粮、2国标二等粮、3国标三等粮、4国标四等粮、5国标五等粮、6等外粮
			if (map.get("quality") != null && !"".equals(map.get("quality"))) {
				String qualityStr = StringUtils.trimToEmpty(map.get("quality").toString());
				String[] qualityArr = qualityStr.split(",");
				if (qualityArr != null) {
					List<Integer> qualityList = new ArrayList<Integer>();
					for (String item : qualityArr) {
						int quality = NumberUtils.toInt(item);
						if (quality > 0) {
							qualityList.add(quality);
						}
					}
					if (qualityList.size() > 0) {
						criteria.andGrainLevelIn(qualityList);
					}
				}
			}
			// 地区
			if (map.get("location") != null && !"".equals(map.get("location"))) {
				String locationStr = (String) map.get("location");
				locationStr = StringUtils.removeEndIgnoreCase(locationStr, "00");
				locationStr = StringUtils.removeEndIgnoreCase(locationStr, "00");
				int locationBegin = NumberUtils.toInt(locationStr);
				int locationEnd = NumberUtils.toInt(locationStr);
				if (locationStr.length() == 2) {
					locationBegin = NumberUtils.toInt(locationStr + "0000");
					locationEnd = NumberUtils.toInt(locationStr + "9999");
				} else if (locationStr.length() == 4) {
					locationBegin = NumberUtils.toInt(locationStr + "00");
					locationEnd = NumberUtils.toInt(locationStr + "99");
				}
				criteria.andLocationBetween(locationBegin, locationEnd);
				// criteria.andLocationEqualTo(NumberUtils.toInt(map.get("location").toString()));
			}

			listMap = new ArrayList<Map<String, Object>>();

			Map<String, Object> m = null;
			example.setOrderByClause("modify_time desc");
			if (map.get("page") != null && !"".equals(map.get("page")) && map.get("number") != null
					&& !"".equals(map.get("number"))) {
				int page = Integer.parseInt(map.get("page").toString());
				int number = Integer.parseInt(map.get("number").toString());
				page = page * number;
				example.setOffset(page);
				example.setLimit(number);
			} else {
				// example.setOffset(1);
				// example.setLimit(500);
			}
			list = bsGoodsInfoMapper.selectByExample(example);
			if (list.size() > 0) {
				List<BsGoodsInfo> firstList = new ArrayList<BsGoodsInfo>();
				List<BsGoodsInfo> secondList = new ArrayList<BsGoodsInfo>();

				Map<String, UserAuthBO> userLevelMap = commonDao.getUserLevelMap(0);
				if (userLevelMap != null) {
					// 排序的list
					Date compareTime = DateUtil.addDays(new Date(), -3);
					Set<String> filterSet = new HashSet<String>();
					for (BsGoodsInfo goods : list) {
						int foodType = goods.getFoodType();
						int userIdBuy = goods.getUserId();
						Date updateCreate = goods.getModifyTime();

						String keyFilter = foodType + "-" + userIdBuy;
						if (filterSet.contains(keyFilter)) {
							continue;
						}
						filterSet.add(keyFilter);
						if (updateCreate.compareTo(compareTime) > 0) {
							// 顺序 第一个比第二个值小；
							firstList.add(goods);
						} else {
							secondList.add(goods);
						}
						String userPhone = goods.getUserPhone();
						UserAuthBO userAuthBO = userLevelMap.get(userPhone);
						if (userAuthBO != null) {
							goods.setViewCount(userAuthBO.getUserLevel());
						} else {
							goods.setViewCount(0);
						}
					}
					// Collections.sort(firstList, goodsUserLevelDesc);
					list = new ArrayList<BsGoodsInfo>();
					list.addAll(firstList);
					list.addAll(secondList);
					Collections.sort(list, goodsTimeDesc);
				}

				for (BsGoodsInfo goods : list) {
					m = new HashMap<String, Object>();

					m.put("id", goods.getId() + "");
					m.put("alreadyAC", 0);
					if (goods.getCheckStatus() != null && goods.getCheckStatus() == 1) {
						m.put("alreadyAC", 1);
					} else {
						m.put("alreadyAC", 0);
					}

					m.put("type", "");
					if (goods.getFoodType() == 1) {
						m.put("type", "小麦");
					} else if (goods.getFoodType() == 2) {
						m.put("type", "玉米");
					}
					m.put("people", goods.getUserName());
					m.put("price", 0);
					if (goods.getFoodPrice() != null) {
						m.put("price", goods.getFoodPrice());
					}
					m.put("number", 0);
					if (goods.getFoodNum() != null) {
						m.put("number", goods.getFoodNum());
					}

					if (goods.getGrainLevel() != null && !"".equals(goods.getGrainLevel())) {
						if (goods.getGrainLevel() == 0) {
							m.put("quality", "无");// 粮食国标
						} else if (goods.getGrainLevel() == 1) {
							m.put("quality", "国标一等粮");// 粮食国标
						} else if (goods.getGrainLevel() == 2) {
							m.put("quality", "国标二等粮");// 粮食国标
						} else if (goods.getGrainLevel() == 3) {
							m.put("quality", "国标三等粮");// 粮食国标
						} else if (goods.getGrainLevel() == 4) {
							m.put("quality", "国标四等粮");// 粮食国标
						} else if (goods.getGrainLevel() == 5) {
							m.put("quality", "国标五等粮");// 粮食国标
						}
					} else {
						m.put("quality", "无");// 粮食国标
					}
					m.put("userPhone", goods.getUserPhone());
					m.put("foodRequire", goods.getFoodRequire());
					m.put("bidInvoice", "无");// 是否索要发票
					if (goods.getHasInvoice() != null && goods.getHasInvoice() > 0) {
						if (goods.getHasInvoice() == 1) {
							m.put("bidInvoice", "是");// 是否索要发票
						} else {
							m.put("bidInvoice", "否");// 是否索要发票
						}
					}
					m.put("userId", goods.getUserId());

					String time = DateUtil.format(goods.getModifyTime(), DateStyle.YYYY_MM_DD);
					m.put("time", time);
					m.put("location", goods.getLocationDesc());
					int goodsLocation = goods.getLocation() == null ? 0 : goods.getLocation();
					// double distance =
					// RequireMatchUtil.baiduDistance(userLocation,
					// goodsLocation);
					double distance = 0;
					m.put("distance", distance + "");
					listMap.add(m);
				}
			}
			maplist.put("dataList", listMap);
		} catch (Exception e) {
			log.warn("BsUserRequireCtrl get by key error..", e);
		}

		return maplist;
	}

	public static void main(String[] args) {
		BsGoodsInfo info1 = new BsGoodsInfo();
		info1.setViewCount(1);
		BsGoodsInfo info2 = new BsGoodsInfo();
		info2.setViewCount(3);
		BsGoodsInfo info3 = new BsGoodsInfo();
		info2.setViewCount(6);

		List<BsGoodsInfo> list = new ArrayList<BsGoodsInfo>();
		list.add(info2);
		list.add(info1);
		list.add(info3);
		Collections.sort(list, goodsUserLevelDesc);

		for (BsGoodsInfo item : list) {
			System.out.println(item.getViewCount());
		}

	}

	public static final Comparator<BsGoodsInfo> goodsUserLevelDesc = new Comparator<BsGoodsInfo>() {
		public int compare(BsGoodsInfo o1, BsGoodsInfo o2) {
			if (o1 == null || o2 == null || o1.getViewCount() == null || o2.getViewCount() == null) {
				return 0;
			} else {
				int result1 = o1.getViewCount();
				int result2 = o2.getViewCount();
				// 降序 排列
				if (result1 < result2) {
					return 1;
				} else if (result1 > result2) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	};

	public static final Comparator<BsGoodsInfo> goodsTimeDesc = new Comparator<BsGoodsInfo>() {
		public int compare(BsGoodsInfo o1, BsGoodsInfo o2) {
			if (o1 == null || o2 == null) {
				return 0;
			} else {
				String time1 = DateUtil.format(o1.getModifyTime(), DateStyle.YYYY_MM_DD);
				String time2 = DateUtil.format(o2.getModifyTime(), DateStyle.YYYY_MM_DD);
				int sort = time2.compareTo(time1);

				if (sort == 0 && o1.getViewCount() != null && o2.getViewCount() != null) {
					int result1 = o1.getViewCount();
					int result2 = o2.getViewCount();
					// 降序 排列
					if (result1 < result2) {
						return 1;
					} else if (result1 > result2) {
						return -1;
					} else {
						return 0;
					}
				} else {
					return sort;
				}

			}
		}
	};

	public Map<String, Object> getBsGoodsInfoByMlbUserId(int mlbuserId) {
		List<BsGoodsInfo> list = null;
		List<Map<String, Object>> listMap = null;
		Map<String, Object> maplist = new HashMap<String, Object>();
		// String map1 = req.getParameter("map");
		try {
			BsGoodsInfoExample example = new BsGoodsInfoExample();
			Criteria criteria = example.or();
			criteria.andUserIdEqualTo(mlbuserId);
			criteria.andProcessStatusNotEqualTo(2);// 过滤掉删除的/下架的
			listMap = new ArrayList<Map<String, Object>>();
			Map<String, Object> m = null;
			example.setOrderByClause("modify_time desc");
			list = bsGoodsInfoMapper.selectByExample(example);
			if (list.size() > 0) {
				for (BsGoodsInfo goods : list) {
					m = new HashMap<String, Object>();
					m.put("id", goods.getId() + "");
					if (goods.getCheckStatus() != null && goods.getCheckStatus() == 1) {
						m.put("alreadyAC", 1);
					} else {
						m.put("alreadyAC", 0);

					}
					m.put("type", "");
					if (goods.getFoodType() == 1) {
						m.put("type", "小麦");
					} else if (goods.getFoodType() == 2) {
						m.put("type", "玉米");
					}
					m.put("people", goods.getUserName());
					m.put("price", 0);
					if (goods.getFoodPrice() != null) {
						m.put("price", goods.getFoodPrice());
					}
					m.put("number", 0);
					if (goods.getFoodNum() != null) {
						m.put("number", goods.getFoodNum());
					}
					if (goods.getGrainLevel() != null && !"".equals(goods.getGrainLevel())) {
						if (goods.getGrainLevel() == 0) {
							m.put("quality", "无");// 粮食国标
						} else if (goods.getGrainLevel() == 1) {
							m.put("quality", "国标一等粮");// 粮食国标
						} else if (goods.getGrainLevel() == 2) {
							m.put("quality", "国标二等粮");// 粮食国标
						} else if (goods.getGrainLevel() == 3) {
							m.put("quality", "国标三等粮");// 粮食国标
						} else if (goods.getGrainLevel() == 4) {
							m.put("quality", "国标四等粮");// 粮食国标
						} else if (goods.getGrainLevel() == 5) {
							m.put("quality", "国标五等粮");// 粮食国标
						}
					} else {
						m.put("quality", "无");// 粮食国标
					}
					m.put("location", goods.getLocationDesc());
					m.put("foodRequire", goods.getFoodRequire());

					Long l = 0l;
					if (goods.getModifyTime() != null) {
						String time = DateUtil.format(goods.getModifyTime(), DateStyle.YYYY_MM_DD);
						String effectiveTime = DateUtil.format(DateUtil.addDays(goods.getModifyTime(), 3),
								DateStyle.YYYY_MM_DD);
						l = DateUtil.getDaysDifference(goods.getModifyTime(), new Date());
						m.put("time", time);
						m.put("effectiveTime", effectiveTime);
					} else {
						m.put("time", "");
						m.put("effectiveTime", "");
					}
					if (l > 3) {
						m.put("butStatus", 1);
					} else {
						m.put("butStatus", 0);
					}
					listMap.add(m);
				}
			}
			maplist.put("dataList", listMap);
		} catch (Exception e) {
			log.warn("BsUserRequireCtrl get by key error..", e);
		}

		return maplist;
	}

	public void insert(BsGoodsInfo info, String imgeIds) {
		try {
			info.setCreateTime(new Date());
			info.setModifyTime(new Date());
			info.setProcessStatus(0);
			info.setFoodSource("1");
			info.setCheckServiceStatus(0);
			info.setCheckStatus(0);
			Mlbuser mlbuser = new Mlbuser();
			MlbuserKey mlbuserKey = new MlbuserKey();
			mlbuserKey.setUserid(info.getUserId());
			mlbuser = mlbuserDao.selectByPrimaryKey(mlbuserKey);
			if (mlbuser != null) {
				info.setUserName(mlbuser.getTruename());
				info.setUserPhone(mlbuser.getPhone());
			}
			if (info.getCreateUserid() != null && info.getCreateUserid() > 0) {
				mlbuser = new Mlbuser();
				mlbuserKey = new MlbuserKey();
				mlbuserKey.setUserid(info.getCreateUserid());
				mlbuser = mlbuserDao.selectByPrimaryKey(mlbuserKey);
				if (mlbuser != null) {
					info.setCreateUsername(mlbuser.getTruename());
				}
			}
			bsGoodsInfoMapper.insertSelective(info);
			// 更新图片对应关系
			String[] iid = StringUtils.trimToEmpty(imgeIds).split(",", -1);
			for (int i = 0; i < iid.length; i++) {
				if (iid[i].length() > 0) {
					ImageKey key2 = new ImageKey();
					key2.setId(NumberUtils.toInt(iid[i]));
					Image image = imageDao.selectByPrimaryKey(key2);
					if (image != null) {
						image.setForeignkey(info.getId().intValue());
						imageDao.updateByPrimaryKey(image);
						// image = ImageService.saveImageBO(image);
					}
				}
			}
			// 发送消息通知
		} catch (Exception e) {
			log.warn("BsUserRequireCtrl insert error..", e);
			// e.printStackTrace();
		}
	}

	/**
	 * 根据商品ID查询详细信息
	 * 
	 * @param goodsInfoid
	 * @return
	 */
	public Map<String, Object> getGoodsInfoById(String goodsInfoid) {
		Map<String, Object> m = new HashMap<String, Object>();
		List<Map<String, Object>> mapList = null;
		Map<String, Object> map = null;
		BsGoodsInfoKey key = new BsGoodsInfoKey();
		key.setId(Long.parseLong(goodsInfoid));
		BsGoodsInfo goodsInfo = bsGoodsInfoMapper.selectByPrimaryKey(key);
		if (goodsInfo != null) {
			mapList = new ArrayList<Map<String, Object>>();
			map = new HashMap<String, Object>();
			map.put("id", goodsInfo.getId());
			map.put("type", goodsInfo.getFoodType());
			if (goodsInfo.getFoodType() == 1) {
				map.put("typeDesc", "小麦");
			} else if (goodsInfo.getFoodType() == 2) {
				map.put("typeDesc", "玉米");
			}
			map.put("serviceType", "");
			if (goodsInfo.getServiceType() != null) {
				if (goodsInfo.getServiceType() == 31) {
					map.put("serviceType", "委托");
				} else if (goodsInfo.getServiceType() == 30) {
					map.put("serviceType", "撮合");
				}
			}
			if (goodsInfo.getGrainLevel() != null && !"".equals(goodsInfo.getGrainLevel())) {
				if (goodsInfo.getGrainLevel() == 0) {
					map.put("qualityDesc", "无");// 粮食国标
				} else if (goodsInfo.getGrainLevel() == 1) {
					map.put("qualityDesc", "国标一等粮");// 粮食国标
				} else if (goodsInfo.getGrainLevel() == 2) {
					map.put("qualityDesc", "国标二等粮");// 粮食国标
				} else if (goodsInfo.getGrainLevel() == 3) {
					map.put("qualityDesc", "国标三等粮");// 粮食国标
				} else if (goodsInfo.getGrainLevel() == 4) {
					map.put("qualityDesc", "国标四等粮");// 粮食国标
				} else if (goodsInfo.getGrainLevel() == 5) {
					map.put("qualityDesc", "国标五等粮");// 粮食国标
				}
			} else {
				map.put("qualityDesc", "无");// 粮食国标
			}
			map.put("quality", goodsInfo.getGrainLevel());// 粮食国标

			map.put("referencePrice", 0);
			if (goodsInfo.getFoodPrice() != null) {
				map.put("referencePrice", goodsInfo.getFoodPrice());
			}
			map.put("foodNumber", 0);
			if (goodsInfo.getFoodNum() != null) {
				map.put("foodNumber", goodsInfo.getFoodNum());
			}

			map.put("location", goodsInfo.getLocation());
			map.put("locationDesc", goodsInfo.getLocationDesc());
			map.put("contentLoc", goodsInfo.getAddress());
			map.put("address", goodsInfo.getAddress());
			map.put("userid", goodsInfo.getUserId());
			map.put("userName", goodsInfo.getUserName());
			map.put("userPhone", goodsInfo.getUserPhone());
			map.put("foodRequire", goodsInfo.getFoodRequire());

			CommonAttrValueExample example = new CommonAttrValueExample();
			int typeId = 6;
			if ("1".equals(goodsInfo.getFoodType() + "")) {
				// 小麦
				typeId = 6;
			} else if ("2".equals(goodsInfo.getFoodType() + "")) {
				// 玉米
				typeId = 7;
			}
			example.createCriteria().andBelongidEqualTo(goodsInfo.getId().intValue())
					.andBelongtableEqualTo(CommonAttrValueUtil.BELONG_TABLE_BS_GOODS_INFO).andTypeidEqualTo(typeId);
			List<CommonAttrValue> commlist = commonAttrValueMapper.selectByExample(example);

			if (commlist != null && commlist.size() > 0) {
				if (goodsInfo.getFoodType() != 1) {

					for (CommonAttrValue c : commlist) {
						if (c.getAttrid() == 7) {
							map.put("water", c.getAttrvalue());// 水分
						}
						if (c.getAttrid() == 13) {
							map.put("weight", c.getAttrvalue());// 容重
						}
						if (c.getAttrid() == 5) {
							map.put("mildew", c.getAttrvalue());// 生霉粒
						}
						if (c.getAttrid() == 15) {
							map.put("impurity", c.getAttrvalue());// 不完善粒
						}
						if (c.getAttrid() == 16) {
							map.put("nocomplete", c.getAttrvalue());// 杂质
						}
						if (c.getAttrid() == 14) {
							map.put("qualityMark", c.getAttrvalue());// 品质备注
						}
					}
				} else {
					for (CommonAttrValue c : commlist) {
						if (c.getAttrid() == 6) {
							map.put("water", c.getAttrvalue());// 水分
						}
						if (c.getAttrid() == 8) {
							map.put("weight", c.getAttrvalue());// 容重
						}
						if (c.getAttrid() == 10) {
							map.put("mildew", c.getAttrvalue());// 生霉粒
						}
						if (c.getAttrid() == 17) {
							map.put("impurity", c.getAttrvalue());// 不完善粒
						}
						if (c.getAttrid() == 18) {
							map.put("nocomplete", c.getAttrvalue());// 杂质
						}
						if (c.getAttrid() == 11) {
							map.put("qualityMark", c.getAttrvalue());// 品质备注
						}
					}
				}
			} else {
				map.put("water", "0");
				map.put("weight", "0");
				map.put("mildew", "0");
				map.put("impurity", "0");
				map.put("nocomplete", "0");
				map.put("qualityMark", "无");
			}

			map.put("bidInvoice", "无");// 是否索要发票
			if (goodsInfo.getHasInvoice() != null && goodsInfo.getHasInvoice() > 0) {
				if (goodsInfo.getHasInvoice() == 1) {
					map.put("bidInvoice", "是");// 是否索要发票
				} else {
					map.put("bidInvoice", "否");// 是否索要发票
				}
			}

			map.put("hasLogistics", "无");// 物流信息
			if (goodsInfo.getHasLogistics() != null && goodsInfo.getHasLogistics() > 0) {
				if (goodsInfo.getHasLogistics() == 1) {
					map.put("hasLogistics", "是");// 物流信息
				} else {
					map.put("hasLogistics", "否");// 物流信息
				}
			}

			map.put("mark", goodsInfo.getRemark());
			MlbuserKey mlbuser = new MlbuserKey();
			mlbuser.setUserid(goodsInfo.getUserId());
			Mlbuser user = mlbuserDao.selectByPrimaryKey(mlbuser);

			map.put("purchaseCompany", goodsInfo.getUserName());// 供货商
			if (user != null) {
				map.put("companyLoc", user.getAddress());// 供货商地址
				if (user.getAuthentication() == 1) {
					map.put("acstatus", user.getAuthentication());
				} else {
					map.put("acstatus", 0);
				}
				map.put("phone", user.getPhone());
				if (user.getShineuser() != null) {
					if (user.getShineuser() == 2 || user.getShineuser() == 3) {
						map.put("phone", "4006029967");
					}
				}
				if (user.getAuthTime() != null) {
					map.put("acTime", DateUtil.format(user.getAuthTime(), DateStyle.YYYY_MM_DD));// 认证时间
				} else {
					map.put("acTime", "");// 认证时间
				}
			} else {
				map.put("companyLoc", "");// 供货商地址
				map.put("acstatus", "");
				map.put("phone", "");
				map.put("acTime", "");// 认证时间
			}
			mapList.add(map);
		}
		m.put("dataList", mapList);
		return m;
	}

	/**
	 * 根据商品ID查询详细信息
	 * 
	 * @param goodsInfoid
	 * @return
	 */
	public Map<String, Object> getGoodsById(String goodsInfoid) {
		Map<String, Object> m = new HashMap<String, Object>();
		List<Map<String, Object>> mapList = null;
		Map<String, Object> map = null;
		BsGoodsInfoKey key = new BsGoodsInfoKey();
		key.setId(Long.parseLong(goodsInfoid));
		BsGoodsInfo goodsInfo = bsGoodsInfoMapper.selectByPrimaryKey(key);
		if (goodsInfo != null) {
			mapList = new ArrayList<Map<String, Object>>();
			map = new HashMap<String, Object>();
			map.put("id", goodsInfo.getId());
			map.put("type", goodsInfo.getFoodType());
			map.put("quality", goodsInfo.getGrainLevel());// 粮食国标
			map.put("price", 0);
			if (goodsInfo.getFoodPrice() != null) {
				map.put("price", goodsInfo.getFoodPrice());
			}
			map.put("foodNumber", 0);
			if (goodsInfo.getFoodNum() != null) {
				map.put("foodNumber", goodsInfo.getFoodNum());
			}

			map.put("serviceType", "");
			if (goodsInfo.getServiceType() != null) {
				if (goodsInfo.getServiceType() == 31) {
					map.put("serviceType", "委托");
				} else if (goodsInfo.getServiceType() == 30) {
					map.put("serviceType", "撮合");
				}
			}
			map.put("location", goodsInfo.getLocation());
			map.put("contentLoc", goodsInfo.getAddress());
			map.put("userid", goodsInfo.getUserId());
			map.put("userName", goodsInfo.getUserName());
			map.put("address", goodsInfo.getAddress());
			map.put("remark", goodsInfo.getRemark());
			map.put("hasLogistics", "");
			if (goodsInfo.getHasLogistics() != null) {
				map.put("hasLogistics", goodsInfo.getHasLogistics());
			}
			CommonAttrValueExample example = new CommonAttrValueExample();
			int typeId = 6;
			if ("1".equals(goodsInfo.getFoodType() + "")) {
				// 小麦
				typeId = 6;
			} else if ("2".equals(goodsInfo.getFoodType() + "")) {
				// 玉米
				typeId = 7;
			}
			example.createCriteria().andBelongidEqualTo(goodsInfo.getId().intValue())
					.andBelongtableEqualTo(CommonAttrValueUtil.BELONG_TABLE_BS_GOODS_INFO).andTypeidEqualTo(typeId);
			List<CommonAttrValue> commlist = commonAttrValueMapper.selectByExample(example);

			if (commlist != null && commlist.size() > 0) {
				if (goodsInfo.getFoodType() != 1) {

					for (CommonAttrValue c : commlist) {
						if (c.getAttrid() == 7) {
							map.put("water", c.getAttrvalue());// 水分
						}
						if (c.getAttrid() == 13) {
							map.put("weight", c.getAttrvalue());// 容重
						}
						if (c.getAttrid() == 5) {
							map.put("mildew", c.getAttrvalue());// 生霉粒
						}
						if (c.getAttrid() == 15) {
							map.put("impurity", c.getAttrvalue());// 不完善粒
						}
						if (c.getAttrid() == 16) {
							map.put("nocomplete", c.getAttrvalue());// 杂质
						}
						if (c.getAttrid() == 14) {
							map.put("qualityMark", c.getAttrvalue());// 品质备注
						}
					}
				} else {
					for (CommonAttrValue c : commlist) {
						if (c.getAttrid() == 6) {
							map.put("water", c.getAttrvalue());// 水分
						}
						if (c.getAttrid() == 8) {
							map.put("weight", c.getAttrvalue());// 容重
						}
						if (c.getAttrid() == 10) {
							map.put("mildew", c.getAttrvalue());// 生霉粒
						}
						if (c.getAttrid() == 17) {
							map.put("impurity", c.getAttrvalue());// 不完善粒
						}
						if (c.getAttrid() == 18) {
							map.put("nocomplete", c.getAttrvalue());// 杂质
						}
						if (c.getAttrid() == 11) {
							map.put("qualityMark", c.getAttrvalue());// 品质备注
						}
					}
				}
			} else {
				map.put("water", "0");
				map.put("weight", "0");
				map.put("mildew", "0");
				map.put("impurity", "0");
				map.put("nocomplete", "0");
				map.put("qualityMark", "无");
			}
			map.put("bidInvoice", goodsInfo.getHasInvoice());// 是否索要发票
			map.put("mark", "");
			MlbuserKey mlbuser = new MlbuserKey();
			mlbuser.setUserid(goodsInfo.getUserId());
			Mlbuser user = mlbuserDao.selectByPrimaryKey(mlbuser);
			map.put("purchaseCompany", goodsInfo.getUserName());// 供货商
			if (user != null) {
				map.put("companyLoc", user.getAddress());// 供货商地址
				if (user.getAuthentication() == 1) {
					map.put("acstatus", user.getAuthentication());
				} else {
					map.put("acstatus", 0);
				}
				map.put("phone", user.getPhone());
				if (user.getAuthTime() != null) {
					map.put("acTime", DateUtil.format(user.getAuthTime(), DateStyle.YYYY_MM_DD));// 认证时间
				} else {
					map.put("acTime", "");// 认证时间
				}
			} else {
				map.put("companyLoc", "");// 供货商地址
				map.put("acstatus", "");
				map.put("phone", "");
				map.put("acTime", "");// 认证时间
			}

			mapList.add(map);
		}
		m.put("dataList", mapList);
		return m;
	}

	/**
	 * 查询此人发布的供应信息
	 * 
	 * @param mlbuserId
	 * @return
	 */
	public List<Map<String, Object>> getGoodsInfoByMlbUserId(int mlbuserId) {
		List<BsGoodsInfo> list = null;
		List<Map<String, Object>> listMap = null;
		// String map1 = req.getParameter("map");
		try {
			BsGoodsInfoExample example = new BsGoodsInfoExample();
			Criteria criteria = example.or();
			criteria.andUserIdEqualTo(mlbuserId);
			criteria.andProcessStatusNotEqualTo(2);// 过滤掉删除的/下架的
			listMap = new ArrayList<Map<String, Object>>();
			Map<String, Object> m = null;
			example.setOrderByClause("modify_time desc");
			list = bsGoodsInfoMapper.selectByExample(example);
			if (list.size() > 0) {
				for (BsGoodsInfo goods : list) {
					m = new HashMap<String, Object>();
					m.put("id", goods.getId() + "");
					if (goods.getCheckStatus() != null && goods.getCheckStatus() == 1) {
						m.put("alreadyAC", 1);
					} else {
						m.put("alreadyAC", 0);

					}
					m.put("type", "");
					if (goods.getFoodType() == 1) {
						m.put("type", "小麦");
					} else if (goods.getFoodType() == 2) {
						m.put("type", "玉米");
					}
					m.put("people", goods.getUserName());
					m.put("referencePrice", 0);
					if (goods.getFoodPrice() != null) {
						m.put("referencePrice", goods.getFoodPrice());
					}
					m.put("number", 0);
					if (goods.getFoodNum() != null) {
						m.put("number", goods.getFoodNum());
					}
					if (goods.getGrainLevel() != null && !"".equals(goods.getGrainLevel())) {
						if (goods.getGrainLevel() == 0) {
							m.put("quality", "无");// 粮食国标
						} else if (goods.getGrainLevel() == 1) {
							m.put("quality", "国标一等粮");// 粮食国标
						} else if (goods.getGrainLevel() == 2) {
							m.put("quality", "国标二等粮");// 粮食国标
						} else if (goods.getGrainLevel() == 3) {
							m.put("quality", "国标三等粮");// 粮食国标
						} else if (goods.getGrainLevel() == 4) {
							m.put("quality", "国标四等粮");// 粮食国标
						} else if (goods.getGrainLevel() == 5) {
							m.put("quality", "国标五等粮");// 粮食国标
						}
					} else {
						m.put("quality", "无");// 粮食国标
					}
					m.put("location", goods.getLocationDesc());
					if (goods.getModifyTime() != null) {
						String time = DateUtil.format(goods.getModifyTime(), DateStyle.YYYY_MM_DD);
						m.put("time", time);
					} else {
						m.put("time", "");
					}

					if (goods.getModifyTime() != null) {
						String effectiveTime = DateUtil.format(DateUtil.addDays(goods.getModifyTime(), 3),
								DateStyle.YYYY_MM_DD);
						m.put("effectiveTime", effectiveTime);
					} else {
						m.put("effectiveTime", "");

					}
					Long l = 0l;
					if (goods.getModifyTime() != null) {
						l = DateUtil.getDaysDifference(goods.getModifyTime(), new Date());
					}
					if (l > 3) {
						m.put("butStatus", 1);
					} else {
						m.put("butStatus", 0);
					}

					listMap.add(m);
				}
			}
		} catch (Exception e) {
			log.warn("BsUserRequireCtrl get by key error..", e);
		}

		return listMap;
	}

}
