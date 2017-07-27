package com.mlb.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class DateListUtil {
	private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat FORMATTER_MONTH = new SimpleDateFormat("yyyy-MM");

	public static void main(String[] args) throws ParseException {
		// getMonthList("2010-12-01", "2012-12-01");
		List<String> list = getWeekList("2016-05-03", "2016-06-01");
		System.out.println(list.size());
		List<Integer> listIndex = getWeekIndexList("2016-12-24", "2017-01-03");
		System.out.println(list.size());
		List<Integer> listDateIndex = getDateIndexList("2016-12-24", "2017-01-03");
		System.out.println(list.size());
		int weekIndex = getWeek("2017-02-26");
		System.out.println(weekIndex);
		weekIndex = getWeek("2017-02-25");
		System.out.println(weekIndex);

	}

	public static List<String> getDateList(String startDate, String endDate, boolean isDes) {
		List<String> listDes = new ArrayList<String>();
		if (endDate.length() == 7) {// 年月
			try {
				Date lastDay = getLastDayOfMonth(new SimpleDateFormat("yyyy-MM").parse(endDate));
				startDate = startDate + "-01";
				endDate = format(lastDay);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		List<String> list = getDateList(startDate, endDate);

		if (isDes) {
			for (int i = list.size() - 1; i >= 0; i--) {
				String date = list.get(i);
				// System.out.println(date);
				listDes.add(date);
			}
			return listDes;
		} else {
			return list;
		}

	}

	public static List<String> getMonthList(String startDate, String endDate, boolean isDes) {
		List<String> listDes = new ArrayList<String>();
		List<String> list = getMonthList(startDate, endDate);
		if (isDes) {
			for (int i = list.size() - 1; i >= 0; i--) {
				String date = list.get(i);
				listDes.add(date);
			}
			return listDes;
		} else {
			return list;
		}

	}

	public static String getLastNDays(int n) {
		Calendar startDay = Calendar.getInstance();
		startDay.add(Calendar.DATE, -n);
		return FORMATTER.format(startDay.getTime());
	}

	public static List<String> getDateList(String startDate, String endDate) {
		List<String> list = new ArrayList<String>();
		if (StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)) {
			return list;
		}

		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();
		try {
			startDay.setTime(FORMATTER.parse(startDate));
			endDay.setTime(FORMATTER.parse(endDate));
		} catch (ParseException e) {
		}
		// 给出的日期开始日比终了日大则不执行打印
		if (startDay.compareTo(endDay) > 0) {
			return list;
		} else if (startDay.compareTo(endDay) == 0) {
			list.add(startDate);
			return list;
		}
		// 现在打印中的日期
		Calendar currentPrintDay = startDay;
		list.add(startDate);
		while (true) {
			// 日期加一
			currentPrintDay.add(Calendar.DATE, 1);
			// 日期加一后判断是否达到终了日，达到则终止打印
			if (currentPrintDay.compareTo(endDay) == 0) {
				list.add(FORMATTER.format(currentPrintDay.getTime()));
				break;
			}
			// 打印日期
			// //System.out.println(FORMATTER.format(currentPrintDay.getTime()));
			list.add(FORMATTER.format(currentPrintDay.getTime()));
		}
		return list;
	}

	public static List<Integer> getDateIndexList(String startDate, String endDate) {
		List<Integer> list = new ArrayList<Integer>();
		if (StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)) {
			return list;
		}

		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();
		try {
			startDay.setTime(FORMATTER.parse(startDate));
			endDay.setTime(FORMATTER.parse(endDate));
		} catch (ParseException e) {
		}
		// 给出的日期开始日比终了日大则不执行打印
		if (startDay.compareTo(endDay) > 0) {
			return list;
		} else if (startDay.compareTo(endDay) == 0) {
			list.add(startDay.get(Calendar.DAY_OF_YEAR));
			return list;
		}
		// 现在打印中的日期
		Calendar currentPrintDay = startDay;
		list.add(currentPrintDay.get(Calendar.DAY_OF_YEAR));
		while (true) {
			// 日期加一
			currentPrintDay.add(Calendar.DATE, 1);
			// 日期加一后判断是否达到终了日，达到则终止打印
			if (currentPrintDay.compareTo(endDay) == 0) {
				list.add(currentPrintDay.get(Calendar.DAY_OF_YEAR));
				break;
			}
			// 打印日期
			// //System.out.println(FORMATTER.format(currentPrintDay.getTime()));
			list.add(currentPrintDay.get(Calendar.DAY_OF_YEAR));
		}
		return list;
	}

	public static List<String> getWeekList(String startDate, String endDate) {
		List<String> list = new ArrayList<String>();
		if (StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)) {
			return list;
		}

		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();
		try {
			startDay.setTime(FORMATTER.parse(startDate));
			endDay.setTime(FORMATTER.parse(endDate));
		} catch (ParseException e) {
		}
		// 给出的日期开始日比终了日大则不执行打印
		if (startDay.compareTo(endDay) > 0) {
			return list;
		} else if (startDay.compareTo(endDay) == 0) {
			list.add(startDate);
			return list;
		}
		// 现在打印中的日期
		// startDay.setFirstDayOfWeek(Calendar.SUNDAY);
		// 设置该周第一天为星期一
		startDay.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		Calendar currentPrintDay = startDay;

		list.add(FORMATTER.format(currentPrintDay.getTime()));

		while (true) {
			// 日期加一
			currentPrintDay.add(Calendar.WEEK_OF_YEAR, 1);
			// 日期加一后判断是否达到终了日，达到则终止打印
			if (currentPrintDay.compareTo(endDay) > 0) {
				list.add(FORMATTER.format(currentPrintDay.getTime()));
				break;
			}
			// 打印日期
			// System.out.println(FORMATTER.format(currentPrintDay.getTime()));
			list.add(FORMATTER.format(currentPrintDay.getTime()));
		}
		return list;
	}

	public static List<Integer> getWeekIndexList(String startDate, String endDate) {
		List<Integer> list = new ArrayList<Integer>();
		if (StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)) {
			return list;
		}

		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();
		try {
			startDay.setTime(FORMATTER.parse(startDate));
			endDay.setTime(FORMATTER.parse(endDate));
		} catch (ParseException e) {
		}
		// 给出的日期开始日比终了日大则不执行打印
		if (startDay.compareTo(endDay) > 0) {
			return list;
		} else if (startDay.compareTo(endDay) == 0) {
			list.add(startDay.get(Calendar.WEEK_OF_YEAR));
			return list;
		}
		// 现在打印中的日期
		// startDay.setFirstDayOfWeek(Calendar.SUNDAY);
		// 设置该周第一天为星期一
		startDay.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		Calendar currentPrintDay = startDay;
		list.add(currentPrintDay.get(Calendar.WEEK_OF_YEAR));
		while (true) {
			// 日期加一
			currentPrintDay.add(Calendar.WEEK_OF_YEAR, 1);
			// 日期加一后判断是否达到终了日，达到则终止打印
			if (currentPrintDay.compareTo(endDay) > 0) {
				// list.add(currentPrintDay.get(Calendar.WEEK_OF_YEAR));
				break;
			}
			// 打印日期
			// System.out.println(FORMATTER.format(currentPrintDay.getTime()));
			list.add(currentPrintDay.get(Calendar.WEEK_OF_YEAR));
		}
		return list;
	}

	public static List<String> getMonthList(String startDate, String endDate) {
		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();
		try {
			startDay.setTime(FORMATTER_MONTH.parse(startDate));
			endDay.setTime(FORMATTER_MONTH.parse(endDate));
		} catch (ParseException e) {
		}
		List<String> list = new ArrayList<String>();
		// 给出的日期开始日比终了日大则不执行打印
		if (startDay.compareTo(endDay) > 0) {
			return list;
		} else if (startDay.compareTo(endDay) == 0) {
			list.add(FORMATTER_MONTH.format(startDay.getTime()));
			return list;
		}
		// 现在打印中的日期
		Calendar currentPrintDay = startDay;
		list.add((FORMATTER_MONTH.format(currentPrintDay.getTime())));
		while (true) {
			// 日期加一
			currentPrintDay.add(Calendar.MONTH, 1);
			// 日期加一后判断是否达到终了日，达到则终止打印
			if (currentPrintDay.compareTo(endDay) == 0) {
				list.add(FORMATTER_MONTH.format(currentPrintDay.getTime()));
				break;
			}
			// 打印日期
			// //System.out.println(FORMATTER_MONTH.format(currentPrintDay.getTime()));
			list.add(FORMATTER_MONTH.format(currentPrintDay.getTime()));
		}
		return list;
	}

	public static List<Integer> getMonthIndexList(String startDate, String endDate) {
		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();
		try {
			startDay.setTime(FORMATTER_MONTH.parse(startDate));
			endDay.setTime(FORMATTER_MONTH.parse(endDate));
		} catch (ParseException e) {
		}
		List<Integer> list = new ArrayList<Integer>();
		// 给出的日期开始日比终了日大则不执行打印
		if (startDay.compareTo(endDay) > 0) {
			return list;
		} else if (startDay.compareTo(endDay) == 0) {
			list.add(startDay.get(Calendar.MONTH));
			return list;
		}
		// 现在打印中的日期
		Calendar currentPrintDay = startDay;
		list.add(currentPrintDay.get(Calendar.MONTH));
		while (true) {
			// 日期加一
			currentPrintDay.add(Calendar.MONTH, 1);
			// 日期加一后判断是否达到终了日，达到则终止打印
			if (currentPrintDay.compareTo(endDay) == 0) {
				list.add(currentPrintDay.get(Calendar.MONTH));
				break;
			}
			// 打印日期
			// //System.out.println(FORMATTER_MONTH.format(currentPrintDay.getTime()));
			list.add(currentPrintDay.get(Calendar.MONTH));
		}
		return list;
	}

	/**
	 * 得到本月第一天的日期
	 *
	 * @Methods Name getFirstDayOfMonth
	 * @return Date
	 */
	public Date getFirstDayOfMonth(Date date) {
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(date);
		cDay.set(Calendar.DAY_OF_MONTH, 1);
		// System.out.println(cDay.getTime());
		return cDay.getTime();
	}

	/**
	 * 得到本月最后一天的日期
	 *
	 * @Methods Name getLastDayOfMonth
	 * @return Date
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(date);
		cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));
		// //System.out.println(cDay.getTime());
		return cDay.getTime();
	}

	public static String format(Date d) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(d);
	}

	public static String formatLong(Date d) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (d != null) {
			return df.format(d);
		} else {
			return "&nbsp;";
		}
	}

	public static int getWeek(String startDate) {
		int list = 0;
		if (StringUtils.isEmpty(startDate)) {
			return list;
		}

		Calendar startDay = Calendar.getInstance();
		try {
			startDay.setTime(FORMATTER.parse(startDate));
			list = startDay.get(Calendar.WEEK_OF_YEAR);
		} catch (ParseException e) {
		}
		return list;
	}

	/**
	 * 根据日期字符串判断当月第几周
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static int getWeek1(String str) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 第几周
		int week = calendar.get(Calendar.WEEK_OF_MONTH);
		// 第几天，从周日开始
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		return week;
	}
	
	// 获取当前时间所在年的周数
    public static int getWeekOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);
 
        return c.get(Calendar.WEEK_OF_YEAR);
    }
}