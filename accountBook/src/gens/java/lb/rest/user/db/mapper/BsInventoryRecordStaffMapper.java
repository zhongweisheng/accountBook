package lb.rest.user.db.mapper;

import java.util.List;
import lb.rest.user.db.entity.BsInventoryRecordStaff;
import lb.rest.user.db.entity.BsInventoryRecordStaffExample;
import lb.rest.user.db.entity.BsInventoryRecordStaffKey;
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

public interface BsInventoryRecordStaffMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_record_staff
     *
     * @mbggenerated Thu Mar 30 16:15:49 CST 2017
     */
    @SelectProvider(type=BsInventoryRecordStaffSqlProvider.class, method="countByExample")
    int countByExample(BsInventoryRecordStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_record_staff
     *
     * @mbggenerated Thu Mar 30 16:15:49 CST 2017
     */
    @DeleteProvider(type=BsInventoryRecordStaffSqlProvider.class, method="deleteByExample")
    int deleteByExample(BsInventoryRecordStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_record_staff
     *
     * @mbggenerated Thu Mar 30 16:15:49 CST 2017
     */
    @Delete({
        "delete from bs_inventory_record_staff",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(BsInventoryRecordStaffKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_record_staff
     *
     * @mbggenerated Thu Mar 30 16:15:49 CST 2017
     */
    @Insert({
        "insert into bs_inventory_record_staff (record_id, staff_id, ",
        "staff_type)",
        "values (#{recordId,jdbcType=INTEGER}, #{staffId,jdbcType=INTEGER}, ",
        "#{staffType,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(BsInventoryRecordStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_record_staff
     *
     * @mbggenerated Thu Mar 30 16:15:49 CST 2017
     */
    @InsertProvider(type=BsInventoryRecordStaffSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(BsInventoryRecordStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_record_staff
     *
     * @mbggenerated Thu Mar 30 16:15:49 CST 2017
     */
    @SelectProvider(type=BsInventoryRecordStaffSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="record_id", property="recordId", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_type", property="staffType", jdbcType=JdbcType.INTEGER)
    })
    List<BsInventoryRecordStaff> selectByExample(BsInventoryRecordStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_record_staff
     *
     * @mbggenerated Thu Mar 30 16:15:49 CST 2017
     */
    @Select({
        "select",
        "id, record_id, staff_id, staff_type",
        "from bs_inventory_record_staff",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="record_id", property="recordId", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_type", property="staffType", jdbcType=JdbcType.INTEGER)
    })
    BsInventoryRecordStaff selectByPrimaryKey(BsInventoryRecordStaffKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_record_staff
     *
     * @mbggenerated Thu Mar 30 16:15:49 CST 2017
     */
    @UpdateProvider(type=BsInventoryRecordStaffSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BsInventoryRecordStaff record, @Param("example") BsInventoryRecordStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_record_staff
     *
     * @mbggenerated Thu Mar 30 16:15:49 CST 2017
     */
    @UpdateProvider(type=BsInventoryRecordStaffSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BsInventoryRecordStaff record, @Param("example") BsInventoryRecordStaffExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_record_staff
     *
     * @mbggenerated Thu Mar 30 16:15:49 CST 2017
     */
    @UpdateProvider(type=BsInventoryRecordStaffSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BsInventoryRecordStaff record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_record_staff
     *
     * @mbggenerated Thu Mar 30 16:15:49 CST 2017
     */
    @Update({
        "update bs_inventory_record_staff",
        "set record_id = #{recordId,jdbcType=INTEGER},",
          "staff_id = #{staffId,jdbcType=INTEGER},",
          "staff_type = #{staffType,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BsInventoryRecordStaff record);
}