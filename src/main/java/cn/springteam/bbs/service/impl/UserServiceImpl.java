package cn.springteam.bbs.service.impl;

import cn.springteam.bbs.exception.ServiceException;
import cn.springteam.bbs.mapper.UserMapper;
import cn.springteam.bbs.pojo.User;
import cn.springteam.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void login(User user) {
		User userDB = userMapper.selectById(user.getUId());
		if(userDB != null){
			String userInputPassword = DigestUtils.md5DigestAsHex((user.getUPassword()+userDB.getUSale()).getBytes());
			if(!(userInputPassword.equals(userDB.getUPassword()))){
				throw new ServiceException("密码错误");
			}
		}else{
			throw new ServiceException("该用户不存在");
		}
	}

	@Override
	public void regist(User user) {
		Date now = new Date();
		//添加盐值
		user.setUSale(UUID.randomUUID().toString().replace("-",""));
		//设置密码
		user.setUPassword(DigestUtils.md5DigestAsHex((user.getUPassword()+user.getUSale()).getBytes()));
		user.setCreateTime(now).setUpdateTime(now);
		try {
			userMapper.insert(user);
		}catch (DuplicateKeyException e){
			throw new ServiceException("该用户存在");
		}
	}

	@Override
	public void checkUsername(User user) {
		User userDB = userMapper.selectById(user.getUId());
		if(userDB != null){
			throw new ServiceException("该用户存在");
		}
	}
}
