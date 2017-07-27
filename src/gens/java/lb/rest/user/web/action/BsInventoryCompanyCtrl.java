package lb.rest.user.web.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lb.rest.user.db.dao.BsInventoryCompanyDao;
import lb.rest.user.db.entity.BsInventoryCompany;
import lb.rest.user.db.entity.BsInventoryCompanyExample;
import lb.rest.user.db.entity.BsInventoryCompanyKey;
import lb.rest.user.db.mapper.BsInventoryCompanyMapper;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlb.util.SequenceUtil;

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
@RequestMapping("/bsinventorycompany")
public class BsInventoryCompanyCtrl extends BasicCtrl {

	private static BsInventoryCompanyMapper bsInventoryCompanyMapper = (BsInventoryCompanyMapper) BeanFactory
			.getBean("bsInventoryCompanyMapper");
	private static BsInventoryCompanyDao bsInventoryCompanyDao = (BsInventoryCompanyDao) BeanFactory
			.getBean("bsInventoryCompanyDao");

	private static DataService mysqlDataService = (DataService) BeanFactory.getBean("mysqlDataService");

	/**
	 * ajax单条数据插入 url:'http://ip/rest/bsinventorycompany'
	 * data:'{"key1":"value1","key2":"value2",...}' type:’POST
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo insert(BsInventoryCompany info, HttpServletRequest req) {
		try {
			int id = SequenceUtil.getInstance().nextValue("bs_inventory_company");
			info.setId(id);
			info.setCreateTime(new Date());
			info.setUpdateTime(new Date());
			bsInventoryCompanyMapper.insertSelective(info);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsInventoryCompanyCtrl insert error..", e);
			// e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}

	@RequestMapping(value = "/getCompanyByOwnerId/{key}", method = RequestMethod.GET)
	@ResponseBody
	public BsInventoryCompany getCompanyByOwnerId(@PathVariable String key, HttpServletRequest req) {
		BsInventoryCompany object = null;
		try {
			int ownerId = NumberUtils.toInt(key);
			object = bsInventoryCompanyDao.getCompanyByOwnerId(ownerId);
		} catch (Exception e) {
			log.warn("BsInventoryCompanyCtrl get by getCompanyByOwnerId error..", e);
		}
		return object;
	}

	/**
	 * ajax根据ID主键查询 请求 url: 'http://ip/app/bsinventorycompany/(_id值)' dataType:
	 * 'json' type: 'get'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	@ResponseBody
	public BsInventoryCompany get(@PathVariable String key, HttpServletRequest req) {
		BsInventoryCompany object = null;
		try {
			BsInventoryCompany akey = new BsInventoryCompany();

			Field keyField = FieldUtils.allDeclaredField(BsInventoryCompanyKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() == null) {
			} else {
				BsInventoryCompanyExample example = new BsInventoryCompanyExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				List<BsInventoryCompany> lists = bsInventoryCompanyMapper.selectByExample(example);
				if (lists != null && lists.size() > 0) {
					object = lists.get(0);
				}
			}
		} catch (Exception e) {
			log.warn("BsInventoryCompanyCtrl get by key error..", e);
		}
		return object;
	}

	/**
	 * ajax根据主键删除 url:'http://ip/app/bsinventorycompany/(_id值)' type: 'DELETE'
	 * dataType: 'json'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
	@ResponseBody
	public ReturnInfo delete(@PathVariable String key, HttpServletRequest req) {
		try {
			BsInventoryCompany akey = new BsInventoryCompany();

			Field keyField = FieldUtils.allDeclaredField(BsInventoryCompanyKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() != null) {
				bsInventoryCompanyMapper.deleteByPrimaryKey(akey);
				return ReturnInfo.Success;
			}
		} catch (Exception e) {
			log.warn("BsInventoryCompanyCtrl delete by key error..");
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax根据主键单条修改 url:'http://ip/app/bsinventorycompany/(_id值)'
	 * data:'{"key1":"value1","key2":"value2",...}' type:'PUT'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo update(@PathVariable String key, BsInventoryCompany info, HttpServletRequest req) {
		try {
			if (info != null) {
				BsInventoryCompany akey = new BsInventoryCompany();

				Field keyField = FieldUtils.allDeclaredField(BsInventoryCompanyKey.class).get(0);

				if (keyField.getType().isInstance(1)) {
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				} else if (keyField.getType().isInstance(1L)) {
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				} else {
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				BsInventoryCompanyExample example = new BsInventoryCompanyExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				info.setUpdateTime(new Date());
				bsInventoryCompanyMapper.updateByExampleSelective(info, example);
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsInventoryCompany update by key error..");
		}
		return ReturnInfo.Faild;
	}

	private void setTableName(DbCondi dc) {
		String tName = DBBean.getTableName2Class(BsInventoryCompany.class);
		if (dc.getOther() == null) {
			Map<String, Object> o = new HashMap<String, Object>();
			o.put(SqlMaker.TABLE_NAME, tName);
			dc.setOther(o);
		} else {
			dc.getOther().put(SqlMaker.TABLE_NAME, tName);
		}
	}

	@SuppressWarnings("serial")
	public static class BsInventoryCompanys extends ArrayList<BsInventoryCompany> {
		public BsInventoryCompanys() {
			super();
		}
	}
}