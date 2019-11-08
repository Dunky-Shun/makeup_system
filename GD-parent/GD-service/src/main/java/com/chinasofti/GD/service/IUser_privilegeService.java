package com.chinasofti.GD.service;

import java.util.List;
import java.util.Map;

import com.chinasofti.GD.beans.User_privilege;


public interface IUser_privilegeService extends ICommonService<User_privilege> {
	//获取权限
	public List<Map<String,Object>> getuser_privilege(User_privilege user_privilege);
}
