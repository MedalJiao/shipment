package com.otms.exercise.util;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.otms.exercise.exception.APPServerException;


public class DateFormatUtil {
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY = "yyyy";
	public static final String MM = "MM";
	public static final String DD = "dd";

	public static Date date2date(Date date, String formatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		String str = sdf.format(date);
		try {
			date = sdf.parse(str);
		} catch (Exception e) {
			return null;
		}
		return date;
	}

	public static String date2string(Date date, String formatStr) throws APPServerException{
		String strDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		try {
			strDate = sdf.format(date);
		} catch (Exception e) {
			throw new APPServerException("date2string fail");
		}
		return strDate;
	}

	public static String timestamp2string(Timestamp timestamp, String formatStr) throws APPServerException {
		String strDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		try {
			strDate = sdf.format(timestamp);
		} catch (Exception e) {
			throw new APPServerException("timestamp2string fail");
		}
		return strDate;
	}

	public static Date string2date(String dateString, String formatStr) {
		Date formateDate = null;
		DateFormat format = new SimpleDateFormat(formatStr);
		try {
			formateDate = format.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
		return formateDate;
	}

	public static Timestamp date2timestamp(Date date) {
		if (date == null)
			return null;
		return new Timestamp(date.getTime());
	}
}
