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
import lb.rest.user.db.entity.BsNewsExample.Criteria;
import lb.rest.user.db.entity.BsNewsExample.Criterion;
import lb.rest.user.db.entity.BsNewsExample;
import lb.rest.user.db.entity.BsNewsWithBLOBs;

public class BsNewsSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public String countByExample(BsNewsExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("bs_news");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public String deleteByExample(BsNewsExample example) {
        BEGIN();
        DELETE_FROM("bs_news");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public String insertSelective(BsNewsWithBLOBs record) {
        BEGIN();
        INSERT_INTO("bs_news");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            VALUES("note", "#{note,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            VALUES("createTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateuserid() != null) {
            VALUES("createUserId", "#{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getCreateusername() != null) {
            VALUES("createUserName", "#{createusername,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdatetime() != null) {
            VALUES("updateTime", "#{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateuserid() != null) {
            VALUES("updateUserId", "#{updateuserid,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateusername() != null) {
            VALUES("updateUserName", "#{updateusername,jdbcType=VARCHAR}");
        }
        
        if (record.getIntcolumn1() != null) {
            VALUES("intColumn1", "#{intcolumn1,jdbcType=INTEGER}");
        }
        
        if (record.getIntcolumn2() != null) {
            VALUES("intColumn2", "#{intcolumn2,jdbcType=INTEGER}");
        }
        
        if (record.getStrcolumn1() != null) {
            VALUES("strColumn1", "#{strcolumn1,jdbcType=VARCHAR}");
        }
        
        if (record.getStrcolumn2() != null) {
            VALUES("strColumn2", "#{strcolumn2,jdbcType=VARCHAR}");
        }
        
        if (record.getHtmlvalue() != null) {
            VALUES("htmlValue", "#{htmlvalue,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public String selectByExampleWithBLOBs(BsNewsExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("title");
        SELECT("note");
        SELECT("createTime");
        SELECT("createUserId");
        SELECT("createUserName");
        SELECT("updateTime");
        SELECT("updateUserId");
        SELECT("updateUserName");
        SELECT("intColumn1");
        SELECT("intColumn2");
        SELECT("strColumn1");
        SELECT("strColumn2");
        SELECT("htmlValue");
        FROM("bs_news");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        if (example !=null && example.getLimit() > 0)
        
        return SQL() + " limit #{offset,jdbcType=INTEGER} , #{limit,jdbcType=INTEGER}";
        else
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public String selectByExample(BsNewsExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("title");
        SELECT("note");
        SELECT("createTime");
        SELECT("createUserId");
        SELECT("createUserName");
        SELECT("updateTime");
        SELECT("updateUserId");
        SELECT("updateUserName");
        SELECT("intColumn1");
        SELECT("intColumn2");
        SELECT("strColumn1");
        SELECT("strColumn2");
        FROM("bs_news");
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
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        BsNewsWithBLOBs record = (BsNewsWithBLOBs) parameter.get("record");
        BsNewsExample example = (BsNewsExample) parameter.get("example");
        
        BEGIN();
        UPDATE("bs_news");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            SET("note = #{record.note,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{record.createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateuserid() != null) {
            SET("createUserId = #{record.createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getCreateusername() != null) {
            SET("createUserName = #{record.createusername,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdatetime() != null) {
            SET("updateTime = #{record.updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateuserid() != null) {
            SET("updateUserId = #{record.updateuserid,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateusername() != null) {
            SET("updateUserName = #{record.updateusername,jdbcType=VARCHAR}");
        }
        
        if (record.getIntcolumn1() != null) {
            SET("intColumn1 = #{record.intcolumn1,jdbcType=INTEGER}");
        }
        
        if (record.getIntcolumn2() != null) {
            SET("intColumn2 = #{record.intcolumn2,jdbcType=INTEGER}");
        }
        
        if (record.getStrcolumn1() != null) {
            SET("strColumn1 = #{record.strcolumn1,jdbcType=VARCHAR}");
        }
        
        if (record.getStrcolumn2() != null) {
            SET("strColumn2 = #{record.strcolumn2,jdbcType=VARCHAR}");
        }
        
        if (record.getHtmlvalue() != null) {
            SET("htmlValue = #{record.htmlvalue,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("bs_news");
        
        SET("ID = #{record.id,jdbcType=INTEGER}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("note = #{record.note,jdbcType=VARCHAR}");
        SET("createTime = #{record.createtime,jdbcType=TIMESTAMP}");
        SET("createUserId = #{record.createuserid,jdbcType=INTEGER}");
        SET("createUserName = #{record.createusername,jdbcType=VARCHAR}");
        SET("updateTime = #{record.updatetime,jdbcType=TIMESTAMP}");
        SET("updateUserId = #{record.updateuserid,jdbcType=INTEGER}");
        SET("updateUserName = #{record.updateusername,jdbcType=VARCHAR}");
        SET("intColumn1 = #{record.intcolumn1,jdbcType=INTEGER}");
        SET("intColumn2 = #{record.intcolumn2,jdbcType=INTEGER}");
        SET("strColumn1 = #{record.strcolumn1,jdbcType=VARCHAR}");
        SET("strColumn2 = #{record.strcolumn2,jdbcType=VARCHAR}");
        SET("htmlValue = #{record.htmlvalue,jdbcType=LONGVARCHAR}");
        
        BsNewsExample example = (BsNewsExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("bs_news");
        
        SET("ID = #{record.id,jdbcType=INTEGER}");
        SET("title = #{record.title,jdbcType=VARCHAR}");
        SET("note = #{record.note,jdbcType=VARCHAR}");
        SET("createTime = #{record.createtime,jdbcType=TIMESTAMP}");
        SET("createUserId = #{record.createuserid,jdbcType=INTEGER}");
        SET("createUserName = #{record.createusername,jdbcType=VARCHAR}");
        SET("updateTime = #{record.updatetime,jdbcType=TIMESTAMP}");
        SET("updateUserId = #{record.updateuserid,jdbcType=INTEGER}");
        SET("updateUserName = #{record.updateusername,jdbcType=VARCHAR}");
        SET("intColumn1 = #{record.intcolumn1,jdbcType=INTEGER}");
        SET("intColumn2 = #{record.intcolumn2,jdbcType=INTEGER}");
        SET("strColumn1 = #{record.strcolumn1,jdbcType=VARCHAR}");
        SET("strColumn2 = #{record.strcolumn2,jdbcType=VARCHAR}");
        
        BsNewsExample example = (BsNewsExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    public String updateByPrimaryKeySelective(BsNewsWithBLOBs record) {
        BEGIN();
        UPDATE("bs_news");
        
        if (record.getTitle() != null) {
            SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            SET("note = #{note,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            SET("createTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateuserid() != null) {
            SET("createUserId = #{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getCreateusername() != null) {
            SET("createUserName = #{createusername,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdatetime() != null) {
            SET("updateTime = #{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateuserid() != null) {
            SET("updateUserId = #{updateuserid,jdbcType=INTEGER}");
        }
        
        if (record.getUpdateusername() != null) {
            SET("updateUserName = #{updateusername,jdbcType=VARCHAR}");
        }
        
        if (record.getIntcolumn1() != null) {
            SET("intColumn1 = #{intcolumn1,jdbcType=INTEGER}");
        }
        
        if (record.getIntcolumn2() != null) {
            SET("intColumn2 = #{intcolumn2,jdbcType=INTEGER}");
        }
        
        if (record.getStrcolumn1() != null) {
            SET("strColumn1 = #{strcolumn1,jdbcType=VARCHAR}");
        }
        
        if (record.getStrcolumn2() != null) {
            SET("strColumn2 = #{strcolumn2,jdbcType=VARCHAR}");
        }
        
        if (record.getHtmlvalue() != null) {
            SET("htmlValue = #{htmlvalue,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("ID = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_news
     *
     * @mbggenerated Fri Mar 31 14:55:39 CST 2017
     */
    protected void applyWhere(BsNewsExample example, boolean includeExamplePhrase) {
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