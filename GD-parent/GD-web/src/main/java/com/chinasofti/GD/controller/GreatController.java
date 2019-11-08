package com.chinasofti.GD.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.GD.beans.Great;
import com.chinasofti.GD.service.IGreatService;


@Controller
@RequestMapping("/Great")
public class GreatController  extends BaseController {
	@Autowired
	private IGreatService greatService;
	
	//点赞
		@RequestMapping (path="/great", produces = {"application/json;charset=utf-8"})
		@ResponseBody
		public Map<String ,String >dianzan(Great great){
			try{
					greatService.addgreat(great);
					return ajaxReturn1("success","点赞成功");
			}catch(Exception e){
				e.printStackTrace();
				return ajaxReturn1("failure","点赞失败！");
			}
		}
		
		//取消点赞
				@RequestMapping (path="/cancelgreat", produces = {"application/json;charset=utf-8"})
				@ResponseBody
				public Map<String ,String >canceldianzan(Great great){
					try{
							greatService.cancle(great);
							return ajaxReturn1("success","取消成功");
					}catch(Exception e){
						e.printStackTrace();
						return ajaxReturn1("failure","取消失败！");
					}
				}
		
		
	//获取同一篇文章的点赞数
		@RequestMapping (path="/getcount", produces = {"application/json;charset=utf-8"})
		@ResponseBody
		public String getcount(Great great){
			return greatService.getcount(great);
		}
		
		//获取用户获得的点赞数
		@RequestMapping (path="/getusercount", produces = {"application/json;charset=utf-8"})
		@ResponseBody
		public String getusercount(Great great){
			return greatService.usercount(great);
		}
		
		//点赞时候判断是否存在
		@RequestMapping(path="/checkgreat",produces={"application/json;charset=utf-8"})
		@ResponseBody
		public List<Great> checkreport(Great great){
			return greatService.checkReport(great);
		}
}
