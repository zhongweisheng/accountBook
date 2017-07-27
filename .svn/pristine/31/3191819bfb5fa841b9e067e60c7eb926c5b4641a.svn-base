package lb.rest.user.web.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lb.rest.user.db.dao.BsInventoryStaffDao;
import lb.rest.user.db.entity.BsInventoryStaff;
import lb.rest.user.db.entity.BsInventoryStaffExample;
import lb.rest.user.db.entity.BsInventoryStaffExample.Criteria;
import lb.rest.user.db.entity.BsInventoryStaffKey;
import lb.rest.user.db.mapper.BsInventoryStaffMapper;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
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
@RequestMapping("/bsinventorystaff")
public class BsInventoryStaffCtrl extends BasicCtrl {

	private static BsInventoryStaffMapper bsInventoryStaffMapper = (BsInventoryStaffMapper) BeanFactory
			.getBean("bsInventoryStaffMapper");

	private static DataService mysqlDataService = (DataService) BeanFactory.getBean("mysqlDataService");
	private static BsInventoryStaffDao bsInventoryStaffDao = (BsInventoryStaffDao) BeanFactory
			.getBean("bsInventoryStaffDao");

	// 判断手机号是否存在
	@RequestMapping(value = "/isExist", method = RequestMethod.POST)
	@ResponseBody
	public boolean isExist(BsInventoryStaff info, HttpServletRequest req) {
		boolean isExist = false;
		try {
			// 验证是否重复手机号
			int id = NumberUtils.toInt(req.getParameter("id"), -1);
			int userId = info.getUserId();
			int staffType = info.getStaffType();
			String phone = info.getPhone();
			isExist = bsInventoryStaffDao.isExist(userId, staffType, phone, id);
			return isExist;
		} catch (Exception e) {
			log.warn("BsInventoryStaffCtrl isExist error..", e);
		}
		return isExist;
	}

