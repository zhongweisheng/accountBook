package fc.wpf.rest.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础状态枚举类
 * 命名规则: 实体类名 + 属性名 + Enum
 * @date	2014-10-13
 */
public enum BaseStatusEnum {
	
	有效(1, "有效", 1),
	无效(0, "无效", 1),
	成功(1, "成功", 2),
	失败(0, "失败", 2),
	是(1, "是", 3),
	否(0, "否", 3),
	启用(1, "启用", 4),
	停用(0, "停用", 4);
	
	
	
	/** example 
	 * 
	 * 获取 有效  BaseStatusEnum.getNameByTypeAndCode(BaseStatusEnum.BSE_GROUP_V, 1);
	 * 获取 失败  BaseStatusEnum.getNameByTypeAndCode(BaseStatusEnum.BSE_GROUP_S, 0);
	 */
	
	/** 有效无效组变量 **/
	public final static int BSE_GROUP_V = 1;
	/** 成功失败组变量 **/
	public final static int BSE_GROUP_S = 2;
	/** 是否组变量 **/
	public final static int BSE_GROUP_Y = 3;
	/** 启用停用组变量 **/
	public final static int BSE_GROUP_U = 4;
	
	/**
	 * @param type type
	 * @param code code
	 * @return BaseStatusEnum
	 */
	public static String getNameByTypeAndCode(int type, int code) {
		BaseStatusEnum names = codeMap.get(type+""+code);
		if (names != null) {
			return names.getName();
		}
		return "未知状态";
	}
	
	public static int getCodeByName(String name) {
		BaseStatusEnum codes = nameMap.get(name);
		if (codes != null) {
			return codes.getCode();
		}
		return 0;
	}

	private static Map<String, BaseStatusEnum> codeMap;
	private static Map<String, BaseStatusEnum> nameMap;

	private BaseStatusEnum(int code, String name, int type) {
		this.code = code;
		this.name = name;
		this.type = type;
	}

	static {
		codeMap = new HashMap<String, BaseStatusEnum>();
		nameMap = new HashMap<String, BaseStatusEnum>();
		for (BaseStatusEnum type : BaseStatusEnum.values()) {
			codeMap.put(type.getType()+""+type.getCode(), type);
			nameMap.put(type.getName(), type);
		}
	}
	private int code;
	private String name;
	private int type;

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	public int getType() {
		return type;
	}

	public String toString() {
		return this.getCode() + "-" + this.getName() + "-" + this.getType();
	}
	
	static List<BaseStatusEnum> list ;
	
	public static BaseStatusEnum[] getValuesByType(int type){
		if(0==type) return null;
		list = new ArrayList<BaseStatusEnum>();
		for(BaseStatusEnum _enum : BaseStatusEnum.values()) {
			if(type==_enum.getType()) {
				list.add(_enum);
			}
		}
		return list.toArray(new BaseStatusEnum[0]);
	}
	
}