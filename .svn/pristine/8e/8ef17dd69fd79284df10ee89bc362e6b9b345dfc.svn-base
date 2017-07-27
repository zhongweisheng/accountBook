package fc.wpf.rest.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.RC4Engine;
import org.bouncycastle.crypto.params.KeyParameter;

public class RC4{
    public int[] box = new int[256];
    
    public static void main(String[] args) throws UnsupportedEncodingException {
    	
    	System.out.println(StringUtil.rc4("123456", "abcd"));
    	
		String key = "abcd";
		String logpwd = "123456";
		String rc4Encrypt = rc4(key, logpwd);
		
		// rc4 encrypt
		byte[] rc4bytes = rc4Encrypt.getBytes("gbk");
		System.out.println("rc4bytes : " + new String(rc4bytes,"gbk"));
		
		// base64 encode
		String base64Encrypt = new String(Base64.encodeBase64(rc4bytes),"gbk");
		System.out.println("base64Encrypt : " + base64Encrypt);
		base64Encrypt = "MbySa5l4e20=";
		System.out.println(base64Encrypt.equals("OaeHaJh2f2o="));
		
		// baes64 decode
		byte[] base64Decrypt = Base64.decodeBase64(base64Encrypt.getBytes("gbk"));
		System.out.println("base64Decrypt : " + new String(base64Decrypt,"gbk"));
		
		// rc4 decrypt
		System.out.println("rc4decrypt : " + drc4(key, base64Decrypt));
		
	}
    
    static String rc4(String key, String logpwd) throws UnsupportedEncodingException{
    	RC4Engine engine = new RC4Engine();
		CipherParameters parameters = new KeyParameter(key.getBytes("gbk"));
		engine.init(false, parameters);
		byte[]  bytes = new byte[logpwd.getBytes("gbk").length];
		for(int i=0;i< logpwd.getBytes("gbk").length;i++) {
			bytes[i] = engine.returnByte(logpwd.getBytes("gbk")[i]);
		}
		
		return new String(bytes,"gbk");
    }
    
    static String drc4(String key, byte[]  bytes) throws UnsupportedEncodingException{
    	RC4Engine engine = new RC4Engine();
		CipherParameters parameters = new KeyParameter(key.getBytes("gbk"));
		engine.init(false, parameters);
		for(int i=0;i< bytes.length;i++) {
			bytes[i] = engine.returnByte(bytes[i]);
		}
		
		return new String(bytes,"gbk");
    }
}