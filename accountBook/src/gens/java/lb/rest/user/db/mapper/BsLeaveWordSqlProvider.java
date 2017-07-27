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
import lb.rest.user.db.entity.BsLeaveWord;
import lb.rest.user.db.entity.BsLeaveWordExample.Criteria;
import lb.rest.user.db.entity.BsLeaveWordExample.Criterion;
import lb.rest.user.db.entity.BsLeaveWordExample;

public class BsLeaveWordSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_leave_word
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String countByExample(BsLeaveWordExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("bs_leave_word");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_leave_word
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String deleteByExample(BsLeaveWordExample example) {
        BEGIN();
        DELETE_FROM("bs_leave_word");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_leave_word
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String insertSelective(BsLeaveWord record) {
        BEGIN();
        INSERT_INTO("bs_leave_word");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectUserId() != null) {
            VALUES("subject_user_id", "#{subjectUserId,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectUserName() != null) {
            VALUES("subject_user_name", "#{subjectUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getObjectUserId() != null) {
            VALUES("object_user_id", "#{objectUserId,jdbcType=INTEGER}");
        }
        
        if (record.getObjectUserName() != null) {
            VALUES("object_user_name", "#{objectUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getViewTime() != null) {
            VALUES("view_time", "#{viewTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHasRead() != null) {
            VALUES("has_read", "#{hasRead,jdbcType=INTEGER}");
        }
        
        if (record.getReplyMsg() != null) {
            VALUES("reply_msg", "#{replyMsg,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table bs_leave_word
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String selectByExample(BsLeaveWordExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("subject_user_id");
        SELECT("subject_user_name");
        SELECT("object_user_id");
        SELECT("object_user_name");
        SELECT("create_time");
        SELECT("content");
        SELECT("remark");
        SELECT("view_time");
        SELECT("has_read");
        SELECT("reply_msg");
        SELECT("int_column1");
        SELECT("int_column2");
        SELECT("str_column1");
        SELECT("str_column2");
        FROM("bs_leave_word");
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
     * This method corresponds to the database table bs_leave_word
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        BsLeaveWord record = (BsLeaveWord) parameter.get("record");
        BsLeaveWordExample example = (BsLeaveWordExample) parameter.get("example");
        
        BEGIN();
        UPDATE("bs_leave_word");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectUserId() != null) {
            SET("subject_user_id = #{record.subjectUserId,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectUserName() != null) {
            SET("subject_user_name = #{record.subjectUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getObjectUserId() != null) {
            SET("object_user_id = #{record.objectUserId,jdbcType=INTEGER}");
        }
        
        if (record.getObjectUserName() != null) {
            SET("object_user_name = #{record.objectUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getViewTime() != null) {
            SET("view_time = #{record.viewTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHasRead() != null) {
            SET("has_read = #{record.hasRead,jdbcType=INTEGER}");
        }
        
        if (record.getReplyMsg() != null) {
            SET("reply_msg = #{record.replyMsg,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table bs_leave_word
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("bs_leave_word");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("subject_user_id = #{record.subjectUserId,jdbcType=INTEGER}");
        SET("subject_user_name = #{record.subjectUserName,jdbcType=VARCHAR}");
        SET("object_user_id = #{record.objectUserId,jdbcType=INTEGER}");
        SET("object_user_name = #{record.objectUserName,jdbcType=VARCHAR}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("content = #{record.content,jdbcType=VARCHAR}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("view_time = #{record.viewTime,jdbcType=TIMESTAMP}");
        SET("has_read = #{record.hasRead,jdbcType=INTEGER}");
        SET("reply_msg = #{record.replyMsg,jdbcType=VARCHAR}");
        SET("int_column1 = #{record.intColumn1,jdbcType=INTEGER}");
        SET("int_column2 = #{record.intColumn2,jdbcType=INTEGER}");
        SET("str_column1 = #{record.strColumn1,jdbcType=VARCHAR}");
        SET("str_column2 = #{record.strColumn2,jdbcType=VARCHAR}");
        
        BsLeaveWordExample example = (BsLeaveWordExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_leave_word
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    public String updateByPrimaryKeySelective(BsLeaveWord record) {
        BEGIN();
        UPDATE("bs_leave_word");
        
        if (record.getSubjectUserId() != null) {
            SET("subject_user_id = #{subjectUserId,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectUserName() != null) {
            SET("subject_user_name = #{subjectUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getObjectUserId() != null) {
            SET("object_user_id = #{objectUserId,jdbcType=INTEGER}");
        }
        
        if (record.getObjectUserName() != null) {
            SET("object_user_name = #{objectUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getViewTime() != null) {
            SET("view_time = #{viewTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getHasRead() != null) {
            SET("has_read = #{hasRead,jdbcType=INTEGER}");
        }
        
        if (record.getReplyMsg() != null) {
            SET("reply_msg = #{replyMsg,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table bs_leave_word
     *
     * @mbggenerated Thu Jun 01 10:59:28 CST 2017
     */
    protected void applyWhere(BsLeaveWordExample example, boolean includeExamplePhrase) {
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