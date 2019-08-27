package cn.springteam.bbs.controller;

import cn.springteam.bbs.pojo.User;
import cn.springteam.bbs.service.UserService;
import cn.springteam.bbs.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("login.do")
	@ResponseBody
	public SysResult login(User user, HttpServletRequest request){
		userService.login(user);
		request.getSession().setAttribute("uId",user.getUId());
		return SysResult.success();
	}

	@RequestMapping("regist.do")
	@ResponseBody
	public SysResult regist(User user){
		userService.regist(user);
		return SysResult.success();
	}

	@RequestMapping("checkUsername.do")
	@ResponseBody
	public SysResult checkUsername(User user){
		userService.checkUsername(user);
		return SysResult.success("用户不存在");
	}

	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "login";
	}

	@RequestMapping("login")
	public String login(HttpServletRequest request){
		return "login";
	}

	@RequestMapping("regist")
	public String regist(HttpServletRequest request){
		return "regist";
	}
}
