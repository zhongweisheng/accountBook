package lb.rest.trade.db.mapper;

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
import lb.rest.trade.db.entity.BsUserRequire;
import lb.rest.trade.db.entity.BsUserRequireExample.Criteria;
import lb.rest.trade.db.entity.BsUserRequireExample.Criterion;
import lb.rest.trade.db.entity.BsUserRequireExample;

public class BsUserRequireSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_require
     *
     * @mbggenerated Fri Feb 24 18:06:23 CST 2017
     */
    public String countByExample(BsUserRequireExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("bs_user_require");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_require
     *
     * @mbggenerated Fri Feb 24 18:06:23 CST 2017
     */
    public String deleteByExample(BsUserRequireExample example) {
        BEGIN();
        DELETE_FROM("bs_user_require");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_require
     *
     * @mbggenerated Fri Feb 24 18:06:23 CST 2017
     */
    public String insertSelective(BsUserRequire record) {
        BEGIN();
        INSERT_INTO("bs_user_require");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getProcessStatus() != null) {
            VALUES("process_status", "#{processStatus,jdbcType=INTEGER}");
        }
        
        if (record.getServiceType() != null) {
            VALUES("service_type", "#{serviceType,jdbcType=INTEGER}");
        }
        
        if (record.getBuyId() != null) {
            VALUES("buy_id", "#{buyId,jdbcType=INTEGER}");
        }
        
        if (record.getBuyName() != null) {
            VALUES("buy_name", "#{buyName,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyAddress() != null) {
            VALUES("buy_address", "#{buyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyPhone() != null) {
            VALUES("buy_phone", "#{buyPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyFoodType() != null) {
            VALUES("buy_food_type", "#{buyFoodType,jdbcType=INTEGER}");
        }
        
        if (record.getBuyFoodPrice() != null) {
            VALUES("buy_food_price", "#{buyFoodPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getBuyFoodNum() != null) {
            VALUES("buy_food_num", "#{buyFoodNum,jdbcType=DOUBLE}");
        }
        
        if (record.getBuyFoodRequire() != null) {
            VALUES("buy_food_require", "#{buyFoodRequire,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyLocationS() != null) {
            VALUES("buy_location_s", "#{buyLocationS,jdbcType=INTEGER}");
        }
        
        if (record.getBuyLocationDescS() != null) {
            VALUES("buy_location_desc_s", "#{buyLocationDescS,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyLocation() != null) {
            VALUES("buy_location", "#{buyLocation,jdbcType=INTEGER}");
        }
        
        if (record.getBuyLocationDesc() != null) {
            VALUES("buy_location_desc", "#{buyLocationDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckStatus() != null) {
            VALUES("check_status", "#{checkStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCheckUserId() != null) {
            VALUES("check_user_id", "#{checkUserId,jdbcType=INTEGER}");
        }
        
        if (record.getCheckUserName() != null) {
            VALUES("check_user_name", "#{checkUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckUserTime() != null) {
            VALUES("check_user_time", "#{checkUserTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCheckClientStatus() != null) {
            VALUES("check_client_status", "#{checkClientStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCheckClientId() != null) {
            VALUES("check_client_id", "#{checkClientId,jdbcType=INTEGER}");
        }
        
        if (record.getCheckClientName() != null) {
            VALUES("check_client_name", "#{checkClientName,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckClientTime() != null) {
            VALUES("check_client_time", "#{checkClientTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCheckClientRemark() != null) {
            VALUES("check_client_remark", "#{checkClientRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getTraderId() != null) {
            VALUES("trader_id", "#{traderId,jdbcType=INTEGER}");
        }
        
        if (record.getTraderName() != null) {
            VALUES("trader_name", "#{traderName,jdbcType=VARCHAR}");
        }
        
        if (record.getTraderPhone() != null) {
            VALUES("trader_phone", "#{traderPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyAllocation() != null) {
            VALUES("apply_allocation", "#{applyAllocation,jdbcType=INTEGER}");
        }
        
        if (record.getRealityBuyPriceType() != null) {
            VALUES("reality_buy_price_type", "#{realityBuyPriceType,jdbcType=INTEGER}");
        }
        
        if (record.getRealitySellPriceType() != null) {
            VALUES("reality_sell_price_type", "#{realitySellPriceType,jdbcType=INTEGER}");
        }
        
        if (record.getRealityBuyPrice() != null) {
            VALUES("reality_buy_price", "#{realityBuyPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getRealitySellPrice() != null) {
            VALUES("reality_sell_price", "#{realitySellPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getRealityBuyPayMethod() != null) {
            VALUES("reality_buy_pay_method", "#{realityBuyPayMethod,jdbcType=INTEGER}");
        }
        
        if (record.getRealitySellPayMethod() != null) {
            VALUES("reality_sell_pay_method", "#{realitySellPayMethod,jdbcType=INTEGER}");
        }
        
        if (record.getRealityBuyRequire() != null) {
            VALUES("reality_buy_require", "#{realityBuyRequire,jdbcType=VARCHAR}");
        }
        
        if (record.getRealitySellRequire() != null) {
            VALUES("reality_sell_require", "#{realitySellRequire,jdbcType=VARCHAR}");
        }
        
        if (record.getRealityLogisticsInfo() != null) {
            VALUES("reality_logistics_info", "#{realityLogisticsInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getAbandonReasonCode() != null) {
            VALUES("abandon_reason_code", "#{abandonReasonCode,jdbcType=INTEGER}");
        }
        
        if (record.getAbandonReason() != null) {
            VALUES("abandon_reason", "#{abandonReason,jdbcType=VARCHAR}");
        }
        
        if (record.getMatchGoodsId() != null) {
            VALUES("match_goods_id", "#{matchGoodsId,jdbcType=INTEGER}");
        }
        
        if (record.getViewCount() != null) {
            VALUES("view_count", "#{viewCount,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            VALUES("modify_time", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFromType() != null) {
            VALUES("from_type", "#{fromType,jdbcType=INTEGER}");
        }
        
        if (record.getCompleteTime() != null) {
            VALUES("complete_time", "#{completeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUserid() != null) {
            VALUES("create_userid", "#{createUserid,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUsername() != null) {
            VALUES("create_username", "#{createUsername,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthStatus() != null) {
            VALUES("auth_status", "#{authStatus,jdbcType=INTEGER}");
        }
        
        if (record.getHasLogistics() != null) {
            VALUES("has_logistics", "#{hasLogistics,jdbcType=INTEGER}");
        }
        
        if (record.getGrainLevel() != null) {
            VALUES("grain_level", "#{grainLevel,jdbcType=INTEGER}");
        }
        
        if (record.getCategory() != null) {
            VALUES("category", "#{category,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
        	VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getColumn1() != null) {
            VALUES("column1", "#{column1,jdbcType=VARCHAR}");
        }
        
        if (record.getColumn2() != null) {
            VALUES("column2", "#{column2,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_require
     *
     * @mbggenerated Fri Feb 24 18:06:23 CST 2017
     */
    public String selectByExample(BsUserRequireExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("process_status");
        SELECT("service_type");
        SELECT("buy_id");
        SELECT("buy_name");
        SELECT("buy_address");
        SELECT("buy_phone");
        SELECT("buy_food_type");
        SELECT("buy_food_price");
        SELECT("buy_food_num");
        SELECT("buy_food_require");
        SELECT("buy_location_s");
        SELECT("buy_location_desc_s");
        SELECT("buy_location");
        SELECT("buy_location_desc");
        SELECT("check_status");
        SELECT("check_user_id");
        SELECT("check_user_name");
        SELECT("check_user_time");
        SELECT("check_client_status");
        SELECT("check_client_id");
        SELECT("check_client_name");
        SELECT("check_client_time");
        SELECT("check_client_remark");
        SELECT("trader_id");
        SELECT("trader_name");
        SELECT("trader_phone");
        SELECT("apply_allocation");
        SELECT("reality_buy_price_type");
        SELECT("reality_sell_price_type");
        SELECT("reality_buy_price");
        SELECT("reality_sell_price");
        SELECT("reality_buy_pay_method");
        SELECT("reality_sell_pay_method");
        SELECT("reality_buy_require");
        SELECT("reality_sell_require");
        SELECT("reality_logistics_info");
        SELECT("abandon_reason_code");
        SELECT("abandon_reason");
        SELECT("match_goods_id");
        SELECT("view_count");
        SELECT("create_time");
        SELECT("modify_time");
        SELECT("from_type");
        SELECT("complete_time");
        SELECT("create_userid");
        SELECT("create_username");
        SELECT("auth_status");
        SELECT("has_logistics");
        SELECT("grain_level");
        SELECT("category");
        SELECT("remark");
        SELECT("address");
        SELECT("column1");
        SELECT("column2");
        FROM("bs_user_require");
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
     * This method corresponds to the database table bs_user_require
     *
     * @mbggenerated Fri Feb 24 18:06:23 CST 2017
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        BsUserRequire record = (BsUserRequire) parameter.get("record");
        BsUserRequireExample example = (BsUserRequireExample) parameter.get("example");
        
        BEGIN();
        UPDATE("bs_user_require");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getProcessStatus() != null) {
            SET("process_status = #{record.processStatus,jdbcType=INTEGER}");
        }
        
        if (record.getServiceType() != null) {
            SET("service_type = #{record.serviceType,jdbcType=INTEGER}");
        }
        
        if (record.getBuyId() != null) {
            SET("buy_id = #{record.buyId,jdbcType=INTEGER}");
        }
        
        if (record.getBuyName() != null) {
            SET("buy_name = #{record.buyName,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyAddress() != null) {
            SET("buy_address = #{record.buyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyPhone() != null) {
            SET("buy_phone = #{record.buyPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyFoodType() != null) {
            SET("buy_food_type = #{record.buyFoodType,jdbcType=INTEGER}");
        }
        
        if (record.getBuyFoodPrice() != null) {
            SET("buy_food_price = #{record.buyFoodPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getBuyFoodNum() != null) {
            SET("buy_food_num = #{record.buyFoodNum,jdbcType=DOUBLE}");
        }
        
        if (record.getBuyFoodRequire() != null) {
            SET("buy_food_require = #{record.buyFoodRequire,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyLocationS() != null) {
            SET("buy_location_s = #{record.buyLocationS,jdbcType=INTEGER}");
        }
        
        if (record.getBuyLocationDescS() != null) {
            SET("buy_location_desc_s = #{record.buyLocationDescS,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyLocation() != null) {
            SET("buy_location = #{record.buyLocation,jdbcType=INTEGER}");
        }
        
        if (record.getBuyLocationDesc() != null) {
            SET("buy_location_desc = #{record.buyLocationDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckStatus() != null) {
            SET("check_status = #{record.checkStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCheckUserId() != null) {
            SET("check_user_id = #{record.checkUserId,jdbcType=INTEGER}");
        }
        
        if (record.getCheckUserName() != null) {
            SET("check_user_name = #{record.checkUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckUserTime() != null) {
            SET("check_user_time = #{record.checkUserTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCheckClientStatus() != null) {
            SET("check_client_status = #{record.checkClientStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCheckClientId() != null) {
            SET("check_client_id = #{record.checkClientId,jdbcType=INTEGER}");
        }
        
        if (record.getCheckClientName() != null) {
            SET("check_client_name = #{record.checkClientName,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckClientTime() != null) {
            SET("check_client_time = #{record.checkClientTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCheckClientRemark() != null) {
            SET("check_client_remark = #{record.checkClientRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getTraderId() != null) {
            SET("trader_id = #{record.traderId,jdbcType=INTEGER}");
        }
        
        if (record.getTraderName() != null) {
            SET("trader_name = #{record.traderName,jdbcType=VARCHAR}");
        }
        
        if (record.getTraderPhone() != null) {
            SET("trader_phone = #{record.traderPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyAllocation() != null) {
            SET("apply_allocation = #{record.applyAllocation,jdbcType=INTEGER}");
        }
        
        if (record.getRealityBuyPriceType() != null) {
            SET("reality_buy_price_type = #{record.realityBuyPriceType,jdbcType=INTEGER}");
        }
        
        if (record.getRealitySellPriceType() != null) {
            SET("reality_sell_price_type = #{record.realitySellPriceType,jdbcType=INTEGER}");
        }
        
        if (record.getRealityBuyPrice() != null) {
            SET("reality_buy_price = #{record.realityBuyPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getRealitySellPrice() != null) {
            SET("reality_sell_price = #{record.realitySellPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getRealityBuyPayMethod() != null) {
            SET("reality_buy_pay_method = #{record.realityBuyPayMethod,jdbcType=INTEGER}");
        }
        
        if (record.getRealitySellPayMethod() != null) {
            SET("reality_sell_pay_method = #{record.realitySellPayMethod,jdbcType=INTEGER}");
        }
        
        if (record.getRealityBuyRequire() != null) {
            SET("reality_buy_require = #{record.realityBuyRequire,jdbcType=VARCHAR}");
        }
        
        if (record.getRealitySellRequire() != null) {
            SET("reality_sell_require = #{record.realitySellRequire,jdbcType=VARCHAR}");
        }
        
        if (record.getRealityLogisticsInfo() != null) {
            SET("reality_logistics_info = #{record.realityLogisticsInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getAbandonReasonCode() != null) {
            SET("abandon_reason_code = #{record.abandonReasonCode,jdbcType=INTEGER}");
        }
        
        if (record.getAbandonReason() != null) {
            SET("abandon_reason = #{record.abandonReason,jdbcType=VARCHAR}");
        }
        
        if (record.getMatchGoodsId() != null) {
            SET("match_goods_id = #{record.matchGoodsId,jdbcType=INTEGER}");
        }
        
        if (record.getViewCount() != null) {
            SET("view_count = #{record.viewCount,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFromType() != null) {
            SET("from_type = #{record.fromType,jdbcType=INTEGER}");
        }
        
        if (record.getCompleteTime() != null) {
            SET("complete_time = #{record.completeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUserid() != null) {
            SET("create_userid = #{record.createUserid,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUsername() != null) {
            SET("create_username = #{record.createUsername,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthStatus() != null) {
            SET("auth_status = #{record.authStatus,jdbcType=INTEGER}");
        }
        
        if (record.getHasLogistics() != null) {
            SET("has_logistics = #{record.hasLogistics,jdbcType=INTEGER}");
        }
        
        if (record.getGrainLevel() != null) {
            SET("grain_level = #{record.grainLevel,jdbcType=INTEGER}");
        }
        
        if (record.getCategory() != null) {
            SET("category = #{record.category,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
        	SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        if (record.getAddress() != null) {
            SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getColumn1() != null) {
            SET("column1 = #{record.column1,jdbcType=VARCHAR}");
        }
        
        if (record.getColumn2() != null) {
            SET("column2 = #{record.column2,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_require
     *
     * @mbggenerated Fri Feb 24 18:06:23 CST 2017
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("bs_user_require");
        
        SET("id = #{record.id,jdbcType=BIGINT}");
        SET("process_status = #{record.processStatus,jdbcType=INTEGER}");
        SET("service_type = #{record.serviceType,jdbcType=INTEGER}");
        SET("buy_id = #{record.buyId,jdbcType=INTEGER}");
        SET("buy_name = #{record.buyName,jdbcType=VARCHAR}");
        SET("buy_address = #{record.buyAddress,jdbcType=VARCHAR}");
        SET("buy_phone = #{record.buyPhone,jdbcType=VARCHAR}");
        SET("buy_food_type = #{record.buyFoodType,jdbcType=INTEGER}");
        SET("buy_food_price = #{record.buyFoodPrice,jdbcType=DOUBLE}");
        SET("buy_food_num = #{record.buyFoodNum,jdbcType=DOUBLE}");
        SET("buy_food_require = #{record.buyFoodRequire,jdbcType=VARCHAR}");
        SET("buy_location_s = #{record.buyLocationS,jdbcType=INTEGER}");
        SET("buy_location_desc_s = #{record.buyLocationDescS,jdbcType=VARCHAR}");
        SET("buy_location = #{record.buyLocation,jdbcType=INTEGER}");
        SET("buy_location_desc = #{record.buyLocationDesc,jdbcType=VARCHAR}");
        SET("check_status = #{record.checkStatus,jdbcType=INTEGER}");
        SET("check_user_id = #{record.checkUserId,jdbcType=INTEGER}");
        SET("check_user_name = #{record.checkUserName,jdbcType=VARCHAR}");
        SET("check_user_time = #{record.checkUserTime,jdbcType=TIMESTAMP}");
        SET("check_client_status = #{record.checkClientStatus,jdbcType=INTEGER}");
        SET("check_client_id = #{record.checkClientId,jdbcType=INTEGER}");
        SET("check_client_name = #{record.checkClientName,jdbcType=VARCHAR}");
        SET("check_client_time = #{record.checkClientTime,jdbcType=TIMESTAMP}");
        SET("check_client_remark = #{record.checkClientRemark,jdbcType=VARCHAR}");
        SET("trader_id = #{record.traderId,jdbcType=INTEGER}");
        SET("trader_name = #{record.traderName,jdbcType=VARCHAR}");
        SET("trader_phone = #{record.traderPhone,jdbcType=VARCHAR}");
        SET("apply_allocation = #{record.applyAllocation,jdbcType=INTEGER}");
        SET("reality_buy_price_type = #{record.realityBuyPriceType,jdbcType=INTEGER}");
        SET("reality_sell_price_type = #{record.realitySellPriceType,jdbcType=INTEGER}");
        SET("reality_buy_price = #{record.realityBuyPrice,jdbcType=DOUBLE}");
        SET("reality_sell_price = #{record.realitySellPrice,jdbcType=DOUBLE}");
        SET("reality_buy_pay_method = #{record.realityBuyPayMethod,jdbcType=INTEGER}");
        SET("reality_sell_pay_method = #{record.realitySellPayMethod,jdbcType=INTEGER}");
        SET("reality_buy_require = #{record.realityBuyRequire,jdbcType=VARCHAR}");
        SET("reality_sell_require = #{record.realitySellRequire,jdbcType=VARCHAR}");
        SET("reality_logistics_info = #{record.realityLogisticsInfo,jdbcType=VARCHAR}");
        SET("abandon_reason_code = #{record.abandonReasonCode,jdbcType=INTEGER}");
        SET("abandon_reason = #{record.abandonReason,jdbcType=VARCHAR}");
        SET("match_goods_id = #{record.matchGoodsId,jdbcType=INTEGER}");
        SET("view_count = #{record.viewCount,jdbcType=INTEGER}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        SET("from_type = #{record.fromType,jdbcType=INTEGER}");
        SET("complete_time = #{record.completeTime,jdbcType=TIMESTAMP}");
        SET("create_userid = #{record.createUserid,jdbcType=INTEGER}");
        SET("create_username = #{record.createUsername,jdbcType=VARCHAR}");
        SET("auth_status = #{record.authStatus,jdbcType=INTEGER}");
        SET("has_logistics = #{record.hasLogistics,jdbcType=INTEGER}");
        SET("grain_level = #{record.grainLevel,jdbcType=INTEGER}");
        SET("category = #{record.category,jdbcType=INTEGER}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("address = #{record.address,jdbcType=VARCHAR}");
        SET("column1 = #{record.column1,jdbcType=VARCHAR}");
        SET("column2 = #{record.column2,jdbcType=VARCHAR}");
        
        BsUserRequireExample example = (BsUserRequireExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_require
     *
     * @mbggenerated Fri Feb 24 18:06:23 CST 2017
     */
    public String updateByPrimaryKeySelective(BsUserRequire record) {
        BEGIN();
        UPDATE("bs_user_require");
        
        if (record.getProcessStatus() != null) {
            SET("process_status = #{processStatus,jdbcType=INTEGER}");
        }
        
        if (record.getServiceType() != null) {
            SET("service_type = #{serviceType,jdbcType=INTEGER}");
        }
        
        if (record.getBuyId() != null) {
            SET("buy_id = #{buyId,jdbcType=INTEGER}");
        }
        
        if (record.getBuyName() != null) {
            SET("buy_name = #{buyName,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyAddress() != null) {
            SET("buy_address = #{buyAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyPhone() != null) {
            SET("buy_phone = #{buyPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyFoodType() != null) {
            SET("buy_food_type = #{buyFoodType,jdbcType=INTEGER}");
        }
        
        if (record.getBuyFoodPrice() != null) {
            SET("buy_food_price = #{buyFoodPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getBuyFoodNum() != null) {
            SET("buy_food_num = #{buyFoodNum,jdbcType=DOUBLE}");
        }
        
        if (record.getBuyFoodRequire() != null) {
            SET("buy_food_require = #{buyFoodRequire,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyLocationS() != null) {
            SET("buy_location_s = #{buyLocationS,jdbcType=INTEGER}");
        }
        
        if (record.getBuyLocationDescS() != null) {
            SET("buy_location_desc_s = #{buyLocationDescS,jdbcType=VARCHAR}");
        }
        
        if (record.getBuyLocation() != null) {
            SET("buy_location = #{buyLocation,jdbcType=INTEGER}");
        }
        
        if (record.getBuyLocationDesc() != null) {
            SET("buy_location_desc = #{buyLocationDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckStatus() != null) {
            SET("check_status = #{checkStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCheckUserId() != null) {
            SET("check_user_id = #{checkUserId,jdbcType=INTEGER}");
        }
        
        if (record.getCheckUserName() != null) {
            SET("check_user_name = #{checkUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckUserTime() != null) {
            SET("check_user_time = #{checkUserTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCheckClientStatus() != null) {
            SET("check_client_status = #{checkClientStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCheckClientId() != null) {
            SET("check_client_id = #{checkClientId,jdbcType=INTEGER}");
        }
        
        if (record.getCheckClientName() != null) {
            SET("check_client_name = #{checkClientName,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckClientTime() != null) {
            SET("check_client_time = #{checkClientTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCheckClientRemark() != null) {
            SET("check_client_remark = #{checkClientRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getTraderId() != null) {
            SET("trader_id = #{traderId,jdbcType=INTEGER}");
        }
        
        if (record.getTraderName() != null) {
            SET("trader_name = #{traderName,jdbcType=VARCHAR}");
        }
        
        if (record.getTraderPhone() != null) {
            SET("trader_phone = #{traderPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getApplyAllocation() != null) {
            SET("apply_allocation = #{applyAllocation,jdbcType=INTEGER}");
        }
        
        if (record.getRealityBuyPriceType() != null) {
            SET("reality_buy_price_type = #{realityBuyPriceType,jdbcType=INTEGER}");
        }
        
        if (record.getRealitySellPriceType() != null) {
            SET("reality_sell_price_type = #{realitySellPriceType,jdbcType=INTEGER}");
        }
        
        if (record.getRealityBuyPrice() != null) {
            SET("reality_buy_price = #{realityBuyPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getRealitySellPrice() != null) {
            SET("reality_sell_price = #{realitySellPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getRealityBuyPayMethod() != null) {
            SET("reality_buy_pay_method = #{realityBuyPayMethod,jdbcType=INTEGER}");
        }
        
        if (record.getRealitySellPayMethod() != null) {
            SET("reality_sell_pay_method = #{realitySellPayMethod,jdbcType=INTEGER}");
        }
        
        if (record.getRealityBuyRequire() != null) {
            SET("reality_buy_require = #{realityBuyRequire,jdbcType=VARCHAR}");
        }
        
        if (record.getRealitySellRequire() != null) {
            SET("reality_sell_require = #{realitySellRequire,jdbcType=VARCHAR}");
        }
        
        if (record.getRealityLogisticsInfo() != null) {
            SET("reality_logistics_info = #{realityLogisticsInfo,jdbcType=VARCHAR}");
        }
        
        if (record.getAbandonReasonCode() != null) {
            SET("abandon_reason_code = #{abandonReasonCode,jdbcType=INTEGER}");
        }
        
        if (record.getAbandonReason() != null) {
            SET("abandon_reason = #{abandonReason,jdbcType=VARCHAR}");
        }
        
        if (record.getMatchGoodsId() != null) {
            SET("match_goods_id = #{matchGoodsId,jdbcType=INTEGER}");
        }
        
        if (record.getViewCount() != null) {
            SET("view_count = #{viewCount,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFromType() != null) {
            SET("from_type = #{fromType,jdbcType=INTEGER}");
        }
        
        if (record.getCompleteTime() != null) {
            SET("complete_time = #{completeTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUserid() != null) {
            SET("create_userid = #{createUserid,jdbcType=INTEGER}");
        }
        
        if (record.getCreateUsername() != null) {
            SET("create_username = #{createUsername,jdbcType=VARCHAR}");
        }
        
        if (record.getAuthStatus() != null) {
            SET("auth_status = #{authStatus,jdbcType=INTEGER}");
        }
        
        if (record.getHasLogistics() != null) {
            SET("has_logistics = #{hasLogistics,jdbcType=INTEGER}");
        }
        
        if (record.getGrainLevel() != null) {
            SET("grain_level = #{grainLevel,jdbcType=INTEGER}");
        }
        
        if (record.getCategory() != null) {
            SET("category = #{category,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
        	SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getColumn1() != null) {
            SET("column1 = #{column1,jdbcType=VARCHAR}");
        }
        
        if (record.getColumn2() != null) {
            SET("column2 = #{column2,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_user_require
     *
     * @mbggenerated Fri Feb 24 18:06:23 CST 2017
     */
    protected void applyWhere(BsUserRequireExample example, boolean includeExamplePhrase) {
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