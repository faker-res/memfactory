/**
 * 
 */
package com.abc.template.service;

import com.abc.template.vo.AggQueryVo;
import com.abc.template.vo.FilterQueryVo;
import com.memfactory.pub.commom.ResponseVo;

/**
 * @author zhairp createDate: 2018-11-10
 */
public interface SearchService {

	ResponseVo filterQuery(FilterQueryVo input);

	ResponseVo aggQuery(AggQueryVo input);

}
