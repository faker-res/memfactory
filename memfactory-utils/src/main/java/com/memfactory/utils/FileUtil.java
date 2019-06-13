/**
 * 
 */
package com.memfactory.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.ineunet.knife.util.StringUtils;

/**
 * 文件工具
 * 
 * @author zhairp createDate: 2018-09-21
 */
public final class FileUtil {
	private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);
	private static final String DEFAULT_UPLOAD_PARH = "E://upload/";

	private FileUtil() {
	};

	/**
	 * 文件上传
	 * 
	 * @author zhairp createDate: 2018-09-21
	 * @param file 上传的文件
	 * @param dest 文件上传在服务器的路径
	 * @return 上传结果
	 */
	public static String upload(MultipartFile file, String dest) {
		String path = StringUtils.isEmpty(dest) ? DEFAULT_UPLOAD_PARH : dest;
		String fileName = file.getOriginalFilename();
		try {
			File destFile = new File(path + fileName);
			// 保存文件
			file.transferTo(destFile);
			return "upload success";
		} catch (Exception e) {
			return "upload failed";
		}
	}
}
