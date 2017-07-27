package fc.wpf.rest.web.action.ext;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import fc.wpf.rest.utils.FConfig;

public class SecurityUtil {

	private ObjectInputStream inputStream;
	 PublicKey publicKey;
	 
	 PrivateKey privateKey;
	@PostConstruct
	public void init() {
		java.security.Security.addProvider(new BouncyCastleProvider());
		try {
			// Get Public Key
			RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(new BigInteger((FConfig.getProValue("wpfrestPublicKeyM"))),new BigInteger((FConfig.getProValue("wpfrestPublicKeyE"))));
			KeyFactory fact = KeyFactory.getInstance("RSA");
			 publicKey = fact.generatePublic(rsaPublicKeySpec);
			// Get Private Key
			RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(new BigInteger((FConfig.getProValue("wpgrestPrivateKeyM"))),new BigInteger((FConfig.getProValue("wpgrestPrivateKeyE"))));
			privateKey = fact.generatePrivate(rsaPrivateKeySpec);
		
		
		
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public KeyPair generateKeypair(int keyLength) {
		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(keyLength);
			KeyPair keyPair = kpg.generateKeyPair();

			return keyPair;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("RSA algorithm not supported", e);
		}
	}
	//TODO：系统私钥解密用
	public  String decrypt(String text) {
	    byte[] dectyptedText = null;
	    try {
	      final Cipher cipher = Cipher.getInstance("RSA/NONE/NoPadding");

	      cipher.init(Cipher.DECRYPT_MODE, privateKey);
	      dectyptedText = cipher.doFinal(hexStringToByteArray(text));

	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }

	    return new String(dectyptedText);
	  }
	//TODO：系统公钥加密用
	public String encrypt(String text) {
	    byte[] cipherText = null;
	    try {
	      final Cipher cipher = Cipher.getInstance("RSA/NONE/NoPadding");
	      cipher.init(Cipher.ENCRYPT_MODE, publicKey);
	      cipherText = cipher.doFinal(text.getBytes());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return byteArrayToHexString(cipherText);
	  }
	//TODO:web私钥解密用
	public  String decrypt(String encrypted, KeyPair keys) {
		Cipher dec;
		try {
			dec = Cipher.getInstance("RSA/NONE/NoPadding");
			dec.init(Cipher.DECRYPT_MODE, keys.getPrivate());
		} catch (GeneralSecurityException e) {
			throw new RuntimeException("RSA algorithm not supported", e);
		}
		String[] blocks = encrypted.split("\\s");
		StringBuffer result = new StringBuffer();
		try {
			for (int i = blocks.length - 1; i >= 0; i--) {
				byte[] data = hexStringToByteArray(blocks[i]);
				byte[] decryptedBlock = dec.doFinal(data);
				result.append(new String(decryptedBlock));
			}
		} catch (GeneralSecurityException e) {
			throw new RuntimeException("Decrypt error", e);
		}
		return result.reverse().toString().substring(2);
	}

	public  Map<String, String> parse(String url, String encoding) {
		try {
			String urlToParse = URLDecoder.decode(url, encoding);
			String[] params = urlToParse.split("&");
			Map<String, String> parsed = new HashMap<String, String>();
			for (int i = 0; i < params.length; i++) {
				String[] p = params[i].split("=");
				String name = p[0];
				String value = (p.length == 2) ? p[1] : null;
				parsed.put(name, value);
			}
			return parsed;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Unknown encoding.", e);
		}
	}

	public  String getPublicKeyModulus(KeyPair keyPair) {
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		return publicKey.getModulus().toString(16);
	}

	public  String getPublicKeyExponent(KeyPair keyPair) {
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		return publicKey.getPublicExponent().toString(16);
	}

	public  int getMaxDigits(int keyLength) {
		return ((keyLength * 2) / 16) + 3;
	}

	public  String byteArrayToHexString(byte[] bytes) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			result.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return result.toString();
	}

	public  byte[] hexStringToByteArray(String data) {
		int k = 0;
		byte[] results = new byte[data.length() / 2];
		for (int i = 0; i < data.length();) {
			results[k] = (byte) (Character.digit(data.charAt(i++), 16) << 4);
			results[k] += (byte) (Character.digit(data.charAt(i++), 16));
			k++;
		}
		return results;
	}


	public String toPublicKeyString() {
		KeyPair keys = generateKeypair(512);
		StringBuffer out = new StringBuffer();

		String e = getPublicKeyExponent(keys);
		String n = getPublicKeyModulus(keys);
		String md = String.valueOf(getMaxDigits(512));

		out.append("{\"e\":\"");
		out.append(e);
		out.append("\",\"n\":\"");
		out.append(n);
		out.append("\",\"maxdigits\":\"");
		out.append(md);
		out.append("\"}");

		return out.toString();
	}
	
	public static void main(String[] args) {
//		String pubPath=args[0];
//		String priPath=args[1];
		 KeyPairGenerator kpg;

		 try {
		      final KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		      keyGen.initialize(1024);
		      final KeyPair key = keyGen.generateKeyPair();
		      System.out.println(key);

//		      File privateKeyFile = new File(priPath);
//		      File publicKeyFile = new File(pubPath);

//		      if (privateKeyFile.getParentFile() != null) {
//		        privateKeyFile.getParentFile().mkdirs();
//		      }
//		      privateKeyFile.createNewFile();
//
//		      if (publicKeyFile.getParentFile() != null) {
//		        publicKeyFile.getParentFile().mkdirs();
//		      }
//		      publicKeyFile.createNewFile();
//
//		      ObjectOutputStream publicKeyOS = new ObjectOutputStream(
//		          new FileOutputStream(publicKeyFile));
//		      publicKeyOS.writeObject(key.getPublic());
//		      publicKeyOS.close();
//
//		      ObjectOutputStream privateKeyOS = new ObjectOutputStream(
//		          new FileOutputStream(privateKeyFile));
//		      privateKeyOS.writeObject(key.getPrivate());
//		      privateKeyOS.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
public static void saveToFile(String fileName, BigInteger mod, BigInteger exp) throws IOException {
    ObjectOutputStream oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
    try {
        oout.writeObject(mod);
        oout.writeObject(exp);
    } catch (Exception e) {
        throw new IOException("Unexpected error", e);
    } finally {
        oout.close();
    }
}

}