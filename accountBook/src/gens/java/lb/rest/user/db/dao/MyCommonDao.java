package lb.rest.user.db.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lb.rest.trade.db.entity.BsReferencePrice;
import lb.rest.trade.db.entity.CommonAttrValue;
import lb.rest.trade.db.entity.CommonAttrValueExample;
import lb.rest.trade.db.mapper.CommonAttrValueMapper;
import lb.rest.user.db.entity.CommonAttr;
import lb.rest.user.db.entity.CommonAttrExample;
import lb.rest.user.db.mapper.CommonAttrMapper;
import lb.rest.user.db.mapper.MyCommonMapper;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Repository;

import com.mlb.bo.CommonAttrBO;
import com.mlb.bo.CommonAttrValueBO;
import com.mlb.bo.DistanceBO;
import com.mlb.bo.LocationBO;
import com.mlb.util.CommonAttrValueUtil;
import com.mlb.util.JsonDataUtils;

@Repository
public class MyCommonDao {

	@Resource
	private MyCommonMapper mapper;
	@Resource
	private CommonAttrMapper commonAttrMapper;
	@Resource
	private CommonAttrValueMapper commonAttrValueMapper;

	public LocationBO getAreaLocation(int location) {
		return mapper.getAreaLocation(location);
	}

	public Map<Integer, DistanceBO> getDistanceMapByDest(int location) {
		Map<Integer, DistanceBO> map = new HashMap<Integer, DistanceBO>();
		List<DistanceBO> list = mapper.getDistanceMapByDest(location);
		if (list != null) {
			for (DistanceBO item : list) {
				int orig = item.getOrigLocation();
				map.put(orig, item);
			}
		}
		return map;
	}

	public DistanceBO getDistance(int origLocation, int destLocation) {
		return mapper.getDistance(origLocation, destLocation);
	}

	public int insertDistance(int origLocation, int destLocation, double distance) {
		return mapper.insertDistance(origLocation, destLocation, distance);
	}

