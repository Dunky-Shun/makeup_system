package com.chinasofti.GD.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinasofti.GD.beans.User;
import com.chinasofti.GD.service.IUserService;


public class UserRealm extends AuthorizingRealm {

	@Autowired
	private IUserService userService;
	
	
	//执行授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
				return null;
	}	
	//执行认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		//1.获取令牌
		//从token中获取用户的登录信息
		UsernamePasswordToken token = (UsernamePasswordToken) arg0;
		String usernames = token.getUsername();
		String password = new String (token.getPassword());
		
		
		//System.out.println("usernames="+usernames);
		//System.out.println("userpass="+password);
		//2.调用业务组件进行登录判断
		
		User user = new User();
		user.setUname(usernames);
		user.setPassword(password);
		List<User> userList = userService.getUser(user);
		//System.out.println(userList);
		//3.判断用户是否为空
		if(userList != null ){
			//user = userList.get(0);
			//System.out.println(">>>>>>>>>>>"+userList.get(0));
			return new SimpleAuthenticationInfo(user,usernames,password);
		}
		return null;
	}
	

}
