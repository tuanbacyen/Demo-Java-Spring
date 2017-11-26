package skay.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class API_CheckAll {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean checkEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public static boolean checkPath(String fileName, String splitFirtName) {
		String[] temp = fileName.split("_");
		if (temp[0].equals(splitFirtName)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkPathSercon(String fileName, String splitFirtName) {
		String[] temp = fileName.split("_");
		if (temp[2].equals(splitFirtName)) {
			return true;
		} else {
			return false;
		}
	}
}
