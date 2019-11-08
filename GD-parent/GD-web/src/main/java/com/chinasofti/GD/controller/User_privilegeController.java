package com.chinasofti.GD.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chinasofti.GD.beans.User_privilege;
import com.chinasofti.GD.service.IUser_privilegeService;

@Controller
@RequestMapping("User_privilege")
public class User_privilegeController extends BaseController {
	@Autowired
	private IUser_privilegeService user_privilegeService;
	
	//添加用户的等级
	@RequestMapping (path="/insert",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public void addprivilege(User_privilege user_privilege){
		user_privilegeService.add(user_privilege);
	}
	
	//修改用户等级
	@RequestMapping (path="/update",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String,String> updateprivilege(User_privilege user_privilege){
		try {
			user_privilegeService.update(user_privilege);
			return ajaxReturn1("success","升级成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxReturn1("failure","升级失败！");
		}
	}
	
	//获取用户的等级信息
		@RequestMapping (path="/find",produces={"application/json;charset=utf-8"})
		@ResponseBody
		public List<User_privilege> findprivilege(User_privilege user_privilege){
			return user_privilegeService.find(user_privilege);
		}
		
	//获取用户的等级信息
	/*	@RequestMapping (path="/find",produces={"application/json;charset=utf-8"})
		@ResponseBody
		public List<Map<String,Object>> findprivilege(User_privilege user_privilege){
			return user_privilegeService.getuser_privilege(user_privilege);
		}*/
}
