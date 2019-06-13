package com.memfactory.utils.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ineunet.knife.config.AppConfig;
import com.memfactory.utils.exception.DBException;

/**
 * 数据库工具类
 * 
 * @author zhairp createDate: 2018-09-11
 */
public class DBHelper {

	/**
	 * 获取数据库连接 createDate: 2018-09-12
	 * 
	 * @return 数据库连接
	 */
	private static Connection getCon() {
		try {
			String driver = AppConfig.getString("datasource.driver"); // 数据库驱动
			String url = AppConfig.getString("datasource.url");// url
			String user = AppConfig.getString("datasource.username"); // 用户名
			String password = AppConfig.getString("datasource.password");// 密码
			Class.forName(driver); // 加载数据库驱动
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			throw new DBException("configuration file does not exist", e);
		}
	}

	/**
	 * 查询 createDate: 2018-09-12
	 * 
	 * @param sql 查询语句
	 * @return 结果集
	 */
	public static ResultSet executeQuery(String sql) {
		try {
			Connection con = getCon();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			throw new DBException("executeQuery exception", e);
		}
	}

	/**
	 * 查询 createDate: 2018-09-12
	 * 
	 * @param sql 查询语句
	 * @param obj 查询参数
	 * @return 结果集
	 */
	public static ResultSet executeQuery(String sql, Object... obj) {
		try {
			Connection con = getCon();
			PreparedStatement pstmt = con.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}
			ResultSet rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			throw new DBException("executeQuery exception", e);
		}
	}

	/**
	 * 执行增删改 createDate: 2018-09-12
	 * 
	 * @param sql 增删改语句
	 * @return 更新个数
	 */
	public static int executeNonQuery(String sql) {
		try {
			Connection con = getCon();
			Statement stmt = con.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			throw new DBException("executeNonQuery exception", e);
		}
	}

	/**
	 * 执行增删改 createDate: 2018-09-12
	 * 
	 * @param sql 增删改语句
	 * @param obj 增删改参数
	 * @return 更新个数
	 */
	public static int executeNonQuery(String sql, Object... obj) {
		try {
			Connection con = getCon();
			PreparedStatement pstmt = con.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(i + 1, obj[i]);
			}
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("executeNonQuery exception", e);
		}
	}

	/**
	 * 解析结果 createDate: 2018-09-12
	 * 
	 * @param rs ResultSet对象
	 * @return 列表
	 */
	public static List<Map<String, Object>> resolveResult(ResultSet rs) {
		try {
			List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
			Map<String, Object> row = null;
			while (rs.next()) {
				row = new HashMap<String, Object>();
				ResultSetMetaData rsMeta = rs.getMetaData();
				int columnCount = rsMeta.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					row.put(rsMeta.getColumnLabel(i), rs.getObject(i));
				}
				result.add(row);
			}
			return result;
		} catch (SQLException e) {
			throw new DBException("resolveResult exception", e);
		}
	}
}
