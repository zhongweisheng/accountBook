package fc.wpf.rest.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fc.wpf.rest.utils.StringUtil;

@Controller
@RequestMapping("/baseenums")
public class BaseEnumsCtrl {
	private List<Map<String,String>> readEnum(String url, String type)
			throws ClassNotFoundException {
		Class<?> c = Class.forName(url);
		Object[] objs = c.getEnumConstants();
		List<Map<String,String>> lstEnum = new ArrayList<Map<String,String>>();
		for (Object obj : objs) {
			String[] cEnum = obj.toString().split("-");
			if (cEnum.length > 2 && StringUtil.isNotBlank(type)) {
				if (cEnum[2].equalsIgnoreCase(type)) {
					Map<String,String> map = new HashMap<String,String>();
					map.put(cEnum[0], cEnum[1]);
					lstEnum.add(map);
				}
			} else {
				Map<String,String> map = new HashMap<String,String>();
				map.put(cEnum[0], cEnum[1]);
				lstEnum.add(map);
			}

		}
		return lstEnum;
	}

	public List<Map<String,String>> readEnum(String url) throws ClassNotFoundException {
		Class<?> c = Class.forName(url);
		Object[] objs = c.getEnumConstants();
		List<Map<String,String>> lstEnum = new ArrayList<Map<String,String>>();
		for (Object obj : objs) {
			String[] cEnum = obj.toString().split("-");
			Map<String,String> map = new HashMap<String,String>();
			map.put(cEnum[0], cEnum[1]);
			lstEnum.add(map);
		}
		return lstEnum;
	}

	// 有效 or无效
	@RequestMapping(value = "/validAndInefficacyReverse", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> validAndInefficacyReverse(HttpServletRequest req)
			throws ClassNotFoundException {

		return readEnum("fc.wpf.rest.enums.BaseStatusEnum", "1");

	}

	// 成功or失败
	@RequestMapping(value = "/successAndFailReverse", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> successAndFailReverse(HttpServletRequest req)
			throws ClassNotFoundException {

		return readEnum("fc.wpf.rest.enums.BaseStatusEnum", "2");

	}

	// 是or否
	@RequestMapping(value = "/isAndNotReverse", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> isAndNotReverse(HttpServletRequest req)
			throws ClassNotFoundException {

		return readEnum("fc.wpf.rest.enums.BaseStatusEnum", "3");

	}

	// 启用or停用
	@RequestMapping(value = "/enableAndDisEnableReverse", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,String>> enableAndDisEnableReverse(HttpServletRequest req)
			throws ClassNotFoundException {

		return readEnum("fc.wpf.rest.enums.BaseStatusEnum", "4");

	}

}
