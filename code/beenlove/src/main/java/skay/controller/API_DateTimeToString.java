package skay.controller;

import java.util.Calendar;

public class API_DateTimeToString {

	public String getNow() {
		Calendar c = Calendar.getInstance();

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		int millis = c.get(Calendar.MILLISECOND);

		return "" + year + month + day + hour + minute + second + millis;
	}

	public String getNowString() {
		Calendar c = Calendar.getInstance();

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);

		return "" + year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
	}

	public String getNewNameWithNow(String name) {
		Calendar c = Calendar.getInstance();

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		int millis = c.get(Calendar.MILLISECOND);

		return name + "_" + year + month + day + hour + minute + second + millis;
	}

}
