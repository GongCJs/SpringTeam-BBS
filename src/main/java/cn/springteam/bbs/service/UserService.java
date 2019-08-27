package cn.springteam.bbs.service;

import cn.springteam.bbs.pojo.User;

public interface UserService {
	void login(User user);
	void regist(User user);
	void checkUsername(User user);
}
