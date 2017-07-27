package lb.rest.user.db.mapper;

import java.util.List;
import lb.rest.user.db.entity.BsNumber;
import lb.rest.user.db.entity.BsNumberExample;
import lb.rest.user.db.entity.BsNumberKey;
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

public interface BsNumberMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @SelectProvider(type=BsNumberSqlProvider.class, method="countByExample")
    int countByExample(BsNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @DeleteProvider(type=BsNumberSqlProvider.class, method="deleteByExample")
    int deleteByExample(BsNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @Delete({
        "delete from bs_number",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(BsNumberKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @Insert({
        "insert into bs_number (ID, name, ",
        "phone, strtime, ",
        "endtime, number, ",
        "status)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{strtime,jdbcType=TIMESTAMP}, ",
        "#{endtime,jdbcType=TIMESTAMP}, #{number,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER})"
    })
    int insert(BsNumber record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @InsertProvider(type=BsNumberSqlProvider.class, method="insertSelective")
    int insertSelective(BsNumber record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @SelectProvider(type=BsNumberSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="strtime", property="strtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endtime", property="endtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    List<BsNumber> selectByExample(BsNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @Select({
        "select",
        "ID, name, phone, strtime, endtime, number, status",
        "from bs_number",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="strtime", property="strtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endtime", property="endtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    BsNumber selectByPrimaryKey(BsNumberKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @UpdateProvider(type=BsNumberSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BsNumber record, @Param("example") BsNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @UpdateProvider(type=BsNumberSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BsNumber record, @Param("example") BsNumberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @UpdateProvider(type=BsNumberSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BsNumber record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_number
     *
     * @mbggenerated Wed May 03 09:58:14 CST 2017
     */
    @Update({
        "update bs_number",
        "set name = #{name,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "strtime = #{strtime,jdbcType=TIMESTAMP},",
          "endtime = #{endtime,jdbcType=TIMESTAMP},",
          "number = #{number,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BsNumber record);
}