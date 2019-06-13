package com.memfactory.utils;

import org.junit.Test;

/**
 * @author zhairp
 * @date 2018-09-03
 */
public class CalendarUtilTest {

	@Test
	public void getScheduleTimeTest() {
		System.out.println(CalendarUtil.getScheduleTime(0, "yyyy-MM-dd"));
		System.out.println(CalendarUtil.getScheduleTime(1, "yyyy-MM-dd"));
		System.out.println(CalendarUtil.getScheduleTime(-1, "yyyy-MM-dd"));
		System.out.println(CalendarUtil.getScheduleTime(0, "yyyy-MM-dd HH:mm:ss"));
		System.out.println(CalendarUtil.getScheduleTime(1, "yyyy-MM-dd HH:mm:ss"));
		System.out.println(CalendarUtil.getScheduleTime(-1, "yyyy-MM-dd HH:mm:ss"));
	}

}
