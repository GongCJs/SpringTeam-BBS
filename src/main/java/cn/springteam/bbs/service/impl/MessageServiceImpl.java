package cn.springteam.bbs.service.impl;

import cn.springteam.bbs.exception.ServiceException;
import cn.springteam.bbs.mapper.MessageMapper;
import cn.springteam.bbs.pojo.Message;
import cn.springteam.bbs.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageMapper messageMapper;
	@Override
	public List<Message> findAll() {
		List<Message> result = messageMapper.selectList(null);
		return result;
	}

	@Override
	public void save(Message message) {
		Integer rows = messageMapper.insert(message);
		if(rows == 0 || rows == null){
			throw new ServiceException("添加失败");
		}
	}
}
