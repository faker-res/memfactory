/**
 * 
 */
package com.memfactory.utils;

import org.junit.Test;

import com.memfactory.utils.jdbc.util.DataSourceUtil;

/**
 * @author zhairp createDate: 2018-09-14
 */
public class DataSourceUtilTest {

	@Test
	public void resolveDataSourceTest() {
		System.out.println(DataSourceUtil.resolveDataSource());
	}

	@Test
	public void resolveActiveProfileTest() {
		System.out.println(DataSourceUtil.resolveActiveProfile());
	}

}
