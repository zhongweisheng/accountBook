package com.mlb.bo;

public class UserAuthBO {
	// 用户 ID
	private int userId;
	private String userName;
	// 用户 手机号
	private String phone;

	private int ifHzk; // 是否合作库
	private int ifRz; // 是否合作社
	private int ifLzb; // 是否粮账本
	private int userLevel; // 用户等级

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIfHzk() {
		return ifHzk;
	}

	public void setIfHzk(int ifHzk) {
		this.ifHzk = ifHzk;
	}

	public int getIfRz() {
		return ifRz;
	}

	public void setIfRz(int ifRz) {
		this.ifRz = ifRz;
	}

	public int getIfLzb() {
		return ifLzb;
	}

	public void setIfLzb(int ifLzb) {
		this.ifLzb = ifLzb;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

}
