package com.mlb.enums;

/**
 * image 数据库表中 目前有的类型
 * 
 * imagetype INTRE_INPIC OUTPIC INPIC INTERACTIVE OUTSYORAGE INSYORAGE
 * INTRE_OUTPIC HEADPIC TAILPIC OFFER_SELL OFFER_BUY FoodSourcePIC USER_FRONT
 * USER_LICENSE USER_PERMIT USER_WAREHOUSE USER_TOWER USER_BACK CHECK_USER_FRONT
 * 
 */
public enum ImageTypeEnum {

	商品("GOODS_INFO", "商品"), 买粮("USER_REQUIRE", "买粮"), 身份证正面("USER_FRONT", "身份证正面"), 身份证反面("USER_BACK", "身份证反面"), 本人与身份证合照(
			"USER_IDCARD", "本人与身份证合照"), 营业执照("USER_LICENSE", "营业执照"), 税务登记证("USER_TAX", "税务登记证"), 粮食收购许可证(
			"USER_PERMIT", "粮食收购许可证"), 组织机构代码证("ORG_CODE", "组织机构代码证"),

	拒收处理("REJECTION", "拒收处理"), 保理业务("FACTORING", "保理业务"), 意向订单("INTENTION", "意向订单");

	private ImageTypeEnum(String type, String name) {
		this.type = type;
		this.name = name;
	}

	private String type;
	private String name;

	public String gettype() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return this.gettype() + "-" + this.getName();
	}
}