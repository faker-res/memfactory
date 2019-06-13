package com.memfactory.utils.xml.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.memfactory.utils.xml.bean.Book;

/**
 * Xml解析工具类(DOM4j方式解析XML)
 * 
 * @author zhairp createDate: 2018-09-13
 */
public final class XmlUtil {
	private XmlUtil() {
	}

	private static List<Book> bookList = null;

	public static List<Book> getBooks(String path) {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(XmlUtil.class.getClassLoader().getResourceAsStream(path));
			Element bookstore = document.getRootElement();
			Iterator storeit = bookstore.elementIterator();
			bookList = new ArrayList<Book>();
			Book book = null;
			while (storeit.hasNext()) {
				book = new Book();
				Element bookElement = (Element) storeit.next();
				// 遍历bookElement的属性
				List<Attribute> attributes = bookElement.attributes();
				for (Attribute attribute : attributes) {
					if (attribute.getName().equals("id")) {
						String id = attribute.getValue();// System.out.println(id);
						book.setId(Integer.parseInt(id));
					}
				}
				Iterator bookit = bookElement.elementIterator();
				while (bookit.hasNext()) {
					Element child = (Element) bookit.next();
					String nodeName = child.getName();
					if (nodeName.equals("name")) {
						// System.out.println(child.getStringValue());
						String name = child.getStringValue();
						book.setName(name);
					} else if (nodeName.equals("author")) {
						String author = child.getStringValue();
						book.setAuthor(author);
					} else if (nodeName.equals("year")) {
						String year = child.getStringValue();
						book.setYear(Integer.parseInt(year));
					} else if (nodeName.equals("price")) {
						String price = child.getStringValue();
						book.setPrice(Double.parseDouble(price));
					}
				}
				bookList.add(book);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return bookList;
	}
}
