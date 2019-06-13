/**
 * 
 */
package com.memfactory.utils;

import java.util.List;

import org.junit.Test;

/**
 * @author zhairp createDate: 2018-09-13
 */
public class ExcelUtilTest {

	@Test
	public void readExcelData() throws Exception {
		String classPath = "demo.xls";
		List<List<String>> data = ExcelUtil.readExcelData(classPath);
		data.forEach(action -> {
			System.out.println(action);
		});
	}

}
