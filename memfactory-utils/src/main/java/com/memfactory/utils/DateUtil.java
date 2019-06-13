/**
 * 
 */
package com.memfactory.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 * 
 * @author zhairp createDate: 2018-12-12
 */
public final class DateUtil {
	private static Logger log = LoggerFactory.getLogger(DateUtil.class);

	private DateUtil() {
	}

	/**
	 * 获取最近N个季度的开始日期和结束日期
	 * 
	 * @author zhairp createDate: 2018-12-12
	 * @param latelyNum N个季度
	 * @return 返回的是日期对象
	 */
	public static Map<String, Date> getLatelyQuarterStartAndEndDate(int latelyNum) {
		Map<String, Date> result = new HashMap<String, Date>();
		Calendar calendar = Calendar.getInstance();
		Integer currentQuarter = (Integer) (calendar.get(Calendar.MONTH) / 3 + 1);
		calendar.set(Calendar.MONTH, (currentQuarter - 1) * 3);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		Date endDate = calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, -3 * latelyNum);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date startDate = calendar.getTime();
		result.put("startDate", startDate);
		result.put("endDate", endDate);
		return result;
	}

	/**
	 * 获取最近N个季度的开始日期和结束日期
	 * 
	 * @author zhairp createDate: 2018-12-12
	 * @param latelyNum  N个季度
	 * @param dataFormat 日期格式,eg.yyyy-MM-dd
	 * @return 返回的是日期字符串
	 */
	public static Map<String, String> getLatelyQuarterStartAndEndDate(int latelyNum, String dataFormat) {
		Map<String, Date> map = getLatelyQuarterStartAndEndDate(latelyNum);
		DateFormat df = new SimpleDateFormat(dataFormat);
		Date startDate = map.get("startDate");
		Date endDate = map.get("endDate");
		Map<String, String> result = new HashMap<String, String>();
		result.put("startDate", df.format(startDate));
		result.put("endDate", df.format(endDate));
		return result;
	}

	/**
	 * 获取最近N个季度的开始季度和结束季度
	 * 
	 * @author zhairp createDate: 2018-12-12
	 * @param latelyNum N个季度
	 * @return 返回的是季度
	 */
	public static Map<String, String> getLatelyQuarterStartAndEndQuarter(int latelyNum) {
		Map<String, Date> map = getLatelyQuarterStartAndEndDate(latelyNum);
		Date startDate = map.get("startDate");
		Date endDate = map.get("endDate");
		Map<String, String> result = new HashMap<String, String>();
		result.put("startQuarter", getYearAndQuarter(startDate));
		result.put("endQuarter", getYearAndQuarter(endDate));
		return result;
	}

	/**
	 * 获取近N天的日期
	 * 
	 * @author zhairp createDate: 2018-12-13
	 * @param dayNum 近N天
	 * @return 返回近N天的日期
	 */
	public static Date getLatelyDayOfDay(int dayNum) {
		Calendar calender = Calendar.getInstance();
		calender.set(Calendar.HOUR_OF_DAY, 0);
		calender.set(Calendar.MINUTE, 0);
		calender.set(Calendar.SECOND, 0);
		calender.set(Calendar.MILLISECOND, 0);
		calender.add(Calendar.DAY_OF_MONTH, -dayNum);
		return calender.getTime();
	}

	/**
	 * 获取近N月的日期
	 * 
	 * @author zhairp createDate: 2018-12-13
	 * @param monthNum 近N月
	 * @return 返回近N月的日期
	 */
	public static Date getLatelyMonthOfDay(int monthNum) {
		Calendar calender = Calendar.getInstance();
		calender.set(Calendar.HOUR_OF_DAY, 0);
		calender.set(Calendar.MINUTE, 0);
		calender.set(Calendar.SECOND, 0);
		calender.set(Calendar.MILLISECOND, 0);
		calender.add(Calendar.MONTH, -monthNum);
		return calender.getTime();
	}

	/**
	 * 获取日期所在的季度,格式是年份加季度
	 * 
	 * @author zhairp createDate: 2018-12-12
	 * @param date 日期对象
	 * @return 季度 eg.2018Q1
	 */
	public static String getYearAndQuarter(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer sb = new StringBuffer(calendar.get(Calendar.YEAR) + "Q");
		int currentQuarter = calendar.get(Calendar.MONTH) / 3 + 1;
		sb.append(currentQuarter);
		return sb.toString();
	}

	/**
	 * 获取当前日期
	 * 
	 * @author zhairp createDate: 2018-12-14
	 * @param dateFormat 日期格式 eg.yyyy-MM-dd
	 * @return 当前日期
	 */
	public static String getCurrentDate(String dateFormat) {
		DateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(Calendar.getInstance().getTime());
	}

	/**
	 * 日期对象转化成字符串
	 * 
	 * @author zhairp createDate: 2018-12-14
	 * @param date       日期对象
	 * @param dateFormat 日期格式 eg.yyyy-MM-dd
	 * @return 日期字符串
	 */
	public static String dateToStr(Date date, String dateFormat) {
		DateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(date);
	}

	/**
	 * 日期字符串转化成对象
	 * 
	 * @author zhairp createDate: 2018-12-14
	 * @param str        日期字符串
	 * @param dateFormat 日期格式 eg.yyyy-MM-dd
	 * @return 日期对象
	 */
	public static Date strToDate(String str, String dateFormat) {
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			return df.parse(str);
		} catch (ParseException e) {
			log.error("日期转化异常:{},str:{},dateFormat:{}", e, str, dateFormat);
			return null;
		}
	}

}
