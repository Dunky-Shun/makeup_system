package com.chinasofti.GD.service;

import java.util.List;

import com.chinasofti.GD.beans.User;

public interface IUserService extends ICommonService<User> {
	//获取所有用户
	List<User> getUser(User user);
	
	//获取在线用户
	List<User> findUserBystate(User user);
	
	//添加用户
	public void addUser(User user);
	
	//获取当前用户的信息。
	public User getUserByName(User uname);
	
	//test
	public List<User>getuser(User user);
	
	//删除用户
	public String deleteuser(User user);

}
