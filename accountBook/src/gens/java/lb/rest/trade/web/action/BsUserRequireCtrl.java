package lb.rest.trade.web.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lb.rest.trade.db.dao.BsUserRequireServiceDao;
import lb.rest.trade.db.entity.BsUserRequire;
import lb.rest.trade.db.entity.BsUserRequireExample;
import lb.rest.trade.db.entity.BsUserRequireKey;
import lb.rest.trade.db.entity.CommonAttrValue;
import lb.rest.trade.db.entity.CommonAttrValueExample;
import lb.rest.trade.db.mapper.BsUserRequireMapper;
import lb.rest.trade.db.mapper.CommonAttrValueMapper;
import lb.rest.user.db.entity.Mlbuser;
import lb.rest.user.db.entity.MlbuserKey;
import lb.rest.user.db.mapper.MlbuserMapper;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlb.bo.CommonAttrValueBO;
import com.mlb.util.CommonAttrValueUtil;
import com.mlb.util.GetParamsUtils;
import com.mlb.util.SequenceUtil;
import com.mlb.util.SessionUtils;

import fc.wpf.rest.db.service.DataService;
import fc.wpf.rest.utils.BeanFactory;
import fc.wpf.rest.utils.DBBean;
import fc.wpf.rest.utils.SerializerUtil;
import fc.wpf.rest.web.action.BasicCtrl;
import fc.wpf.rest.web.bean.DbCondi;
import fc.wpf.rest.web.bean.FieldsMapperBean;
import fc.wpf.rest.web.bean.ListInfo;
import fc.wpf.rest.web.bean.PageInfo;
import fc.wpf.rest.web.bean.QueryMapperBean;
import fc.wpf.rest.web.bean.ReturnInfo;
import fc.wpf.rest.web.bean.SqlMaker;
import fc.wpf.rest.web.bind.FieldUtils;
import fc.wpf.rest.web.bind.KeyExplainHandler;
import fc.wpf.rest.web.bind.RequestJsonParam;

@Slf4j
@Controller
@RequestMapping("/bsuserrequire")
public class BsUserRequireCtrl extends BasicCtrl {

	private static BsUserRequireMapper bsUserRequireMapper = (BsUserRequireMapper) BeanFactory
			.getBean("bsUserRequireMapper");

	private static DataService mysqlDataService = (DataService) BeanFactory.getBean("mysqlDataService");

	private static BsUserRequireServiceDao bsUserRequireServiceDao = (BsUserRequireServiceDao) BeanFactory
			.getBean("bsUserRequireServiceDao");

	private static CommonAttrValueMapper commonAttrValueMapper = (CommonAttrValueMapper) BeanFactory
			.getBean("commonAttrValueMapper");

	private static MlbuserMapper mlbuserMapper = (MlbuserMapper) BeanFactory.getBean("mlbuserMapper");

