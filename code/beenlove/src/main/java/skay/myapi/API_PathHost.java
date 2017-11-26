package skay.myapi;

public class API_PathHost {

	private static String Host = "http://192.168.2.48:8080/";

	private static String resourceImageGararelly = "resources/images/";

	private static String resourceImageEmoji = "resources/emoji/";

	private static String resourceImageConver = "resources/converimages/";

	private static String resourceImageBackGround = "resources/backgroundimages/";

	public static String getLinkGararellys() {
		return Host + resourceImageGararelly;
	}

	public static String getLinkEmojis() {
		return Host + resourceImageEmoji;
	}

	public static String getLinkConvers() {
		return Host + resourceImageConver;
	}

	public static String getLinkBackgrounds() {
		return Host + resourceImageBackGround;
	}
}
