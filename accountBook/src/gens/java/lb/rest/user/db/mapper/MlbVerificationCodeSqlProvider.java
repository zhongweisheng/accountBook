package lb.rest.user.db.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;
import java.util.Map;

import lb.rest.user.db.entity.MlbVerificationCode;
import lb.rest.user.db.entity.MlbVerificationCodeExample;
import lb.rest.user.db.entity.MlbVerificationCodeExample.Criteria;
import lb.rest.user.db.entity.MlbVerificationCodeExample.Criterion;

public class MlbVerificationCodeSqlProvider {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public String countByExample(MlbVerificationCodeExample example) {
		BEGIN();
		SELECT("count(*)");
		FROM("mlb_verification_code");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public String deleteByExample(MlbVerificationCodeExample example) {
		BEGIN();
		DELETE_FROM("mlb_verification_code");
		applyWhere(example, false);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public String insertSelective(MlbVerificationCode record) {
		BEGIN();
		INSERT_INTO("mlb_verification_code");

		if (record.getId() != null) {
			VALUES("id", "#{id,jdbcType=INTEGER}");
		}

		if (record.getPhone() != null) {
			VALUES("phone", "#{phone,jdbcType=VARCHAR}");
		}

		if (record.getStartdate() != null) {
			VALUES("startDate", "#{startdate,jdbcType=TIMESTAMP}");
		}

		if (record.getNum() != null) {
			VALUES("num", "#{num,jdbcType=INTEGER}");
		}

		if (record.getStatus() != null) {
			VALUES("status", "#{status,jdbcType=INTEGER}");
		}

		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public String selectByExample(MlbVerificationCodeExample example) {
		BEGIN();
		if (example != null && example.isDistinct()) {
			SELECT_DISTINCT("id");
		} else {
			SELECT("id");
		}
		SELECT("phone");
		SELECT("startDate");
		SELECT("num");
		SELECT("status");
		FROM("mlb_verification_code");
		applyWhere(example, false);

		if (example != null && example.getOrderByClause() != null) {
			ORDER_BY(example.getOrderByClause());
		}

		if (example != null) {
			return SQL().concat(" limit " + example.getOffset() + "," + example.getLimit());
		}
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public String updateByExampleSelective(Map<String, Object> parameter) {
		MlbVerificationCode record = (MlbVerificationCode) parameter.get("record");
		MlbVerificationCodeExample example = (MlbVerificationCodeExample) parameter.get("example");

		BEGIN();
		UPDATE("mlb_verification_code");

		if (record.getId() != null) {
			SET("id = #{record.id,jdbcType=INTEGER}");
		}

		if (record.getPhone() != null) {
			SET("phone = #{record.phone,jdbcType=VARCHAR}");
		}

		if (record.getStartdate() != null) {
			SET("startDate = #{record.startdate,jdbcType=TIMESTAMP}");
		}

		if (record.getNum() != null) {
			SET("num = #{record.num,jdbcType=INTEGER}");
		}

		if (record.getStatus() != null) {
			SET("status = #{record.status,jdbcType=INTEGER}");
		}

		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public String updateByExample(Map<String, Object> parameter) {
		BEGIN();
		UPDATE("mlb_verification_code");

		SET("id = #{record.id,jdbcType=INTEGER}");
		SET("phone = #{record.phone,jdbcType=VARCHAR}");
		SET("startDate = #{record.startdate,jdbcType=TIMESTAMP}");
		SET("num = #{record.num,jdbcType=INTEGER}");
		SET("status = #{record.status,jdbcType=INTEGER}");

		MlbVerificationCodeExample example = (MlbVerificationCodeExample) parameter.get("example");
		applyWhere(example, true);
		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	public String updateByPrimaryKeySelective(MlbVerificationCode record) {
		BEGIN();
		UPDATE("mlb_verification_code");

		if (record.getPhone() != null) {
			SET("phone = #{phone,jdbcType=VARCHAR}");
		}

		if (record.getStartdate() != null) {
			SET("startDate = #{startdate,jdbcType=TIMESTAMP}");
		}

		if (record.getNum() != null) {
			SET("num = #{num,jdbcType=INTEGER}");
		}

		if (record.getStatus() != null) {
			SET("status = #{status,jdbcType=INTEGER}");
		}

		WHERE("id = #{id,jdbcType=INTEGER}");

		return SQL();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table mlb_verification_code
	 *
	 * @mbggenerated Tue Feb 28 11:10:30 CST 2017
	 */
	protected void applyWhere(MlbVerificationCodeExample example, boolean includeExamplePhrase) {
		if (example == null) {
			return;
		}

		String parmPhrase1;
		String parmPhrase1_th;
		String parmPhrase2;
		String parmPhrase2_th;
		String parmPhrase3;
		String parmPhrase3_th;
		if (includeExamplePhrase) {
			parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
			parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
			parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
			parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
			parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
			parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
		} else {
			parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
			parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
			parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
			parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
			parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
			parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
		}

		StringBuilder sb = new StringBuilder();
		List<Criteria> oredCriteria = example.getOredCriteria();
		boolean firstCriteria = true;
		for (int i = 0; i < oredCriteria.size(); i++) {
			Criteria criteria = oredCriteria.get(i);
			if (criteria.isValid()) {
				if (firstCriteria) {
					firstCriteria = false;
				} else {
					sb.append(" or ");
				}

				sb.append('(');
				List<Criterion> criterions = criteria.getAllCriteria();
				boolean firstCriterion = true;
				for (int j = 0; j < criterions.size(); j++) {
					Criterion criterion = criterions.get(j);
					if (firstCriterion) {
						firstCriterion = false;
					} else {
						sb.append(" and ");
					}

					if (criterion.isNoValue()) {
						sb.append(criterion.getCondition());
					} else if (criterion.isSingleValue()) {
						if (criterion.getTypeHandler() == null) {
							sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
						} else {
							sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,
									criterion.getTypeHandler()));
						}
					} else if (criterion.isBetweenValue()) {
						if (criterion.getTypeHandler() == null) {
							sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
						} else {
							sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j,
									criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
						}
					} else if (criterion.isListValue()) {
						sb.append(criterion.getCondition());
						sb.append(" (");
						List<?> listItems = (List<?>) criterion.getValue();
						boolean comma = false;
						for (int k = 0; k < listItems.size(); k++) {
							if (comma) {
								sb.append(", ");
							} else {
								comma = true;
							}
							if (criterion.getTypeHandler() == null) {
								sb.append(String.format(parmPhrase3, i, j, k));
							} else {
								sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
							}
						}
						sb.append(')');
					}
				}
				sb.append(')');
			}
		}

		if (sb.length() > 0) {
			WHERE(sb.toString());
		}
	}
}