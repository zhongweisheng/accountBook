package fc.wpf.rest.web.action.ext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fc.wpf.rest.web.action.BasicCtrl;

@Slf4j
@Controller
@RequestMapping("/user")
public class EXLogin extends BasicCtrl {

//	private static FCSysUserMapper fCSysUserMapper = (FCSysUserMapper) BeanFactory
//			.getBean("fCSysUserMapper");
//
//	private static DataService mysqlDataService = (DataService) BeanFactory
//			.getBean("mysqlDataService");
//
//	private static FCSysUserRoleMapper fCSysUserRoleMapper = (FCSysUserRoleMapper) BeanFactory
//			.getBean("fCSysUserRoleMapper");
//
//	private static FCSysBusinessMapper fCSysBusinessMapper = (FCSysBusinessMapper) BeanFactory
//			.getBean("fCSysBusinessMapper");
//	
//	private static FCSysRoleMapper fCSysRoleMapper = (FCSysRoleMapper) BeanFactory
//			.getBean("fCSysRoleMapper");
//	
//	private static SecurityUtil securityUtil = (SecurityUtil) BeanFactory
//			.getBean("securityUtil");
//
//
//	@Data
//	class LoginReturn {
//		List<String> roles;
//		String username;
//		String loginname;
//		String userid;
//		String branchid;
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	@ResponseBody
//	public ReturnInfo login(HttpServletRequest req) {
//		
//		Pattern pattern = Pattern.compile("^\\w+$"); // 只要英文字母大小寫下劃線, 其餘不要
//		try {
//			String loginName = req.getParameter("loginname");
//			String password = req.getParameter("password");
//			// TODO:解密
//			String decryptedPassword = securityUtil.decrypt(password);
//			boolean fromCookie = false;
//			ObjectNode on = null;
//			try {
//				on = JsonUtils.toObjectNode(decryptedPassword);
//			} catch (Exception json) {
//				log.debug("login:" + json.getMessage());
//			}
//			if (on != null) {
//				Iterator<Entry<String, JsonNode>> fileds = on.getFields();
//				while (fileds.hasNext()) {
//					Entry<String, JsonNode> filed = fileds.next();
//					if (filed.getKey().contains("loginTime")) {
//						String value = filed.getValue().asText();
//						if (StringUtil.isNotBlank(value)) {
//							Date expire = DateUtil.getDate(
//									DateStyle.YYYY_MM_DD.getValue(), value);
//							long compareInt = DateUtil.getDaysDifference(
//									expire, new Date());
//							if (compareInt >= 7) {
//								return new ReturnInfo("error",
//										LoginStatusEnum.未知错误.getCode(),
//										LoginStatusEnum.未知错误.getName(), false);
//							}
//							fromCookie = true;
//						} else {
//							return new ReturnInfo("error",
//									LoginStatusEnum.未知错误.getCode(),
//									LoginStatusEnum.未知错误.getName(), false);
//						}
//					}
//					if (filed.getKey().contains("pwd")) {
//						String value = filed.getValue().asText();
//						decryptedPassword = value;
//					}
//					if (filed.getKey().contains("name")) {
//						String value = filed.getValue().asText();
//						if(!loginName.equals(value)){
//							return new ReturnInfo("error", LoginStatusEnum.无此用户.getCode(), LoginStatusEnum.无此用户.getName(),false);
//						}
//					}
//				}
//			}
//
//			if (!fromCookie) {
//				KeyPair keys = (KeyPair) req.getSession().getAttribute("keys");
//				decryptedPassword = securityUtil.decrypt(password, keys);
//			}
//
//			if(StringUtil.isBlank(loginName) || StringUtil.isBlank(decryptedPassword) || !pattern.matcher(loginName).find() || !pattern.matcher(decryptedPassword).find()){
//				return new ReturnInfo("error", LoginStatusEnum.格式错误.getCode(), LoginStatusEnum.格式错误.getName(),false);
//			}
//			FCSysUserExample example = new FCSysUserExample();
//			example.createCriteria().andLoginNameEqualTo(loginName)
//					.andStatusEqualTo(BaseStatusEnum.有效.getCode());
//
//			List<FCSysUser> users = fCSysUserMapper.selectByExample(example);
//
//			if (users == null
//					|| users.size() != 1
//					|| !StringUtil.md5(decryptedPassword,null).equals(
//							users.get(0).getPassword())) {
//				return new ReturnInfo("error", LoginStatusEnum.无此用户.getCode(), LoginStatusEnum.无此用户.getName(),false);
//			}
//
//			HttpSession session = req.getSession(true);
//			FCSysUser user = users.get(0);
//			//TODO:判斷是否重複登入若重複登入註銷前一個
//			 HttpSession userSession =SessionListener.sessionContext.getSessionMap().get(user.getUserId());
//			if (userSession != null && session.getId() != userSession.getId()) {
//				try{
//				 userSession.invalidate();
//				}catch(Exception e){
//					log.debug(e.getMessage());
//				}
//				 SessionListener.sessionContext.getSessionMap().remove(user.getUserId());
//				 SessionListener.sessionContext.getSessionMap().remove(session.getId());   
//			}
//			session.setAttribute("user", user);
//			SessionListener.sessionContext.getSessionMap().put(user.getUserId(), session);
//
//			// set syscode
//			FCSysBusinessExample busiExample = new FCSysBusinessExample();
//			busiExample.createCriteria().andStatusEqualTo(
//					BaseStatusEnum.有效.getCode());
//			List<FCSysBusiness> busis = fCSysBusinessMapper
//					.selectByExample(busiExample);
//			
//			for(Iterator<FCSysBusiness> ite=busis.iterator();ite.hasNext();) {
//				int dp = ite.next().getBusinessDataPermission();
//				if(dp!=(dp&user.getDataEnviron())) {
//					ite.remove();
//				}
//			}
//			session.setAttribute("busi", busis);
//			//UserUtils.init(user, busis);//2015-05-20 Ryo
//			// get user menus
//			FCSysUserRoleExample roleEx = new FCSysUserRoleExample();
//			roleEx.createCriteria().andUserIdEqualTo(user.getUserId());
//			List<FCSysUserRole> roles = fCSysUserRoleMapper
//					.selectByExample(roleEx);
//			
//			List<String> iroles = new ArrayList<String>();
//			for (FCSysUserRole urole : roles) {
//				iroles.add(urole.getRoleId());
//			}
//			session.setAttribute("roles", iroles);
//			if(iroles.size()== 0) return new ReturnInfo("error", LoginStatusEnum.无权限.getCode(), LoginStatusEnum.无权限.getName(),false);
//			FCSysRoleExample eRoleExample = new FCSysRoleExample();
//			eRoleExample.createCriteria().andRoleIdIn(iroles);
//			List<FCSysRole> lsRoles= fCSysRoleMapper.selectByExample(eRoleExample) ;
//			session.setAttribute("lsRoles", lsRoles);
//			
//			LoginReturn lr = new LoginReturn();
//			lr.setRoles(iroles);
//			lr.setLoginname(user.getLoginName());
//			lr.setUserid("" + user.getUserId());
//			lr.setUsername(user.getUserName());
//			// fCUserMapper.insert(info);
//			String data="{\"name\":\""+user.getLoginName()+"\",\"pwd\":\""+decryptedPassword+"\",\"loginTime\":\""+DateUtil.format(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS)+"\"}";
//			String ecrypted = securityUtil.encrypt(data);
//			
////			String decryptedPassword2 = securityUtil.decrypt(ecryptedPassword);
//			session.removeAttribute("keys");
//			return new ReturnInfo(ecrypted, 0, lr, true);
//
//		} catch (Exception e) {
//			log.warn("FCUserCtrl insert error..", e);
//			return new ReturnInfo("error", LoginStatusEnum.未知错误.getCode(), "Exception:"+e.getMessage(),false);
//
//			// e.printStackTrace();
//		}
//	}
//	@RequestMapping(value = "/logout", method = RequestMethod.POST)
//	@ResponseBody
//	public ReturnInfo logout(HttpServletRequest req) {
//
//		FCSysUser user = (FCSysUser) req.getSession().getAttribute("user");
//		if (user != null) {
//			String userid = user.getUserId();
//			HttpSession userSession = SessionListener.sessionContext
//					.getSessionMap().get(userid);
//			if (userSession != null) {
//				userSession.invalidate();
//				SessionListener.sessionContext.getSessionMap().remove(userid);
//			}
//		}
//		return new ReturnInfo("success", 0, null, true);
//	}
}
