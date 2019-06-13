/**
 * 
 */
package com.memfactory.utils.jdbc.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ineunet.knife.jdbc.JdbcDao;
import com.ineunet.knife.jdbc.impl.JdbcDaoImpl;
import com.memfactory.utils.jdbc.bean.DataSourceBean;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 数据源管理器
 * 
 * @author zhairp createDate: 2018-09-14
 */
public final class DataSourceManager {
	private static final Logger LOG = LoggerFactory.getLogger(DataSourceManager.class);
	private static Map<String, DataSourceBean> map = DataSourceUtil.resolveDataSource();
	private static String activeProfile = DataSourceUtil.resolveActiveProfile();

	private DataSourceManager() {
	}

	public static JdbcTemplate getJdbcTemplate(String profile) {
		LOG.info("current profile:{}", profile);
		DataSourceBean dataSourceBean = map.get(profile);

		/*
		 * BasicDataSource dataSource = new BasicDataSource();
		 * dataSource.setDriverClassName(dataSourceBean.getDriver());
		 * dataSource.setUrl(dataSourceBean.getUrl());
		 * dataSource.setUsername(dataSourceBean.getUsername());
		 * dataSource.setPassword(dataSourceBean.getPassword());
		 */

		/*
		 * ComboPooledDataSource dataSource = new ComboPooledDataSource(); try {
		 * dataSource.setDriverClass(dataSourceBean.getDriver());
		 * dataSource.setJdbcUrl(dataSourceBean.getUrl());
		 * dataSource.setUser(dataSourceBean.getUsername());
		 * dataSource.setPassword(dataSourceBean.getPassword());
		 * dataSource.setAutoCommitOnClose(false); dataSource.setInitialPoolSize(10);
		 * dataSource.setMinPoolSize(10); dataSource.setMaxPoolSize(100); return new
		 * JdbcTemplate(dataSource); } catch (PropertyVetoException e) { throw new
		 * RuntimeException(e); }
		 */

		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(dataSourceBean.getDriver());
		dataSource.setJdbcUrl(dataSourceBean.getUrl());
		dataSource.setUsername(dataSourceBean.getUsername());
		dataSource.setPassword(dataSourceBean.getPassword());
		// 一个连接idle状态的最大时长（毫秒），超时则被释放（retired），缺省:10分钟
		dataSource.setIdleTimeout(120000);
		// 等待连接池分配连接的最大时长（毫秒），超过这个时长还没可用的连接则发生SQLException， 缺省:30秒
		dataSource.setConnectionTimeout(10000);
		// 连接池中允许的最大连接数。缺省值：10；推荐的公式：((core_count * 2) + effective_spindle_count)
		dataSource.setMaximumPoolSize(100);
		/*
		 * 一个连接的生命时长（毫秒），超时而且没被使用则被释放（retired），缺省:30分钟，建议设置比数据库超时时长少30秒， 参考MySQL
		 * wait_timeout参数（show variables like '%timeout%';）
		 */
		dataSource.setMaxLifetime(240000);
		dataSource.setConnectionTestQuery("/* ping */ SELECT 1");
		return new JdbcTemplate(dataSource);
	}

	public static JdbcTemplate getDynamicJdbcTemplate() {
		return getJdbcTemplate(activeProfile);
	}

	public static JdbcDao getJdbcDao(String profile) {
		LOG.info("current profile:{}", profile);
		DataSourceBean dataSourceBean = map.get(profile);
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(dataSourceBean.getDriver());
		dataSource.setJdbcUrl(dataSourceBean.getUrl());
		dataSource.setUsername(dataSourceBean.getUsername());
		dataSource.setPassword(dataSourceBean.getPassword());
		dataSource.setIdleTimeout(120000);
		dataSource.setConnectionTimeout(10000);
		dataSource.setMaximumPoolSize(100);
		dataSource.setMaxLifetime(240000);
		dataSource.setConnectionTestQuery("/* ping */ SELECT 1");
		return new JdbcDaoImpl(dataSource);
	}

}
