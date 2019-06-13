/**
 * 
 */
package com.memfactory.utils;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;

import com.ineunet.knife.jdbc.JdbcDao;
import com.memfactory.utils.jdbc.util.DataSourceManager;

/**
 * @author zhairp createDate: 2018-09-14
 */
public class DataSourceManagerTest {

	@Test
	public void getJdbcTemplateTest() {
		System.out.println(DataSourceManager.getDynamicJdbcTemplate());
	}

	@Test
	public void getJdbcTemplate02Test() {
		System.out.println(DataSourceManager.getJdbcTemplate("dev"));
	}

	@Test
	public void queryTest() {
		JdbcTemplate jdbcTemplate = DataSourceManager.getJdbcTemplate("local");
		String sql = " select count(*) as cnt from  bond_basic_info; ";
		Long cnt = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(">>>>>>>>>>>cnt:" + cnt);
	}

	@Test
	public void query02Test() {
		JdbcDao jdbcDao = DataSourceManager.getJdbcDao("local");
		String sql = " select count(*) as cnt from  bond_basic_info; ";
		Long cnt = jdbcDao.queryForObject(sql, Long.class);
		System.out.println(">>>>>>>>>>>cnt:" + cnt);
	}

	@Test
	public void query03Test() {
		JdbcTemplate jdbcTemplate = DataSourceManager.getJdbcTemplate("local");
		String sql = " select * from bond_basic_info where 1=1 and coupon_rate>=? and bond_name=?";
		List<Map<String, Object>> data = jdbcTemplate.queryForList(sql, new Object[] { 3.1100, "2001年记帐式(七期)国债" });
		if (!CollectionUtils.isEmpty(data)) {
			data.forEach(action -> {
				System.out.println(action);
			});
		}
	}

	@Test
	public void updateTest() {
		JdbcTemplate jdbcTemplate = DataSourceManager.getJdbcTemplate("local");
		String sql = " delete from bond_basic_info where id<=? ";
		int num = jdbcTemplate.update(sql, new Object[] { 6579 });
		System.out.println(num);
	}

}
