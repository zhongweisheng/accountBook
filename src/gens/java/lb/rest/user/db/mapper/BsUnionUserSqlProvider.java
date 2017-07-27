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
import lb.rest.user.db.entity.BsUnionUser;
import lb.rest.user.db.entity.BsUnionUserExample.Criteria;
import lb.rest.user.db.entity.BsUnionUserExample.Criterion;
import lb.rest.user.db.entity.BsUnionUserExample;

public class BsUnionUserSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    public String countByExample(BsUnionUserExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("bs_union_user");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    public String deleteByExample(BsUnionUserExample example) {
        BEGIN();
        DELETE_FROM("bs_union_user");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    public String insertSelective(BsUnionUser record) {
        BEGIN();
        INSERT_INTO("bs_union_user");
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMlbUserId() != null) {
            VALUES("mlb_user_id", "#{mlbUserId,jdbcType=INTEGER}");
        }
        
        if (record.getLzbUserId() != null) {
            VALUES("lzb_user_id", "#{lzbUserId,jdbcType=INTEGER}");
        }
        
        if (record.getTrueName() != null) {
            VALUES("true_name", "#{trueName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginName() != null) {
            VALUES("login_name", "#{loginName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassWord() != null) {
            VALUES("pass_word", "#{passWord,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenId() != null) {
            VALUES("open_id", "#{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    public String selectByExample(BsUnionUserExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("user_id");
        } else {
            SELECT("user_id");
        }
        SELECT("phone");
        SELECT("mlb_user_id");
        SELECT("lzb_user_id");
        SELECT("true_name");
        SELECT("login_name");
        SELECT("pass_word");
        SELECT("open_id");
        SELECT("create_time");
        FROM("bs_union_user");
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
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        BsUnionUser record = (BsUnionUser) parameter.get("record");
        BsUnionUserExample example = (BsUnionUserExample) parameter.get("example");
        
        BEGIN();
        UPDATE("bs_union_user");
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMlbUserId() != null) {
            SET("mlb_user_id = #{record.mlbUserId,jdbcType=INTEGER}");
        }
        
        if (record.getLzbUserId() != null) {
            SET("lzb_user_id = #{record.lzbUserId,jdbcType=INTEGER}");
        }
        
        if (record.getTrueName() != null) {
            SET("true_name = #{record.trueName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginName() != null) {
            SET("login_name = #{record.loginName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassWord() != null) {
            SET("pass_word = #{record.passWord,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenId() != null) {
            SET("open_id = #{record.openId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("bs_union_user");
        
        SET("user_id = #{record.userId,jdbcType=INTEGER}");
        SET("phone = #{record.phone,jdbcType=VARCHAR}");
        SET("mlb_user_id = #{record.mlbUserId,jdbcType=INTEGER}");
        SET("lzb_user_id = #{record.lzbUserId,jdbcType=INTEGER}");
        SET("true_name = #{record.trueName,jdbcType=VARCHAR}");
        SET("login_name = #{record.loginName,jdbcType=VARCHAR}");
        SET("pass_word = #{record.passWord,jdbcType=VARCHAR}");
        SET("open_id = #{record.openId,jdbcType=VARCHAR}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        BsUnionUserExample example = (BsUnionUserExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    public String updateByPrimaryKeySelective(BsUnionUser record) {
        BEGIN();
        UPDATE("bs_union_user");
        
        if (record.getMlbUserId() != null) {
            SET("mlb_user_id = #{mlbUserId,jdbcType=INTEGER}");
        }
        
        if (record.getLzbUserId() != null) {
            SET("lzb_user_id = #{lzbUserId,jdbcType=INTEGER}");
        }
        
        if (record.getTrueName() != null) {
            SET("true_name = #{trueName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginName() != null) {
            SET("login_name = #{loginName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassWord() != null) {
            SET("pass_word = #{passWord,jdbcType=VARCHAR}");
        }
        
        if (record.getOpenId() != null) {
            SET("open_id = #{openId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("user_id = #{userId,jdbcType=INTEGER}");
        WHERE("phone = #{phone,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_union_user
     *
     * @mbggenerated Wed Jun 28 13:19:26 CST 2017
     */
    protected void applyWhere(BsUnionUserExample example, boolean includeExamplePhrase) {
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