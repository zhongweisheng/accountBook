package lb.rest.user.db.mapper;

import fc.wpf.rest.db.iface.StaticTableDaoSupport;
import java.util.List;
import lb.rest.user.db.entity.Blacklist;
import lb.rest.user.db.entity.BlacklistExample;
import lb.rest.user.db.entity.BlacklistKey;
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

public interface BlacklistMapper extends StaticTableDaoSupport<Blacklist, BlacklistExample, BlacklistKey> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blacklist
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @SelectProvider(type=BlacklistSqlProvider.class, method="countByExample")
    int countByExample(BlacklistExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blacklist
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @DeleteProvider(type=BlacklistSqlProvider.class, method="deleteByExample")
    int deleteByExample(BlacklistExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blacklist
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Delete({
        "delete from blacklist",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(BlacklistKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blacklist
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Insert({
        "insert into blacklist (id, phone, ",
        "name, createTime, ",
        "updateTime, state, ",
        "num, createUserId, ",
        "createUserName, updateUserId, ",
        "updateUserName, mlbuserBoId, ",
        "remarks, source, ",
        "ownedCompany, corporateName, ",
        "location, address, ",
        "locationDesc, trader_name)",
        "values (#{id,jdbcType=INTEGER}, #{phone,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{updatetime,jdbcType=TIMESTAMP}, #{state,jdbcType=INTEGER}, ",
        "#{num,jdbcType=INTEGER}, #{createuserid,jdbcType=INTEGER}, ",
        "#{createusername,jdbcType=VARCHAR}, #{updateuserid,jdbcType=INTEGER}, ",
        "#{updateusername,jdbcType=VARCHAR}, #{mlbuserboid,jdbcType=INTEGER}, ",
        "#{remarks,jdbcType=VARCHAR}, #{source,jdbcType=INTEGER}, ",
        "#{ownedcompany,jdbcType=VARCHAR}, #{corporatename,jdbcType=VARCHAR}, ",
        "#{location,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{locationdesc,jdbcType=VARCHAR}, #{traderName,jdbcType=VARCHAR})"
    })
    int insert(Blacklist record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blacklist
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @InsertProvider(type=BlacklistSqlProvider.class, method="insertSelective")
    int insertSelective(Blacklist record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blacklist
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @SelectProvider(type=BlacklistSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="createUserId", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="createUserName", property="createusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateUserId", property="updateuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="updateUserName", property="updateusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="mlbuserBoId", property="mlbuserboid", jdbcType=JdbcType.INTEGER),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="source", property="source", jdbcType=JdbcType.INTEGER),
        @Result(column="ownedCompany", property="ownedcompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="corporateName", property="corporatename", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="locationDesc", property="locationdesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="trader_name", property="traderName", jdbcType=JdbcType.VARCHAR)
    })
    List<Blacklist> selectByExample(BlacklistExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blacklist
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Select({
        "select",
        "id, phone, name, createTime, updateTime, state, num, createUserId, createUserName, ",
        "updateUserId, updateUserName, mlbuserBoId, remarks, source, ownedCompany, corporateName, ",
        "location, address, locationDesc, trader_name",
        "from blacklist",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="createUserId", property="createuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="createUserName", property="createusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateUserId", property="updateuserid", jdbcType=JdbcType.INTEGER),
        @Result(column="updateUserName", property="updateusername", jdbcType=JdbcType.VARCHAR),
        @Result(column="mlbuserBoId", property="mlbuserboid", jdbcType=JdbcType.INTEGER),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="source", property="source", jdbcType=JdbcType.INTEGER),
        @Result(column="ownedCompany", property="ownedcompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="corporateName", property="corporatename", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="locationDesc", property="locationdesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="trader_name", property="traderName", jdbcType=JdbcType.VARCHAR)
    })
    Blacklist selectByPrimaryKey(BlacklistKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blacklist
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @UpdateProvider(type=BlacklistSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Blacklist record, @Param("example") BlacklistExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blacklist
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @UpdateProvider(type=BlacklistSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Blacklist record, @Param("example") BlacklistExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blacklist
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @UpdateProvider(type=BlacklistSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Blacklist record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blacklist
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    @Update({
        "update blacklist",
        "set phone = #{phone,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "updateTime = #{updatetime,jdbcType=TIMESTAMP},",
          "state = #{state,jdbcType=INTEGER},",
          "num = #{num,jdbcType=INTEGER},",
          "createUserId = #{createuserid,jdbcType=INTEGER},",
          "createUserName = #{createusername,jdbcType=VARCHAR},",
          "updateUserId = #{updateuserid,jdbcType=INTEGER},",
          "updateUserName = #{updateusername,jdbcType=VARCHAR},",
          "mlbuserBoId = #{mlbuserboid,jdbcType=INTEGER},",
          "remarks = #{remarks,jdbcType=VARCHAR},",
          "source = #{source,jdbcType=INTEGER},",
          "ownedCompany = #{ownedcompany,jdbcType=VARCHAR},",
          "corporateName = #{corporatename,jdbcType=VARCHAR},",
          "location = #{location,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "locationDesc = #{locationdesc,jdbcType=VARCHAR},",
          "trader_name = #{traderName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Blacklist record);
}