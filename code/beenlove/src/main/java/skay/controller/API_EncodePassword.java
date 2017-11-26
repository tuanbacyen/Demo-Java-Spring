package skay.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class API_EncodePassword {

	private static String md5(String str){
		String result = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			BigInteger bigInteger = new BigInteger(1,digest.digest());
			result = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String enCode(String str) {
		String newStr = md5(str);
		String newPass = newStr.substring(0, 4) + newStr.substring(newStr.length() - 4, newStr.length());
		String reverse = new StringBuffer(newPass).reverse().toString();
		return md5(reverse);
	}
}
