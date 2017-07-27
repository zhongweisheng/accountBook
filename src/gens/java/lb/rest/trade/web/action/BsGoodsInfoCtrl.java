package lb.rest.trade.web.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lb.rest.trade.db.dao.BsGoodsInfoServiceDao;
import lb.rest.trade.db.entity.BsGoodsInfo;
import lb.rest.trade.db.entity.BsGoodsInfoExample;
import lb.rest.trade.db.entity.BsGoodsInfoKey;
import lb.rest.trade.db.entity.CommonAttrValue;
import lb.rest.trade.db.entity.CommonAttrValueExample;
import lb.rest.trade.db.mapper.BsGoodsInfoMapper;
import lb.rest.trade.db.mapper.CommonAttrValueMapper;
import lb.rest.user.db.dao.ImageDao;
import lb.rest.user.db.entity.Mlbuser;
import lb.rest.user.db.entity.MlbuserKey;
import lb.rest.user.db.mapper.MlbuserMapper;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
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
import fc.wpf.rest.web.action.BasicCtrl;
import fc.wpf.rest.web.bean.DbCondi;
import fc.wpf.rest.web.bean.ListInfo;
import fc.wpf.rest.web.bean.ReturnInfo;
import fc.wpf.rest.web.bean.SqlMaker;
import fc.wpf.rest.web.bind.FieldUtils;

@Slf4j
@Controller
@RequestMapping("/bsgoodsinfo")
public class BsGoodsInfoCtrl extends BasicCtrl {

	private static BsGoodsInfoMapper bsGoodsInfoMapper = (BsGoodsInfoMapper) BeanFactory.getBean("bsGoodsInfoMapper");

	private static DataService mysqlDataService = (DataService) BeanFactory.getBean("mysqlDataService");

	private static BsGoodsInfoServiceDao bsGoodsInfoServiceDao = (BsGoodsInfoServiceDao) BeanFactory
			.getBean("bsGoodsInfoServiceDao");
	private static CommonAttrValueMapper commonAttrValueMapper = (CommonAttrValueMapper) BeanFactory
			.getBean("commonAttrValueMapper");
	private static MlbuserMapper mlbuserMapper = (MlbuserMapper) BeanFactory.getBean("mlbuserMapper");
	private static ImageDao imageDao = (ImageDao) BeanFactory.getBean("imageDao");

