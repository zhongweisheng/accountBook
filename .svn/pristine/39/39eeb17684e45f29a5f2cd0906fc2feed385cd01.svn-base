package lb.rest.user.db.mapper;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.mlb.bo.DistanceBO;

public class MyCommonSqlProvider {

	public String getAreaLocation(Map<String, Object> param) {

		int location = (int) param.get("location");
		StringBuffer query = new StringBuffer(100);
		query.append("SELECT 	`ID`,  ");
		query.append("	`Name`,  ");
		query.append("	`ParentId`,  ");
		query.append("	`ShortName`,  ");
		query.append("	`LevelType`,  ");
		query.append("	`CityCode`,  ");
		query.append("	`ZipCode`,  ");
		query.append("	`MergerName`,  ");
		query.append("	`lng`,  ");
		query.append("	`Lat`,  ");
		query.append("	`Pinyin`,  ");
		query.append("	`bd_lng`,  ");
		query.append("	`bd_lat` ");
		query.append("	  ");
		query.append("	FROM  ");
		query.append("	`attr_area`  ");

		return query.append(" where  ID =" + location).toString();
	}

	public String selectPriceList(Map<String, Object> param) {
		StringBuffer query = new StringBuffer(100);
		query.append("select CONCAT(t.province_name,t.city_name)    locationDes,"
				+ "DATE_FORMAT(t.update_time, '%Y-%m-%d')    dateStr ,"
				+ "CONCAT (MAX(t.Price) ,'-',MIN(t.Price1) )    price " + "from bs_reference_price t  where 1=1 ");
		// "where province = #{province,jdbcType=INTEGER} and city = #{city,jdbcType=INTEGER} and type= #{type,jdbcType=INTEGER} and food_type= #{foodType,jdbcType=INTEGER}"
		int province = NumberUtils.toInt(param.get("province").toString());
		int city = NumberUtils.toInt(param.get("city").toString());
		int type = NumberUtils.toInt(param.get("type").toString());
		int foodType = NumberUtils.toInt(param.get("foodType").toString());

		if (province > 0) {
			query.append(" and province=" + province);
		}
		if (city > 0) {
			query.append(" and city=" + city);
		}
		if (type > 0) {
			query.append(" and type=" + type);
		}
		if (foodType > 0) {
			query.append(" and food_type=" + foodType);
		}

		query.append("  group by locationDes,dateStr ");

		return query.toString();
	}

	public String getDistanceMapByDest(Map<String, Object> param) {
		int location = (int) param.get("location");
		String sql = "select * from offerprice_distance where 1=1 ";
		sql += " and dest_location=" + location;
		return sql;
	}

	public String getDistance(Map<String, Object> param) {
		int origLocation = (int) param.get("origLocation");
		int destLocation = (int) param.get("destLocation");
		String sql = "select * from offerprice_distance where orig_location=" + origLocation;
		sql += " and dest_location=" + destLocation;
		return sql;
	}

	@SuppressWarnings("unchecked")
	public String insertList(Map<String, Object> param) {
		List<DistanceBO> list = (List<DistanceBO>) param.get("list");
		StringBuffer insertSB = new StringBuffer(100);
		insertSB.append("insert into offerprice_distance ( orig_location, " + "dest_location, distance)");
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					insertSB.append("values ( #{list[0].origLocation,jdbcType=INTEGER}, ");
					insertSB.append("#{list[0].destLocation,jdbcType=INTEGER}, #{list[0].distance,jdbcType=DOUBLE})");
				} else {
					insertSB.append(", ( #{list[" + i + "].origLocation,jdbcType=INTEGER}, ");
					insertSB.append("#{list[" + i + "].destLocation,jdbcType=INTEGER}, #{list[" + i
							+ "].distance,jdbcType=DOUBLE})");
				}
			}
		}
		return insertSB.toString();

	}

}