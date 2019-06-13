/**
 * 
 */
package com.memfactory.article.component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.memfactory.article.annotation.ParamCheck;
import com.memfactory.article.exception.ParamIsNullException;

/**
 * 参数校验AOP
 * 
 * @author zhairp createDate: 2018-11-28
 */
@Component
@Aspect
public class ParamCheckAop {
	private Logger log = LoggerFactory.getLogger(getClass());

	/** * 定义有一个切入点，范围为controller包下的类 */
	@Pointcut("execution(public * com.memfactory.article.controller..*.*(..))")
	public void checkParam() {
	}

	@Around("checkParam()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = ((MethodSignature) pjp.getSignature());
		// 得到拦截的方法
		Method method = signature.getMethod();
		// 获取方法参数注解，返回二维数组是因为某些参数可能存在多个注解
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		if (parameterAnnotations == null || parameterAnnotations.length == 0) {
			return pjp.proceed();
		}
		// 获取方法参数名
		String[] paramNames = signature.getParameterNames();
		// 获取参数值
		Object[] paranValues = pjp.getArgs();
		// 获取方法参数类型
		Class<?>[] parameterTypes = method.getParameterTypes();
		for (int i = 0; i < parameterAnnotations.length; i++) {
			for (int j = 0; j < parameterAnnotations[i].length; j++) {
				// 如果该参数前面的注解是ParamCheck的实例，并且notNull()=true,则进行非空校验
				if (parameterAnnotations[i][j] != null && parameterAnnotations[i][j] instanceof ParamCheck && ((ParamCheck) parameterAnnotations[i][j]).notNull()) {
					paramIsNull(paramNames[i], paranValues[i], parameterTypes[i] == null ? null : parameterTypes[i].getName());
					break;
				}

			}
		}
		return pjp.proceed();
	}

	@Before("checkParam()")
	public void doBefore(JoinPoint joinPoint) {
	}

	@AfterReturning("checkParam()")
	public void doAfterReturning(JoinPoint joinPoint) {
	}

	private void paramIsNull(String paramName, Object value, String parameterType) {
		if (value == null || "".equals(value.toString().trim())) {
			log.info("paramName:{},value:{},parameterType:{}", paramName, value, parameterType);
			throw new ParamIsNullException(paramName, parameterType);
		}
	}

}
