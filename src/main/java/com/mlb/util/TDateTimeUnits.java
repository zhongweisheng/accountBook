/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlb.util;

/*
 * Copyright BeiJing Xintuoyida(c) Software Co.,Ltd 2012.
 *
 *          http://www.xintuoyida.com
 *
 * @Author          Spance Wong ,Email: huangsy@xintuoyida.com
 * @Project         dwxj-new
 * @Module          dwxj-new
 * @File            com.xtyd.dwxj_xlxj.common.TDateTimeUnits/TDateTimeUnits.java
 * @LastModified    2012-53-31 07:53:18
 * @Version         12.6.2
 * @Description
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Spance
 */
public class TDateTimeUnits {

	private static final Logger logger = LoggerFactory.getLogger(TDateTimeUnits.class);
	private static final TimeZone tz = TimeZone.getTimeZone("GMT+8:00");
	private static ThreadLocal<SimpleDateFormat> defaultDateFormat = new ThreadLocal<SimpleDateFormat>();
	private static final Pattern p = Pattern.compile(
			"(\\d{1,4}[-|/]\\d{1,2}[-|/]\\d{1,2})[\\s|a-zA-Z](\\d{1,2}:\\d{1,2}:\\d{1,2})", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE);

	static {
		TimeZone.setDefault(tz);
	}

	public static boolean isLegalTimestamp(String t) {
		return t.matches("\\d{13}");
	}

	public static boolean isLegalTimeString(String t) {
		Matcher matcher = p.matcher(t);
		return matcher.find();
	}

	public static String currentTimeString() {
		Calendar cal = Calendar.getInstance(tz);
		return formatDate(cal.getTime());
	}

	public static Date getCurrentTime() {
		Calendar cal = Calendar.getInstance(tz);
		return cal.getTime();
	}

	public static String formatTimestamp(String ts) {
		long tt = 0;
		try {
			tt = Long.valueOf(ts);
		} catch (NumberFormatException ignored) {
		} finally {
			if (tt == 0 || Math.abs(System.currentTimeMillis() - tt) > 1 << 29)
				tt = System.currentTimeMillis();
		}
		Calendar cal = Calendar.getInstance(tz);
		cal.setTimeInMillis(tt);
		return formatDate(cal.getTime());

	}

	public static SimpleDateFormat getDefaultDateFormat() {
		if (null == defaultDateFormat.get()) {
			defaultDateFormat.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		}

		return defaultDateFormat.get();
	}

	public static Date parseDate(String date) {
		Date result = null;
		try {
			if (date.matches("\\d{4}-\\d{2}-\\d{2}"))
				result = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			else
				result = getDefaultDateFormat().parse(date);
		} catch (ParseException e) {
			logger.error("Can't parse {} to Date", date);
		}

		return result;
	}

	public static String formatDate(Date date) {
		return getDefaultDateFormat().format(date);
	}

