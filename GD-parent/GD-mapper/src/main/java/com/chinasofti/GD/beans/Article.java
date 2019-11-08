package com.chinasofti.GD.beans;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Article {
	@Id
	private Integer id;
	@Column(name = "num") // 給该文章点赞的数量
	private int likeNum;
}
