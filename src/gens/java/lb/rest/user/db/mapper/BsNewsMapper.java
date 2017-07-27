package lb.rest.user.db.mapper;

import java.util.List;
import lb.rest.user.db.entity.BsNews;
import lb.rest.user.db.entity.BsNewsExample;
import lb.rest.user.db.entity.BsNewsKey;
import lb.rest.user.db.entity.BsNewsWithBLOBs;
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

public interface BsNewsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @SelectProvider(type=BsNewsSqlProvider.class, method="countByExample")
    int countByExample(BsNewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @DeleteProvider(type=BsNewsSqlProvider.class, method="deleteByExample")
    int deleteByExample(BsNewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @Delete({
        "delete from bs_news",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(BsNewsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @Insert({
        "insert into bs_news (ID, title, ",
        "note, createTime, ",
        "createUserId, createUserName, ",
        "updateTime, updateUserId, ",
        "updateUserName, intColumn1, ",
        "intColumn2, strColumn1, ",
        "strColumn2, htmlValue)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{note,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{createuserid,jdbcType=INTEGER}, #{createusername,jdbcType=VARCHAR}, ",
        "#{updatetime,jdbcType=TIMESTAMP}, #{updateuserid,jdbcType=INTEGER}, ",
        "#{updateusername,jdbcType=VARCHAR}, #{intcolumn1,jdbcType=INTEGER}, ",
        "#{intcolumn2,jdbcType=INTEGER}, #{strcolumn1,jdbcType=VARCHAR}, ",
        "#{strcolumn2,jdbcType=VARCHAR}, #{htmlvalue,jdbcType=LONGVARCHAR})"
    })
    int insert(BsNewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @InsertProvider(type=BsNewsSqlProvider.class, method="insertSelective")
    int insertSelective(BsNewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @SelectProvider(type=BsNewsSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createUserId", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="createUserName", property="createusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateUserId", property="updateuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="updateUserName", property="updateusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="intColumn1", property="intcolumn1", jdbcType=JdbcType.INTEGER),
        @Result(column="intColumn2", property="intcolumn2", jdbcType=JdbcType.INTEGER),
        @Result(column="strColumn1", property="strcolumn1", jdbcType=JdbcType.VARCHAR),
        @Result(column="strColumn2", property="strcolumn2", jdbcType=JdbcType.VARCHAR),
        @Result(column="htmlValue", property="htmlvalue", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<BsNewsWithBLOBs> selectByExampleWithBLOBs(BsNewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @SelectProvider(type=BsNewsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createUserId", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="createUserName", property="createusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateUserId", property="updateuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="updateUserName", property="updateusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="intColumn1", property="intcolumn1", jdbcType=JdbcType.INTEGER),
        @Result(column="intColumn2", property="intcolumn2", jdbcType=JdbcType.INTEGER),
        @Result(column="strColumn1", property="strcolumn1", jdbcType=JdbcType.VARCHAR),
        @Result(column="strColumn2", property="strcolumn2", jdbcType=JdbcType.VARCHAR)
    })
    List<BsNews> selectByExample(BsNewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @Select({
        "select",
        "ID, title, note, createTime, createUserId, createUserName, updateTime, updateUserId, ",
        "updateUserName, intColumn1, intColumn2, strColumn1, strColumn2, htmlValue",
        "from bs_news",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createUserId", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="createUserName", property="createusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateUserId", property="updateuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="updateUserName", property="updateusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="intColumn1", property="intcolumn1", jdbcType=JdbcType.INTEGER),
        @Result(column="intColumn2", property="intcolumn2", jdbcType=JdbcType.INTEGER),
        @Result(column="strColumn1", property="strcolumn1", jdbcType=JdbcType.VARCHAR),
        @Result(column="strColumn2", property="strcolumn2", jdbcType=JdbcType.VARCHAR),
        @Result(column="htmlValue", property="htmlvalue", jdbcType=JdbcType.LONGVARCHAR)
    })
    BsNewsWithBLOBs selectByPrimaryKey(BsNewsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @UpdateProvider(type=BsNewsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BsNewsWithBLOBs record, @Param("example") BsNewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @UpdateProvider(type=BsNewsSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") BsNewsWithBLOBs record, @Param("example") BsNewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @UpdateProvider(type=BsNewsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BsNews record, @Param("example") BsNewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @UpdateProvider(type=BsNewsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BsNewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @Update({
        "update bs_news",
        "set title = #{title,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "createUserId = #{createuserid,jdbcType=INTEGER},",
          "createUserName = #{createusername,jdbcType=VARCHAR},",
          "updateTime = #{updatetime,jdbcType=TIMESTAMP},",
          "updateUserId = #{updateuserid,jdbcType=INTEGER},",
          "updateUserName = #{updateusername,jdbcType=VARCHAR},",
          "intColumn1 = #{intcolumn1,jdbcType=INTEGER},",
          "intColumn2 = #{intcolumn2,jdbcType=INTEGER},",
          "strColumn1 = #{strcolumn1,jdbcType=VARCHAR},",
          "strColumn2 = #{strcolumn2,jdbcType=VARCHAR},",
          "htmlValue = #{htmlvalue,jdbcType=LONGVARCHAR}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(BsNewsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    @Update({
        "update bs_news",
        "set title = #{title,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "createUserId = #{createuserid,jdbcType=INTEGER},",
          "createUserName = #{createusername,jdbcType=VARCHAR},",
          "updateTime = #{updatetime,jdbcType=TIMESTAMP},",
          "updateUserId = #{updateuserid,jdbcType=INTEGER},",
          "updateUserName = #{updateusername,jdbcType=VARCHAR},",
          "intColumn1 = #{intcolumn1,jdbcType=INTEGER},",
          "intColumn2 = #{intcolumn2,jdbcType=INTEGER},",
          "strColumn1 = #{strcolumn1,jdbcType=VARCHAR},",
          "strColumn2 = #{strcolumn2,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BsNews record);
}