package lb.rest.user.db.mapper;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;
import java.util.List;
import lb.rest.user.db.entity.Renzfeedback;
import lb.rest.user.db.entity.RenzfeedbackExample;
import lb.rest.user.db.entity.RenzfeedbackKey;
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

public interface RenzfeedbackMapper extends StaticTableDaoSupport<Renzfeedback, RenzfeedbackExample, RenzfeedbackKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table renzfeedback
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @SelectProvider(type=RenzfeedbackSqlProvider.class, method="countByExample")
    int countByExample(RenzfeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table renzfeedback
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @DeleteProvider(type=RenzfeedbackSqlProvider.class, method="deleteByExample")
    int deleteByExample(RenzfeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table renzfeedback
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Delete({
        "delete from renzfeedback",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(RenzfeedbackKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table renzfeedback
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Insert({
        "insert into renzfeedback (id, createUserid, ",
        "createUserName, createTime, ",
        "mlbUserid, mlbUserName, ",
        "note)",
        "values (#{id,jdbcType=INTEGER}, #{createuserid,jdbcType=INTEGER}, ",
        "#{createusername,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{mlbuserid,jdbcType=INTEGER}, #{mlbusername,jdbcType=VARCHAR}, ",
        "#{note,jdbcType=VARCHAR})"
    })
    int insert(Renzfeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table renzfeedback
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @InsertProvider(type=RenzfeedbackSqlProvider.class, method="insertSelective")
    int insertSelective(Renzfeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table renzfeedback
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @SelectProvider(type=RenzfeedbackSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="createUserid", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="createUserName", property="createusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mlbUserid", property="mlbuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="mlbUserName", property="mlbusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<Renzfeedback> selectByExample(RenzfeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table renzfeedback
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Select({
        "select",
        "id, createUserid, createUserName, createTime, mlbUserid, mlbUserName, note",
        "from renzfeedback",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="createUserid", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="createUserName", property="createusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mlbUserid", property="mlbuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="mlbUserName", property="mlbusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    Renzfeedback selectByPrimaryKey(RenzfeedbackKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table renzfeedback
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @UpdateProvider(type=RenzfeedbackSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Renzfeedback record, @Param("example") RenzfeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table renzfeedback
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @UpdateProvider(type=RenzfeedbackSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Renzfeedback record, @Param("example") RenzfeedbackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table renzfeedback
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @UpdateProvider(type=RenzfeedbackSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Renzfeedback record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table renzfeedback
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Update({
        "update renzfeedback",
        "set createUserid = #{createuserid,jdbcType=INTEGER},",
          "createUserName = #{createusername,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "mlbUserid = #{mlbuserid,jdbcType=INTEGER},",
          "mlbUserName = #{mlbusername,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Renzfeedback record);
}