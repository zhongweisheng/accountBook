package lb.rest.user.web.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lb.rest.user.db.dao.BsInventoryDepotDao;
import lb.rest.user.db.dao.BsInventoryRecordDao;
import lb.rest.user.db.entity.BsInventoryDepot;
import lb.rest.user.db.entity.BsInventoryDepotExample;
import lb.rest.user.db.entity.BsInventoryDepotKey;
import lb.rest.user.db.mapper.BsInventoryDepotMapper;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlb.util.JsonDataUtils;
import com.mlb.util.SequenceUtil;
import com.mlb.util.SessionUtils;

import fc.wpf.rest.db.service.DataService;
import fc.wpf.rest.utils.BeanFactory;
import fc.wpf.rest.utils.DBBean;
import fc.wpf.rest.web.action.BasicCtrl;
import fc.wpf.rest.web.bean.DbCondi;
import fc.wpf.rest.web.bean.ReturnInfo;
import fc.wpf.rest.web.bean.SqlMaker;
import fc.wpf.rest.web.bind.FieldUtils;

@Slf4j
@Controller
@RequestMapping("/bsinventorydepot")
public class BsInventoryDepotCtrl extends BasicCtrl {

	private static BsInventoryDepotMapper bsInventoryDepotMapper = (BsInventoryDepotMapper) BeanFactory
			.getBean("bsInventoryDepotMapper");
	private static BsInventoryDepotDao bsInventoryDepotDao = (BsInventoryDepotDao) BeanFactory
			.getBean("bsInventoryDepotDao");
	private static BsInventoryRecordDao bsInventoryRecordDao = (BsInventoryRecordDao) BeanFactory
			.getBean("bsInventoryRecordDao");

	private static DataService mysqlDataService = (DataService) BeanFactory.getBean("mysqlDataService");

	/**
	 * ajax单条数据插入 url:'http://ip/rest/bsinventorydepot'
	 * data:'{"key1":"value1","key2":"value2",...}' type:’POST
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo insert(BsInventoryDepot info, HttpServletRequest req) {
		try {
			int ownerId = NumberUtils.toInt(req.getParameter("ownerId"));
			if (ownerId > 0) {
				int depotId = SequenceUtil.getInstance().nextValue("bs_inventory_depot");
				info.setId(depotId);
				info.setCreateTime(new Date());
				info.setUpdateTime(new Date());
				int flag = bsInventoryDepotMapper.insertSelective(info);
				if (flag > 0) {
					int isUpate = NumberUtils.toInt(req.getParameter("updateData"));
					if (isUpate == 1) {
						bsInventoryRecordDao.updateByExampleSelective(depotId, ownerId);
					}
				}
				return ReturnInfo.Success;
			}
		} catch (Exception e) {
			log.warn("BsInventoryDepotCtrl insert error..", e);
			// e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax根据ID主键查询 请求 url: 'http://ip/app/bsinventorydepot/(_id值)' dataType:
	 * 'json' type: 'get'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	@ResponseBody
	public BsInventoryDepot get(@PathVariable String key, HttpServletRequest req) {
		BsInventoryDepot obj = null;
		try {
			BsInventoryDepot akey = new BsInventoryDepot();

			Field keyField = FieldUtils.allDeclaredField(BsInventoryDepotKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() == null) {
			} else {
				BsInventoryDepotExample example = new BsInventoryDepotExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				List<BsInventoryDepot> list = bsInventoryDepotMapper.selectByExample(example);
				if (list != null && list.size() > 0) {
					obj = list.get(0);
				}
			}
		} catch (Exception e) {
			log.warn("BsInventoryDepotCtrl get by key error..", e);
		}
		return obj;
	}

	/**
	 * ajax根据主键删除 url:'http://ip/app/bsinventorydepot/(_id值)' type: 'DELETE'
	 * dataType: 'json'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
	@ResponseBody
	public ReturnInfo delete(@PathVariable String key, HttpServletRequest req) {
		try {
			BsInventoryDepot akey = new BsInventoryDepot();

			Field keyField = FieldUtils.allDeclaredField(BsInventoryDepotKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() != null) {
				bsInventoryDepotMapper.deleteByPrimaryKey(akey);
				return ReturnInfo.Success;
			}
		} catch (Exception e) {
			log.warn("BsInventoryDepotCtrl delete by key error..");
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax根据主键单条修改 url:'http://ip/app/bsinventorydepot/(_id值)'
	 * data:'{"key1":"value1","key2":"value2",...}' type:'PUT'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo update(@PathVariable String key, BsInventoryDepot info, HttpServletRequest req) {
		try {
			if (info != null) {
				BsInventoryDepot akey = new BsInventoryDepot();

				Field keyField = FieldUtils.allDeclaredField(BsInventoryDepotKey.class).get(0);

				if (keyField.getType().isInstance(1)) {
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				} else if (keyField.getType().isInstance(1L)) {
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				} else {
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				BsInventoryDepotExample example = new BsInventoryDepotExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				info.setUpdateTime(new Date());
				bsInventoryDepotMapper.updateByExampleSelective(info, example);
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsInventoryDepot update by key error..");
		}
		return ReturnInfo.Faild;
	}

	/***
	 * 用户能看到的粮库列表
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object getList(HttpServletRequest req) {
		int userId = SessionUtils.getMlbUserId(req);
		List<BsInventoryDepot> list = bsInventoryDepotDao.getList(userId);
		boolean success = false;
		JsonDataUtils json = new JsonDataUtils();

		if (list != null && list.size() > 0) {
			success = true;
			int number = 1;
			success = true;
			json.addTitle("number", "id", "name", "address", "storageCapacity");
			if (list != null) {
				for (BsInventoryDepot item : list) {
					// String formattedDate =
					// DateUtil.format(item.getCreateTime(),
					// DateStyle.YYYY_MM_DD_HH_MM_SS);
					json.addOneRow(number++, item.getId(), item.getName(), item.getAddress(), item.getStorageCapacity());
				}
			}
		}
		json.setSuccess(success);
		return json.toJsonObj();
	}

	@RequestMapping(value = "/getDepots", method = RequestMethod.POST)
	@ResponseBody
	public Object getDepots(HttpServletRequest req) {
		int userId = SessionUtils.getMlbUserId(req);
		List<BsInventoryDepot> list = bsInventoryDepotDao.getList(userId);
		JSONArray jsonlist = new JSONArray();
		if (list != null && list.size() > 0) {
				for (BsInventoryDepot item : list) {
					JSONObject obj = new JSONObject();
					obj.put("id", item.getId());
					obj.put("name", item.getName());
					jsonlist.add(obj);
				}
		}
		return jsonlist;
	}

	private void setTableName(DbCondi dc) {
		String tName = DBBean.getTableName2Class(BsInventoryDepot.class);
		if (dc.getOther() == null) {
			Map<String, Object> o = new HashMap<String, Object>();
			o.put(SqlMaker.TABLE_NAME, tName);
			dc.setOther(o);
		} else {
			dc.getOther().put(SqlMaker.TABLE_NAME, tName);
		}
	}

	@SuppressWarnings("serial")
	public static class BsInventoryDepots extends ArrayList<BsInventoryDepot> {
		public BsInventoryDepots() {
			super();
		}
	}
}