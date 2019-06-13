/**
 * 
 */
package com.memfactory.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.memfactory.utils.jdbc.util.DBHelper;

/**
 * @author zhairp createDate: 2018-09-12
 */
public class DBHelperTest {

	@Test
	public void executeQueryTest() throws SQLException {
		String sql = "select count(*) as cnt from  bond_basic_info;";
		ResultSet rs = DBHelper.executeQuery(sql);
		System.out.println(rs);
		while (rs.next()) {
			System.out.println("cnt=" + rs.getInt("cnt"));
		}
	}

	@Test
	public void executeQuery2Test() throws SQLException {
		Map<String, Object> dataMap = null;
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		String sql = " select * from bond_basic_info where 1=1 and coupon_rate>=? and bond_name=? ";
		ResultSet rs = DBHelper.executeQuery(sql, new Object[] { 3.1100, "2001年记帐式(七期)国债" });
		while (rs.next()) {
			dataMap = new HashMap<String, Object>();
			System.out.println("coupon_rate=" + rs.getInt("coupon_rate"));
			ResultSetMetaData rsMeta = rs.getMetaData();
			int columnCount = rsMeta.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				dataMap.put(rsMeta.getColumnLabel(i), rs.getObject(i));
			}
			result.add(dataMap);
		}
		System.out.println("result=" + result);
	}

	@Test
	public void executeNonQueryTest() {
		String sql = " delete from bond_basic_info where id<=? ";
		DBHelper.executeNonQuery(sql, new Object[] { 6569 });
	}

	@Test
	public void resolveResultTest() {
		String sql = " select sec_uni_code,bond_name from bond_basic_info where id<=? order by id;";
		ResultSet rs = DBHelper.executeQuery(sql, new Object[] { 6584 });
		System.out.println(DBHelper.resolveResult(rs));
	}

}
