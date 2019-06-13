/**
 * 
 */
package com.memfactory.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.junit.Test;

/**
 * @author zhairp createDate: 2018-12-12
 */
public class DateUtilTest {

	@Test
	public void getLatelyQuarterStartAndEndDateTest() {
		System.out.println(DateUtil.getLatelyQuarterStartAndEndDate(1, "yyyy-MM-dd"));
		System.out.println(DateUtil.getLatelyQuarterStartAndEndDate(2, "yyyy-MM-dd"));
		System.out.println(DateUtil.getLatelyQuarterStartAndEndDate(6, "yyyy-MM-dd"));
	}

	@Test
	public void dateTest() {
		Map<String, Date> result = DateUtil.getLatelyQuarterStartAndEndDate(1);
		System.out.println("startDate:" + result.get("startDate"));
		System.out.println("endDate:" + result.get("endDate"));
	}

	@Test
	public void getYearAndQuarterTest() {
		Calendar calender = Calendar.getInstance();
		System.out.println(DateUtil.getYearAndQuarter(calender.getTime()));
		calender.add(Calendar.MONTH, -2);
		System.out.println(DateUtil.getYearAndQuarter(calender.getTime()));
		calender.add(Calendar.MONTH, -1);
		System.out.println(DateUtil.getYearAndQuarter(calender.getTime()));
	}

	@Test
	public void getLatelyQuarterStartAndEndQuarterTest() {
		System.out.println(DateUtil.getLatelyQuarterStartAndEndDate(1, "yyyy-MM-dd"));
		System.out.println(DateUtil.getLatelyQuarterStartAndEndQuarter(1));
		System.out.println(DateUtil.getLatelyQuarterStartAndEndDate(2, "yyyy-MM-dd"));
		System.out.println(DateUtil.getLatelyQuarterStartAndEndQuarter(2));
		System.out.println(DateUtil.getLatelyQuarterStartAndEndDate(6, "yyyy-MM-dd"));
		System.out.println(DateUtil.getLatelyQuarterStartAndEndQuarter(6));
	}

	@Test
	public void getLatelyDayTest() {
		System.out.println(DateUtil.getLatelyDayOfDay(1));
		System.out.println(DateUtil.getLatelyDayOfDay(30));
		System.out.println(DateUtil.getLatelyDayOfDay(31));
		System.out.println(DateUtil.getLatelyDayOfDay(60));
	}

	@Test
	public void getLatelyMonthOfDayTest() {
		System.out.println(DateUtil.getLatelyMonthOfDay(1));
		System.out.println(DateUtil.getLatelyMonthOfDay(3));
	}

	@Test
	public void getCurrentDateTest() {
		System.out.println(DateUtil.getCurrentDate("yyyy-MM-dd"));
		System.out.println(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		System.out.println(DateUtil.getCurrentDate("yyyy/MM/dd"));
	}

	@Test
	public void dateToStrTest() {
		System.out.println(DateUtil.dateToStr(new Date(), "yyyy-MM-dd"));
		System.out.println(DateUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(DateUtil.dateToStr(new Date(), "yyyy/MM/dd"));
	}

	@Test
	public void strToDateTest() {
		System.out.println(DateUtil.strToDate("2018-01-12", "yyyy-MM-dd"));
		System.out.println(DateUtil.strToDate("2018/01/12", "yyyy/MM/dd"));
	}

}
