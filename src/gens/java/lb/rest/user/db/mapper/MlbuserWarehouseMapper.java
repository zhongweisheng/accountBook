package lb.rest.user.db.mapper;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;
import java.util.List;
import lb.rest.user.db.entity.MlbuserWarehouse;
import lb.rest.user.db.entity.MlbuserWarehouseExample;
import lb.rest.user.db.entity.MlbuserWarehouseKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MlbuserWarehouseMapper extends StaticTableDaoSupport<MlbuserWarehouse, MlbuserWarehouseExample, MlbuserWarehouseKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @SelectProvider(type=MlbuserWarehouseSqlProvider.class, method="countByExample")
    int countByExample(MlbuserWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @DeleteProvider(type=MlbuserWarehouseSqlProvider.class, method="deleteByExample")
    int deleteByExample(MlbuserWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Delete({
        "delete from mlbuser_warehouse",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(MlbuserWarehouseKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Insert({
        "insert into mlbuser_warehouse (id, user_id, ",
        "warename, wareaddress, ",
        "warelocation, warelocationDesc, ",
        "has_invoice, has_tower, ",
        "out_put_num, field_scale, ",
        "year_turnover, main_flow_direction, ",
        "operate_year_limit, property_right, ",
        "isStorage)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{warename,jdbcType=VARCHAR}, #{wareaddress,jdbcType=VARCHAR}, ",
        "#{warelocation,jdbcType=INTEGER}, #{warelocationdesc,jdbcType=VARCHAR}, ",
        "#{hasInvoice,jdbcType=INTEGER}, #{hasTower,jdbcType=INTEGER}, ",
        "#{outPutNum,jdbcType=VARCHAR}, #{fieldScale,jdbcType=VARCHAR}, ",
        "#{yearTurnover,jdbcType=VARCHAR}, #{mainFlowDirection,jdbcType=VARCHAR}, ",
        "#{operateYearLimit,jdbcType=VARCHAR}, #{propertyRight,jdbcType=VARCHAR}, ",
        "#{isstorage,jdbcType=VARCHAR})"
    })
    int insert(MlbuserWarehouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @InsertProvider(type=MlbuserWarehouseSqlProvider.class, method="insertSelective")
    int insertSelective(MlbuserWarehouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @SelectProvider(type=MlbuserWarehouseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="warename", property="warename", jdbcType=JdbcType.VARCHAR),
        @Result(column="wareaddress", property="wareaddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="warelocation", property="warelocation", jdbcType=JdbcType.INTEGER),
        @Result(column="warelocationDesc", property="warelocationdesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="has_invoice", property="hasInvoice", jdbcType=JdbcType.INTEGER),
        @Result(column="has_tower", property="hasTower", jdbcType=JdbcType.INTEGER),
        @Result(column="out_put_num", property="outPutNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="field_scale", property="fieldScale", jdbcType=JdbcType.VARCHAR),
        @Result(column="year_turnover", property="yearTurnover", jdbcType=JdbcType.VARCHAR),
        @Result(column="main_flow_direction", property="mainFlowDirection", jdbcType=JdbcType.VARCHAR),
        @Result(column="operate_year_limit", property="operateYearLimit", jdbcType=JdbcType.VARCHAR),
        @Result(column="property_right", property="propertyRight", jdbcType=JdbcType.VARCHAR),
        @Result(column="isStorage", property="isstorage", jdbcType=JdbcType.VARCHAR)
    })
    List<MlbuserWarehouse> selectByExample(MlbuserWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Select({
        "select",
        "id, user_id, warename, wareaddress, warelocation, warelocationDesc, has_invoice, ",
        "has_tower, out_put_num, field_scale, year_turnover, main_flow_direction, operate_year_limit, ",
        "property_right, isStorage",
        "from mlbuser_warehouse",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="warename", property="warename", jdbcType=JdbcType.VARCHAR),
        @Result(column="wareaddress", property="wareaddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="warelocation", property="warelocation", jdbcType=JdbcType.INTEGER),
        @Result(column="warelocationDesc", property="warelocationdesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="has_invoice", property="hasInvoice", jdbcType=JdbcType.INTEGER),
        @Result(column="has_tower", property="hasTower", jdbcType=JdbcType.INTEGER),
        @Result(column="out_put_num", property="outPutNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="field_scale", property="fieldScale", jdbcType=JdbcType.VARCHAR),
        @Result(column="year_turnover", property="yearTurnover", jdbcType=JdbcType.VARCHAR),
        @Result(column="main_flow_direction", property="mainFlowDirection", jdbcType=JdbcType.VARCHAR),
        @Result(column="operate_year_limit", property="operateYearLimit", jdbcType=JdbcType.VARCHAR),
        @Result(column="property_right", property="propertyRight", jdbcType=JdbcType.VARCHAR),
        @Result(column="isStorage", property="isstorage", jdbcType=JdbcType.VARCHAR)
    })
    MlbuserWarehouse selectByPrimaryKey(MlbuserWarehouseKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @UpdateProvider(type=MlbuserWarehouseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MlbuserWarehouse record, @Param("example") MlbuserWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @UpdateProvider(type=MlbuserWarehouseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MlbuserWarehouse record, @Param("example") MlbuserWarehouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @UpdateProvider(type=MlbuserWarehouseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MlbuserWarehouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_warehouse
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Update({
        "update mlbuser_warehouse",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "warename = #{warename,jdbcType=VARCHAR},",
          "wareaddress = #{wareaddress,jdbcType=VARCHAR},",
          "warelocation = #{warelocation,jdbcType=INTEGER},",
          "warelocationDesc = #{warelocationdesc,jdbcType=VARCHAR},",
          "has_invoice = #{hasInvoice,jdbcType=INTEGER},",
          "has_tower = #{hasTower,jdbcType=INTEGER},",
          "out_put_num = #{outPutNum,jdbcType=VARCHAR},",
          "field_scale = #{fieldScale,jdbcType=VARCHAR},",
          "year_turnover = #{yearTurnover,jdbcType=VARCHAR},",
          "main_flow_direction = #{mainFlowDirection,jdbcType=VARCHAR},",
          "operate_year_limit = #{operateYearLimit,jdbcType=VARCHAR},",
          "property_right = #{propertyRight,jdbcType=VARCHAR},",
          "isStorage = #{isstorage,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MlbuserWarehouse record);
}