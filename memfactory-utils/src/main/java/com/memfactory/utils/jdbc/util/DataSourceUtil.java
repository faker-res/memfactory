package com.memfactory.utils.jdbc.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.memfactory.utils.exception.DBException;
import com.memfactory.utils.jdbc.bean.DataSourceBean;

/**
 * 读取数据源配置文件的工具类
 * 
 * @author zhairp createDate: 2018-09-14
 */
public final class DataSourceUtil {
	private static final Logger LOG = LoggerFactory.getLogger(DataSourceUtil.class);
	private static final String path = "datasources.xml";

	private DataSourceUtil() {
	}

	/**
	 * 解析数据源 createDate: 2018-09-14
	 * 
	 * @return 数据源容器
	 */
	public static Map<String, DataSourceBean> resolveDataSource() {
		Map<String, DataSourceBean> map = new HashMap<String, DataSourceBean>();
		SAXReader reader = new SAXReader();
		Document document;
		try {
			document = reader.read(DataSourceUtil.class.getClassLoader().getResourceAsStream(path));
			Element root = document.getRootElement();
			Element datasources = root.element("datasources");
			Iterator iterator = datasources.elementIterator();
			while (iterator.hasNext()) {
				Element datasource = (Element) iterator.next();
				Iterator props = datasource.elementIterator();
				DataSourceBean dataSourceBean = new DataSourceBean();
				while (props.hasNext()) {
					Element prop = (Element) props.next();
					String propName = prop.getName();
					String value = prop.getStringValue();
					if ("driver".equals(propName)) {
						dataSourceBean.setDriver(value);
					} else if ("url".equals(propName)) {
						dataSourceBean.setUrl(value);
					} else if ("username".equals(propName)) {
						dataSourceBean.setUsername(value);
					} else if ("password".equals(propName)) {
						dataSourceBean.setPassword(value);
					} else if ("id".equals(propName)) {
						dataSourceBean.setId(value);
					}
				}
				map.put(dataSourceBean.getId(), dataSourceBean);
			}
			return map;
		} catch (DocumentException e) {
			throw new DBException("读取配置文件异常", e);
		}
	}

	/**
	 * 获取激活的数据源标志 createDate: 2018-09-14
	 * 
	 * @return 数据源标志 
	 */
	public static String resolveActiveProfile() {
		SAXReader reader = new SAXReader();
		Document document;
		try {
			document = reader.read(DataSourceUtil.class.getClassLoader().getResourceAsStream(path));
			Element root = document.getRootElement();
			Element datasources = root.element("activeProfiles");
			Element activeProfile = datasources.element("activeProfile");
			return activeProfile.getStringValue();
		} catch (DocumentException e) {
			throw new DBException("读取配置文件异常", e);
		}
	}

}