	/**
	 * ajax单条数据插入 url:'http://ip/rest/bsgoodsinfo'
	 * data:'{"key1":"value1","key2":"value2",...}' type:’POST
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	@ResponseBody
	public ReturnInfo insert(BsGoodsInfo info, HttpServletRequest req) {
		try {
			int id = SequenceUtil.getInstance().nextValue(DBBean.getTableName2Class(BsGoodsInfo.class));
			info.setId(Long.valueOf(id));
			String imageIds = req.getParameter("imageIds");

			int userId = info.getUserId();
			String userName = "";
			String userPhone = "";
			Mlbuser akey = new Mlbuser();
			akey.setUserid(userId);

			Mlbuser mlbuser = mlbuserMapper.selectByPrimaryKey(akey);
			if (mlbuser != null) {
				userName = StringUtils.trimToEmpty(mlbuser.getTruename());
				userPhone = StringUtils.trimToEmpty(mlbuser.getPhone());
			}

			info.setUserName(userName);
			info.setUserPhone(userPhone);

			bsGoodsInfoServiceDao.insert(info, imageIds);

			int tableId = CommonAttrValueUtil.BELONG_TABLE_BS_GOODS_INFO;
			List<CommonAttrValueBO> list = CommonAttrValueUtil.saveQualityAttrList(req, info.getFoodType() + "",
					tableId, info.getId().intValue());
			if (list != null && list.size() > 0) {
				CommonAttrValueExample example = new CommonAttrValueExample();
				int typeId = 6;
				if ("1".equals(info.getFoodType() + "")) {
					// 小麦
					typeId = 6;
				} else if ("2".equals(info.getFoodType() + "")) {
					// 玉米
					typeId = 7;
				}
				example.createCriteria().andBelongidEqualTo(info.getId().intValue()).andBelongtableEqualTo(tableId)
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
			final BsGoodsInfo in = info;
			new Thread() {
				public void run() {
					// MatchUtil.matchOfferprice(in);
				}
			}.start();
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsGoodsInfoCtrl insert error..", e);
			// e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax根据ID主键查询 请求 url: 'http://ip/app/bsgoodsinfo/(_id值)' dataType: 'json'
	 * type: 'get'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ListInfo<BsGoodsInfo> get(@PathVariable String key, HttpServletRequest req) {
		int totalCount = 1;
		List<BsGoodsInfo> list = null;
		try {
			BsGoodsInfo akey = new BsGoodsInfo();

			Field keyField = FieldUtils.allDeclaredField(BsGoodsInfoKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() == null) {
				list = new ArrayList<BsGoodsInfo>();
			} else {
				BsGoodsInfoExample example = new BsGoodsInfoExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				list = bsGoodsInfoMapper.selectByExample(example);
			}
			totalCount = list.size();
		} catch (Exception e) {
			log.warn("BsGoodsInfoCtrl get by key error..", e);
		}
		return new ListInfo<>(totalCount, list, 0, 1);
	}

	@RequestMapping(value = "findGoodsList", method = RequestMethod.GET)
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
		return bsGoodsInfoServiceDao.selectGoodsInfoList(map, userLocation);
	}

	/**
	 * 根据卖粮宝用户ID查询他所发的报价信息
	 */
	@RequestMapping(value = "getGoodsListByMlbUserId", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserRequireListByMlbUserId(HttpServletRequest req) {
		Map<String, Object> map = GetParamsUtils.getParamMap(req);
		String mlbuserid = map.get("mlbuserId").toString();
		int userid = Integer.parseInt(mlbuserid);
		return bsGoodsInfoServiceDao.getBsGoodsInfoByMlbUserId(userid);
	}

	/**
	 * ajax根据ID主键查询 请求 url: 'http://ip/app/bsuserrequire/(_id值)' dataType:
	 * 'json' type: 'get'
	 */
	@RequestMapping(value = "getBsGoodsinfoById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getBsGoodsinfoById(HttpServletRequest req) {
		Map<String, Object> maps = GetParamsUtils.getParamMap(req);
		String goodsInfoid = maps.get("goodsInfoid").toString();
		Map<String, Object> map = bsGoodsInfoServiceDao.getGoodsInfoById(goodsInfoid);
		return map;
	}

	/**
	 * 编辑修改获取商品信息 'json' type: 'get'
	 */
	@RequestMapping(value = "getGoodsById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getGoodsById(HttpServletRequest req) {
		Map<String, Object> maps = GetParamsUtils.getParamMap(req);
		String goodsInfoid = maps.get("goodsInfoid").toString();
		Map<String, Object> map = bsGoodsInfoServiceDao.getGoodsById(goodsInfoid);
		return map;
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
			String goodsId = map.get("goodsId").toString();
			BsGoodsInfo record = new BsGoodsInfo();
			record.setId(Long.parseLong(goodsId));
			record.setModifyTime(new Date());
			bsGoodsInfoMapper.updateByPrimaryKeySelective(record);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsGoodsInfoCtrl  updateBsUserModifyTimeById error" + e);
		}
		return ReturnInfo.Faild;
	}

	/**
	 * 删除操做 修改状态为-10
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "deleteById", method = RequestMethod.GET)
	@ResponseBody
	public ReturnInfo dateleById(HttpServletRequest req) {
		Map<String, Object> map = GetParamsUtils.getParamMap(req);
		try {
			String goodsId = map.get("goodsId").toString();
			BsGoodsInfo record = new BsGoodsInfo();
			record.setId(Long.parseLong(goodsId));
			record.setProcessStatus(2);
			bsGoodsInfoMapper.updateByPrimaryKeySelective(record);
			record = bsGoodsInfoMapper.selectByPrimaryKey(record);
			// 增加操作日志
			// BsOperateRecord info = new BsOperateRecord();
			// int id =
			// SequenceUtil.getInstance().nextValue("bs_operate_record");
			// info.setId(Long.parseLong(id + ""));
			// info.setTargetType(1);
			// info.setTargetId(Integer.parseInt(goodsId));
			// info.setOperateTime(new Date());
			// info.setOperateUserId(0l);
			// info.setOperateUserName(record.getUserName());
			// info.setOperateName("用户自行删除");
			// bsOperateRecordMapper.insert(info);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsGoodsInfoCtrl  updateBsUserModifyTimeById error" + e);
		}
		return ReturnInfo.Faild;
	}

	// /**
	// * 根据卖粮宝用户ID查询他所发的报价信息
	// */
	// @RequestMapping(value = "getGoodsListByRequireId", method =
	// RequestMethod.GET)
	// @ResponseBody
	// public Map<String, Object> getGoodsListByRequireId(HttpServletRequest
	// req) {
	// Map<String, Object> map = GetParamsUtils.getParamMap(req);
	// String requireId = map.get("requireId").toString();
	// int require = Integer.parseInt(requireId);
	// return bsGoodsInfoServiceDao.getGoodsInfoByRequireId(require);
	// }

