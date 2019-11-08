package com.chinasofti.GD.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import tk.mybatis.mapper.common.Mapper;

import com.chinasofti.GD.beans.User;

@Repository
public interface UserMapper extends Mapper<User>{
	//获取在线用户 state==1
	@Select("select * from user u where u.state = 1 ")
	public List<User> findUserBystate();
	
	@Select("select * from user u where u.uname = #{uname}")
	public User getUserByName(User uname);
/*
	@Select("<script>select * from user "
			+ "<if test='uid!=null'>"
			+ "where uid = #{uid}"
			+ "</if>"
			+ "<if test='uname!=null'>"
			+ "and uname = #{uname}"
			+ "</if></script>")*/
	@Select("select * from user where uid=#{uid} or uname=#{uname}")
	public List<User> getuser(User user);
	
	
	//删除用户
	@Delete("delete from user where uid = #{uid}")
	public String deleteuser(User user);
}
