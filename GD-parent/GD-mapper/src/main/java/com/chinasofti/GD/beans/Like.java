package com.chinasofti.GD.beans;

import lombok.Data;

@Data
public class Like {
	//pid 发布人id
	private Integer pb_id;
	//uid 点赞人ID
	private Integer uid;
	//count 点赞数；
	private Integer count;
}
