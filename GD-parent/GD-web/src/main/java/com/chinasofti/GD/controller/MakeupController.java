package com.chinasofti.GD.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.chinasofti.GD.beans.Makeup;
import com.chinasofti.GD.service.IMakeupService;

@Controller
@RequestMapping("/Makeup")
public class MakeupController {
	@Autowired
	private IMakeupService makeupService;
	
	@RequestMapping (path="/getmakeup",produces={"application/json;charset=utf-8"})
	@ResponseBody
	public List<Makeup> getMakeup(Makeup makeup){
		System.out.println("执行getMakeup。。。");
		return makeupService.getMakeup(makeup);	
	}
	

	
	
	@RequestMapping("/upload")
	@ResponseBody
	 public String upload(@RequestParam(value="file", required=true) MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            String savePath = "C:/Users/Administrator/workspace/GD-parent/GD-web/src/main/resources/static/img/";
            // String savePath = request.getServletContext().getRealPath("/static/img/upload");
            File saveFile = new File(savePath + saveFileName);
            
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                System.out.println("shangchuanchenggong"+saveFile);
                return " 上传成功";
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("shangchuanshibai");
                return "上传失败" ;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("上传失败");
                return "上传失败," + e.getMessage();
            }
        } else {
        	System.out.println("上传失败。。");
            return "上传失败，因为文件为空.";
        }
    }

/*	@RequestMapping(value="/upload")
	public ModelAndView upload(HttpServletRequest request
			, @RequestParam(value="file", required=true) MultipartFile file
			, User user) throws Exception {
		//获取保存文件的真实路径
		String savePath = request.getServletContext().getRealPath("/upload");
		//获取上传的文件名
		String fileName = file.getOriginalFilename();
		//创建File对象
		File targetFile = new File(savePath, fileName);
		//保存文件
		file.transferTo(targetFile);
		//把上传文件的URL保存到Model中
		ModelAndView mv = new ModelAndView();
		mv.addObject("picUrl", "/upload/" + fileName);
		mv.setViewName("success");
		System.out.println("shangchuanchenggong");
		return mv;
	}
	*/
	
	@RequestMapping("/getyoupi")
	@ResponseBody
	public List<Makeup> getyoupi(Makeup makeup){
		return makeupService.getyoupi(makeup);
		
	}
	

	

	
	
}
