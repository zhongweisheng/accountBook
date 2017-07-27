package lb.rest.user.db.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import lb.rest.user.db.entity.BsTempTrade;
import lb.rest.user.db.entity.Mlbuser;
import lb.rest.user.db.entity.MlbuserAddition;
import lb.rest.user.db.entity.MlbuserAdditionExample;
import lb.rest.user.db.entity.MlbuserExample;
import lb.rest.user.db.entity.MlbuserExample.Criteria;
import lb.rest.user.db.entity.MlbuserKey;
import lb.rest.user.db.mapper.MlbuserMapper;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Repository;

import com.mlb.bo.MlbUserBO;
import com.mlb.util.JsonDataUtils;

import fc.wpf.rest.utils.DateStyle;
import fc.wpf.rest.utils.DateUtil;
import fc.wpf.rest.utils.NumberFormatUtil;
import fc.wpf.rest.utils.StringUtil;

@Slf4j
@Repository
public class MlbuserServiceDao {

	@Resource
	private MlbuserMapper mapper;

	@Resource
	private MlbuserAdditionDao mlbuserAdditionDao;
	@Resource
	private CommonDao commonDao;
	@Resource
	private BsTempTradeDao bsTempTradeDao;

	/**
	 * 根据ID查询用户信息
	 * 
	 * @param mlbuserID
	 * @return
	 */
	public Map<String, Object> getMlbuserById(String mlbuserID, String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> mapList = null;
		try {
			MlbuserKey mlb = new MlbuserKey();

			int mlbuserIDint = NumberUtils.toInt(mlbuserID);
			if (mlbuserIDint >= 0) {
				mlb.setUserid(mlbuserIDint);
				Mlbuser mlbuser = mapper.selectByPrimaryKey(mlb);
				if (mlbuser != null) {
					mapList = new ArrayList<Map<String, Object>>();
					Map<String, Object> m = new HashMap<String, Object>();
					m.put("id", mlbuser.getUserid());
					m.put("purchaseCompany", mlbuser.getTruename());
					m.put("companyLoc", mlbuser.getAddress());
					m.put("phone", mlbuser.getPhone());
					m.put("acStatus", mlbuser.getAuthentication());
					// 根据人员ID查对应的附表信息
					MlbuserAdditionExample example = new MlbuserAdditionExample();
					example.createCriteria().andUserIdEqualTo(mlbuser.getUserid());
					List<MlbuserAddition> additions = mlbuserAdditionDao.selectByExample(example);
					if (additions != null && additions.size() > 0) {
						if (additions.get(0).getUserCategory() != null) {
							if (additions.get(0).getUserCategory() == 1) {
								m.put("userCategory", "个人");
							} else if (additions.get(0).getUserCategory() == 2) {
								m.put("userCategory", "企业");
							}
						}
					}
					if (mlbuser.getAuthTime() != null && !"".equals(mlbuser.getAuthTime())) {
						String time = DateUtil.format(mlbuser.getAuthTime(), DateStyle.YYYY_MM_DD);
						m.put("acTime", time);
					} else {
						m.put("acTime", "");
					}
					mapList.add(m);
				}
			}
			map.put("dataList", mapList);
		} catch (Exception e) {
			log.warn("MlbuserMapper getMlbuserById error..", e);
		}
		return map;
	}

	/**
	 * 根据类型不同查询 阳光采购 或 阳光供应
	 * 
	 * @param type
	 *            1：供应 2采购
	 * @return
	 */
	public Map<String, Object> getMlbuserListByType(String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> mapList = null;
		Map<String, Object> m = null;
		try {
			List<Mlbuser> mlbList = new ArrayList<Mlbuser>();
			if (type.equals("1")) {
				mlbList = mapper.selectByExampleByShineUser(type);
			} else {
				MlbuserExample example = new MlbuserExample();
				List<Integer> values = new ArrayList<Integer>();
				values.add(Integer.parseInt(type));
				values.add(3);
				example.createCriteria().andShineuserIn(values);
				example.setOrderByClause("updatetime");
				mlbList = mapper.selectByExample(example);
			}
			if (mlbList != null && mlbList.size() > 0) {
				mapList = new ArrayList<Map<String, Object>>();
				for (Mlbuser mlbuser : mlbList) {
					m = new HashMap<String, Object>();
					m.put("id", mlbuser.getUserid());
					m.put("companyName", mlbuser.getTruename());
					// 根据人员ID查对应的附表信息
					MlbuserAdditionExample examples = new MlbuserAdditionExample();
					examples.createCriteria().andUserIdEqualTo(mlbuser.getUserid());
					List<MlbuserAddition> additions = mlbuserAdditionDao.selectByExample(examples);
					m.put("userCategory", "");
					if (additions != null && additions.size() > 0) {
						MlbuserAddition mlba = additions.get(0);
						// {1:个人,2:企业}
						if (mlba.getUserCategory() != null && mlba.getUserCategory() > 0) {
							if (mlba.getUserCategory() == 1) {
								m.put("userCategory", "个人");
							} else {
								m.put("userCategory", "企业");
							}
						}
					}
					mapList.add(m);
				}
				map.put("dataList", mapList);
			}
		} catch (Exception e) {
			log.warn("MlbuserMapper getMlbuserListBy error..", e);
		}
		return map;
	}

