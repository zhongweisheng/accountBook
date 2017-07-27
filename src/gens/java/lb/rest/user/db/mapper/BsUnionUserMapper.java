package lb.rest.user.db.mapper;

import java.util.List;
import lb.rest.user.db.entity.BsUnionUser;
import lb.rest.user.db.entity.BsUnionUserExample;
import lb.rest.user.db.entity.BsUnionUserKey;
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

public interface BsUnionUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    @SelectProvider(type=BsUnionUserSqlProvider.class, method="countByExample")
    int countByExample(BsUnionUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    @DeleteProvider(type=BsUnionUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(BsUnionUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    @Delete({
        "delete from bs_union_user",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and phone = #{phone,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(BsUnionUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    @Insert({
        "insert into bs_union_user (user_id, phone, ",
        "mlb_user_id, lzb_user_id, ",
        "true_name, login_name, ",
        "pass_word, open_id, ",
        "create_time)",
        "values (#{userId,jdbcType=INTEGER}, #{phone,jdbcType=VARCHAR}, ",
        "#{mlbUserId,jdbcType=INTEGER}, #{lzbUserId,jdbcType=INTEGER}, ",
        "#{trueName,jdbcType=VARCHAR}, #{loginName,jdbcType=VARCHAR}, ",
        "#{passWord,jdbcType=VARCHAR}, #{openId,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(BsUnionUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    @InsertProvider(type=BsUnionUserSqlProvider.class, method="insertSelective")
    int insertSelective(BsUnionUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    @SelectProvider(type=BsUnionUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="mlb_user_id", property="mlbUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="lzb_user_id", property="lzbUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="true_name", property="trueName", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pass_word", property="passWord", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BsUnionUser> selectByExample(BsUnionUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    @Select({
        "select",
        "user_id, phone, mlb_user_id, lzb_user_id, true_name, login_name, pass_word, ",
        "open_id, create_time",
        "from bs_union_user",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and phone = #{phone,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="mlb_user_id", property="mlbUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="lzb_user_id", property="lzbUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="true_name", property="trueName", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="pass_word", property="passWord", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BsUnionUser selectByPrimaryKey(BsUnionUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    @UpdateProvider(type=BsUnionUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BsUnionUser record, @Param("example") BsUnionUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    @UpdateProvider(type=BsUnionUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BsUnionUser record, @Param("example") BsUnionUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    @UpdateProvider(type=BsUnionUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BsUnionUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    @Update({
        "update bs_union_user",
        "set mlb_user_id = #{mlbUserId,jdbcType=INTEGER},",
          "lzb_user_id = #{lzbUserId,jdbcType=INTEGER},",
          "true_name = #{trueName,jdbcType=VARCHAR},",
          "login_name = #{loginName,jdbcType=VARCHAR},",
          "pass_word = #{passWord,jdbcType=VARCHAR},",
          "open_id = #{openId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and phone = #{phone,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(BsUnionUser record);
}