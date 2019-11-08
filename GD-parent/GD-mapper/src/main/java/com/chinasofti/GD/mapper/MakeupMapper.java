package com.chinasofti.GD.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.chinasofti.GD.beans.Makeup;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface MakeupMapper extends Mapper<Makeup>{

	@Select("select url from makeup")
	public String getone();
	
	@Select("select * from makeup where tag = '油皮' ")
	public List<Makeup> getyoupi(Makeup makeup);

}
