package com.chinasofti.GD.service;


import java.util.List;

import com.chinasofti.GD.beans.Great;

public interface IGreatService extends ICommonService<Great> {
	//新增点赞记录
	public void addgreat(Great great);
	//用户获得的点赞数
	public String usercount(Great great);
	//获取同一篇文章的点赞数
	public String getcount(Great great);
	//判断点赞是否存在
	public List<Great> checkReport(Great great);
	//取消点赞
	public void cancle(Great great);
}
