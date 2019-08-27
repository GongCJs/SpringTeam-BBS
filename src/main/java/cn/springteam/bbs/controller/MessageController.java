package cn.springteam.bbs.controller;

import cn.springteam.bbs.pojo.Message;
import cn.springteam.bbs.service.MessageService;
import cn.springteam.bbs.util.UserUIDThreadLocal;
import cn.springteam.bbs.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("message")
public class MessageController {
	@Autowired
	private MessageService messageService;

	@RequestMapping("findAll.do")
	@ResponseBody
	public SysResult findAll(){
		List<Message> result = messageService.findAll();
		return SysResult.success(result);
	};

	@RequestMapping("fabu.do")
	@ResponseBody
	public SysResult fabu(Message message){
		Date now = new Date();
		message.setUIdFrom(UserUIDThreadLocal.get())
				.setMId(UUID.randomUUID().toString().replace("-",""))
				.setUpdateTime(now)
				.setCreateTime(now);
		if(StringUtils.isEmpty(message.getUIdTo())){
			message.setUIdTo("所有人");
		}
		messageService.save(message);
		return SysResult.success();
	};

	@RequestMapping("main")
	public String main(){
		return "main";
	};

	@RequestMapping("fabu")
	public String fabu(){
		return "fabu";
	};

	@RequestMapping("upload")
	public String upload(){
		return "upload";
	};
}
