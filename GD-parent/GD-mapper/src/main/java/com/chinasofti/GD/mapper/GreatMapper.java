package com.chinasofti.GD.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import com.chinasofti.GD.beans.Great;
import tk.mybatis.mapper.common.Mapper;
public interface GreatMapper extends Mapper<Great> {
	
	//获取同一篇文章的点赞数
	@Select("select count(*) from great where pb_id = #{pb_id}")
	public String getcount(Great great);
	
	//获取用户获得的点赞数
		@Select("select count(*) from great where p_uid = #{p_uid}")
		public String getusercount(Great great);
	
	
	//检测数据库中是否存在该点赞信息，有的话 点赞即为取消点赞
	@Select("select * from great where uid = #{uid} and pb_id = #{pb_id}")
	public List<Great> checkreport(Great great);
	
	//取消点赞
	@Delete("delete from great where uid = #{uid} and pb_id = #{pb_id}")
	public void cancle(Great great);
	
	
}
