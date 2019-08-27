package cn.springteam.bbs.interceptor;

import cn.springteam.bbs.exception.ServiceException;
import cn.springteam.bbs.vo.SysResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalServiceExceptionInterceptor {
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public SysResult doGlobalServiceException(ServiceException e){
		e.getStackTrace();
		return SysResult.fail(e.getMessage());
	}
}
