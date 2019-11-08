package com.chinasofti.GD.beans;

import javax.persistence.Id;

import lombok.Data;

@Data
public class Makeup {
	@Id
	private Integer mid;
	private String mname;
	private String tag;
	private String category;
	private String url;//图片地址
	private String brain;//品牌
}
