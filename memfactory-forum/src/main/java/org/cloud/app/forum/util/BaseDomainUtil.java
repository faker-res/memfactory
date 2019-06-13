/**
 * 
 */
package org.cloud.app.forum.util;

import org.cloud.app.forum.common.BaseDomain;

/**
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public final class BaseDomainUtil {
	private BaseDomainUtil() {
	}

	public static void setBaseDomain(BaseDomain domain) {
		String currentTime = CalendarUtil.getCurrentTime();
		domain.setCreateTime(currentTime);
		domain.setUpdateTime(currentTime);
		domain.setCreateUser("100000002");
		domain.setUpdateUser("100000002");
	}

	public static void updateBaseDomain(BaseDomain domain) {
		domain.setUpdateTime(CalendarUtil.getCurrentTime());
		domain.setUpdateUser("100000002");
	}
}
