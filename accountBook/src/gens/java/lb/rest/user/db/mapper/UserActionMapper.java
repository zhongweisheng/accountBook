package lb.rest.user.db.mapper;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;
import java.util.List;
import lb.rest.user.db.entity.UserAction;
import lb.rest.user.db.entity.UserActionExample;
import lb.rest.user.db.entity.UserActionKey;
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

public interface UserActionMapper extends StaticTableDaoSupport<UserAction, UserActionExample, UserActionKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @SelectProvider(type=UserActionSqlProvider.class, method="countByExample")
    int countByExample(UserActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @DeleteProvider(type=UserActionSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Delete({
        "delete from user_action",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(UserActionKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Insert({
        "insert into user_action (id, actiontype, ",
        "actionname, actiontime, ",
        "userid, username, ",
        "useropenid, note, ",
        "offerpricetype, graintype, ",
        "offerpriceid, orderid, ",
        "phone, messageId, ",
        "menuname, fromtype, ",
        "isShow)",
        "values (#{id,jdbcType=INTEGER}, #{actiontype,jdbcType=INTEGER}, ",
        "#{actionname,jdbcType=VARCHAR}, #{actiontime,jdbcType=TIMESTAMP}, ",
        "#{userid,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{useropenid,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR}, ",
        "#{offerpricetype,jdbcType=INTEGER}, #{graintype,jdbcType=INTEGER}, ",
        "#{offerpriceid,jdbcType=INTEGER}, #{orderid,jdbcType=INTEGER}, ",
        "#{phone,jdbcType=VARCHAR}, #{messageid,jdbcType=INTEGER}, ",
        "#{menuname,jdbcType=VARCHAR}, #{fromtype,jdbcType=INTEGER}, ",
        "#{isshow,jdbcType=INTEGER})"
    })
    int insert(UserAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @InsertProvider(type=UserActionSqlProvider.class, method="insertSelective")
    int insertSelective(UserAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @SelectProvider(type=UserActionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="actiontype", property="actiontype", jdbcType=JdbcType.INTEGER),
        @Result(column="actionname", property="actionname", jdbcType=JdbcType.VARCHAR),
        @Result(column="actiontime", property="actiontime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="useropenid", property="useropenid", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="offerpricetype", property="offerpricetype", jdbcType=JdbcType.INTEGER),
        @Result(column="graintype", property="graintype", jdbcType=JdbcType.INTEGER),
        @Result(column="offerpriceid", property="offerpriceid", jdbcType=JdbcType.INTEGER),
        @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="messageId", property="messageid", jdbcType=JdbcType.INTEGER),
        @Result(column="menuname", property="menuname", jdbcType=JdbcType.VARCHAR),
        @Result(column="fromtype", property="fromtype", jdbcType=JdbcType.INTEGER),
        @Result(column="isShow", property="isshow", jdbcType=JdbcType.INTEGER)
    })
    List<UserAction> selectByExample(UserActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Select({
        "select",
        "id, actiontype, actionname, actiontime, userid, username, useropenid, note, ",
        "offerpricetype, graintype, offerpriceid, orderid, phone, messageId, menuname, ",
        "fromtype, isShow",
        "from user_action",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="actiontype", property="actiontype", jdbcType=JdbcType.INTEGER),
        @Result(column="actionname", property="actionname", jdbcType=JdbcType.VARCHAR),
        @Result(column="actiontime", property="actiontime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="useropenid", property="useropenid", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="offerpricetype", property="offerpricetype", jdbcType=JdbcType.INTEGER),
        @Result(column="graintype", property="graintype", jdbcType=JdbcType.INTEGER),
        @Result(column="offerpriceid", property="offerpriceid", jdbcType=JdbcType.INTEGER),
        @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="messageId", property="messageid", jdbcType=JdbcType.INTEGER),
        @Result(column="menuname", property="menuname", jdbcType=JdbcType.VARCHAR),
        @Result(column="fromtype", property="fromtype", jdbcType=JdbcType.INTEGER),
        @Result(column="isShow", property="isshow", jdbcType=JdbcType.INTEGER)
    })
    UserAction selectByPrimaryKey(UserActionKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @UpdateProvider(type=UserActionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserAction record, @Param("example") UserActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @UpdateProvider(type=UserActionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserAction record, @Param("example") UserActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @UpdateProvider(type=UserActionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Update({
        "update user_action",
        "set actiontype = #{actiontype,jdbcType=INTEGER},",
          "actionname = #{actionname,jdbcType=VARCHAR},",
          "actiontime = #{actiontime,jdbcType=TIMESTAMP},",
          "userid = #{userid,jdbcType=INTEGER},",
          "username = #{username,jdbcType=VARCHAR},",
          "useropenid = #{useropenid,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "offerpricetype = #{offerpricetype,jdbcType=INTEGER},",
          "graintype = #{graintype,jdbcType=INTEGER},",
          "offerpriceid = #{offerpriceid,jdbcType=INTEGER},",
          "orderid = #{orderid,jdbcType=INTEGER},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "messageId = #{messageid,jdbcType=INTEGER},",
          "menuname = #{menuname,jdbcType=VARCHAR},",
          "fromtype = #{fromtype,jdbcType=INTEGER},",
          "isShow = #{isshow,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserAction record);
}