	/**
	 * 根据客户名称或手机号查询客户信息
	 * 
	 * @param userName
	 * @param phone
	 * @return
	 */
	public Map<String, Object> getMlbuserListByUserNameAndPhone(String userName, String phone) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mp = new HashMap<String, Object>();
		List<Map<String, Object>> maplist = null;
		MlbuserExample example = new MlbuserExample();
		Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(userName)) {
			criteria.andTruenameLike("%" + userName + "%");
		}
		if (StringUtil.isNotEmpty(phone)) {
			criteria.andPhoneLike("%" + phone + "%");
		}
		example.setLimit(20);
		List<Mlbuser> list = mapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			maplist = new ArrayList<Map<String, Object>>();
			for (Mlbuser m : list) {
				mp = new HashMap<String, Object>();
				mp.put("id", m.getUserid());
				mp.put("userName", m.getTruename());
				mp.put("phone", m.getPhone());
				maplist.add(mp);
			}
		}
		map.put("dataList", maplist);
		return map;
	}

	public Object getUserList(double minDistance, double maxDistance, double lat, double lng, int update,
			int foodTypeQuery, String locationQuery) {
		boolean success = false;
		JsonDataUtils json = new JsonDataUtils();
		try {
			// double minDistince = 0;
			// double maxDistince = 50;
			// if("1".equals(type)) {
			// minDistince = 0;
			// maxDistince = 50;
			// } else if("2".equals(type)) {
			// minDistince = 50;
			// maxDistince = 100;
			// } else if("3".equals(type)) {
			// minDistince = 100;
			// maxDistince = 200;
			// }
			List<MlbUserBO> mlbList = commonDao.selectMlbUserList(lat, lng, maxDistance, minDistance, foodTypeQuery,
					locationQuery);
			if (mlbList != null && mlbList.size() > 0) {
				success = true;
				int number = 1;
				success = true;
				json.addTitle("number", "id", "trueName", "address", "companyName", "updateTime", "distance", "phone",
						"foodType", "foodName", "quality", "foodPrice");
				if (mlbList != null) {
					Map<Integer, BsTempTrade> tradeMap = bsTempTradeDao.getTradeMap(update);
					for (MlbUserBO item : mlbList) {

						BsTempTrade trade = tradeMap.get(item.getId());

						int foodType = 0;
						String foodName = "";
						String quality = "";
						double foodPrice = 0;
						if (trade != null) {
							foodType = trade.getBuyFoodType();
							foodName = trade.getBuyFoodName();
							quality = trade.getBuyFoodRequire();
							foodPrice = trade.getBuyFoodPrice();
						}
						String formattedDate = DateUtil.format(item.getUpdatetime(), DateStyle.YYYY_MM_DD);
						json.addOneRow(number++, item.getId(), item.getTrueName(), item.getAddress(),
								item.getCompanyName(), formattedDate, formatPercent(item.getMatchDistance()),
								item.getPhone(), foodType, foodName, quality, foodPrice);
					}
				}
			}
			json.setSuccess(success);
			return json.toJsonObj();
		} catch (Exception e) {
			log.warn("MlbuserMapper getUserList error..", e);
		}
		return json.toJsonObj();
	}

	public static final DecimalFormat dfP2 = new DecimalFormat("###0.00");

	public static String formatPercent(Double doubleVal) {
		if (doubleVal == null) {
			return "";
		}
		return NumberFormatUtil.formatToPercent(dfP2, doubleVal);
	}
}
