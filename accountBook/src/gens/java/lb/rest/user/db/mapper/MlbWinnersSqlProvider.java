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
import lb.rest.user.db.entity.MlbWinners;
import lb.rest.user.db.entity.MlbWinnersExample.Criteria;
import lb.rest.user.db.entity.MlbWinnersExample.Criterion;
import lb.rest.user.db.entity.MlbWinnersExample;

public class MlbWinnersSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_winners
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String countByExample(MlbWinnersExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("mlb_winners");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_winners
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String deleteByExample(MlbWinnersExample example) {
        BEGIN();
        DELETE_FROM("mlb_winners");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_winners
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String insertSelective(MlbWinners record) {
        BEGIN();
        INSERT_INTO("mlb_winners");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getMlbuserid() != null) {
            VALUES("mlbUserId", "#{mlbuserid,jdbcType=INTEGER}");
        }
        
        if (record.getMlbusername() != null) {
            VALUES("mlbUserName", "#{mlbusername,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getWinnersTime() != null) {
            VALUES("winners_time", "#{winnersTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getIsget() != null) {
            VALUES("isGet", "#{isget,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_winners
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String selectByExample(MlbWinnersExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("mlbUserId");
        SELECT("mlbUserName");
        SELECT("status");
        SELECT("winners_time");
        SELECT("remark");
        SELECT("isGet");
        FROM("mlb_winners");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        if(example != null){
            return SQL().concat(" limit "+example.getOffset()+","+example.getLimit());
        }
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_winners
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        MlbWinners record = (MlbWinners) parameter.get("record");
        MlbWinnersExample example = (MlbWinnersExample) parameter.get("example");
        
        BEGIN();
        UPDATE("mlb_winners");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getMlbuserid() != null) {
            SET("mlbUserId = #{record.mlbuserid,jdbcType=INTEGER}");
        }
        
        if (record.getMlbusername() != null) {
            SET("mlbUserName = #{record.mlbusername,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getWinnersTime() != null) {
            SET("winners_time = #{record.winnersTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getIsget() != null) {
            SET("isGet = #{record.isget,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_winners
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("mlb_winners");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("mlbUserId = #{record.mlbuserid,jdbcType=INTEGER}");
        SET("mlbUserName = #{record.mlbusername,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("winners_time = #{record.winnersTime,jdbcType=TIMESTAMP}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("isGet = #{record.isget,jdbcType=INTEGER}");
        
        MlbWinnersExample example = (MlbWinnersExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_winners
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String updateByPrimaryKeySelective(MlbWinners record) {
        BEGIN();
        UPDATE("mlb_winners");
        
        if (record.getMlbuserid() != null) {
            SET("mlbUserId = #{mlbuserid,jdbcType=INTEGER}");
        }
        
        if (record.getMlbusername() != null) {
            SET("mlbUserName = #{mlbusername,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getWinnersTime() != null) {
            SET("winners_time = #{winnersTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getIsget() != null) {
            SET("isGet = #{isget,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlb_winners
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    protected void applyWhere(MlbWinnersExample example, boolean includeExamplePhrase) {
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