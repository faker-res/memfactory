/**
 * 
 */
package com.memfactory.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化工具类
 * 
 * @author zhairp createDate: 2018-09-17
 */
public class SerializeUtil {

	/**
	 * 序列化:把对象转换为字节序列createDate: 2018-09-17
	 *  
	 * @param object 对象
	 * @return 字节序列
	 */
	public static byte[] serialize(Object object) {
		try {
			// 序列化
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (IOException e) {
			throw new RuntimeException("序列化异常", e);
		}
	}

	/**
	 * 反序列化:字节序列恢复为对象
	 createDate: 2018-09-17
	 * @param bytes 字节序列
	 * @return 对象
	 */
	public static Object unserialize(byte[] bytes) {
		try {
			// 反序列化
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException("反序列化异常", e);
		}
	}
}
