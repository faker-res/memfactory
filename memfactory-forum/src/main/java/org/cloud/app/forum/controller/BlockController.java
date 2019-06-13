/**
 * 
 */
package org.cloud.app.forum.controller;

import javax.servlet.http.HttpServletResponse;

import org.cloud.app.forum.bean.TDotaBlockTd;
import org.cloud.app.forum.common.ResponseVo;
import org.cloud.app.forum.service.BlockService;
import org.cloud.app.forum.util.HttpResponseUtil;
import org.cloud.app.forum.util.ResponseVoUtil;
import org.cloud.app.forum.vo.BlockInputVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版块类
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
@RestController
@RequestMapping("/block")
public class BlockController {
	private static final Logger log = LoggerFactory.getLogger(BlockController.class);

	@Autowired
	private BlockService blockService;

	/**
	 * 查询版块列表
	 * 
	 * @param input
	 * @return
	 */
	@RequestMapping("getBlockList")
	public ResponseVo getBlockList(BlockInputVo input, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(blockService.getBlockList(input));
	}

	/**
	 * 新增版块
	 * 
	 * @param block
	 * @return
	 */
	@RequestMapping("addBlock")
	public ResponseVo addBlock(TDotaBlockTd block, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		log.info(">>>>>>>>>>>>>>addBlock:{}", block.toString());
		blockService.addBlock(block);
		return ResponseVoUtil.getDefaultResponse();
	}

	/**
	 * 获取版块信息
	 * 
	 * @param blockId
	 * @return
	 */
	@RequestMapping("getBlock")
	public ResponseVo getBlock(Integer blockId, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(blockService.getBlock(blockId));
	}

	/**
	 * 修改版块
	 * 
	 * @param block
	 * @return
	 */
	@RequestMapping("updateBlcok")
	public ResponseVo updateBlcok(TDotaBlockTd block, HttpServletResponse response) {
		HttpResponseUtil.response(response);
		blockService.updateBlcok(block);
		return ResponseVoUtil.getDefaultResponse();
	}

	/**
	 * 获取系统所有版块，用于过滤帖子
	 * 
	 * @param block
	 * @return
	 */
	@RequestMapping("getAllBlocks")
	public ResponseVo getAllBlocks(HttpServletResponse response) {
		HttpResponseUtil.response(response);
		return ResponseVoUtil.getResponse(blockService.getAllBlocks());
	}

}
