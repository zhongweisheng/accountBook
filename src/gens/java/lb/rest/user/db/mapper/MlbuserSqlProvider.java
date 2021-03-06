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

import lb.rest.user.db.entity.Mlbuser;
import lb.rest.user.db.entity.MlbuserExample.Criteria;
import lb.rest.user.db.entity.MlbuserExample.Criterion;
import lb.rest.user.db.entity.MlbuserExample;

public class MlbuserSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String countByExample(MlbuserExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("mlbuser");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String deleteByExample(MlbuserExample example) {
        BEGIN();
        DELETE_FROM("mlbuser");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String insertSelective(Mlbuser record) {
        BEGIN();
        INSERT_INTO("mlbuser");
        
        if (record.getUserid() != null) {
            VALUES("userId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getRegisterstatus() != null) {
            VALUES("registerstatus", "#{registerstatus,jdbcType=INTEGER}");
        }
        
        if (record.getTruename() != null) {
            VALUES("truename", "#{truename,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginname() != null) {
            VALUES("loginname", "#{loginname,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getUsertype() != null) {
            VALUES("usertype", "#{usertype,jdbcType=INTEGER}");
        }
        
        if (record.getLocation() != null) {
            VALUES("location", "#{location,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getPreferuserid() != null) {
            VALUES("preferuserid", "#{preferuserid,jdbcType=INTEGER}");
        }
        
        if (record.getOpenid() != null) {
            VALUES("openid", "#{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            VALUES("nickname", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getUserimage() != null) {
            VALUES("userimage", "#{userimage,jdbcType=VARCHAR}");
        }
        
        if (record.getLocationdesc() != null) {
            VALUES("locationdesc", "#{locationdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getInvitecode() != null) {
            VALUES("invitecode", "#{invitecode,jdbcType=VARCHAR}");
        }
        
        if (record.getRegtime() != null) {
            VALUES("regtime", "#{regtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCompanyname() != null) {
            VALUES("companyname", "#{companyname,jdbcType=VARCHAR}");
        }
        
        if (record.getFromtype() != null) {
            VALUES("fromtype", "#{fromtype,jdbcType=INTEGER}");
        }
        
        if (record.getCreateuserid() != null) {
            VALUES("createuserid", "#{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getLevel() != null) {
            VALUES("level", "#{level,jdbcType=INTEGER}");
        }
        
        if (record.getUpdatetime() != null) {
            VALUES("updatetime", "#{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsManage() != null) {
            VALUES("is_manage", "#{isManage,jdbcType=INTEGER}");
        }
        
        if (record.getManagerId() != null) {
            VALUES("manager_id", "#{managerId,jdbcType=INTEGER}");
        }
        
        if (record.getHasAgree() != null) {
            VALUES("has_agree", "#{hasAgree,jdbcType=INTEGER}");
        }
        
        if (record.getBlacklist() != null) {
            VALUES("blacklist", "#{blacklist,jdbcType=INTEGER}");
        }
        
        if (record.getAuthentication() != null) {
            VALUES("authentication", "#{authentication,jdbcType=INTEGER}");
        }
        
        if (record.getProcesscode() != null) {
            VALUES("processCode", "#{processcode,jdbcType=INTEGER}");
        }
        
        if (record.getTraderuserid() != null) {
            VALUES("traderUserId", "#{traderuserid,jdbcType=INTEGER}");
        }
        
        if (record.getTradername() != null) {
            VALUES("traderName", "#{tradername,jdbcType=VARCHAR}");
        }
        
        if (record.getClientName() != null) {
            VALUES("client_name", "#{clientName,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomername() != null) {
            VALUES("customerName", "#{customername,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getAssignsStatus() != null) {
            VALUES("assigns_status", "#{assignsStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApplyUserStatus() != null) {
            VALUES("apply_user_status", "#{applyUserStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApplyUserTime() != null) {
            VALUES("apply_user_time", "#{applyUserTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBuyType() != null) {
            VALUES("buy_type", "#{buyType,jdbcType=INTEGER}");
        }
        
        if (record.getMaintainer() != null) {
            VALUES("maintainer", "#{maintainer,jdbcType=VARCHAR}");
        }
        
        if (record.getShineuser() != null) {
            VALUES("shineUser", "#{shineuser,jdbcType=INTEGER}");
        }
        
        if (record.getIdCard() != null) {
            VALUES("id_card", "#{idCard,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone2() != null) {
            VALUES("phone2", "#{phone2,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthTime() != null) {
            VALUES("auth_time", "#{authTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCompanyAuth() != null) {
            VALUES("company_auth", "#{companyAuth,jdbcType=INTEGER}");
        }
        
        if (record.getPersonalAuth() != null) {
            VALUES("personal_auth", "#{personalAuth,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String selectByExample(MlbuserExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("userId");
        } else {
            SELECT("userId");
        }
        SELECT("registerstatus");
        SELECT("truename");
        SELECT("phone");
        SELECT("loginname");
        SELECT("password");
        SELECT("status");
        SELECT("usertype");
        SELECT("location");
        SELECT("address");
        SELECT("preferuserid");
        SELECT("openid");
        SELECT("nickname");
        SELECT("userimage");
        SELECT("locationdesc");
        SELECT("invitecode");
        SELECT("regtime");
        SELECT("companyname");
        SELECT("fromtype");
        SELECT("createuserid");
        SELECT("level");
        SELECT("updatetime");
        SELECT("is_manage");
        SELECT("manager_id");
        SELECT("has_agree");
        SELECT("blacklist");
        SELECT("authentication");
        SELECT("processCode");
        SELECT("traderUserId");
        SELECT("traderName");
        SELECT("client_name");
        SELECT("customerName");
        SELECT("remark");
        SELECT("assigns_status");
        SELECT("apply_user_status");
        SELECT("apply_user_time");
        SELECT("buy_type");
        SELECT("maintainer");
        SELECT("shineUser");
        SELECT("id_card");
        SELECT("email");
        SELECT("phone2");
        SELECT("auth_time");
        SELECT("company_auth");
        SELECT("personal_auth");
        FROM("mlbuser");
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
     * This method corresponds to the database table mlbuser
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Mlbuser record = (Mlbuser) parameter.get("record");
        MlbuserExample example = (MlbuserExample) parameter.get("example");
        
        BEGIN();
        UPDATE("mlbuser");
        
        if (record.getUserid() != null) {
            SET("userId = #{record.userid,jdbcType=INTEGER}");
        }
        
        if (record.getRegisterstatus() != null) {
            SET("registerstatus = #{record.registerstatus,jdbcType=INTEGER}");
        }
        
        if (record.getTruename() != null) {
            SET("truename = #{record.truename,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginname() != null) {
            SET("loginname = #{record.loginname,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getUsertype() != null) {
            SET("usertype = #{record.usertype,jdbcType=INTEGER}");
        }
        
        if (record.getLocation() != null) {
            SET("location = #{record.location,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getPreferuserid() != null) {
            SET("preferuserid = #{record.preferuserid,jdbcType=INTEGER}");
        }
        
        if (record.getOpenid() != null) {
            SET("openid = #{record.openid,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            SET("nickname = #{record.nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getUserimage() != null) {
            SET("userimage = #{record.userimage,jdbcType=VARCHAR}");
        }
        
        if (record.getLocationdesc() != null) {
            SET("locationdesc = #{record.locationdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getInvitecode() != null) {
            SET("invitecode = #{record.invitecode,jdbcType=VARCHAR}");
        }
        
        if (record.getRegtime() != null) {
            SET("regtime = #{record.regtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCompanyname() != null) {
            SET("companyname = #{record.companyname,jdbcType=VARCHAR}");
        }
        
        if (record.getFromtype() != null) {
            SET("fromtype = #{record.fromtype,jdbcType=INTEGER}");
        }
        
        if (record.getCreateuserid() != null) {
            SET("createuserid = #{record.createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getLevel() != null) {
            SET("level = #{record.level,jdbcType=INTEGER}");
        }
        
        if (record.getUpdatetime() != null) {
            SET("updatetime = #{record.updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsManage() != null) {
            SET("is_manage = #{record.isManage,jdbcType=INTEGER}");
        }
        
        if (record.getManagerId() != null) {
            SET("manager_id = #{record.managerId,jdbcType=INTEGER}");
        }
        
        if (record.getHasAgree() != null) {
            SET("has_agree = #{record.hasAgree,jdbcType=INTEGER}");
        }
        
        if (record.getBlacklist() != null) {
            SET("blacklist = #{record.blacklist,jdbcType=INTEGER}");
        }
        
        if (record.getAuthentication() != null) {
            SET("authentication = #{record.authentication,jdbcType=INTEGER}");
        }
        
        if (record.getProcesscode() != null) {
            SET("processCode = #{record.processcode,jdbcType=INTEGER}");
        }
        
        if (record.getTraderuserid() != null) {
            SET("traderUserId = #{record.traderuserid,jdbcType=INTEGER}");
        }
        
        if (record.getTradername() != null) {
            SET("traderName = #{record.tradername,jdbcType=VARCHAR}");
        }
        
        if (record.getClientName() != null) {
            SET("client_name = #{record.clientName,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomername() != null) {
            SET("customerName = #{record.customername,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getAssignsStatus() != null) {
            SET("assigns_status = #{record.assignsStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApplyUserStatus() != null) {
            SET("apply_user_status = #{record.applyUserStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApplyUserTime() != null) {
            SET("apply_user_time = #{record.applyUserTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBuyType() != null) {
            SET("buy_type = #{record.buyType,jdbcType=INTEGER}");
        }
        
        if (record.getMaintainer() != null) {
            SET("maintainer = #{record.maintainer,jdbcType=VARCHAR}");
        }
        
        if (record.getShineuser() != null) {
            SET("shineUser = #{record.shineuser,jdbcType=INTEGER}");
        }
        
        if (record.getIdCard() != null) {
            SET("id_card = #{record.idCard,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone2() != null) {
            SET("phone2 = #{record.phone2,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthTime() != null) {
            SET("auth_time = #{record.authTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCompanyAuth() != null) {
            SET("company_auth = #{record.companyAuth,jdbcType=INTEGER}");
        }
        
        if (record.getPersonalAuth() != null) {
            SET("personal_auth = #{record.personalAuth,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("mlbuser");
        
        SET("userId = #{record.userid,jdbcType=INTEGER}");
        SET("registerstatus = #{record.registerstatus,jdbcType=INTEGER}");
        SET("truename = #{record.truename,jdbcType=VARCHAR}");
        SET("phone = #{record.phone,jdbcType=VARCHAR}");
        SET("loginname = #{record.loginname,jdbcType=VARCHAR}");
        SET("password = #{record.password,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=INTEGER}");
        SET("usertype = #{record.usertype,jdbcType=INTEGER}");
        SET("location = #{record.location,jdbcType=VARCHAR}");
        SET("address = #{record.address,jdbcType=VARCHAR}");
        SET("preferuserid = #{record.preferuserid,jdbcType=INTEGER}");
        SET("openid = #{record.openid,jdbcType=VARCHAR}");
        SET("nickname = #{record.nickname,jdbcType=VARCHAR}");
        SET("userimage = #{record.userimage,jdbcType=VARCHAR}");
        SET("locationdesc = #{record.locationdesc,jdbcType=VARCHAR}");
        SET("invitecode = #{record.invitecode,jdbcType=VARCHAR}");
        SET("regtime = #{record.regtime,jdbcType=TIMESTAMP}");
        SET("companyname = #{record.companyname,jdbcType=VARCHAR}");
        SET("fromtype = #{record.fromtype,jdbcType=INTEGER}");
        SET("createuserid = #{record.createuserid,jdbcType=INTEGER}");
        SET("level = #{record.level,jdbcType=INTEGER}");
        SET("updatetime = #{record.updatetime,jdbcType=TIMESTAMP}");
        SET("is_manage = #{record.isManage,jdbcType=INTEGER}");
        SET("manager_id = #{record.managerId,jdbcType=INTEGER}");
        SET("has_agree = #{record.hasAgree,jdbcType=INTEGER}");
        SET("blacklist = #{record.blacklist,jdbcType=INTEGER}");
        SET("authentication = #{record.authentication,jdbcType=INTEGER}");
        SET("processCode = #{record.processcode,jdbcType=INTEGER}");
        SET("traderUserId = #{record.traderuserid,jdbcType=INTEGER}");
        SET("traderName = #{record.tradername,jdbcType=VARCHAR}");
        SET("client_name = #{record.clientName,jdbcType=VARCHAR}");
        SET("customerName = #{record.customername,jdbcType=VARCHAR}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("assigns_status = #{record.assignsStatus,jdbcType=INTEGER}");
        SET("apply_user_status = #{record.applyUserStatus,jdbcType=INTEGER}");
        SET("apply_user_time = #{record.applyUserTime,jdbcType=TIMESTAMP}");
        SET("buy_type = #{record.buyType,jdbcType=INTEGER}");
        SET("maintainer = #{record.maintainer,jdbcType=VARCHAR}");
        SET("shineUser = #{record.shineuser,jdbcType=INTEGER}");
        SET("id_card = #{record.idCard,jdbcType=VARCHAR}");
        SET("email = #{record.email,jdbcType=VARCHAR}");
        SET("phone2 = #{record.phone2,jdbcType=VARCHAR}");
        SET("auth_time = #{record.authTime,jdbcType=TIMESTAMP}");
        SET("company_auth = #{record.companyAuth,jdbcType=INTEGER}");
        SET("personal_auth = #{record.personalAuth,jdbcType=INTEGER}");
        
        MlbuserExample example = (MlbuserExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String updateByPrimaryKeySelective(Mlbuser record) {
        BEGIN();
        UPDATE("mlbuser");
        
        if (record.getRegisterstatus() != null) {
            SET("registerstatus = #{registerstatus,jdbcType=INTEGER}");
        }
        
        if (record.getTruename() != null) {
            SET("truename = #{truename,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginname() != null) {
            SET("loginname = #{loginname,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getUsertype() != null) {
            SET("usertype = #{usertype,jdbcType=INTEGER}");
        }
        
        if (record.getLocation() != null) {
            SET("location = #{location,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getPreferuserid() != null) {
            SET("preferuserid = #{preferuserid,jdbcType=INTEGER}");
        }
        
        if (record.getOpenid() != null) {
            SET("openid = #{openid,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            SET("nickname = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getUserimage() != null) {
            SET("userimage = #{userimage,jdbcType=VARCHAR}");
        }
        
        if (record.getLocationdesc() != null) {
            SET("locationdesc = #{locationdesc,jdbcType=VARCHAR}");
        }
        
        if (record.getInvitecode() != null) {
            SET("invitecode = #{invitecode,jdbcType=VARCHAR}");
        }
        
        if (record.getRegtime() != null) {
            SET("regtime = #{regtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCompanyname() != null) {
            SET("companyname = #{companyname,jdbcType=VARCHAR}");
        }
        
        if (record.getFromtype() != null) {
            SET("fromtype = #{fromtype,jdbcType=INTEGER}");
        }
        
        if (record.getCreateuserid() != null) {
            SET("createuserid = #{createuserid,jdbcType=INTEGER}");
        }
        
        if (record.getLevel() != null) {
            SET("level = #{level,jdbcType=INTEGER}");
        }
        
        if (record.getUpdatetime() != null) {
            SET("updatetime = #{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsManage() != null) {
            SET("is_manage = #{isManage,jdbcType=INTEGER}");
        }
        
        if (record.getManagerId() != null) {
            SET("manager_id = #{managerId,jdbcType=INTEGER}");
        }
        
        if (record.getHasAgree() != null) {
            SET("has_agree = #{hasAgree,jdbcType=INTEGER}");
        }
        
        if (record.getBlacklist() != null) {
            SET("blacklist = #{blacklist,jdbcType=INTEGER}");
        }
        
        if (record.getAuthentication() != null) {
            SET("authentication = #{authentication,jdbcType=INTEGER}");
        }
        
        if (record.getProcesscode() != null) {
            SET("processCode = #{processcode,jdbcType=INTEGER}");
        }
        
        if (record.getTraderuserid() != null) {
            SET("traderUserId = #{traderuserid,jdbcType=INTEGER}");
        }
        
        if (record.getTradername() != null) {
            SET("traderName = #{tradername,jdbcType=VARCHAR}");
        }
        
        if (record.getClientName() != null) {
            SET("client_name = #{clientName,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomername() != null) {
            SET("customerName = #{customername,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getAssignsStatus() != null) {
            SET("assigns_status = #{assignsStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApplyUserStatus() != null) {
            SET("apply_user_status = #{applyUserStatus,jdbcType=INTEGER}");
        }
        
        if (record.getApplyUserTime() != null) {
            SET("apply_user_time = #{applyUserTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBuyType() != null) {
            SET("buy_type = #{buyType,jdbcType=INTEGER}");
        }
        
        if (record.getMaintainer() != null) {
            SET("maintainer = #{maintainer,jdbcType=VARCHAR}");
        }
        
        if (record.getShineuser() != null) {
            SET("shineUser = #{shineuser,jdbcType=INTEGER}");
        }
        
        if (record.getIdCard() != null) {
            SET("id_card = #{idCard,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone2() != null) {
            SET("phone2 = #{phone2,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthTime() != null) {
            SET("auth_time = #{authTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCompanyAuth() != null) {
            SET("company_auth = #{companyAuth,jdbcType=INTEGER}");
        }
        
        if (record.getPersonalAuth() != null) {
            SET("personal_auth = #{personalAuth,jdbcType=INTEGER}");
        }
        
        WHERE("userId = #{userid,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    protected void applyWhere(MlbuserExample example, boolean includeExamplePhrase) {
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
    
    
    public String getMlbuserByShinUser(Map<String, Object> param) {
		String type =  (String) param.get("type");
		String sql = "SELECT  m.userid ,m.truename , MAX(create_time) createtime FROM mlbuser m "
				+ " LEFT  JOIN bs_user_require b ON b.buy_id = m.userid "
				+ "WHERE m.shineUser in("+type+",3)  GROUP BY  m.userid  "
				+ "ORDER BY  MAX(create_time) DESC ; ";
		return sql;
	}
}