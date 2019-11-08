package com.chinasofti.GD.beans;

import javax.persistence.Id;

import lombok.Data;

@Data
public class Report {
	@Id
	private String rid;
	private Integer uid;//发布人人ID 
	//举报人ID
	private Integer red_id;
	private String r_reason;//举报理由；
	private Integer pb_id;//举报的帖子编号
}
