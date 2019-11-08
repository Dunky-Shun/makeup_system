package com.chinasofti.GD.service;

import java.util.List;

import com.chinasofti.GD.beans.Publish;


public interface IPublishService extends ICommonService<Publish> {
	//发布信息
	public void addPublish(Publish publish);
	//获取信息
	public List<Publish>getpublish(Publish publish);
	//删除信息
	public void deletepublished(Publish publish);
	//把publish表中的指定数据复制到reback_publish表中
	public void copy(Publish publish);
	//获取信息
	public List<Publish>findpublish(Publish publish);
	//获取超级会员的发布
	public List<Publish>getsuper(Publish publish);
	//获取普通用户发布
	public List<Publish>getnormal(Publish publish);
	//定义搜索
	public List<Publish>getsearch(Publish publish);
	//获取回收站的信息
	public List<Publish> getreback(Publish publish);
	//删除回收站信息
	public void deletereback(Publish publish);
	//获取信息总数
	public int getpublishcount();
	//CSDN_获取信息
	//public List<Publish> csdn_getpublish(int page, int limit,String keyword);
	public List<Publish> csdn_getpublish(int page, int limit);
	
}
