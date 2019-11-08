package com.chinasofti.GD.beans;

import javax.persistence.Id;

import lombok.Data;

@Data
public class Great {
	@Id
	private Integer id;
	
	//pid 信息id
	private Integer pb_id;
	//uid 点赞人ID
	private Integer uid;
	
	private Integer p_uid;
}
