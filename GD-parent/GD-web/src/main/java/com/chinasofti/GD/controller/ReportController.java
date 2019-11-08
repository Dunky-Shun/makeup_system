package com.chinasofti.GD.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.GD.beans.Report;
import com.chinasofti.GD.service.IReportService;

@Controller
@RequestMapping("Report")
public class ReportController extends BaseController {
	
	@Autowired
	public IReportService reportService;
	//添加举报信息
	@RequestMapping(path="report",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String ,String> addreport(Report report){
		
		try {
			reportService.add(report);
			return ajaxReturn1("success", "举报成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ajaxReturn1("failure","举报失败!");
		}
	}
	
	
	//查看举报信息（管理员权限）
	@RequestMapping(path="/getreport",produces={"application/json;charset=utf-8"})
	@ResponseBody
	
	public List<Map<String,Object>> getreport(Report report){
		return reportService.getreport(report);
	}
	//删除举报的信息
	@RequestMapping(path="/getreport",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String,String> deletereport(Report report){
		try{
			reportService.deletereport(report);
			return ajaxReturn1("success","删除成功！");
		}catch(Exception e){
		e.printStackTrace();
		return ajaxReturn1("failure","删除失败！");
		}
		}

	
	}

