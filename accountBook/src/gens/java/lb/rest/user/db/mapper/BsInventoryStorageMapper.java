package lb.rest.user.db.mapper;

import java.util.List;
import lb.rest.user.db.entity.BsInventoryStorage;
import lb.rest.user.db.entity.BsInventoryStorageExample;
import lb.rest.user.db.entity.BsInventoryStorageKey;
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

public interface BsInventoryStorageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage
     *
     * @mbggenerated Thu May 18 13:15:19 CST 2017
     */
    @SelectProvider(type=BsInventoryStorageSqlProvider.class, method="countByExample")
    int countByExample(BsInventoryStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage
     *
     * @mbggenerated Thu May 18 13:15:19 CST 2017
     */
    @DeleteProvider(type=BsInventoryStorageSqlProvider.class, method="deleteByExample")
    int deleteByExample(BsInventoryStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage
     *
     * @mbggenerated Thu May 18 13:15:19 CST 2017
     */
    @Delete({
        "delete from bs_inventory_storage",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(BsInventoryStorageKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage
     *
     * @mbggenerated Thu May 18 13:15:19 CST 2017
     */
    @Insert({
        "insert into bs_inventory_storage (id, user_id, ",
        "record_type, record_number, ",
        "record_name, grain_type, ",
        "date, time, record_time, ",
        "license_plate, gross_weight_in, ",
        "tare_weight_in, net_weight_in, ",
        "gross_weight_out, tare_weight_out, ",
        "net_weight_out, money_in, ",
        "money_in_total, money_out, ",
        "money_out_total, unit_price, ",
        "balance, in_total, ",
        "average_price_in, inventory_cost, ",
        "inventory_money, total_profit, ",
        "profit, create_time, ",
        "moisture_content, bulk_density, ",
        "mildew, imperfect_grains, ",
        "product_quality, impurity, ",
        "staff_id, staff_name, ",
        "staff_phone, int_column1, ",
        "int_column2, str_column1, ",
        "str_column2, remark, ",
        "driver_id, driver_name, ",
        "driver_phone, deduction, ",
        "smell, location, ",
        "location_desc, variety_type, ",
        "packing_type, production_niafe, ",
        "cost, shifuk, if_payment, ",
        "paid_money, unpaid_money, ",
        "has_settled, not_settled, ",
        "settle_count, update_time, ",
        "if_clear, operate_user_id, ",
        "operate_user_name, depot_id)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{recordType,jdbcType=INTEGER}, #{recordNumber,jdbcType=VARCHAR}, ",
        "#{recordName,jdbcType=VARCHAR}, #{grainType,jdbcType=INTEGER}, ",
        "#{date,jdbcType=VARCHAR}, #{time,jdbcType=VARCHAR}, #{recordTime,jdbcType=TIMESTAMP}, ",
        "#{licensePlate,jdbcType=VARCHAR}, #{grossWeightIn,jdbcType=DOUBLE}, ",
        "#{tareWeightIn,jdbcType=DOUBLE}, #{netWeightIn,jdbcType=DOUBLE}, ",
        "#{grossWeightOut,jdbcType=DOUBLE}, #{tareWeightOut,jdbcType=DOUBLE}, ",
        "#{netWeightOut,jdbcType=DOUBLE}, #{moneyIn,jdbcType=DOUBLE}, ",
        "#{moneyInTotal,jdbcType=DOUBLE}, #{moneyOut,jdbcType=DOUBLE}, ",
        "#{moneyOutTotal,jdbcType=DOUBLE}, #{unitPrice,jdbcType=DOUBLE}, ",
        "#{balance,jdbcType=DOUBLE}, #{inTotal,jdbcType=DOUBLE}, ",
        "#{averagePriceIn,jdbcType=DOUBLE}, #{inventoryCost,jdbcType=DOUBLE}, ",
        "#{inventoryMoney,jdbcType=DOUBLE}, #{totalProfit,jdbcType=DOUBLE}, ",
        "#{profit,jdbcType=DOUBLE}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{moistureContent,jdbcType=VARCHAR}, #{bulkDensity,jdbcType=VARCHAR}, ",
        "#{mildew,jdbcType=VARCHAR}, #{imperfectGrains,jdbcType=VARCHAR}, ",
        "#{productQuality,jdbcType=VARCHAR}, #{impurity,jdbcType=VARCHAR}, ",
        "#{staffId,jdbcType=INTEGER}, #{staffName,jdbcType=VARCHAR}, ",
        "#{staffPhone,jdbcType=VARCHAR}, #{intColumn1,jdbcType=INTEGER}, ",
        "#{intColumn2,jdbcType=INTEGER}, #{strColumn1,jdbcType=VARCHAR}, ",
        "#{strColumn2,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{driverId,jdbcType=INTEGER}, #{driverName,jdbcType=VARCHAR}, ",
        "#{driverPhone,jdbcType=VARCHAR}, #{deduction,jdbcType=DOUBLE}, ",
        "#{smell,jdbcType=VARCHAR}, #{location,jdbcType=VARCHAR}, ",
        "#{locationDesc,jdbcType=VARCHAR}, #{varietyType,jdbcType=INTEGER}, ",
        "#{packingType,jdbcType=INTEGER}, #{productionNiafe,jdbcType=VARCHAR}, ",
        "#{cost,jdbcType=DOUBLE}, #{shifuk,jdbcType=DOUBLE}, #{ifPayment,jdbcType=INTEGER}, ",
        "#{paidMoney,jdbcType=DOUBLE}, #{unpaidMoney,jdbcType=DOUBLE}, ",
        "#{hasSettled,jdbcType=DOUBLE}, #{notSettled,jdbcType=DOUBLE}, ",
        "#{settleCount,jdbcType=DOUBLE}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{ifClear,jdbcType=INTEGER}, #{operateUserId,jdbcType=INTEGER}, ",
        "#{operateUserName,jdbcType=VARCHAR}, #{depotId,jdbcType=INTEGER})"
    })
    int insert(BsInventoryStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage
     *
     * @mbggenerated Thu May 18 13:15:19 CST 2017
     */
    @InsertProvider(type=BsInventoryStorageSqlProvider.class, method="insertSelective")
    int insertSelective(BsInventoryStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage
     *
     * @mbggenerated Thu May 18 13:15:19 CST 2017
     */
    @SelectProvider(type=BsInventoryStorageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="record_type", property="recordType", jdbcType=JdbcType.INTEGER),
        @Result(column="record_number", property="recordNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_name", property="recordName", jdbcType=JdbcType.VARCHAR),
        @Result(column="grain_type", property="grainType", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_time", property="recordTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="license_plate", property="licensePlate", jdbcType=JdbcType.VARCHAR),
        @Result(column="gross_weight_in", property="grossWeightIn", jdbcType=JdbcType.DOUBLE),
        @Result(column="tare_weight_in", property="tareWeightIn", jdbcType=JdbcType.DOUBLE),
        @Result(column="net_weight_in", property="netWeightIn", jdbcType=JdbcType.DOUBLE),
        @Result(column="gross_weight_out", property="grossWeightOut", jdbcType=JdbcType.DOUBLE),
        @Result(column="tare_weight_out", property="tareWeightOut", jdbcType=JdbcType.DOUBLE),
        @Result(column="net_weight_out", property="netWeightOut", jdbcType=JdbcType.DOUBLE),
        @Result(column="money_in", property="moneyIn", jdbcType=JdbcType.DOUBLE),
        @Result(column="money_in_total", property="moneyInTotal", jdbcType=JdbcType.DOUBLE),
        @Result(column="money_out", property="moneyOut", jdbcType=JdbcType.DOUBLE),
        @Result(column="money_out_total", property="moneyOutTotal", jdbcType=JdbcType.DOUBLE),
        @Result(column="unit_price", property="unitPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DOUBLE),
        @Result(column="in_total", property="inTotal", jdbcType=JdbcType.DOUBLE),
        @Result(column="average_price_in", property="averagePriceIn", jdbcType=JdbcType.DOUBLE),
        @Result(column="inventory_cost", property="inventoryCost", jdbcType=JdbcType.DOUBLE),
        @Result(column="inventory_money", property="inventoryMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="total_profit", property="totalProfit", jdbcType=JdbcType.DOUBLE),
        @Result(column="profit", property="profit", jdbcType=JdbcType.DOUBLE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="moisture_content", property="moistureContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="bulk_density", property="bulkDensity", jdbcType=JdbcType.VARCHAR),
        @Result(column="mildew", property="mildew", jdbcType=JdbcType.VARCHAR),
        @Result(column="imperfect_grains", property="imperfectGrains", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_quality", property="productQuality", jdbcType=JdbcType.VARCHAR),
        @Result(column="impurity", property="impurity", jdbcType=JdbcType.VARCHAR),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_name", property="staffName", jdbcType=JdbcType.VARCHAR),
        @Result(column="staff_phone", property="staffPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="int_column1", property="intColumn1", jdbcType=JdbcType.INTEGER),
        @Result(column="int_column2", property="intColumn2", jdbcType=JdbcType.INTEGER),
        @Result(column="str_column1", property="strColumn1", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_column2", property="strColumn2", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="driver_id", property="driverId", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_name", property="driverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="driver_phone", property="driverPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="deduction", property="deduction", jdbcType=JdbcType.DOUBLE),
        @Result(column="smell", property="smell", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="location_desc", property="locationDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="variety_type", property="varietyType", jdbcType=JdbcType.INTEGER),
        @Result(column="packing_type", property="packingType", jdbcType=JdbcType.INTEGER),
        @Result(column="production_niafe", property="productionNiafe", jdbcType=JdbcType.VARCHAR),
        @Result(column="cost", property="cost", jdbcType=JdbcType.DOUBLE),
        @Result(column="shifuk", property="shifuk", jdbcType=JdbcType.DOUBLE),
        @Result(column="if_payment", property="ifPayment", jdbcType=JdbcType.INTEGER),
        @Result(column="paid_money", property="paidMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="unpaid_money", property="unpaidMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="has_settled", property="hasSettled", jdbcType=JdbcType.DOUBLE),
        @Result(column="not_settled", property="notSettled", jdbcType=JdbcType.DOUBLE),
        @Result(column="settle_count", property="settleCount", jdbcType=JdbcType.DOUBLE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="if_clear", property="ifClear", jdbcType=JdbcType.INTEGER),
        @Result(column="operate_user_id", property="operateUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="operate_user_name", property="operateUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="depot_id", property="depotId", jdbcType=JdbcType.INTEGER)
    })
    List<BsInventoryStorage> selectByExample(BsInventoryStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage
     *
     * @mbggenerated Thu May 18 13:15:19 CST 2017
     */
    @Select({
        "select",
        "id, user_id, record_type, record_number, record_name, grain_type, date, time, ",
        "record_time, license_plate, gross_weight_in, tare_weight_in, net_weight_in, ",
        "gross_weight_out, tare_weight_out, net_weight_out, money_in, money_in_total, ",
        "money_out, money_out_total, unit_price, balance, in_total, average_price_in, ",
        "inventory_cost, inventory_money, total_profit, profit, create_time, moisture_content, ",
        "bulk_density, mildew, imperfect_grains, product_quality, impurity, staff_id, ",
        "staff_name, staff_phone, int_column1, int_column2, str_column1, str_column2, ",
        "remark, driver_id, driver_name, driver_phone, deduction, smell, location, location_desc, ",
        "variety_type, packing_type, production_niafe, cost, shifuk, if_payment, paid_money, ",
        "unpaid_money, has_settled, not_settled, settle_count, update_time, if_clear, ",
        "operate_user_id, operate_user_name, depot_id",
        "from bs_inventory_storage",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="record_type", property="recordType", jdbcType=JdbcType.INTEGER),
        @Result(column="record_number", property="recordNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_name", property="recordName", jdbcType=JdbcType.VARCHAR),
        @Result(column="grain_type", property="grainType", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_time", property="recordTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="license_plate", property="licensePlate", jdbcType=JdbcType.VARCHAR),
        @Result(column="gross_weight_in", property="grossWeightIn", jdbcType=JdbcType.DOUBLE),
        @Result(column="tare_weight_in", property="tareWeightIn", jdbcType=JdbcType.DOUBLE),
        @Result(column="net_weight_in", property="netWeightIn", jdbcType=JdbcType.DOUBLE),
        @Result(column="gross_weight_out", property="grossWeightOut", jdbcType=JdbcType.DOUBLE),
        @Result(column="tare_weight_out", property="tareWeightOut", jdbcType=JdbcType.DOUBLE),
        @Result(column="net_weight_out", property="netWeightOut", jdbcType=JdbcType.DOUBLE),
        @Result(column="money_in", property="moneyIn", jdbcType=JdbcType.DOUBLE),
        @Result(column="money_in_total", property="moneyInTotal", jdbcType=JdbcType.DOUBLE),
        @Result(column="money_out", property="moneyOut", jdbcType=JdbcType.DOUBLE),
        @Result(column="money_out_total", property="moneyOutTotal", jdbcType=JdbcType.DOUBLE),
        @Result(column="unit_price", property="unitPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DOUBLE),
        @Result(column="in_total", property="inTotal", jdbcType=JdbcType.DOUBLE),
        @Result(column="average_price_in", property="averagePriceIn", jdbcType=JdbcType.DOUBLE),
        @Result(column="inventory_cost", property="inventoryCost", jdbcType=JdbcType.DOUBLE),
        @Result(column="inventory_money", property="inventoryMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="total_profit", property="totalProfit", jdbcType=JdbcType.DOUBLE),
        @Result(column="profit", property="profit", jdbcType=JdbcType.DOUBLE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="moisture_content", property="moistureContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="bulk_density", property="bulkDensity", jdbcType=JdbcType.VARCHAR),
        @Result(column="mildew", property="mildew", jdbcType=JdbcType.VARCHAR),
        @Result(column="imperfect_grains", property="imperfectGrains", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_quality", property="productQuality", jdbcType=JdbcType.VARCHAR),
        @Result(column="impurity", property="impurity", jdbcType=JdbcType.VARCHAR),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_name", property="staffName", jdbcType=JdbcType.VARCHAR),
        @Result(column="staff_phone", property="staffPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="int_column1", property="intColumn1", jdbcType=JdbcType.INTEGER),
        @Result(column="int_column2", property="intColumn2", jdbcType=JdbcType.INTEGER),
        @Result(column="str_column1", property="strColumn1", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_column2", property="strColumn2", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="driver_id", property="driverId", jdbcType=JdbcType.INTEGER),
        @Result(column="driver_name", property="driverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="driver_phone", property="driverPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="deduction", property="deduction", jdbcType=JdbcType.DOUBLE),
        @Result(column="smell", property="smell", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="location_desc", property="locationDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="variety_type", property="varietyType", jdbcType=JdbcType.INTEGER),
        @Result(column="packing_type", property="packingType", jdbcType=JdbcType.INTEGER),
        @Result(column="production_niafe", property="productionNiafe", jdbcType=JdbcType.VARCHAR),
        @Result(column="cost", property="cost", jdbcType=JdbcType.DOUBLE),
        @Result(column="shifuk", property="shifuk", jdbcType=JdbcType.DOUBLE),
        @Result(column="if_payment", property="ifPayment", jdbcType=JdbcType.INTEGER),
        @Result(column="paid_money", property="paidMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="unpaid_money", property="unpaidMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="has_settled", property="hasSettled", jdbcType=JdbcType.DOUBLE),
        @Result(column="not_settled", property="notSettled", jdbcType=JdbcType.DOUBLE),
        @Result(column="settle_count", property="settleCount", jdbcType=JdbcType.DOUBLE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="if_clear", property="ifClear", jdbcType=JdbcType.INTEGER),
        @Result(column="operate_user_id", property="operateUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="operate_user_name", property="operateUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="depot_id", property="depotId", jdbcType=JdbcType.INTEGER)
    })
    BsInventoryStorage selectByPrimaryKey(BsInventoryStorageKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage
     *
     * @mbggenerated Thu May 18 13:15:19 CST 2017
     */
    @UpdateProvider(type=BsInventoryStorageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BsInventoryStorage record, @Param("example") BsInventoryStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage
     *
     * @mbggenerated Thu May 18 13:15:19 CST 2017
     */
    @UpdateProvider(type=BsInventoryStorageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BsInventoryStorage record, @Param("example") BsInventoryStorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage
     *
     * @mbggenerated Thu May 18 13:15:19 CST 2017
     */
    @UpdateProvider(type=BsInventoryStorageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BsInventoryStorage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage
     *
     * @mbggenerated Thu May 18 13:15:19 CST 2017
     */
    @Update({
        "update bs_inventory_storage",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "record_type = #{recordType,jdbcType=INTEGER},",
          "record_number = #{recordNumber,jdbcType=VARCHAR},",
          "record_name = #{recordName,jdbcType=VARCHAR},",
          "grain_type = #{grainType,jdbcType=INTEGER},",
          "date = #{date,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=VARCHAR},",
          "record_time = #{recordTime,jdbcType=TIMESTAMP},",
          "license_plate = #{licensePlate,jdbcType=VARCHAR},",
          "gross_weight_in = #{grossWeightIn,jdbcType=DOUBLE},",
          "tare_weight_in = #{tareWeightIn,jdbcType=DOUBLE},",
          "net_weight_in = #{netWeightIn,jdbcType=DOUBLE},",
          "gross_weight_out = #{grossWeightOut,jdbcType=DOUBLE},",
          "tare_weight_out = #{tareWeightOut,jdbcType=DOUBLE},",
          "net_weight_out = #{netWeightOut,jdbcType=DOUBLE},",
          "money_in = #{moneyIn,jdbcType=DOUBLE},",
          "money_in_total = #{moneyInTotal,jdbcType=DOUBLE},",
          "money_out = #{moneyOut,jdbcType=DOUBLE},",
          "money_out_total = #{moneyOutTotal,jdbcType=DOUBLE},",
          "unit_price = #{unitPrice,jdbcType=DOUBLE},",
          "balance = #{balance,jdbcType=DOUBLE},",
          "in_total = #{inTotal,jdbcType=DOUBLE},",
          "average_price_in = #{averagePriceIn,jdbcType=DOUBLE},",
          "inventory_cost = #{inventoryCost,jdbcType=DOUBLE},",
          "inventory_money = #{inventoryMoney,jdbcType=DOUBLE},",
          "total_profit = #{totalProfit,jdbcType=DOUBLE},",
          "profit = #{profit,jdbcType=DOUBLE},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "moisture_content = #{moistureContent,jdbcType=VARCHAR},",
          "bulk_density = #{bulkDensity,jdbcType=VARCHAR},",
          "mildew = #{mildew,jdbcType=VARCHAR},",
          "imperfect_grains = #{imperfectGrains,jdbcType=VARCHAR},",
          "product_quality = #{productQuality,jdbcType=VARCHAR},",
          "impurity = #{impurity,jdbcType=VARCHAR},",
          "staff_id = #{staffId,jdbcType=INTEGER},",
          "staff_name = #{staffName,jdbcType=VARCHAR},",
          "staff_phone = #{staffPhone,jdbcType=VARCHAR},",
          "int_column1 = #{intColumn1,jdbcType=INTEGER},",
          "int_column2 = #{intColumn2,jdbcType=INTEGER},",
          "str_column1 = #{strColumn1,jdbcType=VARCHAR},",
          "str_column2 = #{strColumn2,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "driver_id = #{driverId,jdbcType=INTEGER},",
          "driver_name = #{driverName,jdbcType=VARCHAR},",
          "driver_phone = #{driverPhone,jdbcType=VARCHAR},",
          "deduction = #{deduction,jdbcType=DOUBLE},",
          "smell = #{smell,jdbcType=VARCHAR},",
          "location = #{location,jdbcType=VARCHAR},",
          "location_desc = #{locationDesc,jdbcType=VARCHAR},",
          "variety_type = #{varietyType,jdbcType=INTEGER},",
          "packing_type = #{packingType,jdbcType=INTEGER},",
          "production_niafe = #{productionNiafe,jdbcType=VARCHAR},",
          "cost = #{cost,jdbcType=DOUBLE},",
          "shifuk = #{shifuk,jdbcType=DOUBLE},",
          "if_payment = #{ifPayment,jdbcType=INTEGER},",
          "paid_money = #{paidMoney,jdbcType=DOUBLE},",
          "unpaid_money = #{unpaidMoney,jdbcType=DOUBLE},",
          "has_settled = #{hasSettled,jdbcType=DOUBLE},",
          "not_settled = #{notSettled,jdbcType=DOUBLE},",
          "settle_count = #{settleCount,jdbcType=DOUBLE},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "if_clear = #{ifClear,jdbcType=INTEGER},",
          "operate_user_id = #{operateUserId,jdbcType=INTEGER},",
          "operate_user_name = #{operateUserName,jdbcType=VARCHAR},",
          "depot_id = #{depotId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BsInventoryStorage record);
}