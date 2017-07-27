package lb.rest.user.db.mapper;

import java.util.List;

import lb.rest.trade.db.entity.BsReferencePrice;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.mlb.bo.DistanceBO;
import com.mlb.bo.LocationBO;

public interface MyCommonMapper {

	@SelectProvider(type = MyCommonSqlProvider.class, method = "getAreaLocation")
	@Results({ @Result(column = "ID", property = "location", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "Lat", property = "lat", jdbcType = JdbcType.DOUBLE),
			@Result(column = "lng", property = "lng", jdbcType = JdbcType.DOUBLE),
			@Result(column = "bd_lng", property = "bdlng", jdbcType = JdbcType.DOUBLE),
			@Result(column = "bd_lat", property = "bdlat", jdbcType = JdbcType.DOUBLE),
			@Result(column = "MergerName", property = "name", jdbcType = JdbcType.VARCHAR) })
	LocationBO getAreaLocation(@Param("location") int location);

	@SelectProvider(type = MyCommonSqlProvider.class, method = "getDistanceMapByDest")
	@Results({ @Result(column = "orig_location", property = "origLocation", jdbcType = JdbcType.INTEGER),
			@Result(column = "dest_location", property = "destLocation", jdbcType = JdbcType.INTEGER),
			@Result(column = "distance", property = "distance", jdbcType = JdbcType.DOUBLE), })
	List<DistanceBO> getDistanceMapByDest(@Param("location") int location);

	@SelectProvider(type = MyCommonSqlProvider.class, method = "getDistance")
	@Results({ @Result(column = "orig_location", property = "origLocation", jdbcType = JdbcType.INTEGER),
			@Result(column = "dest_location", property = "destLocation", jdbcType = JdbcType.INTEGER),
			@Result(column = "distance", property = "distance", jdbcType = JdbcType.DOUBLE), })
	DistanceBO getDistance(@Param("origLocation") int origLocation, @Param("destLocation") int destLocation);

	@Insert({ "insert into offerprice_distance ( orig_location, ", "dest_location, distance)",
			"values ( #{origLocation,jdbcType=INTEGER}, ",
			"#{destLocation,jdbcType=INTEGER}, #{distance,jdbcType=DOUBLE})" })
	int insertDistance(@Param("origLocation") int origLocation, @Param("destLocation") int destLocation,
			@Param("distance") double distance);

	@InsertProvider(type = MyCommonSqlProvider.class, method = "insertList")
	int insertList(@Param("list") List<DistanceBO> list);

	@SelectProvider(type = MyCommonSqlProvider.class, method = "selectPriceList")
	@Results({ @Result(column = "locationDes", property = "provinceName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "dateStr", property = "cityName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "price", property = "remark", jdbcType = JdbcType.INTEGER) })
	List<BsReferencePrice> selectPriceList(@Param("province") int province, @Param("city") int city,
			@Param("type") int type, @Param("foodType") int foodType);

	@Select({ "SELECT LAST_INSERT_ID()" })
	int getLastInsertId();

}
