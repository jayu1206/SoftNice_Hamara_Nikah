
package com.softNice.nikah.utility;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * <p>Logic for encryption/decryption.</p>
 * 
 * @author Jayesh Gagnani
 * @version 1.0
 *
 */
public class EncrypitDecrypit {
	/**
	 * <p>decrypt an encrypted string</p>
	 * @param text
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String text,String key) throws Exception
	{
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] keyBytes= new byte[16];
		byte[] b= key.getBytes("UTF-8");
		int len= b.length;
		if (len > keyBytes.length) len = keyBytes.length;
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);

		BASE64Decoder decoder = new BASE64Decoder();
		byte [] results = cipher.doFinal(decoder.decodeBuffer(text));
		return new String(results,"UTF-8");
	}
	/**
	 * <p>Encrypt a string</p>
	 * @param text
	 * @param key
	 * @return
	 * @throws Exception
	 */
	 public static String encrypt(String text,String key) throws Exception 
	 {
		 Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		 byte[] keyBytes= new byte[16];
		 byte[] b= key.getBytes("UTF-8");
		 int len= b.length;
		 if (len > keyBytes.length) len = keyBytes.length;
		 System.arraycopy(b, 0, keyBytes, 0, len);
		 SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		 IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
		 cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);

		 byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
		 BASE64Encoder encoder = new BASE64Encoder();
		 return encoder.encode(results);
	 }



  public static void main(String args []) throws Exception{

	  String text = "jay";
	  String encrypt= encrypt(text,"password");
	  System.out.println("encrypt :"+encrypt);
	  //String decrypt= decrypt("TpVKbe2ZrWG34sayzcDw8RpMYC7NIu7XOwLn0+R4lfiiYumEroTSNbHIVw9MyPuJ");
	  String decrypt= decrypt(encrypt,"password");
	  System.out.println("decrypt :"+decrypt);
	  }
  
}
