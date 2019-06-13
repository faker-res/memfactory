/**
 * 
 */
package com.memfactory.utils;

import java.util.List;

import org.junit.Test;

import com.memfactory.utils.xml.bean.Book;
import com.memfactory.utils.xml.util.XmlUtil;

/**
 * @author zhairp createDate: 2018-09-13
 */
public class XmlUtilTest {

	@Test
	public void getBooksTest() {
		String path = "books.xml";
		List<Book> bookList = XmlUtil.getBooks(path);
		bookList.forEach(action -> {
			System.out.println(action);
		});
	}
}
