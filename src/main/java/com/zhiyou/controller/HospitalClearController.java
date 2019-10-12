package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.modelAssocation.A;
import com.zhiyou.modelAssocation.HospitalClearRegistration_inforAssocation;
import com.zhiyou.modelAssocation.Registration_InforPay_ItemsCharge_ManagerAssocation;
import com.zhiyou.service.HospitalClearService;

@Controller
@RequestMapping("/HospitalClear")
public class HospitalClearController {
	@Autowired
	private HospitalClearService service;
	
	@RequestMapping("/Query")
	public String findRegistration(@RequestParam(value="pageNum",defaultValue="1")int pageNum ,String name,String medical_record,HttpServletRequest request) {
		PageHelper.startPage(pageNum,2);
		List<HospitalClearRegistration_inforAssocation> list = service.find(name, medical_record);
		PageInfo<HospitalClearRegistration_inforAssocation> pageInfo = new PageInfo<>(list);
		request.setAttribute("firstPage",pageInfo.getFirstPage() );// 第一页
		request.setAttribute("lastPage",pageInfo.getLastPage() );// 最一页
		request.setAttribute("total",pageInfo.getTotal() );// 总条数
		request.setAttribute("pages",pageInfo.getPages() );// 总页数
		request.setAttribute("pageNum",pageInfo.getPageNum() );// 当前页
		request.setAttribute("name",name );// 模糊查询字段
		request.setAttribute("medical_record",medical_record );// 模糊查询字段
		request.setAttribute("list", list);
		return "forward:/WEB-INF/hospitalClear/list.jsp";
	}
	@RequestMapping("/Detail")
	public String detail(Registration_InforPay_ItemsCharge_ManagerAssocation rIIMA,HttpServletRequest request) {
		String medical_record = rIIMA.getMedical_record();
		System.out.println("就是这个万恶的病例号啊啊啊啊啊啊"+medical_record);
		List<Registration_InforPay_ItemsCharge_ManagerAssocation> list = service.detail(rIIMA);
		request.setAttribute("list", list);
		double chargeMoney = 0;
		for (Registration_InforPay_ItemsCharge_ManagerAssocation a : list) {
			for (A s  : a.getA()) {
				chargeMoney+=s.getCharge_money();
			}
		}
		request.setAttribute("chargeMoney", chargeMoney);
		return "forward:/WEB-INF/hospitalClear/detail.jsp";
	}
	@RequestMapping("/Close")
	public String Close(int id,HttpServletRequest request) {
		System.out.println("====dddd===="+id);
		int iR = service.colse(id);
		System.out.println("受影响的行数: "+iR);
		return "forward:/HospitalClear/Query";
	}

}