	/**
	 * ajax单条数据插入 url:'http://ip/rest/htuser'
	 * data:'{"key1":"value1","key2":"value2",...}' type:’POST
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo insert(BsInventoryStaff info, HttpServletRequest req) {
		try {
			// 验证是否重复手机号
			int userId = info.getUserId();
			int staffType = info.getStaffType();
			String phone = info.getPhone();
			boolean isExist = bsInventoryStaffDao.isExist(userId, staffType, phone, -1);
			if (!isExist) {
				int id = SequenceUtil.getInstance().nextValue("bs_inventory_staff");
				info.setId(id);
				info.setCreateTime(new Date());
				bsInventoryStaffMapper.insert(info);
			} else {
				return new ReturnInfo("手机号已存在，不可保存", 10000, null, false);
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsInventoryStaffCtrl insert error..", e);
			// e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(HttpServletRequest req) {
		JsonDataUtils json = new JsonDataUtils();
		List<BsInventoryStaff> list = null;
		try {
			int userId = SessionUtils.getMlbUserId(req);
			int staffType = NumberUtils.toInt(req.getParameter("staffType"));
			String staffName = StringUtils.trimToEmpty(req.getParameter("staffName"));
			int currentPage = NumberUtils.toInt(req.getParameter("currentPage"), 1);
			int pageSize = NumberUtils.toInt(req.getParameter("pageSize"), 10);
			BsInventoryStaffExample example = new BsInventoryStaffExample();
			example.setOrderByClause(" create_time desc ");
			int offset = (currentPage - 1) * pageSize;
			example.setLimit(pageSize);
			example.setOffset(offset);
			Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(userId);
			if (staffType > 0) {
				criteria.andStaffTypeEqualTo(staffType);
			}
			if (StringUtils.isNotEmpty(staffName)) {
				// criteria.andTrueNameEqualTo(staffName);
				criteria.andTrueNameLike("%" + staffName + "%");
			}
			list = bsInventoryStaffMapper.selectByExample(example);
			int total = bsInventoryStaffMapper.countByExample(example);

			json.setTotal(total);
			boolean success = false;
			int number = offset + 1;
			if (list != null && list.size() > 0) {
				success = true;
				json.addTitle("number", "staffId", "staffType", "phone", "idCard", "trueName", "cardNumber",
						"licensePlate", "company", "remark");
				if (list != null) {
					for (BsInventoryStaff item : list) {
						// String formattedDate =
						// DateUtil.format(item.getCreateTime(),
						// DateStyle.YYYY_MM_DD_HH_MM_SS);
						json.addOneRow(number++, item.getId(), item.getStaffType(), item.getPhone(), item.getIdCard(),
								item.getTrueName(), item.getCardNumber(),
								StringUtils.trimToEmpty(item.getLicensePlate()),
								StringUtils.trimToEmpty(item.getCompany()), item.getRemark());
					}
				}
			} else {
				success = false;
			}
			json.setSuccess(success);

		} catch (Exception e) {
			log.warn("BsInventoryStaffCtrl get by key error..", e);
		}
		return json.toJsonObj();
	}

	/**
	 * ajax精确查询请求 url:
	 * 'http://ip/app/htuser/?query=({"key1":"value1","key2":"value2",...})'
	 * dataType: 'json' type: 'get'
	 * 
	 * ajax无条件查询全部请求 url: 'http://ip/app/htuser' dataType: 'json' type: 'get'
	 * 
	 * ajax模糊查询请求 url:
	 * 'http://ip/app/htuser/?query={"(colname)":{"$regex":"(colvalue)","$option
	 * s " : " i " } dataType: 'json' type: 'get'
	 * 
	 * ajax分页查询 请求 url:
	 * 'http://ip/app/htuser/?query=(空或{"key1":"value1","key2":"value2",...})&sk
	 * i p = " + beginRow + "&limit=" + rowNum' dataType:'json' type:'get'
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
			dc.setEntityClass(BsInventoryStaff.class);
			dc.setKeyClass(BsInventoryStaffKey.class);
			dc.setMapperClass(BsInventoryStaffMapper.class);
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
			log.warn("BsInventoryStaffCtrl get error..", e);
		}
		if (para.isPage()) {
			return new ListInfo<>(totalCount, list, para);
		} else {
			return list;
		}
	}

	/**
	 * ajax根据ID主键查询 请求 url: 'http://ip/app/htuser/(_id值)' dataType: 'json' type:
	 * 'get'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	@ResponseBody
	public Object get(@PathVariable String key, HttpServletRequest req) {
		int totalCount = 1;
		List<BsInventoryStaff> list = null;
		BsInventoryStaff staff = null;
		try {
			BsInventoryStaff akey = new BsInventoryStaff();

			Field keyField = FieldUtils.allDeclaredField(BsInventoryStaffKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() == null) {
				list = new ArrayList<BsInventoryStaff>();
			} else {
				BsInventoryStaffExample example = new BsInventoryStaffExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				list = bsInventoryStaffMapper.selectByExample(example);

				if (list != null && list.size() > 0) {
					staff = list.get(0);
				}
			}
			totalCount = list.size();
		} catch (Exception e) {
			log.warn("BsInventoryStaffCtrl get by key error..", e);
		}
		return staff;
	}

	/**
	 * ajax根据主键删除 url:'http://ip/app/htuser/(_id值)' type: 'DELETE' dataType:
	 * 'json'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
	@ResponseBody
	public ReturnInfo delete(@PathVariable String key, HttpServletRequest req) {
		try {
			BsInventoryStaff akey = new BsInventoryStaff();

			Field keyField = FieldUtils.allDeclaredField(BsInventoryStaffKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() != null) {
				bsInventoryStaffMapper.deleteByPrimaryKey(akey);
				return ReturnInfo.Success;
			}
		} catch (Exception e) {
			log.warn("BsInventoryStaffCtrl delete by key error..");
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax根据主键单条修改 url:'http://ip/app/htuser/(_id值)'
	 * data:'{"key1":"value1","key2":"value2",...}' type:'PUT'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo update(@PathVariable String key, BsInventoryStaff info, HttpServletRequest req) {
		try {
			if (info != null) {
				BsInventoryStaff akey = new BsInventoryStaff();

				Field keyField = FieldUtils.allDeclaredField(BsInventoryStaffKey.class).get(0);

				if (keyField.getType().isInstance(1)) {
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				} else if (keyField.getType().isInstance(1L)) {
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				} else {
					FieldUtils.setObjectValue(akey, keyField, key);
				}

				// 验证是否重复手机号
				int id = akey.getId();
				int userId = info.getUserId();
				int staffType = info.getStaffType();
				String phone = info.getPhone();
				boolean isExist = bsInventoryStaffDao.isExist(userId, staffType, phone, id);

				if (isExist) {
					return new ReturnInfo("手机号已存在，不可保存", 10000, null, false);
				} else {
					BsInventoryStaffExample example = new BsInventoryStaffExample();
					example.createCriteria().andIdEqualTo(akey.getId());
					info.setUpdateTime(new Date());
					int suc = bsInventoryStaffMapper.updateByExampleSelective(info, example);
					if (suc > 0) {
						// TODO 编辑 司机或送粮人的同时，修改 记录中的信息。
						// bsInventoryStaffDao.updateRecord(info);
					}
					return ReturnInfo.Success;
				}
			}
		} catch (Exception e) {
			log.warn("BsInventoryStaff update by key error..");
		}
		return ReturnInfo.Faild;
	}

	private void setTableName(DbCondi dc) {
		String tName = DBBean.getTableName2Class(BsInventoryStaff.class);
		if (dc.getOther() == null) {
			Map<String, Object> o = new HashMap<String, Object>();
			o.put(SqlMaker.TABLE_NAME, tName);
			dc.setOther(o);
		} else {
			dc.getOther().put(SqlMaker.TABLE_NAME, tName);
		}
	}

	@SuppressWarnings("serial")
	public static class BsInventoryStaffs extends ArrayList<BsInventoryStaffs> {
		public BsInventoryStaffs() {
			super();
		}
	}
}