package com.mlb.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.net.ssl.SSLContext;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.mlb.bo.RedpackRecord;

public class WXHelper {

	public WXHelper() {
	}

	public static final String jsUrl = "http://wxmlb.wvagri.com";

	// private static final String appid = "wx9e2f83a233e6a791";
	// private static final String appid = "wx3dc6933e9273e98a";
	// private static final String appid = "wxc1697ace2f1817a7";//卖粮宝1
	// private static final String appsecret =
	// "16be511a613206c45917d3f06b8dfc79";

	// public static final String appid = "wxc1697ace2f1817a7";// 卖粮宝
	// public static final String appsecret =
	// "27d384adf6b5ecb3c85855ced25fdfc4";// 卖粮宝

	// public static final String appid = "wx921ace7cef816326"; // 卖粮宝1
	// public static final String appsecret =
	// "1402ef1d2a2ba34715ed4b56dc71bdb6";// 卖粮宝1

	public static final String appid = MlbConstant.appId; // 卖粮宝1
	public static final String appsecret = MlbConstant.appSecret;// 卖粮宝1

	// private static final String appsecret =
	// "27d384adf6b5ecb3c85855ced25fdfc4";//卖粮宝1
	// private static final String appsecret =
	// "c0a228b431a0437adb8b6f141151f16f";

	public static final String MCH_ID = "1340852801"; // 商户号
	public static final String NICK_NAME = "wanweiboshi"; // 提供方名称
	public static final String SEND_NAME = "卖粮宝"; // 商户名称
	public static final int TOTAL_NUM = 1; // 红包发放人数
	public static final String WISHING = "恭喜红包开发成功"; // 红包祝福语
	public static final String CLIENT_IP = "101.200.172.58"; // 调用接口的机器IP
	public static final String ACT_NAME = "内部测试"; // 活动名称
	public static final String REMARK = "内部测试"; // 备注
	public static final String KEY = ""; // 秘钥

	private static String token = null;
	private static Date tokenDate = null;
	private static String ticket = null;
	private static Date ticketDate = null;

