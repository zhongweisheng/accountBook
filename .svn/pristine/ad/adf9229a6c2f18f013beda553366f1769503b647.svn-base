package lb.rest.user.web.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lb.rest.user.db.dao.BsNewsServiceDao;
import lb.rest.user.db.entity.BsInventoryRecord;
import lb.rest.user.db.entity.BsInventoryRecordKey;
import lb.rest.user.db.entity.BsNews;
import lb.rest.user.db.entity.BsNewsExample;
import lb.rest.user.db.entity.BsNewsWithBLOBs;
import lb.rest.user.db.mapper.BsInventoryRecordMapper;
import lb.rest.user.db.mapper.BsNewsMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlb.util.GetParamsUtils;
import com.mlb.util.SequenceUtil;

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
@RequestMapping("/bsNews")
public class BsNewsCtrl extends BasicCtrl {

	private static BsNewsMapper bsNewsMapper = (BsNewsMapper) BeanFactory
			.getBean("bsNewsMapper");

	private static DataService mysqlDataService = (DataService) BeanFactory.getBean("mysqlDataService");

	private static BsNewsServiceDao bsNewsServiceDao = (BsNewsServiceDao) BeanFactory.getBean("bsNewsServiceDao");


	/**
	 * ajax单条数据插入 url:'http://ip/rest/bsinventoryrecord'
	 * data:'{"key1":"value1","key2":"value2",...}' type:’POST
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo insert(BsNewsWithBLOBs info, HttpServletRequest req) {
		try {
			int id = SequenceUtil.getInstance().nextValue("bs_news");
			info.setId(id);
			info.setCreatetime(new Date());
			bsNewsMapper.insert(info);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("保存出入库 error..", e);
		}
		return ReturnInfo.Faild;
	}

	/**
	 * 修改更新
	 * 
	 * @param @param info
	 * @param @param req
	 * @param @return
	 * @return ReturnInfo
	 * @throws
	 * @date 2017年3月28日下午1:36:21
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo update(BsNews info, HttpServletRequest req) {
		try {
			bsNewsMapper.updateByPrimaryKey(info);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("更新出入库记录 error..", e);
		}
		return ReturnInfo.Faild;
	}

	/**
	 * 查询新闻list
	 * 
	 * @param @param req
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 * @date 2017年3月28日下午1:35:55
	 */
	@RequestMapping(value = "/getBsNewsList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getBsNewsList(HttpServletRequest req) {
		Map<String, Object> maps = GetParamsUtils.getParamMap(req);
		return bsNewsServiceDao.getBsNewsList(maps);
	}

	
	/**
	 * ajax精确查询请求 url:
	 * 'http://ip/app/bsinventoryrecord/?query=({"key1":"value1","key2":"value2"
	 * , . . . } ) ' dataType: 'json' type: 'get'
	 * 
	 * ajax无条件查询全部请求 url: 'http://ip/app/bsinventoryrecord' dataType: 'json'
	 * type: 'get'
	 * 
	 * ajax模糊查询请求 url:
	 * 'http://ip/app/bsinventoryrecord/?query={"(colname)":{"$regex":"(colvalue
	 * ) " , " $ o p t i o n s " : " i " } dataType: 'json' type: 'get'
	 * 
	 * ajax分页查询 请求 url:
	 * 'http://ip/app/bsinventoryrecord/?query=(空或{"key1":"value1","key2":"value
	 * 2 " , . . . } ) & s k i p = " + beginRow + "&limit=" + rowNum'
	 * dataType:'json' type:'get'
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
			dc.setEntityClass(BsInventoryRecord.class);
			dc.setKeyClass(BsInventoryRecordKey.class);
			dc.setMapperClass(BsInventoryRecordMapper.class);
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
			log.warn("BsInventoryRecordCtrl get error..", e);
		}
		if (para.isPage()) {
			return new ListInfo<>(totalCount, list, para);
		} else {
			return list;
		}
	}

	/**
	 * ajax根据ID主键查询 请求 url: 'http://ip/app/bsinventoryrecord/(_id值)' dataType:
	 * 'json' type: 'get'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	@ResponseBody
	public Object get(@PathVariable String key, HttpServletRequest req) {
		List<BsNews> list = null;
		BsNews obj = null;
		try {
			BsNews akey = new BsNews();

			Field keyField = FieldUtils.allDeclaredField(BsInventoryRecordKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}
			if (true && akey.getId() == null) {
				list = new ArrayList<BsNews>();
			} else {
				BsNewsExample example = new BsNewsExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				list = bsNewsMapper.selectByExample(example);
				if (list != null && list.size() > 0) {
					obj = list.get(0);
				}
			}
		} catch (Exception e) {
			log.warn("BsInventoryRecordCtrl get by key error..", e);
		}
		return obj;
	}

	/**
	 * ajax根据主键删除 url:'http://ip/app/bsinventoryrecord/(_id值)' type: 'DELETE'
	 * dataType: 'json'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
	@ResponseBody
	public ReturnInfo delete(@PathVariable String key, HttpServletRequest req) {
		try {
			BsNews akey = new BsNews();

			Field keyField = FieldUtils.allDeclaredField(BsInventoryRecordKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() != null) {
				bsNewsMapper.deleteByPrimaryKey(akey);
				return ReturnInfo.Success;
			}
		} catch (Exception e) {
			log.warn("BsInventoryRecordCtrl delete by key error..");
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax根据主键单条修改 url:'http://ip/app/bsinventoryrecord/(_id值)'
	 * data:'{"key1":"value1","key2":"value2",...}' type:'PUT'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.PUT)
	@ResponseBody
	public ReturnInfo update(@PathVariable String key, @Valid @RequestBody BsNewsWithBLOBs info,
			HttpServletRequest req) {
		try {
			if (info != null) {
				BsNewsWithBLOBs akey = new BsNewsWithBLOBs();

				Field keyField = FieldUtils.allDeclaredField(BsInventoryRecordKey.class).get(0);

				if (keyField.getType().isInstance(1)) {
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				} else if (keyField.getType().isInstance(1L)) {
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				} else {
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				BsNewsExample example = new BsNewsExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				bsNewsMapper.updateByExampleSelective(info, example);
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("BsInventoryRecord update by key error..");
		}
		return ReturnInfo.Faild;
	}

	private void setTableName(DbCondi dc) {
		String tName = "bs_news";
		if (dc.getOther() == null) {
			Map<String, Object> o = new HashMap<String, Object>();
			o.put(SqlMaker.TABLE_NAME, tName);
			dc.setOther(o);
		} else {
			dc.getOther().put(SqlMaker.TABLE_NAME, tName);
		}
	}

	@SuppressWarnings("serial")
	public static class BsInventoryRecords extends ArrayList<BsInventoryRecord> {
		public BsInventoryRecords() {
			super();
		}
	}
}