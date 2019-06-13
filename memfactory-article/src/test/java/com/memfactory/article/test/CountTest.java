/**
 * 
 */
package com.memfactory.article.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;

/**
 * 统计分析
 * 
 * @author zhairp
 * @date 2018年8月23日
 * @since 0.0.1
 */
public class CountTest {

	public static void main(String[] args) {
		List<Stu> stus = new ArrayList<Stu>();
		stus.add(new Stu(1000L, "zhangsan", 20, new BigDecimal(100)));
		stus.add(new Stu(1002L, "lisi", 25, new BigDecimal(110.99)));
		stus.add(new Stu(1003L, "wangwu", 18, new BigDecimal(99.0009)));
		stus.add(new Stu(1004L, "wangwu", 25, new BigDecimal(130)));
		System.out.println(getMaxAge(stus));
		System.out.println("**************************************");
		System.out.println(getMaxNo(stus));
		System.out.println("**************************************");
		System.out.println(getMaxScore(stus));
	}

	public static Integer getMaxAge(List<Stu> stus) {
		IntSummaryStatistics stats = stus.stream().mapToInt(stu -> stu.getAge()).summaryStatistics();
		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());
		System.out.println("总数 : " + stats.getCount());
		return stats.getMax();
	}

	public static Long getMaxNo(List<Stu> stus) {
		LongSummaryStatistics stats = stus.stream().mapToLong(stu -> stu.getNo()).summaryStatistics();
		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());
		System.out.println("总数 : " + stats.getCount());
		return stats.getMax();
	}

	public static Double getMaxScore(List<Stu> stus) {
		DoubleSummaryStatistics stats = stus.stream().mapToDouble(stu -> stu.getScore().doubleValue()).summaryStatistics();
		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());
		System.out.println("总数 : " + stats.getCount());
		return stats.getMax();
	}

}
