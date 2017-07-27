package fc.wpf.rest.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DecryptUtil {
	 /* to 32bit string*/
		public static String getMD5(String instr) throws UnsupportedEncodingException {  
			
			MessageDigest md5 = null;   
			try {   
			   md5 = MessageDigest.getInstance("MD5");   
			} catch (Exception e) {   
			   System.out.println(e.toString());   
			   e.printStackTrace();   
			   return "";   
			}   
			
			char[] charArray = instr.toCharArray(); 
			byte[] byteArray = new byte[charArray.length];   
			  
			for (int i = 0; i < charArray.length; i++)   
				byteArray[i] = (byte) charArray[i];   
			  
			byte[] md5Bytes = md5.digest(instr.getBytes("GB2312"));   
			  
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {   
			   int val = ((int) md5Bytes[i]) & 0xff;   
			   if (val < 16)   
				   hexValue.append("0");   
			   hexValue.append(Integer.toHexString(val));   
			}   
			  
			return hexValue.toString().toUpperCase();  
		}
		
		public static String getSHA1(String decript) {
	        try {
	            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
	            
	            digest.update(decript.getBytes());
	            byte messageDigest[] = digest.digest();
	            
	            // create hex string
	            StringBuffer hexString = new StringBuffer();
	            for (int i = 0; i < messageDigest.length; i++) {
	                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
	                if (shaHex.length() < 2) {
	                    hexString.append(0);
	                }
	                hexString.append(shaHex);
	            }
	            return hexString.toString(); 
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return "";
	    }
		
		public static String KL(String inStr) {   
			
			char[] a = inStr.toCharArray();   
			for (int i = 0; i < a.length; i++) {   
			   a[i] = (char) (a[i] ^ 't');   
			}   
			String s = new String(a);   
			return s;   
		}
		
		public static String JM(String inStr) {
			
			char[] a = inStr.toCharArray();   
			for (int i = 0; i < a.length; i++) {   
				a[i] = (char) (a[i] ^ 't');   
			}   
			String k = new String(a);   
			return k;   
		}
}
