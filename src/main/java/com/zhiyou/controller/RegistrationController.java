package com.zhiyou.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou.model.Doctor;
import com.zhiyou.model.RegistrationInfor;
import com.zhiyou.model.Registration_Infor;
import com.zhiyou.model.Section;
import com.zhiyou.modelAccept.RegistrationAccept;
import com.zhiyou.service.RegistrationService;

@Controller
@RequestMapping("/Registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@RequestMapping("/Query")
	public String findRegistration(String pageJsp,RegistrationAccept rAccept,HttpServletRequest request) {
		System.out.println("=======-=-=-=-=-"+rAccept.getDocName());
		int total = service.getCount(rAccept);//总条数
		int pageSize = 3; // 每页展示3条
		int pageNum = total%pageSize==0?(total/pageSize):(total/pageSize+1); //一共多少页
		int page = 1;// 当前页
		if (pageJsp != null) {
			page = Integer.parseInt(pageJsp);
		}
		int preIndex = (page-1)*pageSize;//分页开始索引
		// 放在对象中,不需要用map集合
		rAccept.setPageSize(pageSize);
		rAccept.setPreIndex(preIndex);
		List<Registration_Infor> list = service.queryall(rAccept);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("total", total);
		request.setAttribute("page", page);
		
		request.setAttribute("medical_record", rAccept.getMedical_record());
		request.setAttribute("docName", rAccept.getDocName());
		request.setAttribute("secco_name", rAccept.getSecco_name());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (rAccept.getTime1()!=null && rAccept.getTime2()!=null) {
			String time11 = sdf.format(rAccept.getTime1());
			String time22 = sdf.format(rAccept.getTime2());
			request.setAttribute("time1", time11);
			request.setAttribute("time2", time22);
		}
		return "forward:/WEB-INF/registration/list.jsp";
	}
	
	@RequestMapping("/Detail")
	public String detail(RegistrationAccept rAccept,HttpServletRequest request) {
		System.out.println(rAccept);
		request.setAttribute("rAccept", rAccept);
		return "forward:/WEB-INF/registration/detail.jsp";
	}
	
	@RequestMapping("/AddTrain")
	public String addTrain(HttpServletRequest request) {
		List<Doctor> doctor = service.getDoctor();// 获取医生id
		List<Section> section = service.getSection();// 获取科室表id
		System.out.println("================"+doctor);
		System.out.println("================"+section);
		request.setAttribute("doctor",doctor );
		request.setAttribute("section",section );
		return "forward:/WEB-INF/registration/add.jsp";
	}
	@RequestMapping("/Add")
	public String add(RegistrationInfor rInf) {
		System.out.println(rInf);
		int iR = service.addRegistrationInfor(rInf);
		System.out.println("受影响的行数"+iR);
		return "redirect:/Registration/Query";
	}
	
	@RequestMapping(value="/Update",method=RequestMethod.GET)
	public String UpdateDetail(int id,RegistrationAccept rAccept,HttpServletRequest request) {
		System.out.println("==============="+id);
		System.out.println("---------------"+rAccept);
		request.setAttribute("rAccept",rAccept );
		List<Doctor> doctor = service.getDoctor();// 获取医生id
		List<Section> section = service.getSection();// 获取科室表id
		request.setAttribute("doctor",doctor );
		request.setAttribute("section",section );
		request.setAttribute("id",id );
		return "forward:/WEB-INF/registration/update.jsp";
	}
	
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	public String Update(RegistrationInfor rInf,HttpServletRequest request) {
		System.out.println(rInf);
		int iR = service.updateRegistration_Infor(rInf);
		System.out.println(iR);
		return "forward:/Registration/Query";
	}
	@RequestMapping("/Back")
	public String backNo(int id,HttpServletRequest request) {
		System.out.println("=============="+id);
		int iR = service.back(id);
		System.out.println(iR);
		return "forward:/Registration/Query";
	}
	@RequestMapping("/Delete")// 批量删除
	public String detele(@RequestParam(value="check",defaultValue="") int[] id,HttpServletRequest request) {
		System.out.println("===你还能n======");
		for (int a : id) {
		    int iR = service.Delete(a);
		    System.out.println("受影响的行数: "+iR);
		}
		return "forward:/Registration/Query";
	}


}
