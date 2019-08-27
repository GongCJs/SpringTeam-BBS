package cn.springteam.bbs.interceptor;

import cn.springteam.bbs.util.UserUIDThreadLocal;
import cn.springteam.bbs.vo.SysResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String uId = (String)session.getAttribute("uId");
		if (uId == null){
			if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				response.getWriter().println("/user/login");
			}else{
				response.sendRedirect( "/user/login");
			}
			return false;
		}
		UserUIDThreadLocal.set(uId);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		UserUIDThreadLocal.remove();
	}
}
