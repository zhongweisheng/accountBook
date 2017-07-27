package fc.wpf.rest.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/service")
@Slf4j
public class ServiceDispatch {

//	private NotificationService notificationService;

	// 远端发送
	@RequestMapping(value = "/notification", method = RequestMethod.POST)
	@ResponseBody
	public Object post(HttpServletRequest req, HttpServletResponse resp) {return null;}
}
