package com.chinasofti.GD.service.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.GD.beans.User_privilege;
import com.chinasofti.GD.mapper.User_privilegeMapper;
import com.chinasofti.GD.service.IUser_privilegeService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class User_privilegeServiceimpl extends CommonServiceImpl<User_privilege> implements
IUser_privilegeService {
	@Autowired
	private User_privilegeMapper user_privilegeMapper;

	@Override
	protected Mapper getMapper() {
		return this.user_privilegeMapper;
	}

	@Override
	public List<Map<String,Object>> getuser_privilege(User_privilege user_privilege) {
		return user_privilegeMapper.getuser_privilege(user_privilege);
	}
}
