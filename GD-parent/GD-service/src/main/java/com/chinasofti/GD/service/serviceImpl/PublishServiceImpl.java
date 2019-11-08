package com.chinasofti.GD.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;

import com.chinasofti.GD.beans.Publish;
import com.chinasofti.GD.mapper.PublishMapper;
import com.chinasofti.GD.service.IPublishService;
@Service
public class PublishServiceImpl extends CommonServiceImpl<Publish> implements
		IPublishService {

	@Autowired
	private PublishMapper publishMapper;
	
	@Override
	protected Mapper getMapper() {
		return this.publishMapper;
	}
	//发布信息
	@Override
	public void addPublish(Publish publish) {
		publishMapper.insert(publish);
	}
	//获取publish表中的信息
	@Override
	public List<Publish> getpublish(Publish publish) {
		return publishMapper.getpublish(publish);
	}
	//删除publish表中的数据
	@Override
	public void deletepublished(Publish publish) {
		publishMapper.deletepublish(publish);
	}
	//根据字段查找publish表中的数据信息
	@Override
	public List<Publish> findpublish(Publish publish) {
		return publishMapper.findpublish(publish);
	}
	//	获取超级会员得发布信息
	@Override
	public List<Publish> getsuper(Publish publish) {
		return publishMapper.getsuper(publish);
	}
	//获取普通户用发布的信息
	@Override
	public List<Publish> getnormal(Publish publish) {
		return publishMapper.getnormal(publish);
	}
	//获取搜索框搜索到信息
	@Override
	public List<Publish> getsearch(Publish publish) {
		return publishMapper.getsearch(publish);
	}
	//把publish表中信息复制到另一张表中
	@Override
	public void copy(Publish publish) {
		 publishMapper.copy(publish);
	}
	
	//获取回收站的信息
	@Override
	public List<Publish> getreback(Publish publish) {
		return publishMapper.getreback(publish);
	}
	
	//删除回收站
	@Override
	public void deletereback(Publish publish) {
		publishMapper.deletereback(publish);
	}
	
	//获取publish表中的总数
	@Override
	public int getpublishcount() {
		return publishMapper.getpublishcount();
	}
	
	//csdn
	@Override
	/*public List<Publish> csdn_getpublish(int page, int limit,String keyword) {
        page=(page-1)*limit;
        return publishMapper.csdn_getpublish(page, limit,keyword);
	    }
	*/
	public List<Publish> csdn_getpublish(int page, int limit){
        page=(page-1)*limit;
        return publishMapper.csdn_getpublish(page, limit);
	    }
	



}
