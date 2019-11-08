package com.chinasofti.GD.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;

import com.chinasofti.GD.beans.User;
import com.chinasofti.GD.mapper.UserMapper;
import com.chinasofti.GD.service.IUserService;

@Service
public class IUserServiceImpl extends CommonServiceImpl<User> implements
		IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	protected Mapper getMapper() {
		return this.userMapper;
	}
	@Override
	public List<User> getUser(User user) {
		return userMapper.selectAll();
	}
//查询在线的用户
	@Override
	public List<User> findUserBystate(User user) {
	
		return userMapper.findUserBystate();
	}
	
	
/*	@Override
	public List<User> findUser(User user) {
		//当状态为1表示上线
		if("1".equals(user.getState())){
			List<User> userList = new ArrayList<User>();
			//userList.add(user);
			return userList;
		}
		return null;
	}*/
	
	
	@Override
	public void addUser(User user) {
	  userMapper.insert(user);
	  
	}
	@Override
	public User getUserByName(User uname) {
		return userMapper.getUserByName(uname);
	}
	@Override
	public List<User> getuser(User user) {
		return userMapper.getuser(user);
	}
	@Override
	public String deleteuser(User user) {
		return userMapper.deleteuser(user);
	}

	
	
	
	
	


}