	/**
	 * ajax单条数据插入 url:'http://ip/rest/bsuserrequire'
	 * data:'{"key1":"value1","key2":"value2",...}' type:’POST
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	@ResponseBody
	public ReturnInfo insert(BsUserRequire info, HttpServletRequest req) {
		try {
			int id = SequenceUtil.getInstance().nextValue(DBBean.getTableName2Class(BsUserRequire.class));
			info.setId(Long.valueOf(id));
			String imageIds = req.getParameter("imageIds");
			bsUserRequireServiceDao.insert(info, imageIds);
			List<CommonAttrValueBO> list = CommonAttrValueUtil.saveQualityAttrList(req, info.getBuyFoodType() + "",
					201, info.getId().intValue());
			if (list != null && list.size() > 0) {
				CommonAttrValueExample example = new CommonAttrValueExample();
				int typeId = 6;
				if ("1".equals(info.getBuyFoodType() + "")) {
					// 小麦
					typeId = 6;
				} else if ("2".equals(info.getBuyFoodType() + "")) {
					// 玉米
					typeId = 7;
				}
				example.createCriteria().andBelongidEqualTo(info.getId().intValue()).andBelongtableEqualTo(201)
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
			final BsUserRequire in = info;
			new Thread() {
				public void run() {
					// TODO
					// MatchUtil.matchUserRequire(in);
				}
			}.start();
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsUserRequireCtrl insert error..", e);
			// e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax精确查询请求 url:
	 * 'http://ip/app/bsuserrequire/?query=({"key1":"value1","key2":"value2",...
	 * } ) ' dataType: 'json' type: 'get'
	 * 
	 * ajax无条件查询全部请求 url: 'http://ip/app/bsuserrequire' dataType: 'json' type:
	 * 'get'
	 * 
	 * ajax模糊查询请求 url:
	 * 'http://ip/app/bsuserrequire/?query={"(colname)":{"$regex":"(colvalue)","$optio
	 * n s " : " i " } dataType: 'json' type: 'get'
	 * 
	 * ajax分页查询 请求 url:
	 * 'http://ip/app/bsuserrequire/?query=(空或{"key1":"value1","key2":"value2",...})
	 * & s k i p = " + beginRow + "&limit=" + rowNum' dataType:'json' type:'get'
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Object get(@RequestJsonParam(value = "query", required = false) QueryMapperBean info,
			@RequestJsonParam(value = "fields", required = false) FieldsMapperBean fmb, PageInfo para,
			HttpServletRequest req) {
		int totalCount = 0;
		List<HashMap> list = null;
		try {
			DbCondi dc = new DbCondi();
			dc.setEntityClass(BsUserRequire.class);
			dc.setKeyClass(BsUserRequireKey.class);
			dc.setMapperClass(BsUserRequireMapper.class);
			dc.setQmb(info);
			dc.setPageinfo(para);
			dc.setFmb(fmb);
			this.setTableName(dc);
			// TEST query
			// if(info!=null){
			// StringBuffer keyValues = new StringBuffer();
			// for(EqualBean b : info.getEqual()){
			// keyValues.append(b.getFieldName()).append(" = ").append(b.getValue()).append(",");
			// }
			// for(LikeBean b : info.getLikes()){
			// keyValues.append(b.getFieldName()).append(" like ").append(b.getRegex()).append(",");
			// }
			// for(OrBean b : info.getOr()){
			// keyValues.append(b.getFieldName()).append(" or ").append(b.getValue()).append(",");
			// }
			// for(ConditionBean b : info.getCondition()){
			// keyValues.append(b.getFieldName()).append(" ").append(b.getCondi())
			// .append(" ").append(b.getValue()).append(",");
			// }
			// log.debug("传递参数为="+keyValues.toString());
			// }
			// //////////////////
			String sql = SqlMaker.getReferenceCountSql(dc);
			totalCount = mysqlDataService.getCount(sql);
			sql = SqlMaker.getReferenceData(dc);
			list = SerializerUtil.deserializeArray(mysqlDataService.doBySQL(sql), HashMap.class);
			for (HashMap map : list) {
				for (Field filed : FieldUtils.allDeclaredField(dc.getKeyClass())) {
					if (map.get(filed.getName()) == null) {
						map.put(filed.getName(), "");
					}
				}
				map.put(KeyExplainHandler.ID_KEY, KeyExplainHandler.genKey(map, dc.getKeyClass()));
			}
		} catch (Exception e) {
			log.warn("BsUserRequireCtrl get error..", e);
		}
		if (para.isPage()) {
			return new ListInfo<>(totalCount, list, para);
		} else {
			return list;
		}
	}

	/**
	 * ajax精确查询请求 url:
	 * 'http://ip/app/bsuserrequire/?query=({"key1":"value1","key2":"value2",...
	 * } ) ' dataType: 'json' type: 'get'
	 * 
	 * ajax无条件查询全部请求 url: 'http://ip/app/bsuserrequire' dataType: 'json' type:
	 * 'get'
	 * 
	 * ajax模糊查询请求 url:
	 * 'http://ip/app/bsuserrequire/?query={"(colname)":{"$regex":"(colvalue)","$optio
	 * n s " : " i " } dataType: 'json' type: 'get'
	 * 
	 * ajax分页查询 请求 url:
	 * 'http://ip/app/bsuserrequire/?query=(空或{"key1":"value1","key2":"value2",...})
	 * & s k i p = " + beginRow + "&limit=" + rowNum' dataType:'json' type:'get'
	 */
	@RequestMapping(value = "findUserRequireList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserRequireList(HttpServletRequest req) {
		int userLocation = SessionUtils.getMlbUserLocation(req);
		int userId = SessionUtils.getMlbUserId(req);
		if (userLocation <= 0 && userId > 0) {
			MlbuserKey key = new MlbuserKey();
			key.setUserid(userId);
			Mlbuser user = mlbuserMapper.selectByPrimaryKey(key);
			if (user != null && user.getLocation() != null) {
				userLocation = NumberUtils.toInt(user.getLocation());
			}
		}
		Map<String, Object> map = GetParamsUtils.getParamMap(req);
		return bsUserRequireServiceDao.selectBsUserRequire(map, userLocation);
	}

