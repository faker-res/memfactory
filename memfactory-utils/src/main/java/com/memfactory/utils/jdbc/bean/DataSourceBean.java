/**
 * 
 */
package com.memfactory.utils.jdbc.bean;

/**
 * 数据源连接信息
 * 
 * @author zhairp createDate: 2018-09-14
 */
public class DataSourceBean {
	private String driver;
	private String url;
	private String username;
	private String password;
	private String id;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DataSourceBean [driver=" + driver + ", url=" + url + ", username=" + username + ", password=" + password + ", id=" + id + "]";
	}

}
