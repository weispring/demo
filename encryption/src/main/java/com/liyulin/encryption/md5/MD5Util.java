package com.liyulin.encryption.md5;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Base64;

/**
 * 采用MD5加密解密，MD5加密算法是一种单向加密算法。
 * 
 * @author liyulin
 * @version 1.0, 07/07/2013
 */
public final class MD5Util {

	/**
	 * MD5加码 生成32位md5码
	 * @throws NoSuchAlgorithmException 
	 */
	public static String string2MD5(String inStr) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");

		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];// 获得对应字节的ASCⅡ
		}
		byte[] md5Bytes = md5.digest(byteArray);// 通过执行诸如填充之类的最终操作完成哈希计算
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 6) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	/**
	 * 加密解密算法，执行一次加密，两次解密
	 */
	public static String convertMD5(String inStr) {
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 'a');
		}
		return new String(a);
	}


	/**
	 * 非jdk提供的算法，需要自己添加进去
	 * @param inStr
	 * @return
	 */

	public static void bcMd5(String inStr) throws Exception{
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest md4 = MessageDigest.getInstance("MD4");
		String digest = Base64.getEncoder().encodeToString(md4.digest("dajandoajdjdnao".getBytes()));
		System.out.print(digest);
	}




	public static void main(String[] args) throws Exception {
		bcMd5("");
	}
}