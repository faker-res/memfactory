/**
 * 
 */
package com.memfactory.utils.redis;

import java.util.Set;

/**
 * @author zhairp createDate: 2018-09-18
 */
public interface IJedis {

	// 设置key
	public boolean setnx(final String key, final String value);

	// 设置key
	public void set(String key, Object value);

	// 设置key
	public void set(String key, String value);

	// 设置key
	public void set(String key, String value, int liveTime);

	// 设置key
	public void set(byte[] key, byte[] value, int liveTime);

	// 检查key是否已经存在
	public boolean exists(String key);

	// 根据key获取值
	public String get(final String key);

	// 根据key获取值
	public Object get(final byte[] key);

	// 通过key删除
	public boolean del(final String key);

	// 通过key删除
	public boolean del(final byte[] key);

	// 清空redis 所有数据
	public boolean flushDB();

	// 检查是否连接成功
	public String ping();

	// 查看redis里有多少数据
	public Long dbSize();

	// 通过正则匹配keys
	public Set<String> keys(final String pattern);

}
