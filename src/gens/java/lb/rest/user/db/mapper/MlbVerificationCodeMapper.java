package lb.rest.user.db.mapper;

import java.util.List;

import lb.rest.user.db.entity.MlbVerificationCode;
import lb.rest.user.db.entity.MlbVerificationCodeExample;
import lb.rest.user.db.entity.MlbVerificationCodeKey;

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

import fc.wpf.rest.db.iface.StaticTableDaoSupport;

public interface MlbVerificationCodeMapper extends
		StaticTableDaoSupport<MlbVerificationCode, MlbVerificationCodeExample, MlbVerificationCodeKey> {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@SelectProvider(type = MlbVerificationCodeSqlProvider.class, method = "countByExample")
	int countByExample(MlbVerificationCodeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@DeleteProvider(type = MlbVerificationCodeSqlProvider.class, method = "deleteByExample")
	int deleteByExample(MlbVerificationCodeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@Delete({ "delete from mlb_verification_code", "where id = #{id,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(MlbVerificationCodeKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@Insert({ "insert into mlb_verification_code (id, phone, ", "startDate, num, ", "status)",
			"values (#{id,jdbcType=INTEGER}, #{phone,jdbcType=VARCHAR}, ",
			"#{startdate,jdbcType=TIMESTAMP}, #{num,jdbcType=INTEGER}, ", "#{status,jdbcType=INTEGER})" })
	int insert(MlbVerificationCode record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@InsertProvider(type = MlbVerificationCodeSqlProvider.class, method = "insertSelective")
	int insertSelective(MlbVerificationCode record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@SelectProvider(type = MlbVerificationCodeSqlProvider.class, method = "selectByExample")
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "startDate", property = "startdate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "num", property = "num", jdbcType = JdbcType.INTEGER),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER) })
	List<MlbVerificationCode> selectByExample(MlbVerificationCodeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@Select({ "select", "id, phone, startDate, num, status", "from mlb_verification_code",
			"where id = #{id,jdbcType=INTEGER}" })
	@Results({ @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "startDate", property = "startdate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "num", property = "num", jdbcType = JdbcType.INTEGER),
			@Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER) })
	MlbVerificationCode selectByPrimaryKey(MlbVerificationCodeKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@UpdateProvider(type = MlbVerificationCodeSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") MlbVerificationCode record,
			@Param("example") MlbVerificationCodeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@UpdateProvider(type = MlbVerificationCodeSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") MlbVerificationCode record,
			@Param("example") MlbVerificationCodeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@UpdateProvider(type = MlbVerificationCodeSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(MlbVerificationCode record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	@Update({ "update mlb_verification_code", "set phone = #{phone,jdbcType=VARCHAR},",
			"startDate = #{startdate,jdbcType=TIMESTAMP},", "num = #{num,jdbcType=INTEGER},",
			"status = #{status,jdbcType=INTEGER}", "where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(MlbVerificationCode record);
}