	public static String formatDateNew(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	/**
	 * @param year
	 *            Year
	 * @param month
	 *            Month
	 * @param week
	 *            数字0表示整月，1-4表示每月的4个自然周，5-6表示上半月下半月
	 * @return string array.
	 */
	public static String[] getDateBetween(String year, String month, int week) {
		String[] days = new String[2];
		short day1 = 0, day2 = 0;
		boolean flag = true;
		switch (week) {
		case 0:
			day1 = 1;
			day2 = 31;
			break;
		case 1:
			day1 = 1;
			day2 = 7;
			break;
		case 2:
			day1 = 8;
			day2 = 14;
			break;
		case 3:
			day1 = 15;
			day2 = 21;
			break;
		case 4:
			day1 = 22;
			day2 = 31;
			break;
		case 5:
			day1 = 1;
			day2 = 15;
			break;
		case 6:
			day1 = 16;
			day2 = 31;
			break;
		default:
			flag = false;
			break;
		}
		if (flag) {
			String time1 = "00:00:00";
			String time2 = "23:59:59";
			days[0] = String.format("%s-%s-%02d %s", year, month, day1, time1);
			days[1] = String.format("%s-%s-%02d %s", year, month, day2, time2);
		} else {
			days = null;
		}
		return days;
	}

	/**
	 * @param year
	 *            Year
	 * @param month
	 *            Month
	 * @param _week
	 *            数字0表示整月，1-4表示每月的4个自然周，5-6表示上半月下半月
	 * @return string array.
	 */

	public static String[] getDateBetween(String year, String month, String _week) {

		int week;
		try {
			week = Integer.parseInt(_week);
			return getDateBetween(year, month, week);
		} catch (NumberFormatException ignored) {
		}
		return null;
	}

	/**
	 * @param date
	 *            格式形如"YYYYMMW"的7位，W位（数字0表示整月，1-4表示每月的4个自然周，5-6表示上半月下半月）
	 * @return string array.
	 */

	public static String[] getDateBetweenWithoutTime(String date) {
		String year, month, _week;
		if (date.matches("\\d{7}")) {
			year = date.substring(0, 4);
			month = date.substring(4, 6);
			_week = date.substring(6, 7);
			int week = Integer.parseInt(_week);
			String[] days = getDateBetween(year, month, week);
			days[0] = days[0].substring(0, 10);
			days[1] = days[1].substring(0, 10);
			return days;
		} else {
			return null;
		}
	}

	public static String endOfDay(String day) {
		day = day.contains(" ") ? day.split("\\s")[0] : day;
		return day.trim() + " 23:59:59";
	}

	public static String beforeNowMinute(int before) {
		Date d = new Date();
		d.setTime(d.getTime() - 1000 * 60 * before);
		return getDefaultDateFormat().format(d);
	}

	public static String needDateTimeStringFromString(String text) {
		try {
			List<String> matches = null;
			Matcher matcher = p.matcher(text);
			if (matcher.find() && matcher.groupCount() == 2) {
				matches = new ArrayList<String>();
				for (int i = 1; i <= matcher.groupCount(); i++) {
					String temp = matcher.group(i);
					matches.add(temp);
				}
			}
			if (matches != null && matches.size() == 2) {
				return String.format("%s %s", matches.get(0).trim(), matches.get(1).trim());
			}
		} catch (Exception ignored) {
		}
		return currentTimeString();
	}

	public static String[] todayBeginAndEnd() {
		String[] day = new String[2];
		SimpleDateFormat sdf = getDefaultDateFormat();
		String _ymd = sdf.format(new Date()).split("\\s")[0];
		day[0] = String.format("%s 00:00:00", _ymd);
		day[1] = String.format("%s 23:59:59", _ymd);
		return day;
	}

	public static String[] dayBeginAndEnd(Date date) {
		String[] day = new String[2];
		String _ymd = getDefaultDateFormat().format(date).split("\\s")[0];
		day[0] = String.format("%s 00:00:00", _ymd);
		day[1] = String.format("%s 23:59:59", _ymd);
		return day;
	}

	public static Date beginOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null)
			cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	public static Date endOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		if (date != null)
			cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	public static Date beginOfYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获得year中的month的最后一天(如:2013,12 结果为:2013-12-31)
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date beginOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获得year中的month的最后一天(如:2013,12 结果为:2013-12-31)
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date endOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 计算两个时间差
	 *
	 * @param begintime
	 * @param endtime
	 * @return
	 */
	public static long getDiffTime(String begintime, String endtime) {
		long ret = 0l;
		try {
			Date _begin = parseDate(begintime);
			Date _end = parseDate(endtime);
			long _l = (_begin.getTime() - _end.getTime());
			ret = Math.round(_l / 1000.0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static String getDateStrByMonth(int n) {
		Calendar cal = Calendar.getInstance(tz);
		cal.add(Calendar.MONTH, -n);
		String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return dateStr;
	}

	public static String getDateStrByMonth1() {
		Calendar cal = Calendar.getInstance(tz);
		String dateStr = new SimpleDateFormat("yyyy-MM").format(cal.getTime());
		return dateStr;
	}

	public static String getFirstDayOfMonth(int n) {
		Calendar cal = Calendar.getInstance(tz);
		// cal.add(Calendar.MONTH, -n);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return dateStr;
	}

	public static String getCurrentDate(int n) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, n);
		Date monday = c.getTime();
		String preMonday = sdf.format(monday);
		return preMonday;
	}

	public static String getCurrentDate(int n, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, n);
		Date monday = c.getTime();
		String preMonday = sdf.format(monday);
		return preMonday;
	}

