package com.J5VA.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	public Date convertToDateSQL(Date date) {
		java.sql.Date myDate = new java.sql.Date(date.getTime());
		return myDate;
	}

	static SimpleDateFormat formater = new SimpleDateFormat();

	public static Date toDate(String date, String pattern) {
		try {
			formater.applyPattern(pattern);
			java.util.Date date1 = formater.parse(date);
			java.sql.Date myDate = new java.sql.Date(date1.getTime());
			return myDate;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
