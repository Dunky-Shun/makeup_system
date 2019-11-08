package com.chinasofti.GD.service;


import java.util.List;
import java.util.Map;

import com.chinasofti.GD.beans.Report;

public interface IReportService extends ICommonService<Report>{
	//获取举报信息
	public List<Map<String,Object>> getreport(Report report);
	
	//删除举报信息
	public void deletereport(Report report);
}
