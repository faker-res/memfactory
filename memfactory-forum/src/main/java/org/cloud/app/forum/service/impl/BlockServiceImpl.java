/**
 * 
 */
package org.cloud.app.forum.service.impl;

import java.util.List;

import org.cloud.app.forum.bean.TDotaBlockTd;
import org.cloud.app.forum.common.PageResult;
import org.cloud.app.forum.persistence.TDotaBlockTdMapper;
import org.cloud.app.forum.service.BlockService;
import org.cloud.app.forum.util.BaseDomainUtil;
import org.cloud.app.forum.vo.BlockInputVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
@Service
public class BlockServiceImpl implements BlockService {

	@Autowired
	private TDotaBlockTdMapper tDotaBlockTdMapper;

	@Override
	public void addBlock(TDotaBlockTd block) {
		BaseDomainUtil.setBaseDomain(block);
		tDotaBlockTdMapper.insertSelective(block);
	}

	@Override
	public TDotaBlockTd getBlock(Integer blockId) {
		return tDotaBlockTdMapper.selectByPrimaryKey(blockId);
	}

	@Override
	public void updateBlcok(TDotaBlockTd block) {
		BaseDomainUtil.updateBaseDomain(block);
		tDotaBlockTdMapper.updateByPrimaryKeySelective(block);
	}

	@Override
	public PageResult<TDotaBlockTd> getBlockList(BlockInputVo input) {
		Integer total = tDotaBlockTdMapper.getBlockListCnt(input);
		List<TDotaBlockTd> data = tDotaBlockTdMapper.getBlockListData(input);
		return new PageResult<TDotaBlockTd>(total, data);
	}

	@Override
	public List<TDotaBlockTd> getAllBlocks() {
		return tDotaBlockTdMapper.getAllBlocks();
	}

}
