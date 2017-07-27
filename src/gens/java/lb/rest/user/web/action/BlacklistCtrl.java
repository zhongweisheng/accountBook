package lb.rest.user.web.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lb.rest.user.db.entity.Blacklist;
import lb.rest.user.db.entity.BlacklistExample;
import lb.rest.user.db.entity.BlacklistKey;
import lb.rest.user.db.entity.Mlbuser;
import lb.rest.user.db.entity.MlbuserKey;
import lb.rest.user.db.mapper.BlacklistMapper;
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
@RequestMapping("/blacklist")
public class BlacklistCtrl extends BasicCtrl {

	private static BlacklistMapper blacklistMapper = (BlacklistMapper) BeanFactory.getBean("blacklistMapper");

	private static DataService mysqlDataService = (DataService) BeanFactory.getBean("mysqlDataService");
	private static MlbuserMapper mlbuserMapper = (MlbuserMapper) BeanFactory.getBean("mlbuserMapper");

	/**
	 * ajax单条数据插入 url:'http://ip/rest/blacklist'
	 * data:'{"key1":"value1","key2":"value2",...}' type:’POST
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo insert(@Valid @RequestBody Blacklist info, HttpServletRequest req) {
		try {
			blacklistMapper.insert(info);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BlacklistCtrl insert error..", e);
			// e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax精确查询请求 url:
	 * 'http://ip/app/blacklist/?query=({"key1":"value1","key2":"value2",...})'
	 * dataType: 'json' type: 'get'
	 * 
	 * ajax无条件查询全部请求 url: 'http://ip/app/blacklist' dataType: 'json' type: 'get'
	 * 
	 * ajax模糊查询请求 url:
	 * 'http://ip/app/blacklist/?query={"(colname)":{"$regex":"(colvalue)","$opt
	 * i o n s " : " i " } dataType: 'json' type: 'get'
	 * 
	 * ajax分页查询 请求 url:
	 * 'http://ip/app/blacklist/?query=(空或{"key1":"value1","key2":"value2",...})
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
			dc.setEntityClass(Blacklist.class);
			dc.setKeyClass(BlacklistKey.class);
			dc.setMapperClass(BlacklistMapper.class);
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
			log.warn("BlacklistCtrl get error..", e);
		}
		if (para.isPage()) {
			return new ListInfo<>(totalCount, list, para);
		} else {
			return list;
		}
	}

	/**
	 * ajax根据ID主键查询 请求 url: 'http://ip/app/blacklist/(_id值)' dataType: 'json'
	 * type: 'get'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ListInfo<Blacklist> get(@PathVariable String key, HttpServletRequest req) {
		int totalCount = 1;
		List<Blacklist> list = null;
		try {
			Blacklist akey = new Blacklist();

			Field keyField = FieldUtils.allDeclaredField(BlacklistKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() == null) {
				list = new ArrayList<Blacklist>();
			} else {
				BlacklistExample example = new BlacklistExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				list = blacklistMapper.selectByExample(example);
			}
			totalCount = list.size();
		} catch (Exception e) {
			log.warn("BlacklistCtrl get by key error..", e);
		}
		return new ListInfo<>(totalCount, list, 0, 1);
	}

	@RequestMapping(value = "/isBlackList/{key}", method = RequestMethod.GET)
	@ResponseBody
	public int isBlackList(@PathVariable String key, HttpServletRequest req) {
		int isBlackList = 0;
		List<Blacklist> list = null;
		try {
			int userId = NumberUtils.toInt(key);

			if (userId > 0) {
				MlbuserKey keyAddition = new MlbuserKey();
				keyAddition.setUserid(userId);
				Mlbuser additionBO = mlbuserMapper.selectByPrimaryKey(keyAddition);
				if (additionBO != null) {
					String userPhone = additionBO.getPhone();
					if (StringUtils.isNotEmpty(userPhone)) {
						BlacklistExample example = new BlacklistExample();
						// 黑名单state=1
						example.createCriteria().andPhoneLike(userPhone).andStateEqualTo(1);
						list = blacklistMapper.selectByExample(example);
						if (list != null && list.size() > 0) {
							isBlackList = 1;
						}
					}
				}
			}
		} catch (Exception e) {
			log.warn("BlacklistCtrl isBlackList by userId error..", e);
		}
		return isBlackList;
	}

	/**
	 * ajax根据主键删除 url:'http://ip/app/blacklist/(_id值)' type: 'DELETE' dataType:
	 * 'json'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
	@ResponseBody
	public ReturnInfo delete(@PathVariable String key, HttpServletRequest req) {
		try {
			Blacklist akey = new Blacklist();

			Field keyField = FieldUtils.allDeclaredField(BlacklistKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() != null) {
				blacklistMapper.deleteByPrimaryKey(akey);
				return ReturnInfo.Success;
			}
		} catch (Exception e) {
			log.warn("BlacklistCtrl delete by key error..");
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax根据主键单条修改 url:'http://ip/app/blacklist/(_id值)'
	 * data:'{"key1":"value1","key2":"value2",...}' type:'PUT'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.PUT)
	@ResponseBody
	public ReturnInfo update(@PathVariable String key, @Valid @RequestBody Blacklist info, HttpServletRequest req) {
		try {
			if (info != null) {
				Blacklist akey = new Blacklist();

				Field keyField = FieldUtils.allDeclaredField(BlacklistKey.class).get(0);

				if (keyField.getType().isInstance(1)) {
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				} else if (keyField.getType().isInstance(1L)) {
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				} else {
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				BlacklistExample example = new BlacklistExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				blacklistMapper.updateByExampleSelective(info, example);
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("Blacklist update by key error..");
		}
		return ReturnInfo.Faild;
	}

	private void setTableName(DbCondi dc) {
		String tName = DBBean.getTableName2Class(Blacklist.class);
		if (dc.getOther() == null) {
			Map<String, Object> o = new HashMap<String, Object>();
			o.put(SqlMaker.TABLE_NAME, tName);
			dc.setOther(o);
		} else {
			dc.getOther().put(SqlMaker.TABLE_NAME, tName);
		}
	}

	@SuppressWarnings("serial")
	public static class Blacklists extends ArrayList<Blacklist> {
		public Blacklists() {
			super();
		}
	}
}