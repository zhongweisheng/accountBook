package com.mlb.bo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MlbUserBO {
	private int id = -1;
	private String trueName;
	private String phone;
	private String loginName;
	private String passWord;
	private int status;
	private int usertype;
	private String location;
	private String address;
	private int preferUserid;
	private String openId;
	private String nickName;
	private String userImage;
	private String locationDesc;
	private String inviteCode;
	private Date regTime;
	private String companyName;
	private int from;
	private int warehouseId;
	private int createuserid;
	private int level;
	private Date updatetime;
	private int blacklist;
	private Date actionTime;
	private int viewCount;

	private String maintainer;

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public Date getActionTime() {
		return actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	// 卖粮宝微信平台用户认证
	private int processCode;
	private int traderUserId;

	// 新用户注册后运营人员 修改的状态 （三种：1:未处理,2:通过,3:放弃）
	private int registerStatus;
	// 是否同意用户协议(1表示同意)
	private int hasAgree;

	private double lng;
	private double lat;
	private String area;
	private double matchDistance;// 计算距离

	// 卖粮宝微信平台用户认证
	private int authentication;

	private String traderName;

	// 客服名称
	private String customerName;
	/*
	 * FoodSource 库容 5000吨以上 年周转量 1-4万吨 运输方式 汽运、船运 主要流向 江苏、浙江 场地规模 比较大 提供发票 是
	 */
	private String out_put_num = "";
	private String year_revolve_num = "";
	private String transport_type = "";
	private String main_flow_direction = "";
	private String field_scale = "";
	private String bill_status = "";

	private int assignsStatus;// 分配状态
	private int applyUserStatus; // 被申请状态 0 未被申请，1、未处理，2、已处理

	private int buyType; // 用户买卖类别：1买家，2是卖家，3是即买又卖，4新注册用户

	public int getBuyType() {
		return buyType;
	}

	public void setBuyType(int buyType) {
		this.buyType = buyType;
	}

	public int getApplyUserStatus() {
		return applyUserStatus;
	}

	public void setApplyUserStatus(int applyUserStatus) {
		this.applyUserStatus = applyUserStatus;
	}

	public int getAssignsStatus() {
		return assignsStatus;
	}

	public void setAssignsStatus(int assignsStatus) {
		this.assignsStatus = assignsStatus;
	}

	// 分配状态 分配状态0未分配，1已分配，2、取消分配
	public String getAssignsStatusDesc() {
		switch (this.assignsStatus) {
		case 1:
			return "已分配";
		case 2:
			return "取消分配";
		default:
			return "未分配";

		}
	}

	public static Map<Integer, String> USER_TYPE_NAMES = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;

		{
			put(1, "下游用户");
			put(2, "上游用户");
			put(3, "粮库用户");
		}
	};

	public String getStatusDesc() {
		switch (this.status) {
		case 1:
			return "待沟通";
		case 2:
			return "已沟通";
		case 3:
			return "待分配 ";
		case 4:
			return "已分配";
		case 10:
			return "已完善信息";
		case 20:
			return "已通过审核";
		default:
			return "待沟通";

		}
	}

	public String getRegisterStatusDesc() {
		switch (this.registerStatus) {
		case 1:
			return "未处理";
		case 2:
			return "通过";
		case 3:
			return "放弃 ";
		default:
			return "未处理";
		}
	}

	public String getUsertypeDesc() {
		switch (this.usertype) {
		case 1:
			return "下游客户";
		case 2:
			return "贸易商";
		case 3:
			return "粮库用户";
		default:
			return "上游客户";

		}
	}

	public String getUserlevelDesc() {
		switch (this.level) {
		case 1:
			return "A级";
		case 2:
			return "B级";
		case 3:
			return "C级";
		case 4:
			return "D级";
		default:
			return "待评级";
		}
	}

	public String getFromDesc() {
		switch (this.from) {
		case 1:
			return "微信";
		case 2:
			return "后台";
		case 3:
			return "短信";
		default:
			return "后台";
		}
	}

	public String getFromDesc2() {
		switch (this.from) {
		case 0:
			return "后台";
		case 1:
			return "微信";
		case 2:
			return "后台";
			// case 3:{
			// PromotionchannelBO bo =PromotionchannelService.getBO(getFrom());
			// if (bo!=null){
			// return bo.getName();
			// }else{
			// return "经纪人/销售";
			// }
			// }
			// default:
			// return "后台";
			// }
		default: {
////			PromotionchannelBO bo = PromotionchannelService.getBO(getFrom());
//			if (bo != null) {
//				return bo.getName();
//			} else {
//				return "经纪人/销售";
//			}
			return "";
		}
		}
	}

	public String getAuthen() {
		switch (this.authentication) {
		case 0:
			return "未认证";
		case -1:
			return "取消认证";
		case -2:
			return "认证未通过";
		default:
			return "已认证";
		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPreferUserid() {
		return preferUserid;
	}

	public void setPreferUserid(int preferUserid) {
		this.preferUserid = preferUserid;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(int createuserid) {
		this.createuserid = createuserid;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getRegisterStatus() {
		return registerStatus;
	}

	public void setRegisterStatus(int registerStatus) {
		this.registerStatus = registerStatus;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

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

	public double getMatchDistance() {
		return matchDistance;
	}

	public void setMatchDistance(double matchDistance) {
		this.matchDistance = matchDistance;
	}

	public String getOut_put_num() {
		return out_put_num;
	}

	public void setOut_put_num(String out_put_num) {
		this.out_put_num = out_put_num;
	}

	public String getYear_revolve_num() {
		return year_revolve_num;
	}

	public void setYear_revolve_num(String year_revolve_num) {
		this.year_revolve_num = year_revolve_num;
	}

	public String getTransport_type() {
		return transport_type;
	}

	public void setTransport_type(String transport_type) {
		this.transport_type = transport_type;
	}

	public String getMain_flow_direction() {
		return main_flow_direction;
	}

	public void setMain_flow_direction(String main_flow_direction) {
		this.main_flow_direction = main_flow_direction;
	}

	public String getField_scale() {
		return field_scale;
	}

	public void setField_scale(String field_scale) {
		this.field_scale = field_scale;
	}

	public String getBill_status() {
		return bill_status;
	}

	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
	}

	public int getHasAgree() {
		return hasAgree;
	}

	public void setHasAgree(int hasAgree) {
		this.hasAgree = hasAgree;
	}

	public int getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(int blacklist) {
		this.blacklist = blacklist;
	}

	public int getAuthentication() {
		return authentication;
	}

	public void setAuthentication(int authentication) {
		this.authentication = authentication;
	}

	public int getProcessCode() {
		return processCode;
	}

	public void setProcessCode(int processCode) {
		this.processCode = processCode;
	}

	public int getTraderUserId() {
		return traderUserId;
	}

	public void setTraderUserId(int traderUserId) {
		this.traderUserId = traderUserId;
	}

	public String getTraderName() {
		return traderName;
	}

	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMaintainer() {
		return maintainer;
	}

	public void setMaintainer(String maintainer) {
		this.maintainer = maintainer;
	}

}