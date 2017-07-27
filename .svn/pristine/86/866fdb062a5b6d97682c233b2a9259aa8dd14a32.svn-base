package com.mlb.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.mlb.bo.CommonAttrValueBO;

public class CommonAttrValueUtil {
	// 卖粮宝
	public static final int BELONG_TABLE_OFFERPRICE = 1;
	public static final int BELONG_TABLE_TRADEORDER = 2;
	public static final int BELONG_TABLE_OUTPAPER = 3;
	public static final int BELONG_TABLE_INPAPER = 4;
	public static final int BELONG_TABLE_USERREQUIRE = 5;
	public static final int BELONG_TABLE_TRANSACTION = 6;
	public static final int BELONG_TABLE_OFFER = 7;
	public static final int BELONG_TABLE_AUCTIONGROUP = 8;
	public static final int BELONG_TABLE_MLBUSER = 9;

	// 内部流程使用
	public static final int BELONG_TABLE_TB_ORDER = 100;
	public static final int BELONG_TABLE_TB_OUT_STORE = 101;
	public static final int BELONG_TABLE_TB_IN_STORE = 102;
	public static final int BELONG_TABLE_TB_USER_REQUIRE = 103;
	public static final int BELONG_TABLE_TB_ORDER_SELL = 104;
	public static final int BELONG_TABLE_TB_REJECTION_RECORD = 105;

	// 交易
	public static final int BELONG_TABLE_BS_GOODS_INFO = 200;
	public static final int BELONG_TABLE_BS_USER_REQUIRE = 201;
	// 意向订单
	public static final int BELONG_TABLE_MLB_INTENTION_ORDER = 202;
	// 竞标订单
	public static final int BELONG_TABLE_BS_BORDER = 203;
	// 竞标报价
	public static final int BELONG_TABLE_BS_BORDEROFFER = 204;
	public static final int BELONG_TABLE_MLB_REJECTION_DISPOSE = 205;

	public static List<CommonAttrValueBO> saveQualityAttrList(HttpServletRequest request, String food_type,
			int belongTable, int belongId) {
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

		/*
		 * CommonAttrValueService.saveList(belongTable, belongId, typeId, list);
		 * 
		 * public static boolean saveList(int belongTable, int belongId, int
		 * typeId, List<CommonAttrValueBO> list) { boolean result = false; try {
		 * if (list != null && list.size() > 0) { StringBuffer deleteSql = new
		 * StringBuffer(100); deleteSql.append("DELETE ");
		 * deleteSql.append("FROM `common_attr_value` ");
		 * deleteSql.append("WHERE `typeId` = ? and belongId= ? and belongTable=? "
		 * ); QueryHelper.update(deleteSql.toString(), typeId, belongId,
		 * belongTable);
		 * 
		 * StringBuffer insertSql = new StringBuffer(100);
		 * insertSql.append("INSERT INTO `common_attr_value` ");
		 * insertSql.append("            ( ");
		 * insertSql.append("             `belongTable`, ");
		 * insertSql.append("             `belongId`, ");
		 * insertSql.append("             `typeId`, ");
		 * insertSql.append("             `attrId`, ");
		 * insertSql.append("             `attrValue`) ");
		 * insertSql.append("VALUES ( "); insertSql.append("        ?, ");
		 * insertSql.append("        ?, "); insertSql.append("        ?, ");
		 * insertSql.append("        ?, "); insertSql.append("        ? )");
		 * Object[][] params = new Object[list.size()][5]; int i = 0; for
		 * (CommonAttrValueBO item : list) { params[i][0] =
		 * item.getBelongTable(); params[i][1] = item.getBelongId();
		 * params[i][2] = item.getTypeId(); params[i][3] = item.getAttrId();
		 * params[i][4] = item.getAttrValue(); i++; }
		 * QueryHelper.batch(insertSql.toString(), params); result = true; } }
		 * catch (Exception e) { result = false; e.printStackTrace(); } return
		 * result; }
		 */
		return list;
	}

	public static List<CommonAttrValueBO> getCommonAttrValueList(HttpServletRequest request, int belongTable,
			int belongId, int typeId) {
		List<CommonAttrValueBO> attrList = new ArrayList<CommonAttrValueBO>();
		Map<String, String[]> map = request.getParameterMap();
		Set<Entry<String, String[]>> set = map.entrySet();
		Iterator<Entry<String, String[]>> it = set.iterator();
		while (it.hasNext()) {
			Entry<String, String[]> entry = it.next();
			String key = entry.getKey();

			if (StringUtils.startsWith(key, "ATTR_")) {
				String proId = key.substring(5);

				for (String value : entry.getValue()) {
					if (!isNumeric(proId)) {
						continue;
					}
					if (StringUtils.isEmpty(value))
						continue;
					CommonAttrValueBO attrBO = new CommonAttrValueBO();
					attrBO.setId(-1);
					attrBO.setAttrId(NumberUtils.toInt(proId));
					attrBO.setAttrValue(value);
					attrBO.setTypeId(typeId);
					attrBO.setBelongId(belongId);
					attrBO.setBelongTable(belongTable);
					attrList.add(attrBO);
				}
			}
		}
		return attrList;
	}

	public static Map<String, CommonAttrValueBO> getValueMap(List<CommonAttrValueBO> list) {
		Map<String, CommonAttrValueBO> attrValueMap = new HashMap<String, CommonAttrValueBO>();
		if (list != null) {
			for (CommonAttrValueBO item : list) {
				long proId = item.getAttrId();
				String proIdStr = "ATTR_" + proId;
				attrValueMap.put(proIdStr, item);
			}
		}
		return attrValueMap;
	}

	public static boolean isNumeric(String str) {
		if (str.matches("\\d+")) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

	}

}
