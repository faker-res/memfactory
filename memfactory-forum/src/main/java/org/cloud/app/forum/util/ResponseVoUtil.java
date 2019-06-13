/**
 * 
 */
package org.cloud.app.forum.util;

import org.cloud.app.forum.common.ResponseVo;
import org.cloud.app.forum.constant.OperationEnum;

/**
 * ResponseV工具类
 * 
 * @author zhairp
 * @date 2018年8月13日
 * @since 0.0.1
 */
public final class ResponseVoUtil {
	private ResponseVoUtil() {
	}

	/**
	 * 统一生产ResponseVo实例
	 * 
	 * @param result 结果数据
	 * @return ResponseVo实例
	 */
	public static ResponseVo getResponse(Object result) {
		ResponseVo responseVo = new ResponseVo();
		responseVo.setSuccess(true);
		responseVo.setMsg(OperationEnum.SUCCESS.getMsg());
		responseVo.setStatus(OperationEnum.SUCCESS.getCode());
		responseVo.setResult(result);
		return responseVo;
	}

	/**
	 * 统一生产ResponseVo实例
	 * 
	 * @param success 操作是否成功
	 * @param msg     操作提示信息
	 * @return ResponseVo实例
	 */
	public static ResponseVo getResponse(boolean success, OperationEnum operation) {
		ResponseVo responseVo = new ResponseVo();
		responseVo.setSuccess(success);
		responseVo.setMsg(operation.getMsg());
		responseVo.setStatus(operation.getCode());
		return responseVo;
	}

	/**
	 * 生产默认ResponseVo实例
	 * 
	 * @return
	 */
	public static ResponseVo getDefaultResponse() {
		ResponseVo responseVo = new ResponseVo();
		responseVo.setSuccess(true);
		responseVo.setMsg(OperationEnum.SUCCESS.getMsg());
		responseVo.setStatus(OperationEnum.SUCCESS.getCode());
		return responseVo;
	}

}
