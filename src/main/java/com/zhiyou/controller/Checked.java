package com.zhiyou.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.service.AjaxService;
import com.zhiyou.service.AjaxServiceImpl;

import util.TestFastDFS;

@Controller
@RequestMapping("/Check")
public class Checked {
	@Autowired
	AjaxService as =  new  AjaxServiceImpl();
	
	@RequestMapping("/User")
	public void testAxjx(String usernameJosn,HttpServletResponse response) throws IOException {
		System.out.println("============"+usernameJosn);
		String code = as.checkedUser(usernameJosn);
		response.getWriter().write(code);
	}
    /*
     * 可以使返回的对象变为json对象
     * {"":"","":"","":{}}
     * 
     */
	@RequestMapping("/User2")
	@ResponseBody   
	public ResponseObject testAxjx2(String usernameJosn,HttpServletResponse response) throws IOException {
		System.out.println("============"+usernameJosn);
		ResponseObject resObj = as.checkedUser2(usernameJosn);
		return resObj;
	}
	
	@RequestMapping("/findUserById")
	@ResponseBody 
	public ResponseObject testAxjx3(String id,HttpServletResponse response) throws IOException {
		System.out.println("==========aa"+id);
		ResponseObject resObj = as.findUserById(id);
		System.out.println("===========---------====="+resObj);
		return resObj;
	}
	@RequestMapping("/findDoctorBySectionID")
	@ResponseBody 
	public ResponseObject testAxjx4(String sectionId,HttpServletResponse response) throws IOException {
		System.out.println("===="+sectionId);
		ResponseObject resObj = as.findDoctorBySectionID(sectionId);
		return resObj;
	}
	
	@RequestMapping("/toEchartsUI")
	public String  showEchartsUI(){
		//double[] month = {100.0,90.0,80.0,70.0,65.0,52.0,};
		return "Echarts";
	}
	@RequestMapping("/showEchartsUI")
	@ResponseBody 
	public double[]  toEchartsUI(){
		double[] month = {100.0,90.0,80.0,70.0,65.0,52.0,45.0};
		return month;
	}
	@RequestMapping("/showEchartsUI2")
	@ResponseBody 
	public ArrayList  toEchartsUI2(){
		ArrayList<Double[]> list = new ArrayList<>();
		Double[] k1 = {100.0,90.0,80.0,70.0,65.0,52.0,45.0};
		Double[] k2 = {10.0,50.0,80.0,70.0,65.0,52.0,45.0};
		Double[] k3 = {70.0,90.0,80.0,70.0,65.0,52.0,45.0};
		Double[] k4 = {50.0,80.0,80.0,70.0,65.0,52.0,45.0};
		list.add(k1);
		list.add(k2);
		list.add(k3);
		list.add(k4);
		return list;
	}
	@RequestMapping("/POI")
	@ResponseBody 
	public ResponseObject exportExcel(String[] IDArr ) {
		System.out.println("=====-=-=-=--=-="+IDArr);
		/*
		 * 根据id查数据库,返回一个或多个用户对象
		 */
		return new ResponseObject("200","成功");
	}
	@RequestMapping("/Delete")
	public String delete(@RequestParam(value="check",defaultValue="")int[] a) {
		System.out.println("hahaah "+a.toString());
		
		return "Echarts";
	}
	
	/*
	 * ajax实现上传并回显
	 * (上传至服务器)
	 */
	@RequestMapping("/Upload")
	@ResponseBody
	public ResponseObject ajaxUpload(MultipartFile img,HttpServletRequest request) throws IOException {
		// 1.获得上传的对象
		// 2. 获得最终上传的目的地路径(上传至服务器中当前项目下)
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println(realPath);
		// 2.1 将最终目的文件夹创建出来
		File file = new File(realPath);
		// 判断该文件是否存在
		if(file.exists()) {
			// 不存在则创建出
			file.mkdir();
		}
		// 2.2 获得文件名
		/*
		 * 文件名重复时不能重复上传文件
		 */
		String fileName = img.getOriginalFilename();
		System.out.println(fileName);
		/*
		 * 获得文件后缀名
		 */
		String[] split = fileName.split("\\.");
		System.out.println(Arrays.toString(split));
		String suffix = split[1];
		// 以当前毫秒值为文件名
		long prefix = new Date().getTime();
		// 组装文件名
		String newFileName = prefix+"."+suffix;
		System.out.println("新的文件名 : "+newFileName);
		System.out.println("文件名 : "+fileName);
		// 2.3 确定上传路径
		File newFile = new File(file,newFileName);
		// 3. 上传
		FileUtils.writeByteArrayToFile(newFile, img.getBytes());
		String path ="/upload/"+newFileName;
		return new ResponseObject("200","成功",path);
	}
	
	
	/*
	 * ajax上传回显
	 * 上传至FastDFS
	 * 
	 */
	@RequestMapping("/Upload2")
	@ResponseBody
	public Map ajaxUploadFastDFS(MultipartFile img) throws IOException, MyException {
		// 1.获得上传的对象
		String path = TestFastDFS.upload(img);
		String split = path.split("http://ligoudan/")[1];
		Map<String,String> map = new HashMap<>();
		map.put("file_id", split);
		map.put("status", "200");
		map.put("success", "200");
		map.put("path", path);
		return map;
	}
	
	@RequestMapping("/DownLoad")
	@ResponseBody
	public ResponseObject ajaxDownLoadFastDFS(String file_Id) throws IOException, MyException {
		String suffx = file_Id.split("\\.")[1];
		System.out.println(suffx);
		TestFastDFS.download(file_Id,suffx);
		String success = "下载成功";
		return new ResponseObject("200","成功",success);
	}
	
	
}
