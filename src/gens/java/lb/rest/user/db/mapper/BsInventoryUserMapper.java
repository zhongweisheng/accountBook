package lb.rest.user.db.mapper;

import java.util.List;
import lb.rest.user.db.entity.BsInventoryUser;
import lb.rest.user.db.entity.BsInventoryUserExample;
import lb.rest.user.db.entity.BsInventoryUserKey;
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

public interface BsInventoryUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @SelectProvider(type=BsInventoryUserSqlProvider.class, method="countByExample")
    int countByExample(BsInventoryUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @DeleteProvider(type=BsInventoryUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(BsInventoryUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Delete({
        "delete from bs_inventory_user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(BsInventoryUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Insert({
        "insert into bs_inventory_user (user_id, true_name, ",
        "phone, login_name, ",
        "pass_word, location, ",
        "location_desc, address, ",
        "openid, nick_name, ",
        "user_image, reg_time, ",
        "update_time, remark, ",
        "print_head, bs_number_id, ",
        "user_type, company_id, ",
        "owner_id, is_actived, ",
        "is_deleted, depot_count)",
        "values (#{userId,jdbcType=INTEGER}, #{trueName,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{loginName,jdbcType=VARCHAR}, ",
        "#{passWord,jdbcType=VARCHAR}, #{location,jdbcType=INTEGER}, ",
        "#{locationDesc,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{openid,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
        "#{userImage,jdbcType=VARCHAR}, #{regTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{remark,jdbcType=VARCHAR}, ",
        "#{printHead,jdbcType=VARCHAR}, #{bsNumberId,jdbcType=INTEGER}, ",
        "#{userType,jdbcType=INTEGER}, #{companyId,jdbcType=INTEGER}, ",
        "#{ownerId,jdbcType=INTEGER}, #{isActived,jdbcType=INTEGER}, ",
        "#{isDeleted,jdbcType=INTEGER}, #{depotCount,jdbcType=INTEGER})"
    })
    int insert(BsInventoryUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @InsertProvider(type=BsInventoryUserSqlProvider.class, method="insertSelective")
    int insertSelective(BsInventoryUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @SelectProvider(type=BsInventoryUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="true_name", property="trueName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pass_word", property="passWord", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.INTEGER),
        @Result(column="location_desc", property="locationDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_image", property="userImage", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_time", property="regTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="print_head", property="printHead", jdbcType=JdbcType.VARCHAR),
        @Result(column="bs_number_id", property="bsNumberId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_type", property="userType", jdbcType=JdbcType.INTEGER),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="owner_id", property="ownerId", jdbcType=JdbcType.INTEGER),
        @Result(column="is_actived", property="isActived", jdbcType=JdbcType.INTEGER),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.INTEGER),
        @Result(column="depot_count", property="depotCount", jdbcType=JdbcType.INTEGER)
    })
    List<BsInventoryUser> selectByExample(BsInventoryUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Select({
        "select",
        "user_id, true_name, phone, login_name, pass_word, location, location_desc, address, ",
        "openid, nick_name, user_image, reg_time, update_time, remark, print_head, bs_number_id, ",
        "user_type, company_id, owner_id, is_actived, is_deleted, depot_count",
        "from bs_inventory_user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="true_name", property="trueName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pass_word", property="passWord", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.INTEGER),
        @Result(column="location_desc", property="locationDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_image", property="userImage", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_time", property="regTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="print_head", property="printHead", jdbcType=JdbcType.VARCHAR),
        @Result(column="bs_number_id", property="bsNumberId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_type", property="userType", jdbcType=JdbcType.INTEGER),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="owner_id", property="ownerId", jdbcType=JdbcType.INTEGER),
        @Result(column="is_actived", property="isActived", jdbcType=JdbcType.INTEGER),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.INTEGER),
        @Result(column="depot_count", property="depotCount", jdbcType=JdbcType.INTEGER)
    })
    BsInventoryUser selectByPrimaryKey(BsInventoryUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @UpdateProvider(type=BsInventoryUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BsInventoryUser record, @Param("example") BsInventoryUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @UpdateProvider(type=BsInventoryUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BsInventoryUser record, @Param("example") BsInventoryUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @UpdateProvider(type=BsInventoryUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BsInventoryUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_inventory_user
     *
     * @mbggenerated Mon May 15 11:47:33 CST 2017
     */
    @Update({
        "update bs_inventory_user",
        "set true_name = #{trueName,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "login_name = #{loginName,jdbcType=VARCHAR},",
          "pass_word = #{passWord,jdbcType=VARCHAR},",
          "location = #{location,jdbcType=INTEGER},",
          "location_desc = #{locationDesc,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "openid = #{openid,jdbcType=VARCHAR},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "user_image = #{userImage,jdbcType=VARCHAR},",
          "reg_time = #{regTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "print_head = #{printHead,jdbcType=VARCHAR},",
          "bs_number_id = #{bsNumberId,jdbcType=INTEGER},",
          "user_type = #{userType,jdbcType=INTEGER},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "owner_id = #{ownerId,jdbcType=INTEGER},",
          "is_actived = #{isActived,jdbcType=INTEGER},",
          "is_deleted = #{isDeleted,jdbcType=INTEGER},",
          "depot_count = #{depotCount,jdbcType=INTEGER}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BsInventoryUser record);
}