package com.chinasofti.GD.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.GD.beans.Publish;
import com.chinasofti.GD.service.IPublishService;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/Publish")
public class PublishController extends BaseController {

	@Autowired
	private IPublishService publishService;
	
	//获取发布的信息
	@RequestMapping (path="/getpublish", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Publish> getPublish(Publish publish){
		return publishService.findAll();
	}
	//根据用户id查找发布信息
	@RequestMapping (path="/getpublishbyid", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Publish> getPublishbyuser(Publish publish){
		System.out.println("运行getbulishedbyid");
		return publishService.getpublish(publish);
	}
	//查询publish表中信息
	@RequestMapping (path="/getpublished", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	
	public List<Publish> getPublished(Publish publish){
		
		//System.out.println("运行find()");
		
		return publishService.find(publish);
	}
	
	//查询publish表中信息、倒序查询
		@RequestMapping (path="/findpublished", produces = {"application/json;charset=utf-8"})
		@ResponseBody
		
		public List<Publish> findPublished(Publish publish){
			
			//System.out.println("运行find()");
			//返回publish表中倒序信息
			return publishService.findpublish(publish);
		}


//发布信息
	@RequestMapping (path="/addtie", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String ,String> addinto(Publish publish){
		
		//System.out.println(publish);
		try {
			publishService.addPublish(publish);
			return ajaxReturn1("success", "发布成功!");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return ajaxReturn1("failure","发布失败!");
		}
	}
	
	//删除信息
	@RequestMapping (path="/delete", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String,String> delete(Publish publish){
		try{
			publishService.deletepublished(publish);
			return ajaxReturn1("success","删除成功！");
		}catch(Exception e){
			e.printStackTrace();
			return ajaxReturn1("failure","删除失败！");
		}
	}
	
	
	//获取超级会员的信息
	@RequestMapping (path="/getsuper", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Publish>getsuper(Publish publish){
		return publishService.getsuper(publish);
	}
	
	//获取超级会员的信息
	@RequestMapping (path="/getnormal", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Publish>getnormal(Publish publish){
		return publishService.getnormal(publish);
	}
	
	//定义搜索
	@RequestMapping (path="/getsearch", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Publish> getsearch(Publish publish){
		return publishService.getsearch(publish);
	}
	
	//把publish表中的数据复制到另一张表中
	@RequestMapping (path="/copy", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public void copy(Publish publish){
			 publishService.copy(publish);
	}
	//查找回收站的信息
	@RequestMapping (path="/getreback", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Publish> getreback(Publish publish){
			 return publishService.getreback(publish);
	}
	
	//删除回收站
	@RequestMapping (path="/deletereback", produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String,String> deletereback(Publish publish){
		try{
			 publishService.deletereback(publish);
			return ajaxReturn1("success","删除成功！");
		}catch(Exception e){
			e.printStackTrace();
			return ajaxReturn1("failure","删除失败！");
		}
	}

//分页
	 @ResponseBody
	 @RequestMapping("/showData")
	    public Map<String,Object> methodx(
	            @RequestParam(required=false,defaultValue="1") int page,
	            @RequestParam(required=false,defaultValue="15") int limit,
	            String keyWord
	    ){
	    List<Publish> datas=publishService.csdn_getpublish(page, limit);
	        int countx=  publishService.getTotal();
	        Map<String,Object> map=new HashMap<String,Object>();
	        map.put("code",0);
	        map.put("msg","");
	        map.put("count",countx);
	        map.put("data",datas);
	        System.out.println(map.toString());
	        return map;
	    }
	
}
