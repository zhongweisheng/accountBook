package com.mlb.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lb.rest.user.db.entity.BsInventoryCompany;
import lb.rest.user.db.entity.BsInventoryDepot;
import lb.rest.user.db.entity.BsInventoryOperate;
import lb.rest.user.db.entity.BsInventoryRecord;
import lb.rest.user.db.entity.BsInventoryStaff;
import lb.rest.user.db.entity.BsInventoryUser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonDataUtils {
	// 标题
	private List<String> titleList = new ArrayList<String>();
	// 列数据
	// private List<String> columnList = new ArrayList<String>();
	// 行数据
	private List<List<Object>> rowList = new ArrayList<List<Object>>();

	private boolean success = false;
	private int searchType;
	private int grainType;
	private int recordType;
	private int total;

	private Map<String, String> titleMap = new HashMap<String, String>();

	public void setTitleMap(Map<String, String> map) {
		this.titleMap = map;
	}

	public Map<String, String> getTitleMap() {
		return titleMap;
	}

	// 添加标题数据
	public void addTitle(String... title) {
		for (String arg : title) {
			titleList.add(arg);
		}
	}

	public List<String> getTitleList() {
		return titleList;
	}

	public List<List<Object>> getRowList() {
		return rowList;
	}

	// 添加行数据
	public void addOneRow(Object... value) {
		List<Object> columnList = new ArrayList<Object>();
		for (Object arg : value) {
			columnList.add(arg);
		}
		rowList.add(columnList);
	}

	public String toJsonString() {
		JSONObject obj = new JSONObject();
		JSONArray list = new JSONArray();
		for (List<Object> row : rowList) {
			JSONObject rowObject = new JSONObject();
			for (int titleIndex = 0; titleIndex < titleList.size(); titleIndex++) {
				String title = titleList.get(titleIndex);
				Object value = null;
				if (titleIndex < row.size()) {
					value = row.get(titleIndex);
				} else {
					value = "";
				}
				rowObject.put(title, value);
			}
			list.add(rowObject);
		}
		obj.put("dataList", list);
		obj.put("success", success);
		obj.put("total", total);
		return obj.toString();
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}

	public Object toJsonObj() {
		JSONObject obj = new JSONObject();
		JSONArray list = new JSONArray();
		for (List<Object> row : rowList) {
			JSONObject rowObject = new JSONObject();
			for (int titleIndex = 0; titleIndex < titleList.size(); titleIndex++) {
				String title = titleList.get(titleIndex);
				Object value = null;
				if (titleIndex < row.size()) {
					value = row.get(titleIndex);
				} else {
					value = "";
				}
				rowObject.put(title, value);
			}
			list.add(rowObject);
		}
		obj.put("dataList", list);
		obj.put("success", success);
		obj.put("searchType", searchType);
		obj.put("total", total);
		return obj;
	}

	/*
	 * { "id":"1", "winBids":1, "company":"卖粮宝", "needs":"1650", "price":"可议价",
	 * "content":"采购小麦", "quality":"国标一等粮", "endtime":"12:10:30", "number":"10",
	 * "haveNum":"5" },
	 */

	public static void main(String[] args) {
		// BsUserRequire userrequire = new BsUserRequire();
		// JSONObject json = JSONObject.fromObject(userrequire);
		// System.out.println(json.toString());
		//
		// BsGoodsInfo goodInfo = new BsGoodsInfo();
		// json = JSONObject.fromObject(goodInfo);
		// System.out.println(json.toString());
		//
		// MlbIntentionOrder info = new MlbIntentionOrder();
		// json = JSONObject.fromObject(info);
		// System.out.println(json.toString());
		//
		// BsBorder order = new BsBorder();
		// json = JSONObject.fromObject(order);
		// System.out.println(json.toString());
		//
		// BsBorderoffer offer = new BsBorderoffer();
		// json = JSONObject.fromObject(offer);
		// System.out.println(json.toString());
		//
		// MlbLogisticsService logistics = new MlbLogisticsService();
		// json = JSONObject.fromObject(logistics);
		// System.out.println(json.toString());
		//
		// MlbSuggestion suggestion = new MlbSuggestion();
		// json = JSONObject.fromObject(suggestion);
		// System.out.println(json.toString());
		//
		// MlbFactoringBusiness fatoringbuss = new MlbFactoringBusiness();
		// json = JSONObject.fromObject(fatoringbuss);
		// System.out.println(json.toString());
		//
		// MlbGuarantee guarantee = new MlbGuarantee();
		// json = JSONObject.fromObject(guarantee);
		// System.out.println(json.toString());
		//
		// MlbRejectionDispose rejection = new MlbRejectionDispose();
		// json = JSONObject.fromObject(rejection);
		// System.out.println(json.toString());
		/*
		 * 1、javascript中一般采用encodeURIComponent函数对特殊字符进行编码；
		 * 2、Java中可以使用函数URLEncoder.encode对特殊字符进行编码；
		 * 3、C#中可以使用函数HttpUtility.UrlEncode对特殊字符进行编码；
		 * 4、php中可以使用函数urlencode对特殊字符进行编码。
		 */
		// http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding
		// http://api.map.baidu.com/geocoder/v2/?ak=XFFxeu5ZP47kxS2obcqKM2AUpwHG4Gbs&location=30.548397,104.04701&output=json&pois=1
		StringBuffer table = new StringBuffer(100);
		table.append("{\"status\":0,\"result\":{\"location\":{\"lng\":104.04700999999996,\"lat\":30.548396905160847},\"formatted_address\":\"四川省成都市武侯区天府四街\",\"business\":\"\","
				+ "\"addressComponent\":{\"country\":\"中国\",\"country_code\":0,\"province\":\"四川省\",\"city\":\"成都市\",\"district\":\"武侯区\",\"adcode\":\"510107\",\"street\":\"天府四街\",\"street_number\":\"\",\"direction\":\"\",\"distance\":\"\"},\"pois\":[{\"addr\":\"成都市武侯区\",\"cp\":\" \",\"direction\":\"东南\",\"distance\":\"58\",\"name\":\"保利·心语花园官邸-5栋\",\"poiType\":\"房地产\",\"point\":{\"x\":104.04673872446225,\"y\":30.54878561088612},\"tag\":\"房地产;住宅区\",\"tel\":\"\",\"uid\":\"37b12b8ab641055d14c8f61a\",\"zip\":\"\"},{\"addr\":\"成都市武侯区\",\"cp\":\" \",\"direction\":\"西南\",\"distance\":\"59\",\"name\":\"保利·心语花园官邸-4栋\",\"poiType\":\"房地产\",\"point\":{\"x\":104.04728669082333,\"y\":30.5487933861634},\"tag\":\"房地产;住宅区\",\"tel\":\"\",\"uid\":\"af392cce623c8408c27da2b3\",\"zip\":\"\"},{\"addr\":\"高新区南高新、剑南大道伊藤旗舰店旁\",\"cp\":\" \",\"direction\":\"西\",\"distance\":\"144\",\"name\":\"保利心语花园\",\"poiType\":\"房地产\",\"point\":{\"x\":104.04823889466391,\"y\":30.548746734490327},\"tag\":\"房地产;住宅区\",\"tel\":\"\",\"uid\":\"dbf4d6eedbe0bd546fa3ccdb\",\"zip\":\"\"},{\"addr\":\"成都市武侯区\",\"cp\":\" \",\"direction\":\"东南\",\"distance\":\"99\",\"name\":\"保利·心语花园官邸-6栋\",\"poiType\":\"房地产\",\"point\":{\"x\":104.04623567337666,\"y\":30.548777835608218},\"tag\":\"房地产;住宅区\",\"tel\":\"\",\"uid\":\"4a81254d2e044b4adbeced13\",\"zip\":\"\"},{\"addr\":\"成都市武侯区\",\"cp\":\" \",\"direction\":\"东\",\"distance\":\"152\",\"name\":\"保利·心语花园官邸-7栋\",\"poiType\":\"房地产\",\"point\":{\"x\":104.04570567312577,\"y\":30.54877006032969},\"tag\":\"房地产;住宅区\",\"tel\":\"\",\"uid\":\"5739c38d5cbfe83fb21e36ba\",\"zip\":\"\"},{\"addr\":\"四川省成都市武侯区荣华南路366号\",\"cp\":\" \",\"direction\":\"东南\",\"distance\":\"192\",\"name\":\"保利心语花园别墅\",\"poiType\":\"房地产\",\"point\":{\"x\":104.04584940200737,\"y\":30.54950870898165},\"tag\":\"房地产;住宅区\",\"tel\":\"\",\"uid\":\"d614e647ce943aad41d63e49\",\"zip\":\"\"},{\"addr\":\"荣华南路201号，荣华南路与天府四街交叉口往北10米\",\"cp\":\" \",\"direction\":\"西\",\"distance\":\"370\",\"name\":\"完美汽车\",\"poiType\":\"汽车服务\",\"point\":{\"x\":104.05032296344706,\"y\":30.548653431076248},\"tag\":\"汽车服务\",\"tel\":\"\",\"uid\":\"2e0f0ed7ebaa1ffe00ff2d44\",\"zip\":\"\"},{\"addr\":\"武侯区保利心语三期盛源街1131号(原同德街)\",\"cp\":\" \",\"direction\":\"西南\",\"distance\":\"413\",\"name\":\"三只熊披萨外卖（保利心语店）\",\"poiType\":\"美食\",\"point\":{\"x\":104.0486790643638,\"y\":30.55126589243267},\"tag\":\"美食;外国餐厅\",\"tel\":\"\",\"uid\":\"800c2024cdb63509dbeced1d\",\"zip\":\"\"},{\"addr\":\"天府三街保利心语花园三期2幢1103室\",\"cp\":\" \",\"direction\":\"南\",\"distance\":\"552\",\"name\":\"全鑫整装家居馆\",\"poiType\":\"购物\",\"point\":{\"x\":104.04756516553143,\"y\":30.5526653960908},\"tag\":\"购物;家居建材\",\"tel\":\"\",\"uid\":\"3eef7c8b5aaf0465e9f85306\",\"zip\":\"\"},{\"addr\":\"天府三街1007-1011\",\"cp\":\" \",\"direction\":\"西南\",\"distance\":\"653\",\"name\":\"中国建设银行(保利心语四期东)\",\"poiType\":\"金融\",\"point\":{\"x\":104.04999059040836,\"y\":30.552774245521094},\"tag\":\"金融;银行\",\"tel\":\"\",\"uid\":\"7306c3e473f14b19f72310cb\",\"zip\":\"\"}],\"poiRegions\":[],\"sematic_description\":\"保利·心语花园官邸-5栋东南58米\",\"cityCode\":75}}");

		JSONObject jsonObject = JSONObject.fromObject(table.toString());

		JSONObject resultObject = (JSONObject) jsonObject.get("result");
		/*
		 * 返回码 定义 0 正常 1 服务器内部错误 2 请求参数非法 3 权限校验失败 4 配额校验失败 5 ak不存在或者非法 101 服务禁用
		 * 102 不通过白名单或者安全码不对 2xx 无权限 3xx 配额错误
		 */
		if (jsonObject.containsKey("status")) {
			int status = jsonObject.getInt("status");
			String address = resultObject.getString("formatted_address");
			JSONObject addressObject = (JSONObject) resultObject.get("addressComponent");
			String country = addressObject.getString("country");
			String province = addressObject.getString("province");
			String district = addressObject.getString("district");
			String adcode = addressObject.getString("adcode");

			System.out.println(address);
			System.out.println(addressObject);
			System.out.println(country + ":" + province + ":" + district + ":" + adcode + ":");
		}

		BsInventoryRecord userrequire = new BsInventoryRecord();
		JSONObject json = JSONObject.fromObject(userrequire);
		System.out.println(json.toString());
		BsInventoryUser userrequire1 = new BsInventoryUser();
		JSONObject json1 = JSONObject.fromObject(userrequire1);
		System.out.println(json1.toString());

		BsInventoryStaff staff = new BsInventoryStaff();
		JSONObject staffs = JSONObject.fromObject(staff);
		System.out.println(staffs.toString());

		BsInventoryCompany temp = new BsInventoryCompany();
		JSONObject tempObj = JSONObject.fromObject(temp);
		System.out.println(tempObj.toString());

		BsInventoryDepot tempDepot = new BsInventoryDepot();
		tempObj = JSONObject.fromObject(tempDepot);
		System.out.println(tempObj.toString());

		BsInventoryOperate tempOperate = new BsInventoryOperate();
		tempObj = JSONObject.fromObject(tempOperate);
		System.out.println(tempObj.toString());

	}

	public int getGrainType() {
		return grainType;
	}

	public void setGrainType(int grainType) {
		this.grainType = grainType;
	}

	public int getRecordType() {
		return recordType;
	}

	public void setRecordType(int recordType) {
		this.recordType = recordType;
	}

	public int getSearchType() {
		return searchType;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