	/**
	 * 获取某年某周的起始时间和结束时间 星期一为一周开始
	 * 
	 * @param year
	 * @param weekindex
	 * @return
	 */
	public static String[] getDayOfWeek(int year, int weekindex) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setWeekDate(year, weekindex, 1);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		c.add(Calendar.DATE, -dayOfWeek + 1); // 得到本周的第一天（周一）
		// c.add(Calendar.DATE, -dayOfWeek); // 得到本周的第一天（周日）
		String begin = sdf.format(c.getTime());
		c.add(Calendar.DATE, 6); // 得到本周的最后一天
		String end = sdf.format(c.getTime());
		String[] range = new String[2];
		range[0] = begin;
		range[1] = end;
		return range;
	}

	public static void main(String[] args) {
		getDayOfWeek(2017, 13);

		// System.out.println(getDateStrByMonth(0));
		// System.out.println(getDateStrByMonth(1));
		// System.out.println(getDateStrByMonth(-1));
		// System.out.println(beginOfMonth(2016, 2));
		// System.out.println(endOfMonth(2016, 2));
	}

	public static Map<String,List<String>> getDateWeek(Date date){
		GregorianCalendar gc = new GregorianCalendar();
		Map<String, List<String>> dateMap = new HashMap<String, List<String>>();
		List<String> str =new ArrayList<String>();
		for (int i = 6; i >= 0 ; i--) {
			gc.setTime(date);
			gc.add(3,-i);
			gc.set(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH),gc.get(Calendar.DATE));
//			System.out.println(sf.format(gc.getTime()));
			Calendar c = new GregorianCalendar();
	        c.setFirstDayOfWeek(Calendar.MONDAY);
	        c.setMinimalDaysInFirstWeek(7);
	        c.setTime(gc.getTime());
//	        System.out.println(c.get(Calendar.YEAR));
//			System.out.println(c.get(Calendar.YEAR)+"-"+c.get(Calendar.WEEK_OF_YEAR));
//	        dateMap.put(c.get(Calendar.YEAR)+"", );
	        if(dateMap.containsKey(c.get(Calendar.YEAR)+"")){
	        	str =dateMap.get(c.get(Calendar.YEAR)+"");
	        	str.add(c.get(Calendar.WEEK_OF_YEAR)+"");
	        }else{
	        	str =new ArrayList<String>();
	        	str.add(c.get(Calendar.WEEK_OF_YEAR)+"");
	        	dateMap.put(c.get(Calendar.YEAR)+"", str);
	        }
		}
		return dateMap;
	}
	
	
	public static List<String> getDateMonth(Date da){
		List<String> str =new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
        Calendar cl = Calendar.getInstance();  
        int i = 6;
        Date date = null;
        for (; i >= 0; i--) {
        	 cl.setTime( da);  
        	 cl.add(Calendar.MONTH, -i);  
             date = cl.getTime();
             str.add(sdf.format(date) );
		}
		return str;
	}
	
	
	public static String getStartDayOfWeekNo(int year,int weekNo){  
        Calendar cal = getCalendarFormYear(year);  
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);  
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String mon = month+"";
        String dy = day +"";
        if(month < 10){
        	 mon = "0"+month;
        }
        if(day < 10){
        	dy = "0" +day;
        }
        return cal.get(Calendar.YEAR) + "-" + mon + "-" +  dy;      
          
    }  
	private static Calendar getCalendarFormYear(int year){  
        Calendar cal = Calendar.getInstance();  
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);        
        cal.set(Calendar.YEAR, year);  
        return cal;  
    }  
}