	public static String getAccessToken() {
		if (token != null) {
			Date d = new Date();
			if (d.getTime() - tokenDate.getTime() < 7000 * 1000) {
				return token;
			} else {
				token = null;
				tokenDate = null;
			}
		}
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=";
		url += appid + "&secret=" + appsecret;
		String newtoken = null;
		try {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			HttpResponse resp = httpclient.execute(httpget);
			int retcode = resp.getStatusLine().getStatusCode();
			// System.out.println("getAccessToken--->retcode:" + retcode);
			HttpEntity entity = resp.getEntity();
			String s = EntityUtils.toString(entity);
			// System.out.println(s);
			httpclient.getConnectionManager().shutdown();
			JSONObject obj = JSONObject.fromObject(s);
			if (obj != null) {
				newtoken = obj.getString("access_token");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		token = newtoken;
		tokenDate = new Date();
		return newtoken;
	}

	public static String getJSAPITicket(String token) {
		if (ticket != null) {
			Date d = new Date();
			if (d.getTime() - ticketDate.getTime() < 7000 * 1000) {
				return ticket;
			} else {
				ticket = null;
				ticketDate = null;
			}
		}
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=";
		url += token + "&type=jsapi";
		String newticket = null;
		try {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			HttpResponse resp = httpclient.execute(httpget);
			int retcode = resp.getStatusLine().getStatusCode();
			// System.out.println("getJSAPITicket--->retcode:" + retcode);
			HttpEntity entity = resp.getEntity();
			String s = EntityUtils.toString(entity);
			// System.out.println(s);
			httpclient.getConnectionManager().shutdown();
			JSONObject obj = JSONObject.fromObject(s);
			if (obj != null) {
				newticket = obj.getString("ticket");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ticket = newticket;
		ticketDate = new Date();
		return newticket;
	}

	@SuppressWarnings("resource")
	public static JSONObject getWXAccessToken(String code) {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid;
		url += "&secret=" + appsecret + "&code=" + code;
		url += "&grant_type=authorization_code";
		JSONObject obj = null;
		try {

			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(url);
			HttpResponse resp = httpclient.execute(httppost);
			int retcode = resp.getStatusLine().getStatusCode();
			// System.out.println("getOpenIDByCode--->retcode:" + retcode);
			HttpEntity entity = resp.getEntity();
			String s = EntityUtils.toString(entity);
			// System.out.println(s);
			httpclient.getConnectionManager().shutdown();
			obj = JSONObject.fromObject(s);
			// System.out.println(obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static JSONObject getWXUserInfo(String openid, String accessToken) {
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openid;
		JSONObject obj = null;
		try {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(url);
			HttpResponse resp = httpclient.execute(httppost);
			int retcode = resp.getStatusLine().getStatusCode();
			// System.out.println("getOpenIDByCode--->retcode:" + retcode);
			HttpEntity entity = resp.getEntity();
			String s = EntityUtils.toString(entity, "utf-8");
			// System.out.println(s);
			httpclient.getConnectionManager().shutdown();
			obj = JSONObject.fromObject(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static void sign(SortedMap<String, String> params) {
		Set<Entry<String, String>> entrys = params.entrySet();
		Iterator<Entry<String, String>> it = entrys.iterator();
		StringBuffer result = new StringBuffer();
		List<String> temp = new ArrayList<String>();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			temp.add(entry.getKey() + "=" + entry.getValue());
			// System.out.println(entry.getKey() + "=" + entry.getValue());
			// result.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		Collections.sort(temp);
		for (String item : temp) {
			result.append(item).append("&");
		}
		// System.out.println("sign===>" + result.toString());
		result.append("key=").append(appsecret);
		String s = DigestUtils.md5Hex(result.toString()).toUpperCase();
		// System.out.println(s);
		params.put("sign", s);
	}

	// public static String getSign(Object o) throws IllegalAccessException {
	// ArrayList<String> list = new ArrayList<String>();
	// Class cls = o.getClass();
	// Field[] fields = cls.getDeclaredFields();
	// for (Field f : fields) {
	// f.setAccessible(true);
	// if (f.get(o) != null && f.get(o) != "") {
	// list.add(f.getName() + "=" + f.get(o) + "&");
	// }
	// }
	// int size = list.size();
	// String [] arrayToSort = list.toArray(new String[size]);
	// Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
	// StringBuilder sb = new StringBuilder();
	// for(int i = 0; i < size; i ++) {
	// sb.append(arrayToSort[i]);
	// }
	// String result = sb.toString();
	// result += "key=" + Configure.getKey();
	// result = MD5.MD5Encode(result).toUpperCase();
	// return result;
	// }
	public static String getRequestXml(SortedMap<String, String> params) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set es = params.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			// if ("nick_name".equalsIgnoreCase(k) ||
			// "send_name".equalsIgnoreCase(k) || "wishing".equalsIgnoreCase(k)
			// || "act_name".equalsIgnoreCase(k) || "remark".equalsIgnoreCase(k)
			// || "sign".equalsIgnoreCase(k)) {
			sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
			// } else {
			// sb.append("<" + k + ">" + v + "</" + k + ">");
			// }
		}
		sb.append("</xml>");
		return sb.toString();
	}

	public static SortedMap<String, String> createMap(String openid, String userId, int amount) {
		SortedMap<String, String> params = new TreeMap<String, String>();
		params.put("wxappid", appid);
		params.put("nonce_str", createNonceStr());
		params.put("mch_billno", createBillNo(userId));
		params.put("mch_id", MCH_ID);
		params.put("send_name", SEND_NAME);
		params.put("re_openid", openid);
		params.put("total_amount", amount + "");
		params.put("total_num", TOTAL_NUM + "");
		params.put("wishing", WISHING);
		params.put("client_ip", CLIENT_IP);
		params.put("act_name", ACT_NAME);
		params.put("remark", REMARK);
		return params;
	}

	public static SortedMap<String, String> createMap(RedpackRecord redpack) {
		SortedMap<String, String> params = new TreeMap<String, String>();
		params.put("wxappid", appid);
		params.put("nonce_str", createNonceStr());
		params.put("mch_billno", createBillNo(redpack.getId() + ""));
		params.put("mch_id", MCH_ID);
		params.put("send_name", SEND_NAME);
		params.put("re_openid", redpack.getOpenid());
		params.put("total_amount", (int) (redpack.getAmount() * 100) + "");
		params.put("total_num", TOTAL_NUM + "");
		params.put("wishing", redpack.getWishWords());
		params.put("client_ip", CLIENT_IP);
		params.put("act_name", redpack.getActivityName());
		params.put("remark", redpack.getRemark());
		return params;
	}

	public static String createBillNo(String userId) {
		Date dt = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyymmdd");
		String nowTime = df.format(dt);
		int length = 10 - userId.length();
		return MCH_ID + nowTime + userId + getRandomNum(length);
	}

	private static String getRandomNum(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}

	public static String createNonceStr() {
		return UUID.randomUUID().toString().toUpperCase().replace("-", "");
	}

	public static String sendRedPack(String requestXML) {

		JSONObject obj = null;
		String result = "";
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream instream = new FileInputStream(new File("/usr/mlbcert/apiclient_cert.p12"));
			// FileInputStream instream = new FileInputStream(new
			// File("D:/cert/apiclient_cert.p12"));
			try {
				keyStore.load(instream, MCH_ID.toCharArray());
			} finally {
				instream.close();
			}
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, MCH_ID.toCharArray()).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack");
			StringEntity reqEntity = new StringEntity(requestXML, "utf-8");
			reqEntity.setContentType("application/x-www-form-urlencoded");
			httpPost.setEntity(reqEntity);
			HttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
				String text;
				while ((text = bufferedReader.readLine()) != null) {
					result += text;
				}
				httpclient.getConnectionManager().shutdown();
				// obj = JSONObject.fromObject(result);
				// System.out.println("redpack==>" + result);
			}
		} catch (Exception e) {
			obj = null;
		}
		return result;
	}

	public static JSONObject mySendRed(String openid, String userId, int amount) {
		SortedMap<String, String> map = createMap(openid, userId, amount);
		sign(map);
		String xml = getRequestXml(map);
		// System.out.println(xml);
		String result = sendRedPack(xml);
		Map<String, String> mapresult = parseResult(result);
		JSONObject jobj = new JSONObject();
		String resultCode = mapresult.get("result_code");
		if (resultCode != null && resultCode.equals("SUCCESS")) {
			jobj.put("success", true);
			jobj.put("message", "发放成功");
		} else {
			jobj.put("success", false);
			jobj.put("message", mapresult.get("return_msg"));
		}
		return jobj;
	}

	public static JSONObject mySendRed(RedpackRecord redPack) {
		SortedMap<String, String> map = createMap(redPack);
		sign(map);
		String xml = getRequestXml(map);
		// System.out.println(xml);
		String result = sendRedPack(xml);
		Map<String, String> mapresult = parseResult(result);
		JSONObject jobj = new JSONObject();
		String resultCode = mapresult.get("result_code");
		if (resultCode != null && resultCode.equals("SUCCESS")) {
			jobj.put("success", true);
			jobj.put("message", "发放成功");
		} else {
			jobj.put("success", false);
			jobj.put("message", mapresult.get("return_msg"));
		}
		return jobj;
	}

	/**
	 * 
	 * @Description: 获取签名加密
	 * @param @param source
	 * @param @return
	 * @return String
	 * @throws
	 * @author 常鹏飞
	 * @date 2016-6-12上午9:25:36
	 */
	public static String getSHA1Sign(String source) {
		String sign = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA1");
			digest.update(source.getBytes());
			sign = getFormattedText(digest.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sign;
	}

	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };

	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuilder buf = new StringBuilder(len * 2);
		for (int j = 0; j < len; j++) {
			buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
		}
		return buf.toString();
	}

	public static Map<String, String> parseResult(String xmlResult) {
		Map<String, String> rmap = new HashMap<String, String>();
		try {
			Document doc = DocumentHelper.parseText(xmlResult);
			Element root = doc.getRootElement();
			for (java.util.Iterator<?> i = root.elementIterator(); i.hasNext();) {
				Element e = (Element) i.next();
				String ename = e.getName();
				String value = e.getStringValue();
				rmap.put(ename, value);
				// System.out.println(ename + ":" + value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			rmap = null;
		}
		return rmap;
	}

	public static void updateAccessToken() {
		token = null;
	}

	public static void main(String[] args) {
		String s = getJSAPITicket("Cv1FGJbR_UC2RCg81Un1eyQ-w9Rn34kYwd2kpqdbYmB5FVo-0idGcWGuXXxBXrWaNTg2RUKNCaMEAlr_Txx45zOy0xERUZlbOhs2XcOeO_VO1Ct4fQP0osgquiteozF_NPZaABAQSC");
		// System.out.println(s);
	}
}
