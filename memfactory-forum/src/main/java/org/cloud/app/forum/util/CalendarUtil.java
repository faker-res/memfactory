/**
 * 
 */
package org.cloud.app.forum.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.cloud.app.forum.constant.IndexConstant;

/**
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public final class CalendarUtil {
	private CalendarUtil() {
	}

	/**
	 * 返回当前时间
	 * 
	 * @return 当前时间,格式是：yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentTime() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(IndexConstant.DATE_FORMAT);
		return format.format(c.getTime());
	}

}
