package lb.rest.user.web.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lb.rest.user.db.dao.ImageDao;
import lb.rest.user.db.dao.MyCommonDao;
import lb.rest.user.db.entity.MlbRejectionDispose;
import lb.rest.user.db.entity.MlbRejectionDisposeExample;
import lb.rest.user.db.entity.MlbRejectionDisposeKey;
import lb.rest.user.db.entity.Mlbuser;
import lb.rest.user.db.entity.MlbuserKey;
import lb.rest.user.db.mapper.MlbRejectionDisposeMapper;
import lb.rest.user.db.mapper.MlbuserMapper;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlb.util.CommonAttrValueUtil;
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
@RequestMapping("/mlbrejectiondispose")
public class MlbRejectionDisposeCtrl extends BasicCtrl {

	private static MlbRejectionDisposeMapper mlbRejectionDisposeMapper = (MlbRejectionDisposeMapper) BeanFactory
			.getBean("mlbRejectionDisposeMapper");

	private static DataService mysqlDataService = (DataService) BeanFactory.getBean("mysqlDataService");

	private static MlbuserMapper mlbuserMapper = (MlbuserMapper) BeanFactory.getBean("mlbuserMapper");

	private static ImageDao imageDao = (ImageDao) BeanFactory.getBean("imageDao");
	private static MyCommonDao myCommonDao = (MyCommonDao) BeanFactory.getBean("myCommonDao");

