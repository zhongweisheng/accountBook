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
import lb.rest.user.db.entity.BsUserComment;
import lb.rest.user.db.entity.BsUserCommentExample.Criteria;
import lb.rest.user.db.entity.BsUserCommentExample.Criterion;
import lb.rest.user.db.entity.BsUserCommentExample;

public class BsUserCommentSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_comment
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String countByExample(BsUserCommentExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("bs_user_comment");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_comment
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String deleteByExample(BsUserCommentExample example) {
        BEGIN();
        DELETE_FROM("bs_user_comment");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_comment
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String insertSelective(BsUserComment record) {
        BEGIN();
        INSERT_INTO("bs_user_comment");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getCommentTime() != null) {
            VALUES("comment_time", "#{commentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommentatorId() != null) {
            VALUES("commentator_id", "#{commentatorId,jdbcType=INTEGER}");
        }
        
        if (record.getCommentatorName() != null) {
            VALUES("commentator_name", "#{commentatorName,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentLevel() != null) {
            VALUES("comment_level", "#{commentLevel,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getFromType() != null) {
            VALUES("from_type", "#{fromType,jdbcType=INTEGER}");
        }
        
        if (record.getHasRead() != null) {
            VALUES("has_read", "#{hasRead,jdbcType=INTEGER}");
        }
        
        if (record.getIntColumn1() != null) {
            VALUES("int_column1", "#{intColumn1,jdbcType=INTEGER}");
        }
        
        if (record.getIntColumn2() != null) {
            VALUES("int_column2", "#{intColumn2,jdbcType=INTEGER}");
        }
        
        if (record.getStrColumn1() != null) {
            VALUES("str_column1", "#{strColumn1,jdbcType=VARCHAR}");
        }
        
        if (record.getStrColumn2() != null) {
            VALUES("str_column2", "#{strColumn2,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_comment
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String selectByExample(BsUserCommentExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("user_id");
        SELECT("comment_time");
        SELECT("commentator_id");
        SELECT("commentator_name");
        SELECT("comment_level");
        SELECT("content");
        SELECT("remark");
        SELECT("from_type");
        SELECT("has_read");
        SELECT("int_column1");
        SELECT("int_column2");
        SELECT("str_column1");
        SELECT("str_column2");
        FROM("bs_user_comment");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        if (example !=null && example.getLimit() > 0 ) { 
        
        	return SQL() + " limit #{offset,jdbcType=INTEGER} , #{limit,jdbcType=INTEGER}";
        	} 
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_comment
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        BsUserComment record = (BsUserComment) parameter.get("record");
        BsUserCommentExample example = (BsUserCommentExample) parameter.get("example");
        
        BEGIN();
        UPDATE("bs_user_comment");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getCommentTime() != null) {
            SET("comment_time = #{record.commentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommentatorId() != null) {
            SET("commentator_id = #{record.commentatorId,jdbcType=INTEGER}");
        }
        
        if (record.getCommentatorName() != null) {
            SET("commentator_name = #{record.commentatorName,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentLevel() != null) {
            SET("comment_level = #{record.commentLevel,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getFromType() != null) {
            SET("from_type = #{record.fromType,jdbcType=INTEGER}");
        }
        
        if (record.getHasRead() != null) {
            SET("has_read = #{record.hasRead,jdbcType=INTEGER}");
        }
        
        if (record.getIntColumn1() != null) {
            SET("int_column1 = #{record.intColumn1,jdbcType=INTEGER}");
        }
        
        if (record.getIntColumn2() != null) {
            SET("int_column2 = #{record.intColumn2,jdbcType=INTEGER}");
        }
        
        if (record.getStrColumn1() != null) {
            SET("str_column1 = #{record.strColumn1,jdbcType=VARCHAR}");
        }
        
        if (record.getStrColumn2() != null) {
            SET("str_column2 = #{record.strColumn2,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_comment
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("bs_user_comment");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("user_id = #{record.userId,jdbcType=INTEGER}");
        SET("comment_time = #{record.commentTime,jdbcType=TIMESTAMP}");
        SET("commentator_id = #{record.commentatorId,jdbcType=INTEGER}");
        SET("commentator_name = #{record.commentatorName,jdbcType=VARCHAR}");
        SET("comment_level = #{record.commentLevel,jdbcType=INTEGER}");
        SET("content = #{record.content,jdbcType=VARCHAR}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("from_type = #{record.fromType,jdbcType=INTEGER}");
        SET("has_read = #{record.hasRead,jdbcType=INTEGER}");
        SET("int_column1 = #{record.intColumn1,jdbcType=INTEGER}");
        SET("int_column2 = #{record.intColumn2,jdbcType=INTEGER}");
        SET("str_column1 = #{record.strColumn1,jdbcType=VARCHAR}");
        SET("str_column2 = #{record.strColumn2,jdbcType=VARCHAR}");
        
        BsUserCommentExample example = (BsUserCommentExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_comment
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String updateByPrimaryKeySelective(BsUserComment record) {
        BEGIN();
        UPDATE("bs_user_comment");
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getCommentTime() != null) {
            SET("comment_time = #{commentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCommentatorId() != null) {
            SET("commentator_id = #{commentatorId,jdbcType=INTEGER}");
        }
        
        if (record.getCommentatorName() != null) {
            SET("commentator_name = #{commentatorName,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentLevel() != null) {
            SET("comment_level = #{commentLevel,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getFromType() != null) {
            SET("from_type = #{fromType,jdbcType=INTEGER}");
        }
        
        if (record.getHasRead() != null) {
            SET("has_read = #{hasRead,jdbcType=INTEGER}");
        }
        
        if (record.getIntColumn1() != null) {
            SET("int_column1 = #{intColumn1,jdbcType=INTEGER}");
        }
        
        if (record.getIntColumn2() != null) {
            SET("int_column2 = #{intColumn2,jdbcType=INTEGER}");
        }
        
        if (record.getStrColumn1() != null) {
            SET("str_column1 = #{strColumn1,jdbcType=VARCHAR}");
        }
        
        if (record.getStrColumn2() != null) {
            SET("str_column2 = #{strColumn2,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_comment
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    protected void applyWhere(BsUserCommentExample example, boolean includeExamplePhrase) {
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
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
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