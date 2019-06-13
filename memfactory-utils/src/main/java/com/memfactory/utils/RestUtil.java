package com.memfactory.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.memfactory.pub.commom.ResponseVo;


/**
 * 
 * @author zhairp createDate: 2018-09-04
 */
public final class RestUtil {
	private static final Logger LOG = LoggerFactory.getLogger(RestUtil.class);

	private RestUtil() {
	}

	public static void write(HttpServletResponse response, String data) {
		setRespHeader(response);
		try {
			PrintWriter writer = getWriter(response);
			writer.write(data);
			flush(writer);
		} catch (IOException e) {
			LOG.error("Write response data failed.", e);
		}
	}

	public static void write(HttpServletResponse response, ResponseVo responseVo) {
		setRespHeader(response);
		try {
			PrintWriter writer = getWriter(response);
			writer.write(JsonUtil.toString(responseVo));
			flush(writer);
		} catch (IOException e) {
			LOG.error("Write response data failed.", e);
		}
	}

	public static void setRespHeader(HttpServletResponse response) {
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Method", "POST,GET");
	}

	private static PrintWriter getWriter(HttpServletResponse response) throws IOException {
		return response.getWriter();
	}

	private static void flush(PrintWriter writer) {
		writer.flush();
	}
}
