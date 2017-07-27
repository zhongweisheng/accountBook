package lb.rest.user.db.mapper;

import java.util.List;
import lb.rest.user.db.entity.BsInventoryStoragePay;
import lb.rest.user.db.entity.BsInventoryStoragePayExample;
import lb.rest.user.db.entity.BsInventoryStoragePayKey;
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

public interface BsInventoryStoragePayMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @SelectProvider(type=BsInventoryStoragePaySqlProvider.class, method="countByExample")
    int countByExample(BsInventoryStoragePayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @DeleteProvider(type=BsInventoryStoragePaySqlProvider.class, method="deleteByExample")
    int deleteByExample(BsInventoryStoragePayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @Delete({
        "delete from bs_inventory_storage_pay",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(BsInventoryStoragePayKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @Insert({
        "insert into bs_inventory_storage_pay (id, storage_id, ",
        "settle_count, settle_price, ",
        "settle_money, should_pay, ",
        "actual_pay, create_time, ",
        "update_time, operate_user_id, ",
        "operate_user_name, is_deleted)",
        "values (#{id,jdbcType=INTEGER}, #{storageId,jdbcType=INTEGER}, ",
        "#{settleCount,jdbcType=DOUBLE}, #{settlePrice,jdbcType=DOUBLE}, ",
        "#{settleMoney,jdbcType=DOUBLE}, #{shouldPay,jdbcType=DOUBLE}, ",
        "#{actualPay,jdbcType=DOUBLE}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{operateUserId,jdbcType=INTEGER}, ",
        "#{operateUserName,jdbcType=VARCHAR}, #{isDeleted,jdbcType=INTEGER})"
    })
    int insert(BsInventoryStoragePay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @InsertProvider(type=BsInventoryStoragePaySqlProvider.class, method="insertSelective")
    int insertSelective(BsInventoryStoragePay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @SelectProvider(type=BsInventoryStoragePaySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="storage_id", property="storageId", jdbcType=JdbcType.INTEGER),
        @Result(column="settle_count", property="settleCount", jdbcType=JdbcType.DOUBLE),
        @Result(column="settle_price", property="settlePrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="settle_money", property="settleMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="should_pay", property="shouldPay", jdbcType=JdbcType.DOUBLE),
        @Result(column="actual_pay", property="actualPay", jdbcType=JdbcType.DOUBLE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="operate_user_id", property="operateUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="operate_user_name", property="operateUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.INTEGER)
    })
    List<BsInventoryStoragePay> selectByExample(BsInventoryStoragePayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @Select({
        "select",
        "id, storage_id, settle_count, settle_price, settle_money, should_pay, actual_pay, ",
        "create_time, update_time, operate_user_id, operate_user_name, is_deleted",
        "from bs_inventory_storage_pay",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="storage_id", property="storageId", jdbcType=JdbcType.INTEGER),
        @Result(column="settle_count", property="settleCount", jdbcType=JdbcType.DOUBLE),
        @Result(column="settle_price", property="settlePrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="settle_money", property="settleMoney", jdbcType=JdbcType.DOUBLE),
        @Result(column="should_pay", property="shouldPay", jdbcType=JdbcType.DOUBLE),
        @Result(column="actual_pay", property="actualPay", jdbcType=JdbcType.DOUBLE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="operate_user_id", property="operateUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="operate_user_name", property="operateUserName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.INTEGER)
    })
    BsInventoryStoragePay selectByPrimaryKey(BsInventoryStoragePayKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @UpdateProvider(type=BsInventoryStoragePaySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BsInventoryStoragePay record, @Param("example") BsInventoryStoragePayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @UpdateProvider(type=BsInventoryStoragePaySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BsInventoryStoragePay record, @Param("example") BsInventoryStoragePayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @UpdateProvider(type=BsInventoryStoragePaySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BsInventoryStoragePay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_storage_pay
     *
     * @mbggenerated Thu May 18 17:26:05 CST 2017
     */
    @Update({
        "update bs_inventory_storage_pay",
        "set storage_id = #{storageId,jdbcType=INTEGER},",
          "settle_count = #{settleCount,jdbcType=DOUBLE},",
          "settle_price = #{settlePrice,jdbcType=DOUBLE},",
          "settle_money = #{settleMoney,jdbcType=DOUBLE},",
          "should_pay = #{shouldPay,jdbcType=DOUBLE},",
          "actual_pay = #{actualPay,jdbcType=DOUBLE},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "operate_user_id = #{operateUserId,jdbcType=INTEGER},",
          "operate_user_name = #{operateUserName,jdbcType=VARCHAR},",
          "is_deleted = #{isDeleted,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BsInventoryStoragePay record);
}