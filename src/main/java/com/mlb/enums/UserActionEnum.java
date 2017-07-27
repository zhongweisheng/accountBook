package com.mlb.enums;

/**
 * 
 */
public enum UserActionEnum {

	用户注册(1, "用户注册"), 进入菜单(2, "进入菜单"), 用户报价(3, "用户报价"), 点击订单(4, "点击订单"),

	点击拨打电话(5, "点击拨打电话"), 点击推送信息(6, "点击推送信息"), 推送浏览(7, "推送浏览"), 发送短信(8, "发送短信"),

	交换名片(9, "交换名片"), 点击推广链接(10, "点击推广链接"), 新增参考价(11, "新增参考价"), 点击个人认证(12, "点击个人认证"), 点击企业认证(13, "点击企业认证"),

	阳光采购(20, "阳光采购"), 诚信供应(21, "诚信供应"), 招标大厅(22, "招标大厅"), 采购行情(23, "采购行情"), 供应行情(24, "供应行情"),

	港口订单(25, "港口订单"), 加工厂订单(26, "加工厂订单"), 接货订单(27, "接货订单"), 饲料养殖厂(28, "饲料养殖厂"), 贸易商调粮(29, "贸易商调粮"), 其它(30, "其它"), ;

	private UserActionEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	private int code;
	private String name;

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return this.getCode() + "-" + this.getName();
	}

	public static String getName(int code) {
		String name = "";
		for (UserActionEnum c : UserActionEnum.values()) {
			if (c.getCode() == code) {
				name = c.getName();
				break;
			}
		}
		return name;
	}

	public static void main(String[] args) {
		int code = 2;
		String name = getName(code);
		System.out.println("name:" + name);
	}
}