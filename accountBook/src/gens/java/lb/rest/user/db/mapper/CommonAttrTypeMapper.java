package lb.rest.user.db.mapper;

import java.util.List;

import lb.rest.user.db.entity.CommonAttrType;
import lb.rest.user.db.entity.CommonAttrTypeExample;
import lb.rest.user.db.entity.CommonAttrTypeKey;

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

public interface CommonAttrTypeMapper extends
		StaticTableDaoSupport<CommonAttrType, CommonAttrTypeExample, CommonAttrTypeKey> {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr_type
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@SelectProvider(type = CommonAttrTypeSqlProvider.class, method = "countByExample")
	int countByExample(CommonAttrTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr_type
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@DeleteProvider(type = CommonAttrTypeSqlProvider.class, method = "deleteByExample")
	int deleteByExample(CommonAttrTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr_type
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@Delete({ "delete from common_attr_type", "where typeId = #{typeid,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(CommonAttrTypeKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr_type
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@Insert({ "insert into common_attr_type (typeId, typeName, ", "isAvailable, createTime, ", "isTag, tagCategory)",
			"values (#{typeid,jdbcType=INTEGER}, #{typename,jdbcType=VARCHAR}, ",
			"#{isavailable,jdbcType=INTEGER}, #{createtime,jdbcType=VARCHAR}, ",
			"#{istag,jdbcType=INTEGER}, #{tagcategory,jdbcType=INTEGER})" })
	int insert(CommonAttrType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr_type
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@InsertProvider(type = CommonAttrTypeSqlProvider.class, method = "insertSelective")
	int insertSelective(CommonAttrType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr_type
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@SelectProvider(type = CommonAttrTypeSqlProvider.class, method = "selectByExample")
	@Results({ @Result(column = "typeId", property = "typeid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "typeName", property = "typename", jdbcType = JdbcType.VARCHAR),
			@Result(column = "isAvailable", property = "isavailable", jdbcType = JdbcType.INTEGER),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "isTag", property = "istag", jdbcType = JdbcType.INTEGER),
			@Result(column = "tagCategory", property = "tagcategory", jdbcType = JdbcType.INTEGER) })
	List<CommonAttrType> selectByExample(CommonAttrTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr_type
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@Select({ "select", "typeId, typeName, isAvailable, createTime, isTag, tagCategory", "from common_attr_type",
			"where typeId = #{typeid,jdbcType=INTEGER}" })
	@Results({ @Result(column = "typeId", property = "typeid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "typeName", property = "typename", jdbcType = JdbcType.VARCHAR),
			@Result(column = "isAvailable", property = "isavailable", jdbcType = JdbcType.INTEGER),
			@Result(column = "createTime", property = "createtime", jdbcType = JdbcType.VARCHAR),
			@Result(column = "isTag", property = "istag", jdbcType = JdbcType.INTEGER),
			@Result(column = "tagCategory", property = "tagcategory", jdbcType = JdbcType.INTEGER) })
	CommonAttrType selectByPrimaryKey(CommonAttrTypeKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr_type
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@UpdateProvider(type = CommonAttrTypeSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") CommonAttrType record, @Param("example") CommonAttrTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr_type
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@UpdateProvider(type = CommonAttrTypeSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") CommonAttrType record, @Param("example") CommonAttrTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr_type
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@UpdateProvider(type = CommonAttrTypeSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(CommonAttrType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table common_attr_type
	 *
	 * @mbggenerated Thu Feb 16 17:53:28 CST 2017
	 */
	@Update({ "update common_attr_type", "set typeName = #{typename,jdbcType=VARCHAR},",
			"isAvailable = #{isavailable,jdbcType=INTEGER},", "createTime = #{createtime,jdbcType=VARCHAR},",
			"isTag = #{istag,jdbcType=INTEGER},", "tagCategory = #{tagcategory,jdbcType=INTEGER}",
			"where typeId = #{typeid,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CommonAttrType record);
}