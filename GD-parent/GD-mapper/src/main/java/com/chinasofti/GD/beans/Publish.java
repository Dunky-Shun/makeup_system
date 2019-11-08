package com.chinasofti.GD.beans;

import javax.persistence.Id;
import lombok.Data;
@Data
public class Publish {
	@Id
	private Integer pb_id;
	//private Integer uid;//private String uid;
	private String pb_date;
	private String topic;
	private String content;
	private String p_url;
	private String pb_type;
	private Integer uid;
	private String category;
	private String buy_url;
	//private Integer privilege;
}
