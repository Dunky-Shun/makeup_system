package com.chinasofti.GD.service.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.GD.beans.Report;
import com.chinasofti.GD.mapper.ReportMapper;
import com.chinasofti.GD.service.IReportService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class ReportServiceImpl extends CommonServiceImpl<Report> implements IReportService{

	@Autowired
	public ReportMapper reportMapper;
	@Override
	protected Mapper getMapper() {
		 return this.reportMapper;
	}
	
	//获取举报相关的内容
	@Override
	public List<Map<String,Object>> getreport(Report report) {
		return reportMapper.getreport(report);
	}

	@Override
	public void deletereport(Report report) {
		reportMapper.deleteReport(report);
	}


}