	public boolean insertDistanceList(List<DistanceBO> list) {
		boolean result = false;
		try {
			if (list != null && list.size() > 0) {
				Set<String> keyFilter = new HashSet<String>();
				for (DistanceBO distance : list) {
					String key = distance.getOrigLocation() + "-" + distance.getDestLocation();
					if (!keyFilter.contains(key)) {
						keyFilter.add(key);
						if (distance.getDistance() <= 0) {
							continue;
						}
						int origLocation = distance.getOrigLocation();
						int destLocation = distance.getDestLocation();
						double distanceTmp = distance.getDistance();
						mapper.insertDistance(origLocation, destLocation, distanceTmp);
					}
				}
				result = true;
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public List<CommonAttrBO> getList(int isAvailable, int typeId) {
		List<CommonAttrBO> list = new ArrayList<CommonAttrBO>();

		CommonAttrExample example = new CommonAttrExample();
		lb.rest.user.db.entity.CommonAttrExample.Criteria criteria = example.createCriteria();
		criteria.andIsavailableEqualTo(isAvailable);
		if (typeId > 0) {
			criteria.andTypeidEqualTo(typeId);
		}
		List<CommonAttr> listDB = commonAttrMapper.selectByExample(example);
		if (listDB != null) {
			for (CommonAttr item : listDB) {
				CommonAttrBO bo = new CommonAttrBO();
				bo.setId(item.getAttrid());
				bo.setTypeId(item.getTypeid());
				bo.setName(item.getAttrname());
				bo.setSort(item.getSort());
				bo.setIsAvailable(item.getIsavailable());
				bo.setRule(item.getRule());
				bo.setWeight(item.getWeight());
				list.add(bo);
			}
		}
		return list;
	}

	public List<CommonAttrValueBO> getList(int belongTable, int belongId, int typeId) {
		List<CommonAttrValueBO> list = new ArrayList<CommonAttrValueBO>();
		if (belongId <= 0) {
			return list;
		}
		CommonAttrValueExample example = new CommonAttrValueExample();
		lb.rest.trade.db.entity.CommonAttrValueExample.Criteria criteria = example.createCriteria();
		criteria.andBelongidEqualTo(belongTable);
		criteria.andBelongtableEqualTo(belongId);
		if (typeId > 0) {
			criteria.andTypeidEqualTo(typeId);
		}
		example.setOrderByClause("id desc  ");

		List<CommonAttrValue> listDB = commonAttrValueMapper.selectByExample(example);
		if (listDB != null) {
			for (CommonAttrValue item : listDB) {
				CommonAttrValueBO bo = new CommonAttrValueBO();
				bo.setId(item.getId());
				bo.setAttrId(item.getAttrid());
				bo.setAttrValue(item.getAttrvalue());
				bo.setTypeId(item.getTypeid());
				bo.setBelongId(item.getBelongid());
				bo.setBelongTable(item.getBelongtable());
				list.add(bo);
			}
		}
		return list;
	}

	public List<CommonAttrValueBO> getLists(int belongTable, List<Integer> gids, int typeId) {
		List<CommonAttrValueBO> list = new ArrayList<CommonAttrValueBO>();
		if (gids.size() <= 0) {
			return list;
		}
		CommonAttrValueExample example = new CommonAttrValueExample();
		lb.rest.trade.db.entity.CommonAttrValueExample.Criteria criteria = example.createCriteria();
		criteria.andBelongidEqualTo(belongTable);
		criteria.andBelongtableIn(gids);
		if (typeId > 0) {
			criteria.andTypeidEqualTo(typeId);
		}
		example.setOrderByClause("id desc  ");

		List<CommonAttrValue> listDB = commonAttrValueMapper.selectByExample(example);
		if (listDB != null) {
			for (CommonAttrValue item : listDB) {
				CommonAttrValueBO bo = new CommonAttrValueBO();
				bo.setId(item.getId());
				bo.setAttrId(item.getAttrid());
				bo.setAttrValue(item.getAttrvalue());
				bo.setTypeId(item.getTypeid());
				bo.setBelongId(item.getBelongid());
				bo.setBelongTable(item.getBelongtable());
				list.add(bo);
			}
		}
		return list;
	}

	public String selectPriceList(Map<String, Object> param) {
		int province = NumberUtils.toInt(param.get("province").toString());
		int city = NumberUtils.toInt(param.get("city").toString());
		int type = NumberUtils.toInt(param.get("type").toString());
		int foodType = NumberUtils.toInt(param.get("foodType").toString());
		List<BsReferencePrice> list = mapper.selectPriceList(province, city, type, foodType);
		JsonDataUtils json = new JsonDataUtils();
		json.addTitle("address", "price", "time");
		if (list != null) {
			for (BsReferencePrice item : list) {
				json.addOneRow(item.getProvinceName(), item.getRemark(), item.getCityName());
			}
		}
		return json.toJsonString();
	};

	public List<CommonAttrValueBO> saveQualityAttrList(HttpServletRequest request, String food_type, int belongTable,
			int belongId) {
		int typeId = 6;
		if ("1".equals(food_type + "")) {
			// 小麦
			typeId = 6;
		} else if ("2".equals(food_type + "")) {
			// 玉米
			typeId = 7;
		}
		List<CommonAttrValueBO> list = CommonAttrValueUtil.getCommonAttrValueList(request, belongTable, belongId,
				typeId);

		if (list != null && list.size() > 0) {
			CommonAttrValueExample example = new CommonAttrValueExample();

			example.createCriteria().andBelongidEqualTo(belongId).andBelongtableEqualTo(belongTable)
					.andTypeidEqualTo(typeId);
			// int deleteByExample();
			commonAttrValueMapper.deleteByExample(example);

			for (CommonAttrValueBO bo : list) {
				CommonAttrValue co = new CommonAttrValue();
				co.setAttrid(bo.getAttrId());
				co.setAttrvalue(bo.getAttrValue());
				co.setBelongid(bo.getBelongId());
				co.setBelongtable(bo.getBelongTable());
				co.setTypeid(bo.getTypeId());
				commonAttrValueMapper.insertSelective(co);
			}
		}

		return list;
	}

	public int getLastInsertId() {
		return mapper.getLastInsertId();
	}

}
