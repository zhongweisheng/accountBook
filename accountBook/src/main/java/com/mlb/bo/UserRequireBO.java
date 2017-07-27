package com.mlb.bo;

import java.util.Date;

public class UserRequireBO {

	private int id;
	private int processStatus;// 审核状态{-1:废弃,0:未分配,10:匹配,20:核价,30:核品质,40:核物流,50:审核中,60:成单;}
	private int serviceType; // {撮合 委托 自营}
	private int buyId;// 购粮企业（人）ID
	private String buyName;// 购粮企业（人）
	private String buyAddress;// 送粮地址
	private String buyPhone;// 购粮人电话
	private int buyFoodType;// 作物品种
	private double buyFoodPrice;// 购粮价格
	private double buyFoodNum;// 买入购粮数量
	private String buyFoodRequire;// 品质串儿
	private int buyLocationS;// 收货地址
	private String buyLocationDescS;// 收货地址
	private int buyLocation;// 要求粮食产地位置
	private String buyLocationDesc;// 要求粮食产地位置描述
	private String remark;// 备注

	private int checkStatus;// 审核状态{1:通过,2:不通过;}
	private int checkUserId;// 审核人
	private String checkUserName;// 审核人
	private Date checkUserTime;// 审核时间

	private int checkClientStatus;// 审核状态{1:通过,2:不通过;}
	private int checkClientId;// 审核人
	private String checkClientName;// 审核人
	private Date checkClientTime;// 审核时间
	private String checkClientRemark;// 备注

	private int traderId;// 交易员
	private String traderName;// 交易员姓名
	private String traderPhone;// 交易员电话

	private int applyAllocation;// 请求分配
	private int realityBuyPriceType;// 买方价格类型
	private int realitySellPriceType;// 卖方价格类型
	private double realityBuyPrice;// 购粮价格
	private double realitySellPrice;// 商品价格
	private int realityBuyPayMethod;// 买方付款方式
	private int realitySellPayMethod;// 卖方付款方式
	private String realityBuyRequire;// 实际采购质量
	private String realitySellRequire;// 实际商品质量
	private String realityLogisticsInfo;// 物流信息
	private int abandonReasonCode;// 废弃原因
	private String abandonReason;// 废弃原因
	private int matchGoodsId;// 匹配商品ID
	private int viewCount;// 微信端浏览详情次数
	private Date createTime;// 创建时间
	private Date modifyTime;// 修改时间
	private String processStatusName; // 审核状态

	private Date completeTime;

	private int createUserId;
	private String createUserName;

	private int authStatus;
	private int hasLogistics;
	private int grainLevel;
	private int category;

