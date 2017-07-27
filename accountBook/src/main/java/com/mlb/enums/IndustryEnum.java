package com.mlb.enums;

/**
 * 
 */
public enum IndustryEnum {

	未知(0, "未知"), 粮库(1, "粮库"), 深加工厂(2, "深加工厂"), 个人(3, "个人"), 合作社(4, "合作社"), 交易商(5, "交易商");

	private IndustryEnum(int code, String name) {
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
		for (IndustryEnum c : IndustryEnum.values()) {
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