/**
 * 
 */
package com.memfactory.article.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhairp createDate: 2018-11-22
 */
public class ListTest {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Test
	public void filterTest() {
//		List<String> words1 = Arrays.asList(new String[] { "abc", "John", "zhangsan" });
		List<String> words = new ArrayList<String>();
		words.add("abc");
		words.add("John");
		words.add("zhangsan");
		log.info("source words:{}", words);
		Iterator<String> iterator = words.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			if (element.contains("abc")) {
				iterator.remove();
			}
		}
		log.info("target words:{}", words);
	}

	@Test
	public void filterTest2() {
		List<String> words = new ArrayList<String>();
		words.add("abc");
		words.add("John");
		words.add("zhangsan");
		log.info("source words:{}", words);
		words.remove("abc");
		log.info("target words:{}", words);
	}

}
