package com.chinasofti.GD.controller;


import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.GD.beans.User;
import com.chinasofti.GD.service.IUserService;

@Controller
@RequestMapping("/User")
public class UserController extends BaseController {
	@Autowired
	private IUserService userService;
	

	@RequestMapping(path="/login",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String ,Object> login(User user){
				try {
					//创建令牌
					UsernamePasswordToken token = new UsernamePasswordToken(
							user.getUname(),user.getPassword());
	
					//创建主体
					Subject subject = SecurityUtils.getSubject();
					
					//调用主体的login方法，如果噶方法抛出异常，则代表登录失败
					subject.login(token);
					
//					System.out.println(token);
					return ajaxReturn("success","登录成功！");
				} catch (AuthenticationException e) {
					
					e.printStackTrace();
					return ajaxReturn("failure", "用户名或密码不正确");
				}
	}

	@RequestMapping("/getUserName")
	@ResponseBody
	public String getUserName() {
		//Object o = session.getAttribute("user");
		// 获取主角
		Object o = SecurityUtils.getSubject().getPrincipal();
		if (o == null) {
			return "";
		} else {
			User u= (User) o;
//			System.out.println(u.getUname());
			return u.getUname();
		}
		/*System.out.println("ok");
		return "ok";*/
	}
	
	//获取在线用户
	@RequestMapping(path="/findUser",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public List<User> findUser(User user){
		return userService.findUserBystate(user);
	}
	
	

	
/*	//获取user表中所有用户xinxi
	@RequestMapping(path="/getUser",produces={"application/json;charset=utf-8"})
	@ResponseBody
	List<User> getUser(User user){
		return userService.getUser(user);
	}*/
	
	
	//添加新用户
	@RequestMapping(path="/addUsers",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String,String> add(User user){
		try{
			userService.addUser(user);
			return ajaxReturn1("success","注册成功");
		}catch(Exception e){
			e.printStackTrace();
			return ajaxReturn1("failure", "注册失败");
		}
	 
	}
	
	
	
	//获取user表中所有信息
	@RequestMapping(path="/find",produces={"application/json;charset=utf-8"})
	@ResponseBody
	List<User>XX(User user){
		return userService.find(user);
		}

	
	@RequestMapping("/logout")
	public String logout() {
		// 销毁session
		//session.invalidate();
		SecurityUtils.getSubject().logout();
		// 跳转到登录页面
		return "/views/GD/demo.html";	
	}
	
	//获取当前用户的信息
	@RequestMapping(path="/getcur",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public User getCur(User uname){
		//System.out.println(uname);
		return userService.getUserByName(uname);
	}

@RequestMapping(path="/updateinfo",produces={"application/json;charset=utf-8"})
@ResponseBody
public Map<String ,String> updateinfo(User user){
	try {
		userService.update(user);
		return ajaxReturn1("success","保存成功！");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ajaxReturn1("failure","保存失败！");
	}
	//userService.update(user);
}

//test
@RequestMapping(path="test",produces={"application/json;charset=utf-8"})
@ResponseBody
public List<User>getuser(User user){
	return userService.getuser(user);
}
@RequestMapping(path="deleteUser",produces={"application/json;charset=utf-8"})
@ResponseBody
public Map<String, String> deleteUser(User user){
	try{
		userService.deleteuser(user);
		return ajaxReturn1("success","删除成功!");
	}catch(Exception e){
		e.printStackTrace();
		return ajaxReturn1("failure","删除失败！");
	}
}
//删除用户

	}



