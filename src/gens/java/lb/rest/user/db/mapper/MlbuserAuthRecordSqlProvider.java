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
import lb.rest.user.db.entity.MlbuserAuthRecord;
import lb.rest.user.db.entity.MlbuserAuthRecordExample.Criteria;
import lb.rest.user.db.entity.MlbuserAuthRecordExample.Criterion;
import lb.rest.user.db.entity.MlbuserAuthRecordExample;

public class MlbuserAuthRecordSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_auth_record
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String countByExample(MlbuserAuthRecordExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("mlbuser_auth_record");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_auth_record
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String deleteByExample(MlbuserAuthRecordExample example) {
        BEGIN();
        DELETE_FROM("mlbuser_auth_record");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_auth_record
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String insertSelective(MlbuserAuthRecord record) {
        BEGIN();
        INSERT_INTO("mlbuser_auth_record");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeManagerId() != null) {
            VALUES("trade_manager_id", "#{tradeManagerId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeManagerName() != null) {
            VALUES("trade_manager_name", "#{tradeManagerName,jdbcType=VARCHAR}");
        }
        
        if (record.getTradePersonId() != null) {
            VALUES("trade_person_id", "#{tradePersonId,jdbcType=INTEGER}");
        }
        
        if (record.getTradePersonName() != null) {
            VALUES("trade_person_name", "#{tradePersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getClientId() != null) {
            VALUES("client_id", "#{clientId,jdbcType=INTEGER}");
        }
        
        if (record.getClientName() != null) {
            VALUES("client_name", "#{clientName,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            VALUES("modify_time", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_auth_record
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String selectByExample(MlbuserAuthRecordExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("user_id");
        SELECT("user_name");
        SELECT("trade_manager_id");
        SELECT("trade_manager_name");
        SELECT("trade_person_id");
        SELECT("trade_person_name");
        SELECT("client_id");
        SELECT("client_name");
        SELECT("remark");
        SELECT("create_time");
        SELECT("modify_time");
        FROM("mlbuser_auth_record");
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
     * This method corresponds to the database table mlbuser_auth_record
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        MlbuserAuthRecord record = (MlbuserAuthRecord) parameter.get("record");
        MlbuserAuthRecordExample example = (MlbuserAuthRecordExample) parameter.get("example");
        
        BEGIN();
        UPDATE("mlbuser_auth_record");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeManagerId() != null) {
            SET("trade_manager_id = #{record.tradeManagerId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeManagerName() != null) {
            SET("trade_manager_name = #{record.tradeManagerName,jdbcType=VARCHAR}");
        }
        
        if (record.getTradePersonId() != null) {
            SET("trade_person_id = #{record.tradePersonId,jdbcType=INTEGER}");
        }
        
        if (record.getTradePersonName() != null) {
            SET("trade_person_name = #{record.tradePersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getClientId() != null) {
            SET("client_id = #{record.clientId,jdbcType=INTEGER}");
        }
        
        if (record.getClientName() != null) {
            SET("client_name = #{record.clientName,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_auth_record
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("mlbuser_auth_record");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("user_id = #{record.userId,jdbcType=INTEGER}");
        SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        SET("trade_manager_id = #{record.tradeManagerId,jdbcType=INTEGER}");
        SET("trade_manager_name = #{record.tradeManagerName,jdbcType=VARCHAR}");
        SET("trade_person_id = #{record.tradePersonId,jdbcType=INTEGER}");
        SET("trade_person_name = #{record.tradePersonName,jdbcType=VARCHAR}");
        SET("client_id = #{record.clientId,jdbcType=INTEGER}");
        SET("client_name = #{record.clientName,jdbcType=VARCHAR}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        
        MlbuserAuthRecordExample example = (MlbuserAuthRecordExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_auth_record
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String updateByPrimaryKeySelective(MlbuserAuthRecord record) {
        BEGIN();
        UPDATE("mlbuser_auth_record");
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getTradeManagerId() != null) {
            SET("trade_manager_id = #{tradeManagerId,jdbcType=INTEGER}");
        }
        
        if (record.getTradeManagerName() != null) {
            SET("trade_manager_name = #{tradeManagerName,jdbcType=VARCHAR}");
        }
        
        if (record.getTradePersonId() != null) {
            SET("trade_person_id = #{tradePersonId,jdbcType=INTEGER}");
        }
        
        if (record.getTradePersonName() != null) {
            SET("trade_person_name = #{tradePersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getClientId() != null) {
            SET("client_id = #{clientId,jdbcType=INTEGER}");
        }
        
        if (record.getClientName() != null) {
            SET("client_name = #{clientName,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_auth_record
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    protected void applyWhere(MlbuserAuthRecordExample example, boolean includeExamplePhrase) {
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