package lb.rest.user.db.mapper;

import java.util.List;
import lb.rest.user.db.entity.BsInventoryCompany;
import lb.rest.user.db.entity.BsInventoryCompanyExample;
import lb.rest.user.db.entity.BsInventoryCompanyKey;
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

public interface BsInventoryCompanyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_company
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @SelectProvider(type=BsInventoryCompanySqlProvider.class, method="countByExample")
    int countByExample(BsInventoryCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_company
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @DeleteProvider(type=BsInventoryCompanySqlProvider.class, method="deleteByExample")
    int deleteByExample(BsInventoryCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_company
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Delete({
        "delete from bs_inventory_company",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(BsInventoryCompanyKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_company
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Insert({
        "insert into bs_inventory_company (id, owner_id, ",
        "company_name, phone, ",
        "location, location_desc, ",
        "address, create_time, ",
        "update_time, remark, ",
        "print_head, is_deleted, ",
        "int_column1, int_column2, ",
        "str_column1, str_column2)",
        "values (#{id,jdbcType=INTEGER}, #{ownerId,jdbcType=INTEGER}, ",
        "#{companyName,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{location,jdbcType=INTEGER}, #{locationDesc,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{remark,jdbcType=VARCHAR}, ",
        "#{printHead,jdbcType=VARCHAR}, #{isDeleted,jdbcType=INTEGER}, ",
        "#{intColumn1,jdbcType=INTEGER}, #{intColumn2,jdbcType=INTEGER}, ",
        "#{strColumn1,jdbcType=VARCHAR}, #{strColumn2,jdbcType=VARCHAR})"
    })
    int insert(BsInventoryCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_company
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @InsertProvider(type=BsInventoryCompanySqlProvider.class, method="insertSelective")
    int insertSelective(BsInventoryCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_company
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @SelectProvider(type=BsInventoryCompanySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="owner_id", property="ownerId", jdbcType=JdbcType.INTEGER),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.INTEGER),
        @Result(column="location_desc", property="locationDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="print_head", property="printHead", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.INTEGER),
        @Result(column="int_column1", property="intColumn1", jdbcType=JdbcType.INTEGER),
        @Result(column="int_column2", property="intColumn2", jdbcType=JdbcType.INTEGER),
        @Result(column="str_column1", property="strColumn1", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_column2", property="strColumn2", jdbcType=JdbcType.VARCHAR)
    })
    List<BsInventoryCompany> selectByExample(BsInventoryCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_company
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Select({
        "select",
        "id, owner_id, company_name, phone, location, location_desc, address, create_time, ",
        "update_time, remark, print_head, is_deleted, int_column1, int_column2, str_column1, ",
        "str_column2",
        "from bs_inventory_company",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="owner_id", property="ownerId", jdbcType=JdbcType.INTEGER),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.INTEGER),
        @Result(column="location_desc", property="locationDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="print_head", property="printHead", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.INTEGER),
        @Result(column="int_column1", property="intColumn1", jdbcType=JdbcType.INTEGER),
        @Result(column="int_column2", property="intColumn2", jdbcType=JdbcType.INTEGER),
        @Result(column="str_column1", property="strColumn1", jdbcType=JdbcType.VARCHAR),
        @Result(column="str_column2", property="strColumn2", jdbcType=JdbcType.VARCHAR)
    })
    BsInventoryCompany selectByPrimaryKey(BsInventoryCompanyKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_company
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @UpdateProvider(type=BsInventoryCompanySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BsInventoryCompany record, @Param("example") BsInventoryCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_company
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @UpdateProvider(type=BsInventoryCompanySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BsInventoryCompany record, @Param("example") BsInventoryCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_company
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @UpdateProvider(type=BsInventoryCompanySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BsInventoryCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_company
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Update({
        "update bs_inventory_company",
        "set owner_id = #{ownerId,jdbcType=INTEGER},",
          "company_name = #{companyName,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "location = #{location,jdbcType=INTEGER},",
          "location_desc = #{locationDesc,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "print_head = #{printHead,jdbcType=VARCHAR},",
          "is_deleted = #{isDeleted,jdbcType=INTEGER},",
          "int_column1 = #{intColumn1,jdbcType=INTEGER},",
          "int_column2 = #{intColumn2,jdbcType=INTEGER},",
          "str_column1 = #{strColumn1,jdbcType=VARCHAR},",
          "str_column2 = #{strColumn2,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BsInventoryCompany record);
}