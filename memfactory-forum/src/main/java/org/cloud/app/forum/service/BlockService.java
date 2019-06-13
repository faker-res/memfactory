/**
 * 
 */
package org.cloud.app.forum.service;

import java.util.List;

import org.cloud.app.forum.bean.TDotaBlockTd;
import org.cloud.app.forum.common.PageResult;
import org.cloud.app.forum.vo.BlockInputVo;

/**
 * 版块服务
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public interface BlockService {

	/**
	 * 查询版块列表
	 * 
	 * @param input 版块查询条件
	 * @return 统一分页结果
	 */
	PageResult<TDotaBlockTd> getBlockList(BlockInputVo input);

	/**
	 * 新增版块
	 * 
	 * @param block 版块信息
	 */
	void addBlock(TDotaBlockTd block);

	/**
	 * 获取版块信息
	 * 
	 * @param blockId 版块ID
	 * @return
	 */
	TDotaBlockTd getBlock(Integer blockId);

	/**
	 * 修改版块
	 * 
	 * @param block 版块信息
	 */
	void updateBlcok(TDotaBlockTd block);

	/**
	 * 获取系统所有版块，用于过滤帖子
	 * 
	 * @return 系统所有版块
	 */
	List<TDotaBlockTd> getAllBlocks();

}