	/**
	 * ajax根据主键删除 url:'http://ip/app/bsgoodsinfo/(_id值)' type: 'DELETE'
	 * dataType: 'json'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
	@ResponseBody
	public ReturnInfo delete(@PathVariable String key, HttpServletRequest req) {
		try {
			BsGoodsInfo akey = new BsGoodsInfo();

			Field keyField = FieldUtils.allDeclaredField(BsGoodsInfoKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() != null) {
				bsGoodsInfoMapper.deleteByPrimaryKey(akey);
				return ReturnInfo.Success;
			}
		} catch (Exception e) {
			log.warn("BsGoodsInfoCtrl delete by key error..");
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax根据主键单条修改 url:'http://ip/app/bsgoodsinfo/(_id值)'
	 * data:'{"key1":"value1","key2":"value2",...}' type:'PUT'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.PUT)
	@ResponseBody
	public ReturnInfo update(@PathVariable String key, @Valid @RequestBody BsGoodsInfo info, HttpServletRequest req) {
		try {
			if (info != null) {
				BsGoodsInfo akey = new BsGoodsInfo();

				Field keyField = FieldUtils.allDeclaredField(BsGoodsInfoKey.class).get(0);

				if (keyField.getType().isInstance(1)) {
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				} else if (keyField.getType().isInstance(1L)) {
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				} else {
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				BsGoodsInfoExample example = new BsGoodsInfoExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				bsGoodsInfoMapper.updateByExampleSelective(info, example);
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsGoodsInfo update by key error..");
		}
		return ReturnInfo.Faild;
	}

	@RequestMapping(value = "updateBsGoodsInfo", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo updateBsGoodsInfo(BsGoodsInfo info, HttpServletRequest req) {
		try {
			if (info != null) {
				BsGoodsInfoExample example = new BsGoodsInfoExample();
				example.createCriteria().andIdEqualTo(info.getId());
				// info.setCreateTime(new Date());
				info.setModifyTime(new Date());
				info.setProcessStatus(0);
				bsGoodsInfoMapper.updateByExampleSelective(info, example);
				List<CommonAttrValueBO> list = CommonAttrValueUtil.saveQualityAttrList(req, info.getFoodType() + "",
						200, info.getId().intValue());
				if (list != null && list.size() > 0) {
					CommonAttrValueExample examplec = new CommonAttrValueExample();
					int typeId = 6;
					if ("1".equals(info.getFoodType() + "")) {
						// 小麦
						typeId = 6;
					} else if ("2".equals(info.getFoodType() + "")) {
						// 玉米
						typeId = 7;
					}
					examplec.createCriteria().andBelongidEqualTo(info.getId().intValue()).andBelongtableEqualTo(200)
							.andTypeidEqualTo(typeId);
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

				// 更新图片对应关系
				int fKey = info.getId().intValue();
				String imageIds = StringUtils.trimToEmpty(req.getParameter("imageIds"));
				if (StringUtils.isNotEmpty(imageIds) && fKey > 0 && imageDao != null) {
					imageDao.updateFkey(imageIds, fKey);
				}

			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsGoodsInfo update by key error..");
		}
		return ReturnInfo.Faild;
	}

	private void setTableName(DbCondi dc) {
		String tName = DBBean.getTableName2Class(BsGoodsInfo.class);
		if (dc.getOther() == null) {
			Map<String, Object> o = new HashMap<String, Object>();
			o.put(SqlMaker.TABLE_NAME, tName);
			dc.setOther(o);
		} else {
			dc.getOther().put(SqlMaker.TABLE_NAME, tName);
		}
	}

	@SuppressWarnings("serial")
	public static class BsGoodsInfos extends ArrayList<BsGoodsInfo> {
		public BsGoodsInfos() {
			super();
		}
	}
}