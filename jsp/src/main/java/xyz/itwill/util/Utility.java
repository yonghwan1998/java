package xyz.itwill.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utility {

	public static String encrypt(String passwd) {

		String encryptPassword = "";

		try {

			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

			messageDigest.update(passwd.getBytes());

			byte[] digest = messageDigest.digest();

			for (int i = 0; i < digest.length; i++) {
				encryptPassword += Integer.toHexString(digest[i] & 0xff);
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("[에러] 잘못된 암호화 알고리즘을 사용했습니다.");
		}

		return encryptPassword;

	}
}
