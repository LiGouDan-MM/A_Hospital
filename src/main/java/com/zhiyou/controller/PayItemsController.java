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
import com.zhiyou.model.PayItems;
import com.zhiyou.modelAccept.pay_itemsAccept;
import com.zhiyou.modelAssocation.PayRegistrationChargeAssocation;
import com.zhiyou.service.PayItemsService;
import com.zhiyou.service.PayItemsServiceImpl;


@Controller
@RequestMapping("/PayItems")
public class PayItemsController {
	@Autowired
	private PayItemsService service = new PayItemsServiceImpl();
	
	@RequestMapping("/Query")
	public String findAll(@RequestParam(value="pageNum",defaultValue="1")int pageNum ,pay_itemsAccept pIA,HttpServletRequest request) {
		PageHelper.startPage(pageNum, 3);
		List<PayRegistrationChargeAssocation> list = service.findAll(pIA);
		PageInfo<PayRegistrationChargeAssocation> pageInfo = new PageInfo<PayRegistrationChargeAssocation>(list);
		request.setAttribute("list", list);
		request.setAttribute("firstPage",pageInfo.getFirstPage() );// 第一页
		request.setAttribute("lastPage",pageInfo.getLastPage() );// 最一页
		request.setAttribute("total",pageInfo.getTotal() );// 总条数
		request.setAttribute("pages",pageInfo.getPages() );// 总页数
		request.setAttribute("pageNum",pageInfo.getPageNum() );// 当前页
		request.setAttribute("pIA",pIA );// 模糊查询字段
		return "forward:/WEB-INF/pay_items/list.jsp";
	}
	@RequestMapping("/AddTrain")
	public String addTrain(String medical_record,String name,HttpServletRequest request) {
		request.setAttribute("medical_record", medical_record);
		request.setAttribute("name", name);
		List<PayItems> list = service.findPay_Items();
		request.setAttribute("list", list);
		return "forward:/WEB-INF/pay_items/add.jsp";
	}
	@RequestMapping("/Add")
	public String add(pay_itemsAccept pIAccept,HttpServletRequest request) {
		System.out.println("==----=-=-="+pIAccept);
		int iR = service.addCharge_Manager(pIAccept);
		System.out.println("受影响的行数"+iR);
		return "redirect:/PayItems/Query";
	}
	@RequestMapping("/AddTotal")
	public String addtotal(HttpServletRequest request) {
		return "forward:/WEB-INF/pay_items/addTotal.jsp";
	}
	@RequestMapping(value="/AddTotal",method=RequestMethod.POST)
	public String addTotal(String charge_item_name,Double receivable_money,HttpServletRequest request) {
		int iR = service.add(charge_item_name,receivable_money);
		System.out.println("受影响的行数"+iR);
		return "forward:/PayItems/Query";
	}
	
	
}
