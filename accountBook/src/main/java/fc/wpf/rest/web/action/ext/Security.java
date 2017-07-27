package fc.wpf.rest.web.action.ext;

import java.security.KeyPair;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fc.wpf.rest.utils.BeanFactory;
import fc.wpf.rest.utils.JsonUtils;
import fc.wpf.rest.web.bean.ReturnInfo;

@Slf4j
@Controller
@RequestMapping("/security")
public class Security {
	
	private static SecurityUtil securityUtil = (SecurityUtil) BeanFactory
			.getBean("securityUtil");
	
	@RequestMapping(value = "/key", method = RequestMethod.GET)
	@ResponseBody
	public Object genKey(HttpServletRequest req){
			KeyPair keys = null;
			try{
			if (req.getSession().getAttribute("keys") == null) {
				keys = securityUtil.generateKeypair(512);
				req.getSession().setAttribute("keys", keys);
			}else{
				keys=(KeyPair)req.getSession().getAttribute("keys");
			}

			StringBuffer output = new StringBuffer();

			String e = securityUtil.getPublicKeyExponent(keys);
			String n = securityUtil.getPublicKeyModulus(keys);
			String md = String.valueOf(securityUtil.getMaxDigits(512));

			output.append("{\"e\":\"");
			output.append(e);
			output.append("\",\"n\":\"");
			output.append(n);
			output.append("\",\"maxdigits\":\"");
			output.append(md);
			output.append("\"}");
			output.toString();
			
			return JsonUtils.toObjectNode(output.toString().replaceAll("\r", "").replaceAll("\n", "")
					.trim());
			}catch(Exception e){
				log.error("security genKey method faild!",e);
			}
			return ReturnInfo.Faild;
		
	}
}
