package com.mlb.util;

import java.io.Serializable;
import java.util.Set;

/**
 * 用户登录后，在session中存放信息
 * 
 * @author zhongweisheng
 * @date 2016-05-19
 */

public class SessionConfig implements Serializable {

	private static final long serialVersionUID = -784983480544269613L;

	private int userId;// 用户ID
	private int userType; // 用户类型
	private String userName;// 用户名
	private String realName;// 姓名
	private String email;// 电子邮件地址
	private String phone;// 手机号
	private String location;// 区域代码
	private String address;// 详细地址

	private int roleId;
	private int departmentId;

	private Set<Integer> rightIdsSet;
	private Set<Integer> functionIdsSet;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Set<Integer> getRightIdsSet() {
		return rightIdsSet;
	}

	public void setRightIdsSet(Set<Integer> rightIdsSet) {
		this.rightIdsSet = rightIdsSet;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Integer> getFunctionIdsSet() {
		return functionIdsSet;
	}

	public void setFunctionIdsSet(Set<Integer> functionIdsSet) {
		this.functionIdsSet = functionIdsSet;
	}

}
