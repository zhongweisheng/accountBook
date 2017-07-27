package fc.wpf.rest.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LoginStatusEnum {
	
	未知错误(-9999, "未知错误", 1),
	无权限(-9998, "无权限", 1),
	无此用户(-9997, "无此用户", 1),
	格式错误(-9996, "格式错误", 1);
	

	
	/**
	 * @param type type
	 * @param code code
	 * @return BaseStatusEnum
	 */
	public static String getNameByTypeAndCode(Integer type, Integer code) {
		LoginStatusEnum names = codeMap.get(type+""+code);
		if (names != null) {
			return names.getName();
		}
		return "未知状态";
	}
	
	public static Integer getCodeByName(String name) {
		LoginStatusEnum codes = nameMap.get(name);
		if (codes != null) {
			return codes.getCode();
		}
		return null;
	}

	private static Map<String, LoginStatusEnum> codeMap;
	private static Map<String, LoginStatusEnum> nameMap;

	private LoginStatusEnum(Integer code, String name, Integer type) {
		this.code = code;
		this.name = name;
		this.type = type;
	}

	static {
		codeMap = new HashMap<String, LoginStatusEnum>();
		nameMap = new HashMap<String, LoginStatusEnum>();
		for (LoginStatusEnum type : LoginStatusEnum.values()) {
			codeMap.put(type.getType()+""+type.getCode(), type);
			nameMap.put(type.getName(), type);
		}
	}
	private Integer code;
	private String name;
	private Integer type;

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	public Integer getType() {
		return type;
	}

	public String toString() {
		return this.getCode() + "-" + this.getName() + "-" + this.getType();
	}
	
	static List<LoginStatusEnum> list ;
	
	public static LoginStatusEnum[] getValuesByType(Integer type){
		if(null==type) return null;
		list = new ArrayList<LoginStatusEnum>();
		for(LoginStatusEnum _enum : LoginStatusEnum.values()) {
			if(type==_enum.getType()) {
				list.add(_enum);
			}
		}
		return list.toArray(new LoginStatusEnum[0]);
	}
	
}