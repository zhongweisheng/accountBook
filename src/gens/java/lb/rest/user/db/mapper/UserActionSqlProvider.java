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
import lb.rest.user.db.entity.UserAction;
import lb.rest.user.db.entity.UserActionExample.Criteria;
import lb.rest.user.db.entity.UserActionExample.Criterion;
import lb.rest.user.db.entity.UserActionExample;

public class UserActionSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String countByExample(UserActionExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("user_action");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String deleteByExample(UserActionExample example) {
        BEGIN();
        DELETE_FROM("user_action");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String insertSelective(UserAction record) {
        BEGIN();
        INSERT_INTO("user_action");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getActiontype() != null) {
            VALUES("actiontype", "#{actiontype,jdbcType=INTEGER}");
        }
        
        if (record.getActionname() != null) {
            VALUES("actionname", "#{actionname,jdbcType=VARCHAR}");
        }
        
        if (record.getActiontime() != null) {
            VALUES("actiontime", "#{actiontime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserid() != null) {
            VALUES("userid", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getUseropenid() != null) {
            VALUES("useropenid", "#{useropenid,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            VALUES("note", "#{note,jdbcType=VARCHAR}");
        }
        
        if (record.getOfferpricetype() != null) {
            VALUES("offerpricetype", "#{offerpricetype,jdbcType=INTEGER}");
        }
        
        if (record.getGraintype() != null) {
            VALUES("graintype", "#{graintype,jdbcType=INTEGER}");
        }
        
        if (record.getOfferpriceid() != null) {
            VALUES("offerpriceid", "#{offerpriceid,jdbcType=INTEGER}");
        }
        
        if (record.getOrderid() != null) {
            VALUES("orderid", "#{orderid,jdbcType=INTEGER}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMessageid() != null) {
            VALUES("messageId", "#{messageid,jdbcType=INTEGER}");
        }
        
        if (record.getMenuname() != null) {
            VALUES("menuname", "#{menuname,jdbcType=VARCHAR}");
        }
        
        if (record.getFromtype() != null) {
            VALUES("fromtype", "#{fromtype,jdbcType=INTEGER}");
        }
        
        if (record.getIsshow() != null) {
            VALUES("isShow", "#{isshow,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String selectByExample(UserActionExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("actiontype");
        SELECT("actionname");
        SELECT("actiontime");
        SELECT("userid");
        SELECT("username");
        SELECT("useropenid");
        SELECT("note");
        SELECT("offerpricetype");
        SELECT("graintype");
        SELECT("offerpriceid");
        SELECT("orderid");
        SELECT("phone");
        SELECT("messageId");
        SELECT("menuname");
        SELECT("fromtype");
        SELECT("isShow");
        FROM("user_action");
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
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserAction record = (UserAction) parameter.get("record");
        UserActionExample example = (UserActionExample) parameter.get("example");
        
        BEGIN();
        UPDATE("user_action");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getActiontype() != null) {
            SET("actiontype = #{record.actiontype,jdbcType=INTEGER}");
        }
        
        if (record.getActionname() != null) {
            SET("actionname = #{record.actionname,jdbcType=VARCHAR}");
        }
        
        if (record.getActiontime() != null) {
            SET("actiontime = #{record.actiontime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserid() != null) {
            SET("userid = #{record.userid,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            SET("username = #{record.username,jdbcType=VARCHAR}");
        }
        
        if (record.getUseropenid() != null) {
            SET("useropenid = #{record.useropenid,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            SET("note = #{record.note,jdbcType=VARCHAR}");
        }
        
        if (record.getOfferpricetype() != null) {
            SET("offerpricetype = #{record.offerpricetype,jdbcType=INTEGER}");
        }
        
        if (record.getGraintype() != null) {
            SET("graintype = #{record.graintype,jdbcType=INTEGER}");
        }
        
        if (record.getOfferpriceid() != null) {
            SET("offerpriceid = #{record.offerpriceid,jdbcType=INTEGER}");
        }
        
        if (record.getOrderid() != null) {
            SET("orderid = #{record.orderid,jdbcType=INTEGER}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMessageid() != null) {
            SET("messageId = #{record.messageid,jdbcType=INTEGER}");
        }
        
        if (record.getMenuname() != null) {
            SET("menuname = #{record.menuname,jdbcType=VARCHAR}");
        }
        
        if (record.getFromtype() != null) {
            SET("fromtype = #{record.fromtype,jdbcType=INTEGER}");
        }
        
        if (record.getIsshow() != null) {
            SET("isShow = #{record.isshow,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("user_action");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("actiontype = #{record.actiontype,jdbcType=INTEGER}");
        SET("actionname = #{record.actionname,jdbcType=VARCHAR}");
        SET("actiontime = #{record.actiontime,jdbcType=TIMESTAMP}");
        SET("userid = #{record.userid,jdbcType=INTEGER}");
        SET("username = #{record.username,jdbcType=VARCHAR}");
        SET("useropenid = #{record.useropenid,jdbcType=VARCHAR}");
        SET("note = #{record.note,jdbcType=VARCHAR}");
        SET("offerpricetype = #{record.offerpricetype,jdbcType=INTEGER}");
        SET("graintype = #{record.graintype,jdbcType=INTEGER}");
        SET("offerpriceid = #{record.offerpriceid,jdbcType=INTEGER}");
        SET("orderid = #{record.orderid,jdbcType=INTEGER}");
        SET("phone = #{record.phone,jdbcType=VARCHAR}");
        SET("messageId = #{record.messageid,jdbcType=INTEGER}");
        SET("menuname = #{record.menuname,jdbcType=VARCHAR}");
        SET("fromtype = #{record.fromtype,jdbcType=INTEGER}");
        SET("isShow = #{record.isshow,jdbcType=INTEGER}");
        
        UserActionExample example = (UserActionExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    public String updateByPrimaryKeySelective(UserAction record) {
        BEGIN();
        UPDATE("user_action");
        
        if (record.getActiontype() != null) {
            SET("actiontype = #{actiontype,jdbcType=INTEGER}");
        }
        
        if (record.getActionname() != null) {
            SET("actionname = #{actionname,jdbcType=VARCHAR}");
        }
        
        if (record.getActiontime() != null) {
            SET("actiontime = #{actiontime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserid() != null) {
            SET("userid = #{userid,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getUseropenid() != null) {
            SET("useropenid = #{useropenid,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            SET("note = #{note,jdbcType=VARCHAR}");
        }
        
        if (record.getOfferpricetype() != null) {
            SET("offerpricetype = #{offerpricetype,jdbcType=INTEGER}");
        }
        
        if (record.getGraintype() != null) {
            SET("graintype = #{graintype,jdbcType=INTEGER}");
        }
        
        if (record.getOfferpriceid() != null) {
            SET("offerpriceid = #{offerpriceid,jdbcType=INTEGER}");
        }
        
        if (record.getOrderid() != null) {
            SET("orderid = #{orderid,jdbcType=INTEGER}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMessageid() != null) {
            SET("messageId = #{messageid,jdbcType=INTEGER}");
        }
        
        if (record.getMenuname() != null) {
            SET("menuname = #{menuname,jdbcType=VARCHAR}");
        }
        
        if (record.getFromtype() != null) {
            SET("fromtype = #{fromtype,jdbcType=INTEGER}");
        }
        
        if (record.getIsshow() != null) {
            SET("isShow = #{isshow,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_action
     *
     * @mbggenerated Thu Feb 16 17:53:29 CST 2017
     */
    protected void applyWhere(UserActionExample example, boolean includeExamplePhrase) {
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