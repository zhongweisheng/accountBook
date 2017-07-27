package lb.rest.user.db.mapper;

import java.util.List;
import lb.rest.user.db.entity.BsTempTrade;
import lb.rest.user.db.entity.BsTempTradeExample;
import lb.rest.user.db.entity.BsTempTradeKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface BsTempTradeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_temp_trade
     *
     * @mbggenerated Tue May 23 15:30:01 CST 2017
     */
    @SelectProvider(type=BsTempTradeSqlProvider.class, method="countByExample")
    int countByExample(BsTempTradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_temp_trade
     *
     * @mbggenerated Tue May 23 15:30:01 CST 2017
     */
    @DeleteProvider(type=BsTempTradeSqlProvider.class, method="deleteByExample")
    int deleteByExample(BsTempTradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_temp_trade
     *
     * @mbggenerated Tue May 23 15:30:01 CST 2017
     */
    @Delete({
        "delete from bs_temp_trade",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(BsTempTradeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_temp_trade
     *
     * @mbggenerated Tue May 23 15:30:01 CST 2017
     */
    @Insert({
        "insert into bs_temp_trade (buy_id, buy_name, ",
        "buy_phone, buy_address, ",
        "company_name, reg_time, ",
        "buy_food_type, buy_food_name, ",
        "buy_food_price, buy_food_require, ",
        "buy_location_s, buy_location_desc_s, ",
        "buy_location, buy_location_desc, ",
        "create_time, modify_time, ",
        "food_level, remark, ",
        "address)",
        "values (#{buyId,jdbcType=INTEGER}, #{buyName,jdbcType=VARCHAR}, ",
        "#{buyPhone,jdbcType=VARCHAR}, #{buyAddress,jdbcType=VARCHAR}, ",
        "#{companyName,jdbcType=VARCHAR}, #{regTime,jdbcType=VARCHAR}, ",
        "#{buyFoodType,jdbcType=INTEGER}, #{buyFoodName,jdbcType=VARCHAR}, ",
        "#{buyFoodPrice,jdbcType=DOUBLE}, #{buyFoodRequire,jdbcType=VARCHAR}, ",
        "#{buyLocationS,jdbcType=INTEGER}, #{buyLocationDescS,jdbcType=VARCHAR}, ",
        "#{buyLocation,jdbcType=INTEGER}, #{buyLocationDesc,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{modifyTime,jdbcType=TIMESTAMP}, ",
        "#{foodLevel,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(BsTempTrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_temp_trade
     *
     * @mbggenerated Tue May 23 15:30:01 CST 2017
     */
    @InsertProvider(type=BsTempTradeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(BsTempTrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_temp_trade
     *
     * @mbggenerated Tue May 23 15:30:01 CST 2017
     */
    @SelectProvider(type=BsTempTradeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="buy_id", property="buyId", jdbcType=JdbcType.INTEGER),
        @Result(column="buy_name", property="buyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_phone", property="buyPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_address", property="buyAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_time", property="regTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_food_type", property="buyFoodType", jdbcType=JdbcType.INTEGER),
        @Result(column="buy_food_name", property="buyFoodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_food_price", property="buyFoodPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="buy_food_require", property="buyFoodRequire", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_location_s", property="buyLocationS", jdbcType=JdbcType.INTEGER),
        @Result(column="buy_location_desc_s", property="buyLocationDescS", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_location", property="buyLocation", jdbcType=JdbcType.INTEGER),
        @Result(column="buy_location_desc", property="buyLocationDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="food_level", property="foodLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    List<BsTempTrade> selectByExample(BsTempTradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_temp_trade
     *
     * @mbggenerated Tue May 23 15:30:01 CST 2017
     */
    @Select({
        "select",
        "id, buy_id, buy_name, buy_phone, buy_address, company_name, reg_time, buy_food_type, ",
        "buy_food_name, buy_food_price, buy_food_require, buy_location_s, buy_location_desc_s, ",
        "buy_location, buy_location_desc, create_time, modify_time, food_level, remark, ",
        "address",
        "from bs_temp_trade",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="buy_id", property="buyId", jdbcType=JdbcType.INTEGER),
        @Result(column="buy_name", property="buyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_phone", property="buyPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_address", property="buyAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_time", property="regTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_food_type", property="buyFoodType", jdbcType=JdbcType.INTEGER),
        @Result(column="buy_food_name", property="buyFoodName", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_food_price", property="buyFoodPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="buy_food_require", property="buyFoodRequire", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_location_s", property="buyLocationS", jdbcType=JdbcType.INTEGER),
        @Result(column="buy_location_desc_s", property="buyLocationDescS", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_location", property="buyLocation", jdbcType=JdbcType.INTEGER),
        @Result(column="buy_location_desc", property="buyLocationDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="food_level", property="foodLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    BsTempTrade selectByPrimaryKey(BsTempTradeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_temp_trade
     *
     * @mbggenerated Tue May 23 15:30:01 CST 2017
     */
    @UpdateProvider(type=BsTempTradeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BsTempTrade record, @Param("example") BsTempTradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_temp_trade
     *
     * @mbggenerated Tue May 23 15:30:01 CST 2017
     */
    @UpdateProvider(type=BsTempTradeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BsTempTrade record, @Param("example") BsTempTradeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_temp_trade
     *
     * @mbggenerated Tue May 23 15:30:01 CST 2017
     */
    @UpdateProvider(type=BsTempTradeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BsTempTrade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_temp_trade
     *
     * @mbggenerated Tue May 23 15:30:01 CST 2017
     */
    @Update({
        "update bs_temp_trade",
        "set buy_id = #{buyId,jdbcType=INTEGER},",
          "buy_name = #{buyName,jdbcType=VARCHAR},",
          "buy_phone = #{buyPhone,jdbcType=VARCHAR},",
          "buy_address = #{buyAddress,jdbcType=VARCHAR},",
          "company_name = #{companyName,jdbcType=VARCHAR},",
          "reg_time = #{regTime,jdbcType=VARCHAR},",
          "buy_food_type = #{buyFoodType,jdbcType=INTEGER},",
          "buy_food_name = #{buyFoodName,jdbcType=VARCHAR},",
          "buy_food_price = #{buyFoodPrice,jdbcType=DOUBLE},",
          "buy_food_require = #{buyFoodRequire,jdbcType=VARCHAR},",
          "buy_location_s = #{buyLocationS,jdbcType=INTEGER},",
          "buy_location_desc_s = #{buyLocationDescS,jdbcType=VARCHAR},",
          "buy_location = #{buyLocation,jdbcType=INTEGER},",
          "buy_location_desc = #{buyLocationDesc,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP},",
          "food_level = #{foodLevel,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BsTempTrade record);
}