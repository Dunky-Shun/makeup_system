package com.chinasofti.GD.beans;

import javax.persistence.Id;

import lombok.Data;

@Data
public class User {

	@Id//主键
	private Integer uid;
	private String uname;
	private String password;
	private String gender;
	private Integer  privilege;
	private String state;//用户上线后下线状态
	private String Cintro;
	private String email;
	private String phonenum;
	private String u_photo;
	
}
