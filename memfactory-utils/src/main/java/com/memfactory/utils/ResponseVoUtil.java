/**
 * 
 */
package com.memfactory.utils;

import com.memfactory.pub.commom.ResponseVo;

/**
 * ResponseV工具类
 * 
 * @author zhairp
 * @since 0.0.1
 * createDate: 2018年8月30日
 */
public final class ResponseVoUtil {
	private ResponseVoUtil() {
	}

//	/**
//	 * 统一生产ResponseVo实例
//	 * 
//	 * @param result 结果数据
//	 * @return ResponseVo实例
//	 */
//	public static ResponseVo getResponse(Object result) {
//		ResponseVo responseVo = new ResponseVo();
//		responseVo.setSuccess(true);
//		responseVo.setMsg(OperationEnum.SUCCESS.getMsg());
//		responseVo.setStatus(OperationEnum.SUCCESS.getCode());
//		responseVo.setResult(result);
//		return responseVo;
//	}
//
//	/**
//	 * 统一生产ResponseVo实例
//	 * 
//	 * @param success   操作是否成功
//	 * @param operation 操作提示信息
//	 * @return ResponseVo实例
//	 */
//	public static ResponseVo getResponse(boolean success, OperationEnum operation) {
//		ResponseVo responseVo = new ResponseVo();
//		responseVo.setSuccess(success);
//		responseVo.setMsg(operation.getMsg());
//		responseVo.setStatus(operation.getCode());
//		return responseVo;
//	}
//
//    /*
//     * 生产默认ResponseVo实例
//     */
//	public static ResponseVo getDefaultResponse() {
//		ResponseVo responseVo = new ResponseVo();
//		responseVo.setSuccess(true);
//		responseVo.setMsg(OperationEnum.SUCCESS.getMsg());
//		responseVo.setStatus(OperationEnum.SUCCESS.getCode());
//		return responseVo;
//	}
	
	/**
	 * 通用的返回实例
	 * 
	 * @author zhairp createDate: 2018-11-13
	 * @param success 成功标志
	 * @param msg     提示信息
	 * @param result  数据
	 * @param status  状态编码
	 * @return 通用的返回实例
	 */
	public static ResponseVo getCommonResponse(boolean success, String msg, Object result, String status) {
		ResponseVo responseVo = new ResponseVo();
		responseVo.setSuccess(success);
		responseVo.setResult(result);
		responseVo.setMsg(msg);
		responseVo.setStatus(status);
		return responseVo;
	}
	
	/**
	 * 返回成功的实例
	 * 
	 * @author zhairp createDate: 2018-11-13
	 * @param result 数据
	 * @return 返回成功的实例
	 */
	public static ResponseVo getSuccessResponse(Object result) {
		return getCommonResponse(true, "操作成功", result, "");
	}

	/**
	 * 返回失败的实例
	 * 
	 * @author zhairp createDate: 2018-11-13
	 * @param msg 提示信息
	 * @return 返回失败的实例
	 */
	public static ResponseVo getFailureResponse(String msg) {
		return getCommonResponse(false, msg, null, "");
	}

}
