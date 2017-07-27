package com.mlb.util;

import javax.servlet.http.HttpServletRequest;

import lb.rest.user.db.entity.Mlbuser;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * session 工具类 将openId 放入session 中
 */
public class SessionUtils {

	public static final String AB_SESSION_CONFIG = "accountBookSessionConfig";
	public static final String AB_SESSION_USER_OPEN_ID = "accountbook_session_open_id";
	public static final String AB_SESSION_ID = "accountbook_session_id";

	public static final String login_session_timeout = PropertiesUtil.getProperty("login_session_timeout");

	public static String getMlbUserOpenId(HttpServletRequest request) {
		if (request.getSession().getAttribute(AB_SESSION_USER_OPEN_ID) != null) {
			return (String) request.getSession().getAttribute(AB_SESSION_USER_OPEN_ID);
		} else {
			return null;
		}
	}

	/**
	 * 得到卖粮宝session
	 * 
	 * @param request
	 * @return
	 */
	public static SessionConfig getMlbSessionConfig(HttpServletRequest request) {
		SessionConfig sessionConfig = (SessionConfig) request.getSession().getAttribute(AB_SESSION_CONFIG);
		return sessionConfig;
	}

	/**
	 * 得到session中的用户地域
	 * 
	 * @param request
	 * @return
	 */
	public static int getMlbUserLocation(HttpServletRequest request) {
		int userId = 0;
		SessionConfig sessionConfig = getMlbSessionConfig(request);
		if (sessionConfig != null) {
			userId = NumberUtils.toInt(sessionConfig.getLocation());
		}
		return userId;
	}

	/**
	 * 得到session中的用户ID
	 * 
	 * @param request
	 * @return
	 */
	public static int getMlbUserId(HttpServletRequest request) {
		int userId = 0;
		SessionConfig sessionConfig = getMlbSessionConfig(request);
		if (sessionConfig != null) {
			userId = sessionConfig.getUserId();
		}
		if (request.getParameter("userId") != null) {
			userId = NumberUtils.toInt(request.getParameter("userId"));
		}

		return userId;
	}

	public static boolean setMlbUserSession(HttpServletRequest request, Mlbuser userBean, String openId) {
		boolean success = false;
		if (userBean != null) {
			SessionConfig sessionConfig = new SessionConfig();
			sessionConfig.setUserId(userBean.getUserid());
			sessionConfig.setUserName(userBean.getLoginname());
			sessionConfig.setRealName(userBean.getTruename());
			sessionConfig.setLocation(userBean.getLocation());
			String sessionId = request.getSession().getId();
			sessionId = sessionId + "_" + userBean.getUserid();
			request.getSession().setAttribute(AB_SESSION_CONFIG, sessionConfig);
			request.getSession().setAttribute(AB_SESSION_ID, sessionId);
			if (StringUtils.isNotEmpty(openId)) {
				request.getSession().setAttribute(AB_SESSION_USER_OPEN_ID, openId);
			} else {
				request.getSession().setAttribute(AB_SESSION_USER_OPEN_ID, userBean.getOpenid());
			}
			success = true;
		}

		return success;
	}

	private static final int session_timeout = 4 * 60 * 60; // 单位 秒 60*60 一个小时

	public static boolean setAbSessionConfig(HttpServletRequest request, SessionConfig sessionConfig) {
		boolean success = false;
		int timeOut = session_timeout;
		String fromWeixin = request.getParameter("CHANNAL_TYPE_CHECK");
		int setLoginTimeout = NumberUtils.toInt(login_session_timeout);
		if (setLoginTimeout > 0) {
			timeOut = setLoginTimeout;
		}

		if ("WEIXIN".equalsIgnoreCase(fromWeixin)) {
			timeOut = -1;
		}
		request.getSession().setMaxInactiveInterval(timeOut);// 以秒为单位
		request.getSession().setAttribute(SessionUtils.AB_SESSION_CONFIG, sessionConfig);
		if (sessionConfig != null) {
			String sessionId = request.getSession().getId();
			sessionId = sessionId + "_" + sessionConfig.getUserId();
			request.getSession().setAttribute(AB_SESSION_ID, sessionId);
			success = true;
		}
		return success;
	}

	public static void main(String[] args) {
	}
}
