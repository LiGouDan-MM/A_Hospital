package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.model.CertificateType;
import com.zhiyou.model.Doctor;
import com.zhiyou.model.Doctor_CS;
import com.zhiyou.model.Section;
import com.zhiyou.modelAccept.DoctorAccept;
import com.zhiyou.service.DoctorService;

@Controller
@RequestMapping("/Doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	
	@RequestMapping("/Query")
	public String findAll(@RequestParam(defaultValue="1")int pageNum,DoctorAccept dAccept,HttpServletRequest request) {
		PageHelper.startPage(pageNum, 3);
		List<Doctor_CS> list = service.findAll(dAccept);
		PageInfo<Doctor_CS> pageInfo = new PageInfo<>(list);
		request.setAttribute("list",list );// 查询到的总数据
		request.setAttribute("firstPage",pageInfo.getFirstPage() );// 第一页
		request.setAttribute("lastPage",pageInfo.getLastPage() );// 最一页
		request.setAttribute("total",pageInfo.getTotal() );// 总条数
		request.setAttribute("pages",pageInfo.getPages() );// 总页数
		request.setAttribute("pageNum",pageInfo.getPageNum() );// 当前页
		request.setAttribute("dAccept",dAccept );// 模糊查询字段
		System.out.println("当前页:"+pageNum+"  总条数:"+pageInfo.getTotal()+"  总页数:"+pageInfo.getPages());
		return "forward:/WEB-INF/doctor/list.jsp";
	}
	@RequestMapping("/Detail")
	public String detial(int id ,HttpServletRequest request) {
		Doctor_CS doctor_CS = service.fingById(id);
		request.setAttribute("doctor_CS",doctor_CS );
		return "forward:/WEB-INF/doctor/detail.jsp";
	}
	@RequestMapping("/AddTrain")
	public String addTrain(HttpServletRequest request) {
	    List<CertificateType> certificateType = service.findCertificateType();
	    List<Section> section = service.findSection();
		request.setAttribute("certificateType",certificateType );
		request.setAttribute("section",section );
		return "forward:/WEB-INF/doctor/add.jsp";
	}
	@RequestMapping("/Add")
	public String add(Doctor doctor,HttpServletRequest request) {
		int iR = service.addDoctor(doctor);
		System.out.println("受影响行"+iR);
		return "forward:/Doctor/Query";
	}
	@RequestMapping(value="/Update",method=RequestMethod.GET)
	public String UpdateDetail(int id,HttpServletRequest request) {
		List<CertificateType> certificateType = service.findCertificateType();
		List<Section> section = service.findSection();
		Doctor_CS doctor_CS = service.fingById(id);
		request.setAttribute("doctor_CS",doctor_CS );
		request.setAttribute("certificateType",certificateType );
		request.setAttribute("section",section );
		return "forward:/WEB-INF/doctor/update.jsp";
	}
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	public String Update(Doctor doctor,HttpServletRequest request) {
		int iR = service.updateDoctor(doctor);
		System.out.println("受影响行"+iR);
		return "forward:/Doctor/Query";
	}
	
	@RequestMapping("/Delete")// 批量删除
	public String delete(@RequestParam(value="check",defaultValue="")int[] id,HttpServletRequest request) {
		for (int a : id) {
			int iR = service.delete(a);
			System.out.println("受影响行"+iR);
		}
		return "forward:/Doctor/Query";
	}
	

}
