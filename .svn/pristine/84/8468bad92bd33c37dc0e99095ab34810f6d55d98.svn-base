package com.mlb.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

public class SMSHelper {
	private static final String company = "wvagri";
	private static final String password = "wvagri2015";
	private static final String serviceURL = "http://qxt.ccme.cc/WS/";

	public SMSHelper() {
	}

	public static String sendSMS(String content, String tel) {
		String s = "ok";
		try {
			String service = "Send.aspx";
			content = content + "【卖粮宝】";
			if (tel.indexOf(';') > 0) {
				service = "BatchSend.aspx";
			} else {
				if (StringUtils.isEmpty(tel) || tel.length() != 11) {
					return "手机号码格式不正确！";
				}
			}
			String sRequestURL = serviceURL + service + "?CorpID=" + company + "&Pwd=" + password;
			String sendcontent = URLEncoder.encode(content, "GBK");
			sRequestURL += "&Content=" + sendcontent + "&Mobile=" + tel + "&Cell=&SendTime=";
			URL url = new URL(sRequestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.connect();
			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				String sResponse = br.readLine();
				int iret = Integer.parseInt(sResponse);
				if (iret < 0) {
					s = "短信发送失败！失败原因：" + sResponse;
				}
			} else {
				s = "无法访问短信服务端口。";
			}
			br.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
			s = "网络连接异常";
		}
		return s;
	}

	public static void main(String[] args) {
		SMSHelper.sendSMS(" 测试 ！ 2017-05-26 日 http://account.wvagri.com/", "13439343885");
		// SMSHelper.sendSMS(" 测试 ！ 2017-02-26 日", "13718407961");
	}
}
