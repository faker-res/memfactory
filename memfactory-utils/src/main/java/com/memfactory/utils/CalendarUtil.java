package com.memfactory.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 * 
 * @author zhairp createDate: 2018-09-04
 */
public final class CalendarUtil {
	private static final Logger LOG = LoggerFactory.getLogger(CalendarUtil.class);

	private CalendarUtil() {
	}

	/**
	 * 获取几天前或者几天后的日期
	 * 
	 * @param amount 前或者后几天
	 * @param format 日期格式 eg.yyyy-MM-dd或者yyyy-MM-dd HH:mm:ss
	 * @return 日期字符串 eg.2018-09-03 或者 2018-09-03 11:04:55
	 */
	public static String getScheduleTime(int amount, String format) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(format);
		c.setTime(new Date());
		c.add(Calendar.DATE, amount);
		return df.format(c.getTime());
	}

}
