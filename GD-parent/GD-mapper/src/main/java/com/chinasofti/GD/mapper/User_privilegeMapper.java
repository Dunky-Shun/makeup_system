package com.chinasofti.GD.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.chinasofti.GD.beans.User_privilege;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface User_privilegeMapper extends Mapper<User_privilege> {
	@Select("select * from user_privilege join user on user_privilege.uid = user.uid")
	public List<Map<String,Object>> getuser_privilege(User_privilege user_privilege);
	
}
