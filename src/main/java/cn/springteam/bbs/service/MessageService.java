package cn.springteam.bbs.service;

import cn.springteam.bbs.pojo.Message;
import cn.springteam.bbs.pojo.User;

import java.util.List;

public interface MessageService {

	List<Message> findAll();

	void save(Message message);
}
