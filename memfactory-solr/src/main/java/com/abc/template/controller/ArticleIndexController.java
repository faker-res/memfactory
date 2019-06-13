/**
 * 
 */
package com.abc.template.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.template.service.ArticleIndexService;
import com.memfactory.pub.commom.ResponseVo;
import com.memfactory.utils.Base64Util;

/**
 * 文章索引
 * 
 * @author zhairp createDate: 2018-11-12
 */
@RestController
@RequestMapping("article")
public class ArticleIndexController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private ArticleIndexService articleIndexService;

	/**
	 * 推送文章数据
	 * 
	 * @author zhairp createDate: 2018-11-13
	 * @param requestObj { "id": 1, "title": "JDK源码阅读：ByteBuffer", "picUrl":
	 *                   "http://incdn1.b0.upaiyun.com/2018/02/34b98a117bfdc631a250fd017ba8a89c.jpg",
	 *                   "content": "Buffer是Java NIO中对于缓冲区的封装。", "columnId": 1000,
	 *                   "source": "importnew", "sourceUrl":
	 *                   "http://www.importnew.com/29534.html" }
	 * @return
	 */
	@PostMapping("addArticle")
	public ResponseVo addArticle(@RequestBody String requestObj) {
		return articleIndexService.addArticle(requestObj);
	}

	/**
	 * 批量推送文章数据
	 * 
	 * @author zhairp createDate: 2018-11-13
	 * @param requestObj [{ "id": 1, "title": "JDK源码阅读：ByteBuffer", "picUrl":
	 *                   "http://incdn1.b0.upaiyun.com/2018/08/ce8d3e72fe2d2cfe168c448f77a5f2c2-1024x394.png",
	 *                   "content": "Buffer是Java NIO中对于缓冲区的封装。在Java
	 *                   BIO中，所有的读写API，都是直接使用byte数组作为缓冲区的，简单直接。但是在Java
	 *                   NIO中，缓冲区这一概念变得复杂，可能是对应Java堆中的一块内存，也可能是对应本地内存中的一块内存。而byte数组只能用来指定Java堆中的一块内存，所以Java
	 *                   NIO中设计了一个新的缓冲区抽象，涵盖了不同类型缓冲区，这个抽象就是Buffer。", "columnId":
	 *                   1000, "source": "importnew", "sourceUrl":
	 *                   "http://www.importnew.com/29473.html" }, { "id": 2,
	 *                   "title": "谈谈微信支付曝出的漏洞", "picUrl":
	 *                   "http://incdn1.b0.upaiyun.com/2018/07/100bd0024910e189930c5af7be5e677c.jpg",
	 *                   "content":
	 *                   "昨天（2018-07-04）微信支付的SDK曝出重大漏洞（XXE漏洞），通过该漏洞，攻击者可以获取服务器中目录结构、文件内容，如代码、各种私钥等。获取这些信息以后，攻击者便可以为所欲为，其中就包括众多媒体所宣传的“0元也能买买买”。",
	 *                   "columnId": 1000, "source": "importnew", "sourceUrl":
	 *                   "http://www.importnew.com/29134.html" } ]
	 * @return
	 */
	@PostMapping("batchAddArticles")
	public ResponseVo batchAddArticles(@RequestBody String requestObj) {
		return articleIndexService.batchAddArticles(requestObj);
	}

	/**
	 * 推送文章数据(前端UI或者其他系统先对请求参数编码处理)
	 * 
	 * 
	 * @author zhairp createDate: 2018-11-13
	 * @param requestObj ewoJImlkIjogMSwKCSJ0aXRsZSI6ICJKREvmupDnoIHpmIXor7vvvJpCeXRlQnVmZmVyIiwKCSJwaWNVcmwiOiAiaHR0cDovL2luY2RuMS5iMC51cGFpeXVuLmNvbS8yMDE4LzAyLzM0Yjk4YTExN2JmZGM2MzFhMjUwZmQwMTdiYThhODljLmpwZyIsCgkiY29udGVudCI6ICJCdWZmZXLmmK9KYXZhIE5JT+S4reWvueS6jue8k+WGsuWMuueahOWwgeijheOAgiIsCgkiY29sdW1uSWQiOiAxMDAwLAoJInNvdXJjZSI6ICJpbXBvcnRuZXciLAoJInNvdXJjZVVybCI6ICJodHRwOi8vd3d3LmltcG9ydG5ldy5jb20vMjk1MzQuaHRtbCIKfQ==
	 * @return
	 */
	@GetMapping("addArt")
	public ResponseVo addArt(String requestObj) {
		return articleIndexService.addArticle(Base64Util.decode(requestObj));
	}

}
