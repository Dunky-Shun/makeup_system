package com.chinasofti.GD.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.chinasofti.GD.beans.Publish;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface PublishMapper extends Mapper<Publish> {
	//根据发布时间倒序查询
	@Select("select * from publish where uid = #{uid} order by pb_date desc")
	public List<Publish> getpublish(Publish publish);
	
	//把表中的数据复制到另一张表中；
	@Insert("insert into reback_publish select * from publish where pb_id = #{pb_id}")
	public void copy(Publish publish);
	//删除表中的数据
	@Delete("delete  from publish where pb_id = #{pb_id}")
	public void deletepublish(Publish publish);
	//倒叙获取数据库数据o
	@Select("select * from publish where category = #{category} order by pb_date desc")
	public List<Publish> findpublish(Publish publish);
	
	//获得超级会员的发布信息；privilege=1
	@Select("SELECT * from publish join user on publish.uid =user.uid and user.privilege=1")
	public List<Publish> getsuper(Publish publish);
	
	//获得超级会员的发布信息；privilege=0
	@Select("SELECT * from publish join user on publish.uid =user.uid and user.privilege=0 and category =#{category} and user.privilege =0")
	public List<Publish> getnormal(Publish publish); 
		
	//topic或查询
	@Select("<script>select * from publish  "
			+ "<if test='topic!=null'>"
			+ "where topic like concat ('%',#{topic},'%')"
			+ "</if>"
			+ "<if test='content!=null'>"
			+ "or  content like concat ('%',#{content},'%')"
			+ "</if>"
			+ "<if test='category != null'>"
			+ "or  category like concat ('%',#{category},'%')"
			+ "</if></script>")
	//@Select("select * from publish where topic like '%#{topic}%' or content like '%#{content}%' or category like '%#{category}%'")
	public List<Publish> getsearch(Publish publish);
	
	//查找信息回收站的内容 reback_publish表中的信息
	@Select("select * from reback_publish order by pb_date desc")
	public List<Publish> getreback(Publish publish);
	
	//删除回收站
	@Delete("delete from reback_publish where pb_id = #{pb_id}")
	public void deletereback(Publish publish);
	//获取所有信息数量
	@Select("select count(*) from publish")
	public int getpublishcount();
	
	//CSDN分页查询模板
	@Select("select * from publish  limit #{page},#{limit}")
	/*@Select("<script> select * from publish"
			+ "<if test= \"keyWord!='' or keyWord!=null\">"
			+ "where topic like concat ('%',#{keyWord},'%')"
			+ "</if></script>")*/
	public List<Publish> csdn_getpublish(@Param("page") int page, @Param("limit") int limit);
}	
