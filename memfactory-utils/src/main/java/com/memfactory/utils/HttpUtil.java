package com.memfactory.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Http工具类-支持多种方式的get请求和post请求
 * 
 * @author zhairp createDate: 2018-11-23
 */
public final class HttpUtil {
	private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	private static PoolingHttpClientConnectionManager connMgr;
	private static RequestConfig requestConfig;
	/**
	 * 超时时间，单位毫秒
	 */
	private static final int CONNECTION_REQUEST_TIMEOUT = 1000 * 10;
	// 建立连接的超时时间,多长时间没有建立连接,放弃连接
	private static final int CONNECT_TIMEOUT = 1000 * 10;
	// 获取响应数据的超时时间,多长时间没有获取响应数据,放弃连接
	private static final int SOCKET_TIMEOUT = 1000 * 10;

	static {
		// 设置连接池
		connMgr = new PoolingHttpClientConnectionManager();
		// 设置连接池大小
		connMgr.setMaxTotal(100);
		connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

		RequestConfig.Builder configBuilder = RequestConfig.custom();
		// 设置连接超时
		configBuilder.setConnectTimeout(CONNECT_TIMEOUT);
		// 设置读取超时
		configBuilder.setSocketTimeout(SOCKET_TIMEOUT);
		// 设置从连接池获取连接实例的超时
		configBuilder.setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT);
		requestConfig = configBuilder.build();
	}

	public static String doGet(String url) {
		return doGet(url, new HashMap<String, Object>(), null);
	}

	public static String doGet(String url, Map<String, Object> params) {
		return doGet(url, params, null);
	}

	/**
	 * 发送 GET 请求（HTTP），K-V形式
	 * 
	 * @author zhairp createDate: 2018-11-26
	 * @param url     请求地址
	 * @param params  请求参数
	 * @param headers 请求头参数
	 * @return
	 */
	public static String doGet(String url, Map<String, Object> params, Map<String, Object> headers) {
		String apiUrl = url;
		StringBuffer param = new StringBuffer();
		int i = 0;
		if (params != null) {
			for (String key : params.keySet()) {
				if (i == 0) {
					param.append("?");
				} else {
					param.append("&");
				}
				param.append(key).append("=");

				try {
					param.append(URLEncoder.encode(params.get(key).toString(), "UTF-8"));
				} catch (Exception e) {
					param.append(params.get(key));
				}

				i++;
			}
		}
		apiUrl += param;
		String result = null;
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
			HttpGet httpGet = new HttpGet(apiUrl);
			// 超时时间起作用
			httpGet.setConfig(requestConfig);
			if (headers != null) {
				for (Map.Entry<String, Object> it : headers.entrySet()) {
					httpGet.addHeader(it.getKey(), it.getValue().toString());
				}
			}

			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				result = IOUtils.toString(instream, "UTF-8");
			}
		} catch (IOException e) {
			logger.error("doGet [{}] error. Exception:[{}]", apiUrl, e);
		}
		return result;
	}

	public static String doPost(String url) {
		return doPost(url, new HashMap<String, Object>());
	}

	public static String doPost(String url, Map<String, Object> params) {
		return doPost(url, params, null);
	}

	/**
	 * 发送 POST 请求（HTTP），K-V形式
	 * 
	 * @author zhairp createDate: 2018-11-26
	 * @param url     请求地址
	 * @param params  请求参数
	 * @param headers 请求头参数
	 * @return
	 */
	public static String doPost(String url, Map<String, Object> params, Map<String, Object> headers) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String httpStr = null;
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;

		try {
			httpPost.setConfig(requestConfig);
			List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
				pairList.add(pair);
			}
			if (headers != null) {
				for (Map.Entry<String, Object> it : headers.entrySet()) {
					httpPost.setHeader(it.getKey(), it.getValue().toString());
				}
			}
			httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			httpStr = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			logger.error("doPost [{}] error. Exception:[{}]", httpPost.toString(), e);
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					logger.error("close inputstream error. url[{}] Exception:[{}]", httpPost.toString(), e);
				}
			}
		}
		return httpStr;
	}

	public static String doPut(String url, Map<String, Object> params, Map<String, Object> headers) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String httpStr = null;
		HttpPut httpPut = new HttpPut(url);
		CloseableHttpResponse response = null;

		try {
			httpPut.setConfig(requestConfig);
			List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
				pairList.add(pair);
			}
			if (headers != null) {
				for (Map.Entry<String, Object> it : headers.entrySet()) {
					httpPut.setHeader(it.getKey(), it.getValue().toString());
				}
			}
			httpPut.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("UTF-8")));
			response = httpClient.execute(httpPut);
			HttpEntity entity = response.getEntity();
			httpStr = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			logger.error("doPut [{}] Exception:[{}].", httpPut.toString(), e);
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					logger.error("doPut [{}],close inputstream error:[{e}]", httpPut.toString(), e);
				}
			}
		}
		return httpStr;
	}

	public static String doDelete(String url, Map<String, Object> headers) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String httpStr = null;
		HttpDelete httpDelete = new HttpDelete(url);
		CloseableHttpResponse response = null;

		try {
			httpDelete.setConfig(requestConfig);
			if (headers != null) {
				for (Map.Entry<String, Object> it : headers.entrySet()) {
					httpDelete.setHeader(it.getKey(), it.getValue().toString());
				}
			}
			response = httpClient.execute(httpDelete);
			HttpEntity entity = response.getEntity();
			httpStr = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			logger.error("doDelete [{}] Exception:[{}].", httpDelete.toString(), e);
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					logger.error("doDelete [{}],close inputstream error:[{e}]", httpDelete.toString(), e);
				}
			}
		}
		return httpStr;
	}

	/**
	 * 发送 POST 请求（HTTP），JSON形式
	 * 
	 * @author zhairp createDate: 2018-11-26
	 * @param url  请求地址
	 * @param json 请求参数JSON格式
	 * @return 返回结果
	 */
	public static String doPost(String url, Object json) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String httpStr = null;
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;

		try {
			httpPost.setConfig(requestConfig);
			// 解决中文乱码问题
			StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");
			stringEntity.setContentEncoding("UTF-8");
			stringEntity.setContentType("application/json;charset=UTF-8");
			httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			httpStr = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			logger.error("doPost [{}] Exception:[{}].", httpPost.toString(), e);
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					logger.error("doPost [{}],close inputstream error:[{e}]", httpPost.toString(), e);
				}
			}
		}
		return httpStr;
	}

	/**
	 * 发送 POST 请求（HTTP），JSON形式
	 * 
	 * @author zhairp createDate: 2018-11-26
	 * @param url     请求地址
	 * @param json    请求参数JSON格式
	 * @param headers 请求头参数
	 * @return 返回结果
	 */
	public static String doPost(String url, Object json, Map<String, Object> headers) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String httpStr = null;
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;

		try {
			if (headers != null) {
				for (Map.Entry<String, Object> it : headers.entrySet()) {
					httpPost.setHeader(it.getKey(), it.getValue().toString());
				}
			}
			httpPost.setConfig(requestConfig);
			// 解决中文乱码问题
			StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");
			stringEntity.setContentEncoding("UTF-8");
			stringEntity.setContentType("application/json;charset=UTF-8");
			httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			httpStr = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			logger.error("doPost [{}] Exception:[{}].", httpPost.toString(), e);
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					logger.error("doPost [{}],close inputstream error:[{e}]", httpPost.toString(), e);
				}
			}
		}
		return httpStr;
	}

	/**
	 * 发送 SSL POST 请求（HTTPS），K-V形式
	 * 
	 * @author zhairp createDate: 2018-11-26
	 * @param url    API接口URL
	 * @param params 参数map
	 * @return 返回结果
	 */
	public static String doPostSSL(String url, Map<String, Object> params) {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		String httpStr = null;

		try {
			httpPost.setConfig(requestConfig);
			List<NameValuePair> pairList = new ArrayList<NameValuePair>(params.size());
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
				pairList.add(pair);
			}
			httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName("utf-8")));

			response = httpClient.execute(httpPost);

			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				return null;
			}
			HttpEntity entity = response.getEntity();
			if (entity == null) {
				return null;
			}
			httpStr = EntityUtils.toString(entity, "utf-8");
		} catch (Exception e) {
			logger.error("doPostSSL [{}] Exception:[{}].", httpPost.toString(), e);
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					logger.error("doPostSSL [{}],close inputstream error:[{e}]", httpPost.toString(), e);
				}
			}
		}
		return httpStr;
	}

	/**
	 * 发送 SSL POST 请求（HTTPS），JSON形式
	 * 
	 * @author zhairp createDate: 2018-11-26
	 * @param url  API接口URL
	 * @param json JSON对象
	 * @return 返回结果
	 */
	public static String doPostSSL(String url, Object json) {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		String httpStr = null;

		try {
			httpPost.setConfig(requestConfig);
			StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");
			stringEntity.setContentEncoding("UTF-8");
			stringEntity.setContentType("application/json");
			httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				return null;
			}
			HttpEntity entity = response.getEntity();
			if (entity == null) {
				return null;
			}
			httpStr = EntityUtils.toString(entity, "utf-8");
		} catch (Exception e) {
			logger.error("doPostSSL [{}] Exception:[{}].", httpPost.toString(), e);
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					logger.error("doPostSSL [{}],close inputstream error:[{e}]", httpPost.toString(), e);
				}
			}
		}
		return httpStr;
	}

	/**
	 * 发送 SSL POST 请求（HTTPS），JSON形式
	 * 
	 * @param url API接口URL
	 * @param xml JSON对象
	 * @return 返回結果
	 */
	public static String doPostSSLXml(String url, String xml) {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig).build();
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		String httpStr = null;

		try {
			httpPost.setConfig(requestConfig);
			StringEntity stringEntity = new StringEntity(xml, "UTF-8");
			stringEntity.setContentEncoding("UTF-8");
			httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				return null;
			}
			HttpEntity entity = response.getEntity();
			if (entity == null) {
				return null;
			}
			httpStr = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			logger.error("doPostSSL [{}] Exception:[{}].", httpPost.toString(), e);
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					logger.error("doPostSSL [{}],close inputstream error:[{e}]", httpPost.toString(), e);
				}
			}
		}
		return httpStr;
	}

	/**
	 * 创建SSL安全连接
	 * 
	 * @author zhairp createDate: 2018-11-26
	 * @return SSLConnectionSocketFactory实例
	 */
	@SuppressWarnings("deprecation")
	private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
		SSLContext sslcontext = null;
		try {
			sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
		} catch (Exception e) {
			logger.error("SSLConnectionSocketFactory Exception:[{}].", e);
		}
		HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, hostnameVerifier);
		return sslsf;
	}
}