	/**
	 * ajax单条数据插入 url:'http://ip/rest/mlbrejectiondispose'
	 * data:'{"key1":"value1","key2":"value2",...}' type:’POST
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo insert(MlbRejectionDispose info, HttpServletRequest req) {
		try {
			int id = SequenceUtil.getInstance().nextValue(DBBean.getTableName2Class(MlbRejectionDispose.class));
			info.setId(id);
			info.setApplyTime(new Date());
			info.setOperationTime(new Date());
			int userId = info.getUserId();
			MlbuserKey key = new MlbuserKey();
			key.setUserid(userId);
			Mlbuser user = mlbuserMapper.selectByPrimaryKey(key);
			if (user != null) {
				String userName = StringUtils.trimToEmpty(user.getTruename());
				String phone = StringUtils.trimToEmpty(user.getPhone());
				info.setUserName(userName);
				info.setUserPhone(phone);
			}

			info.setStatus(0);
			mlbRejectionDisposeMapper.insertSelective(info);

			String imageIds = StringUtils.trimToEmpty(req.getParameter("imageIds"));
			imageDao.updateFkey(imageIds, id);

			info.setId(id);
			String food_type = info.getGrainType() + "";
			int belongTable = CommonAttrValueUtil.BELONG_TABLE_MLB_REJECTION_DISPOSE;
			int belongId = id;
			myCommonDao.saveQualityAttrList(req, food_type, belongTable, belongId);

			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("MlbRejectionDisposeCtrl insert error..", e);
			// e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax精确查询请求 url:
	 * 'http://ip/app/mlbrejectiondispose/?query=({"key1":"value1","key2":"value
	 * 2 " , . . . } ) ' dataType: 'json' type: 'get'
	 * 
	 * ajax无条件查询全部请求 url: 'http://ip/app/mlbrejectiondispose' dataType: 'json'
	 * type: 'get'
	 * 
	 * ajax模糊查询请求 url:
	 * 'http://ip/app/mlbrejectiondispose/?query={"(colname)":{"$regex":"(colvalue)","$opti
	 * o n s " : " i " } dataType: 'json' type: 'get'
	 * 
	 * ajax分页查询 请求 url:
	 * 'http://ip/app/mlbrejectiondispose/?query=(空或{"key1":"value1","key2":"value2",...}
	 * ) & s k i p = " + beginRow + "&limit=" + rowNum' dataType:'json'
	 * type:'get'
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
			dc.setEntityClass(MlbRejectionDispose.class);
			dc.setKeyClass(MlbRejectionDisposeKey.class);
			dc.setMapperClass(MlbRejectionDisposeMapper.class);
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
			log.warn("MlbRejectionDisposeCtrl get error..", e);
		}
		if (para.isPage()) {
			return new ListInfo<>(totalCount, list, para);
		} else {
			return list;
		}
	}

	/**
	 * ajax根据ID主键查询 请求 url: 'http://ip/app/mlbrejectiondispose/(_id值)' dataType:
	 * 'json' type: 'get'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ListInfo<MlbRejectionDispose> get(@PathVariable String key, HttpServletRequest req) {
		int totalCount = 1;
		List<MlbRejectionDispose> list = null;
		try {
			MlbRejectionDispose akey = new MlbRejectionDispose();

			Field keyField = FieldUtils.allDeclaredField(MlbRejectionDisposeKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() == null) {
				list = new ArrayList<MlbRejectionDispose>();
			} else {
				MlbRejectionDisposeExample example = new MlbRejectionDisposeExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				list = mlbRejectionDisposeMapper.selectByExample(example);
			}
			totalCount = list.size();
		} catch (Exception e) {
			log.warn("MlbRejectionDisposeCtrl get by key error..", e);
		}
		return new ListInfo<>(totalCount, list, 0, 1);
	}

	/**
	 * ajax根据主键删除 url:'http://ip/app/mlbrejectiondispose/(_id值)' type: 'DELETE'
	 * dataType: 'json'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
	@ResponseBody
	public ReturnInfo delete(@PathVariable String key, HttpServletRequest req) {
		try {
			MlbRejectionDispose akey = new MlbRejectionDispose();

			Field keyField = FieldUtils.allDeclaredField(MlbRejectionDisposeKey.class).get(0);

			if (keyField.getType().isInstance(1)) {
				FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
			} else if (keyField.getType().isInstance(1L)) {
				FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
			} else {
				FieldUtils.setObjectValue(akey, keyField, key);
			}

			if (true && akey.getId() != null) {
				mlbRejectionDisposeMapper.deleteByPrimaryKey(akey);
				return ReturnInfo.Success;
			}
		} catch (Exception e) {
			log.warn("MlbRejectionDisposeCtrl delete by key error..");
		}
		return ReturnInfo.Faild;
	}

	/**
	 * ajax根据主键单条修改 url:'http://ip/app/mlbrejectiondispose/(_id值)'
	 * data:'{"key1":"value1","key2":"value2",...}' type:'PUT'
	 */
	@RequestMapping(value = "/{key}", method = RequestMethod.PUT)
	@ResponseBody
	public ReturnInfo update(@PathVariable String key, @Valid @RequestBody MlbRejectionDispose info,
			HttpServletRequest req) {
		try {
			if (info != null) {
				MlbRejectionDispose akey = new MlbRejectionDispose();

				Field keyField = FieldUtils.allDeclaredField(MlbRejectionDisposeKey.class).get(0);

				if (keyField.getType().isInstance(1)) {
					FieldUtils.setObjectValue(akey, keyField, Integer.parseInt(key));
				} else if (keyField.getType().isInstance(1L)) {
					FieldUtils.setObjectValue(akey, keyField, Long.parseLong(key));
				} else {
					FieldUtils.setObjectValue(akey, keyField, key);
				}
				MlbRejectionDisposeExample example = new MlbRejectionDisposeExample();
				example.createCriteria().andIdEqualTo(akey.getId());
				mlbRejectionDisposeMapper.updateByExampleSelective(info, example);
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("MlbRejectionDispose update by key error..");
		}
		return ReturnInfo.Faild;
	}

	private void setTableName(DbCondi dc) {
		String tName = DBBean.getTableName2Class(MlbRejectionDispose.class);
		if (dc.getOther() == null) {
			Map<String, Object> o = new HashMap<String, Object>();
			o.put(SqlMaker.TABLE_NAME, tName);
			dc.setOther(o);
		} else {
			dc.getOther().put(SqlMaker.TABLE_NAME, tName);
		}
	}

	@SuppressWarnings("serial")
	public static class MlbRejectionDisposes extends ArrayList<MlbRejectionDispose> {
		public MlbRejectionDisposes() {
			super();
		}
	}
}