	private int fromType; // 来源类型{1:微信,2:录入}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(int processStatus) {
		this.processStatus = processStatus;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	public int getBuyId() {
		return buyId;
	}

	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}

	public String getBuyName() {
		return buyName;
	}

	public void setBuyName(String buyName) {
		this.buyName = buyName;
	}

	public String getBuyAddress() {
		return buyAddress;
	}

	public void setBuyAddress(String buyAddress) {
		this.buyAddress = buyAddress;
	}

	public String getBuyPhone() {
		return buyPhone;
	}

	public void setBuyPhone(String buyPhone) {
		this.buyPhone = buyPhone;
	}

	public int getBuyFoodType() {
		return buyFoodType;
	}

	public void setBuyFoodType(int buyFoodType) {
		this.buyFoodType = buyFoodType;
	}

	public double getBuyFoodPrice() {
		return buyFoodPrice;
	}

	public void setBuyFoodPrice(double buyFoodPrice) {
		this.buyFoodPrice = buyFoodPrice;
	}

	public double getBuyFoodNum() {
		return buyFoodNum;
	}

	public void setBuyFoodNum(double buyFoodNum) {
		this.buyFoodNum = buyFoodNum;
	}

	public String getBuyFoodRequire() {
		return buyFoodRequire;
	}

	public void setBuyFoodRequire(String buyFoodRequire) {
		this.buyFoodRequire = buyFoodRequire;
	}

	public int getBuyLocation() {
		return buyLocation;
	}

	public void setBuyLocation(int buyLocation) {
		this.buyLocation = buyLocation;
	}

	public String getBuyLocationDesc() {
		return buyLocationDesc;
	}

	public void setBuyLocationDesc(String buyLocationDesc) {
		this.buyLocationDesc = buyLocationDesc;
	}

	public int getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(int checkStatus) {
		this.checkStatus = checkStatus;
	}

	public int getCheckUserId() {
		return checkUserId;
	}

	public void setCheckUserId(int checkUserId) {
		this.checkUserId = checkUserId;
	}

	public String getCheckUserName() {
		return checkUserName;
	}

	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}

	public Date getCheckUserTime() {
		return checkUserTime;
	}

	public void setCheckUserTime(Date checkUserTime) {
		this.checkUserTime = checkUserTime;
	}

	public int getCheckClientStatus() {
		return checkClientStatus;
	}

	public void setCheckClientStatus(int checkClientStatus) {
		this.checkClientStatus = checkClientStatus;
	}

	public int getCheckClientId() {
		return checkClientId;
	}

	public void setCheckClientId(int checkClientId) {
		this.checkClientId = checkClientId;
	}

	public String getCheckClientName() {
		return checkClientName;
	}

	public void setCheckClientName(String checkClientName) {
		this.checkClientName = checkClientName;
	}

	public Date getCheckClientTime() {
		return checkClientTime;
	}

	public void setCheckClientTime(Date checkClientTime) {
		this.checkClientTime = checkClientTime;
	}

	public String getCheckClientRemark() {
		return checkClientRemark;
	}

	public void setCheckClientRemark(String checkClientRemark) {
		this.checkClientRemark = checkClientRemark;
	}

	public int getTraderId() {
		return traderId;
	}

	public void setTraderId(int traderId) {
		this.traderId = traderId;
	}

	public String getTraderName() {
		return traderName;
	}

	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}

	public String getTraderPhone() {
		return traderPhone;
	}

	public void setTraderPhone(String traderPhone) {
		this.traderPhone = traderPhone;
	}

	public int getApplyAllocation() {
		return applyAllocation;
	}

	public void setApplyAllocation(int applyAllocation) {
		this.applyAllocation = applyAllocation;
	}

	public int getRealityBuyPriceType() {
		return realityBuyPriceType;
	}

	public void setRealityBuyPriceType(int realityBuyPriceType) {
		this.realityBuyPriceType = realityBuyPriceType;
	}

	public int getRealitySellPriceType() {
		return realitySellPriceType;
	}

	public void setRealitySellPriceType(int realitySellPriceType) {
		this.realitySellPriceType = realitySellPriceType;
	}

	public double getRealityBuyPrice() {
		return realityBuyPrice;
	}

	public void setRealityBuyPrice(double realityBuyPrice) {
		this.realityBuyPrice = realityBuyPrice;
	}

	public double getRealitySellPrice() {
		return realitySellPrice;
	}

	public void setRealitySellPrice(double realitySellPrice) {
		this.realitySellPrice = realitySellPrice;
	}

	public int getRealityBuyPayMethod() {
		return realityBuyPayMethod;
	}

	public void setRealityBuyPayMethod(int realityBuyPayMethod) {
		this.realityBuyPayMethod = realityBuyPayMethod;
	}

	public int getRealitySellPayMethod() {
		return realitySellPayMethod;
	}

	public void setRealitySellPayMethod(int realitySellPayMethod) {
		this.realitySellPayMethod = realitySellPayMethod;
	}

	public String getRealityBuyRequire() {
		return realityBuyRequire;
	}

	public void setRealityBuyRequire(String realityBuyRequire) {
		this.realityBuyRequire = realityBuyRequire;
	}

	public String getRealitySellRequire() {
		return realitySellRequire;
	}

	public void setRealitySellRequire(String realitySellRequire) {
		this.realitySellRequire = realitySellRequire;
	}

	public String getRealityLogisticsInfo() {
		return realityLogisticsInfo;
	}

	public void setRealityLogisticsInfo(String realityLogisticsInfo) {
		this.realityLogisticsInfo = realityLogisticsInfo;
	}

	public int getAbandonReasonCode() {
		return abandonReasonCode;
	}

	public void setAbandonReasonCode(int abandonReasonCode) {
		this.abandonReasonCode = abandonReasonCode;
	}

	public String getAbandonReason() {
		return abandonReason;
	}

	public void setAbandonReason(String abandonReason) {
		this.abandonReason = abandonReason;
	}

	public int getMatchGoodsId() {
		return matchGoodsId;
	}

	public void setMatchGoodsId(int matchGoodsId) {
		this.matchGoodsId = matchGoodsId;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public int getFromType() {
		return fromType;
	}

	public void setFromType(int fromType) {
		this.fromType = fromType;
	}

	private double lng;
	private double lat;
	private String area;

	private double matchResult; // 匹配结果
	private double matchDistance;// 计算距离

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	// 审核状态{-1:废弃,0:未分配,10:匹配,20:核价,30:核品质,40:核物流,50:审核中,60:成单;}
	public String getProcessStatusName() {
		switch (this.processStatus) {
		case -1:
			return "废弃";
		case 0:
			return "未分配";
		case 10:
			return "进行中";
		case 20:
			return "进行中";
		case 30:
			return "进行中";
		case 40:
			return "进行中";
		case 50:
			return "进行中";
		case 60:
			return "成单";
		case 70:
			return "失败";
		default:
			return "";
		}
	}

	public void setProcessStatusName(String processStatusName) {
		this.processStatusName = processStatusName;
	}

	public double getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(double matchResult) {
		this.matchResult = matchResult;
	}

	public double getMatchDistance() {
		return matchDistance;
	}

	public void setMatchDistance(double matchDistance) {
		this.matchDistance = matchDistance;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public int getBuyLocationS() {
		return buyLocationS;
	}

	public void setBuyLocationS(int buyLocationS) {
		this.buyLocationS = buyLocationS;
	}

	public String getBuyLocationDescS() {
		return buyLocationDescS;
	}

	public void setBuyLocationDescS(String buyLocationDescS) {
		this.buyLocationDescS = buyLocationDescS;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public int getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(int authStatus) {
		this.authStatus = authStatus;
	}

	public int getHasLogistics() {
		return hasLogistics;
	}

	public void setHasLogistics(int hasLogistics) {
		this.hasLogistics = hasLogistics;
	}

	public int getGrainLevel() {
		return grainLevel;
	}

	public void setGrainLevel(int grainLevel) {
		this.grainLevel = grainLevel;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
}
