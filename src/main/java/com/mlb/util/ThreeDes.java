package com.mlb.util;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.util.encoders.Base64;

/*字符串 DESede(3DES) 加密 
 * ECB模式/使用PKCS7方式填充不足位,目前给的密钥是192位 
 * 3DES（即Triple DES）是DES向AES过渡的加密算法（1999年，NIST将3-DES指定为过渡的 
 * 加密标准），是DES的一个更安全的变形。它以DES为基本模块，通过组合分组方法设计出分组加 
 * 密算法，其具体实现如下：设Ek()和Dk()代表DES算法的加密和解密过程，K代表DES算法使用的 
 * 密钥，P代表明文，C代表密表，这样， 
 * 3DES加密过程为：C=Ek3(Dk2(Ek1(P))) 
 * 3DES解密过程为：P=Dk1((EK2(Dk3(C))) 
 * */
public class ThreeDes {
	public static final String keyStr = "WanweiBoshi2017";
	/**
	 * @param args在java中调用sun公司提供的3DES加密解密算法时
	 *            ，需要使 用到$JAVA_HOME/jre/lib/目录下如下的4个jar包： jce.jar
	 *            security/US_export_policy.jar security/local_policy.jar
	 *            ext/sunjce_provider.jar
	 */

	private static final String Algorithm = "DESede"; // 定义加密算法,可用
														// DES,DESede,Blowfish

	// keybyte为加密密钥，长度为24字节
	// src为被加密的数据缓冲区（源）
	public static byte[] encryptMode(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 加密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);// 在单一方面的加密或解密
		} catch (java.security.NoSuchAlgorithmException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// keybyte为加密密钥，长度为24字节
	// src为加密后的缓冲区
	public static byte[] decryptMode(byte[] keybyte, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			// 解密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// 转换成十六进制字符串
	public static String byte2Hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
			if (n < b.length - 1)
				hs = hs + ":";
		}
		return hs.toUpperCase();
	}

	public static byte[] hex(String username) {
		String key = "test";// 关键字
		String f = DigestUtils.md5Hex(username + key);
		byte[] bkeys = new String(f).getBytes();
		byte[] enk = new byte[24];
		for (int i = 0; i < 24; i++) {
			enk[i] = bkeys[i];
		}
		return enk;
	}

	public static String encryptMode(String enkStr, String password) {
		if (StringUtils.isEmpty(enkStr)) {
			enkStr = keyStr;
		}
		byte[] enk = hex(enkStr);// 用户名
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		byte[] encoded = encryptMode(enk, password.getBytes());
		String pword = new String(Base64.encode(encoded));
		return pword;
	}

	public static String decryptMode(String enkStr, String password) {
		if (StringUtils.isEmpty(enkStr)) {
			enkStr = keyStr;
		}
		byte[] enk = hex(enkStr);// 用户名
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		byte[] reqPassword = Base64.decode(password);
		byte[] srcBytes = decryptMode(enk, reqPassword);
		String pword = new String(srcBytes);
		return pword;
	}

	public static String encryptPhone(String enkStr, String phone) {
		// String phone = "13439343885";
		if (StringUtils.isEmpty(enkStr)) {
			enkStr = keyStr;
		}
		if (StringUtils.isEmpty(phone)) {
			return "";
		}
		String temp = phone;
		// 等于11位加密
		if (phone.length() == 11) {
			// String enk = "WanweiBoshi2017";
			String middle = phone.substring(3, 7);
			String pword = ThreeDes.encryptMode(enkStr, middle);
			temp = phone.substring(0, 3) + pword + phone.substring(7, 11);
			System.out.println(":" + temp);
		}
		return temp;
	}

	public static String decryptPhone(String enkStr, String phone) {
		if (StringUtils.isEmpty(enkStr)) {
			enkStr = keyStr;
		}
		if (StringUtils.isEmpty(phone)) {
			return "";
		}
		int length = phone.length();
		String temp = phone;
		// 等于11位 不用解密 134BPIB46+KxdY=3885
		if (length > 15) {
			String middle = phone.substring(3, length - 4);
			String pword = ThreeDes.decryptMode(enkStr, middle);
			temp = phone.substring(0, 3) + pword + phone.substring(length - 4, length);
		}
		return temp;
	}

	/***
	 * 加密前的字符串:1234567 加密后的字符串:DRaJPHUCkt0= 解密后的字符串:1234567 加密前的字符串:13439343885
	 * 加密后的字符串:EQR6sBlfOUQPr4kaqFtcPA== 解密后的字符串:13439343885
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// // 添加新安全算法,如果用JCE就要把它添加进去
		// byte[] enk = hex("zeromike");// 用户名
		// Security.addProvider(new com.sun.crypto.provider.SunJCE());
		// String password = "13439343885";// 密码
		// System.out.println("加密前的字符串:" + password);
		// byte[] encoded = encryptMode(enk, password.getBytes());
		// String pword = new String(Base64.encode(encoded));
		// System.out.println("加密后的字符串:" + pword);
		//
		// byte[] reqPassword = Base64.decode(pword);
		// byte[] srcBytes = decryptMode(enk, reqPassword);
		// System.out.println("解密后的字符串:" + (new String(srcBytes)));

		String enk = "WanweiBoshi2017";
		String password = "13439343885";// 密码
		String pword = encryptMode(enk, password);
		System.out.println("加密前的字符串:" + password);
		System.out.println(("加密后的字符串:" + pword));
		String pwordAfter = decryptMode(enk, pword);
		System.out.println("解密后的字符串:" + pwordAfter);

		String phone = encryptPhone(enk, password);
		System.out.println("加密前的字符串:" + password);
		System.out.println(("加密后的字符串:" + phone));
		String dePhone = decryptPhone(enk, phone);
		System.out.println("解密后的字符串:" + dePhone);

	}
}