	/**
	 * 根据卖粮宝用户ID查询他所发的报价信息
	 */
	@RequestMapping(value = "getUserRequireListByMlbUserId", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserRequireListByMlbUserId(HttpServletRequest req) {
		// int userid = SessionUtils.getMlbUserId(req);
		Map<String, Object> map = GetParamsUtils.getParamMap(req);
		String mlbuserid = map.get("mlbuserId").toString();
		int userid = Integer.parseInt(mlbuserid);
		return bsUserRequireServiceDao.getUserRequireListByMlbUserId(userid);
	}

	/**
	 * 更新报价操作
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "updateBsUserModifyTimeById", method = RequestMethod.GET)
	@ResponseBody
	public ReturnInfo updateBsUserModifyTimeById(HttpServletRequest req) {
		Map<String, Object> map = GetParamsUtils.getParamMap(req);
		try {
			String userRequrieid = map.get("userRequrieid").toString();
			BsUserRequire record = new BsUserRequire();
			record.setId(Long.parseLong(userRequrieid));
			record.setModifyTime(new Date());
			record.setCheckStatus(0);// 初始化审核状态，修改后，不再是审核通过。
			bsUserRequireMapper.updateByPrimaryKeySelective(record);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsUserRequireCtrl  updateBsUserModifyTimeById error" + e);
		}
		return ReturnInfo.Faild;
	}

	/**
	 * 删除操作 修改状态为10
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "deleteById", method = RequestMethod.GET)
	@ResponseBody
	public ReturnInfo deteteById(HttpServletRequest req) {
		Map<String, Object> map = GetParamsUtils.getParamMap(req);
		try {
			String userRequrieid = map.get("userRequrieid").toString();
			BsUserRequire record = new BsUserRequire();
			record.setId(Long.parseLong(userRequrieid));
			record.setProcessStatus(-10);// 客户自己删除
			bsUserRequireMapper.updateByPrimaryKeySelective(record);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsUserRequireCtrl  deteteById error" + e);
		}
		return ReturnInfo.Faild;
	}

	@RequestMapping(value = "updateBsUserRequire", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo updateBsUserRequire(BsUserRequire info, HttpServletRequest req) {
		try {
			if (info != null) {
				BsUserRequireExample example = new BsUserRequireExample();
				example.createCriteria().andIdEqualTo(info.getId());
				info.setModifyTime(new Date());
				info.setProcessStatus(0);
				Mlbuser mbluser = new Mlbuser();
				MlbuserKey mlbuserKey = new MlbuserKey();
				mlbuserKey.setUserid(info.getBuyId());
				mbluser = mlbuserMapper.selectByPrimaryKey(mlbuserKey);
				// 交易员信息
				if (mbluser.getTraderuserid() > 0) {
					info.setProcessStatus(10);
				}
				bsUserRequireMapper.updateByExampleSelective(info, example);
				List<CommonAttrValueBO> list = CommonAttrValueUtil.saveQualityAttrList(req, info.getBuyFoodType() + "",
						201, info.getId().intValue());
				if (list != null && list.size() > 0) {
					CommonAttrValueExample examplec = new CommonAttrValueExample();
					int typeId = 6;
					if ("1".equals(info.getBuyFoodType() + "")) {
						// 小麦
						typeId = 6;
					} else if ("2".equals(info.getBuyFoodType() + "")) {
						// 玉米
						typeId = 7;
					}
					examplec.createCriteria().andBelongidEqualTo(info.getId().intValue()).andBelongtableEqualTo(201)
							.andTypeidEqualTo(typeId);
					// int deleteByExample();
					commonAttrValueMapper.deleteByExample(examplec);

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
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsUserRequireCtrl update by key error..");
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax根据ID主键查询 请求 url: 'http://ip/app/bsuserrequire/(_id值)' dataType:
	 * 'json' type: 'get'
	 */
	@RequestMapping(value = "getBsUserRequireById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getBsUserRequireById(HttpServletRequest req) {
		int userLocation = SessionUtils.getMlbUserLocation(req);
		Map<String, Object> maps = GetParamsUtils.getParamMap(req);
		String bsUserRequireid = (String) maps.get("bsUserRequireid");
		Map<String, Object> map = bsUserRequireServiceDao.getBsUserRequireById(bsUserRequireid);
		return map;
	}

	/**
	 * 编辑修改获取采购信息 'json' type: 'get'
	 */
	@RequestMapping(value = "getUserRequireById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserRequireById(HttpServletRequest req) {
		int userLocation = SessionUtils.getMlbUserLocation(req);
		Map<String, Object> maps = GetParamsUtils.getParamMap(req);
		String bsUserRequireid = (String) maps.get("bsUserRequireid");
		Map<String, Object> map = bsUserRequireServiceDao.getUserRequireById(bsUserRequireid);
		return map;
	}

	@RequestMapping(value = "getRequireListByGoodsId", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getRequireListByGoodsId(HttpServletRequest req) {
		Map<String, Object> map = GetParamsUtils.getParamMap(req);
		String goodsId = map.get("goodsId").toString();
		int goods = Integer.parseInt(goodsId);
		return bsUserRequireServiceDao.getRequireListByGoodsId(goods);
	}

	/**
	 * ajax根据ID主键查询 请求 url: 'http://ip/app/bsuserrequire/(_id值)' dataType:
	 * 'json' type: 'get'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ListInfo<BsUserRequire> get(@PathVariable String key, HttpServletRequest req) {
		int totalCount = 1;
		List<BsUserRequire> list = null;
		try {
			BsUserRequire akey = new BsUserRequire();

			Field keyField = FieldUtils.allDeclaredField(BsUserRequireKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() == null) {
				list = new ArrayList<BsUserRequire>();
			} else {
				BsUserRequireExample example = new BsUserRequireExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				list = bsUserRequireMapper.selectByExample(example);
			}
			totalCount = list.size();
		} catch (Exception e) {
			log.warn("BsUserRequireCtrl get by key error..", e);
		}
		return new ListInfo<>(totalCount, list, 0, 1);
	}

	/**
	 * ajax根据主键删除 url:'http://ip/app/bsuserrequire/(_id值)' type: 'DELETE'
	 * dataType: 'json'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
	@ResponseBody
	public ReturnInfo delete(@PathVariable String key, HttpServletRequest req) {
		try {
			BsUserRequire akey = new BsUserRequire();

			Field keyField = FieldUtils.allDeclaredField(BsUserRequireKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() != null) {
				bsUserRequireMapper.deleteByPrimaryKey(akey);
				return ReturnInfo.Success;
			}
		} catch (Exception e) {
			log.warn("BsUserRequireCtrl delete by key error..");
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax根据主键单条修改 url:'http://ip/app/bsuserrequire/(_id值)'
	 * data:'{"key1":"value1","key2":"value2",...}' type:'PUT'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.PUT)
	@ResponseBody
	public ReturnInfo update(@PathVariable String key, @Valid @RequestBody BsUserRequire info, HttpServletRequest req) {
		try {
			if (info != null) {
				BsUserRequire akey = new BsUserRequire();

				Field keyField = FieldUtils.allDeclaredField(BsUserRequireKey.class).get(0);

				if (keyField.getType().isInstance(1)) {
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				} else if (keyField.getType().isInstance(1L)) {
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				} else {
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				BsUserRequireExample example = new BsUserRequireExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				bsUserRequireMapper.updateByExampleSelective(info, example);
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsUserRequire update by key error..");
		}
		return ReturnInfo.Faild;
	}

	private void setTableName(DbCondi dc) {
		String tName = DBBean.getTableName2Class(BsUserRequire.class);
		if (dc.getOther() == null) {
			Map<String, Object> o = new HashMap<String, Object>();
			o.put(SqlMaker.TABLE_NAME, tName);
			dc.setOther(o);
		} else {
			dc.getOther().put(SqlMaker.TABLE_NAME, tName);
		}
	}

	@SuppressWarnings("serial")
	public static class BsUserRequires extends ArrayList<BsUserRequire> {
		public BsUserRequires() {
			super();
		}
	}
}