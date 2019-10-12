package com.zhiyou.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.model.Drug;
import com.zhiyou.service.MedicineService;

@Controller
@RequestMapping("/Medicine")
public class MedicineController {
	
	@Autowired
	private MedicineService service;
	
	@RequestMapping("/Query")
	public String findAll(@RequestParam(value="pageNum",defaultValue="1")int pageNum , Drug drug ,HttpServletRequest request) {
		PageHelper.startPage(pageNum, 3);
		List<Drug> list = service.findAllMedicine(drug);
		PageInfo<Drug> pageInfo = new PageInfo<Drug>(list);
		request.setAttribute("list", list);
		request.setAttribute("firstPage",pageInfo.getFirstPage() );// 第一页
		request.setAttribute("lastPage",pageInfo.getLastPage() );// 最一页
		request.setAttribute("total",pageInfo.getTotal() );// 总条数
		request.setAttribute("pages",pageInfo.getPages() );// 总页数
		request.setAttribute("pageNum",pageInfo.getPageNum() );// 当前页
		request.setAttribute("drug",drug );// 模糊查询字段
		return "forward:/WEB-INF/medicine/list.jsp";
	}
	@RequestMapping("/AddTrain")
	public String addTrain(HttpServletRequest request) {
		return "forward:/WEB-INF/medicine/add.jsp";
	}
	@RequestMapping("/Add")
	public String add(@RequestParam(value="img",required=false)MultipartFile img,Drug drug,HttpServletRequest request) throws IOException {
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
		/*
		 * /upload/xx.jpg
		 * 
		 *  <img src="${}/upload/xx.jpg">
		 */
		// 添加
		drug.setDrug_url(newFileName);
		int iR = service.addDrug(drug);
		System.out.println("受影响的行数"+iR);
		return "forward:/Medicine/Query";
		
	}
	@RequestMapping("/Detail")
	public String detail(String drug_num,HttpServletRequest request) {
		Drug drug = service.destail(drug_num);
		request.setAttribute("drug", drug);
		request.setAttribute("path", "/upload/"+drug.getDrug_url());
		return "forward:/WEB-INF/medicine/detail.jsp";
	}
	@RequestMapping(value="/Update",method=RequestMethod.GET)
	public String updateDetail(String drug_num,HttpServletRequest request) {
		Drug drug = service.destail(drug_num);
		request.setAttribute("drug", drug);
		return "forward:/WEB-INF/medicine/update.jsp";
	}
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	public String update(@RequestParam(value="img",required=false)MultipartFile img,Drug drug,HttpServletRequest request) throws IOException {
		System.out.println("==========-0"+img);
		System.out.println(drug);
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
		if (split.length>0) {
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
		/*
		 * /upload/xx.jpg
		 * 
		 *  <img src="${}/upload/xx.jpg">
		 */
		// 添加
		drug.setDrug_url(newFileName);
		}
		int iR = service.update(drug);
		System.out.println("受影响的行数"+iR);
		return "forward:/Medicine/Query";
	}

}
