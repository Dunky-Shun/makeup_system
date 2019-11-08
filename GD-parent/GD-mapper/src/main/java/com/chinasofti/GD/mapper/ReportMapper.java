package com.chinasofti.GD.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.chinasofti.GD.beans.Report;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ReportMapper extends Mapper<Report> {
	
	//获取举报的内容
	@Select("select * from report join publish on report.pb_id = publish.pb_id")
	public List<Map<String,Object>> getreport(Report report); 
	
	//删除举报信息
	@Delete("delete from report where rid = #{rid}")
	public void deleteReport(Report report);
}
