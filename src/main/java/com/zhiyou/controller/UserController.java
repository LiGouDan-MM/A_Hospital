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
import com.zhiyou.model.Role;
import com.zhiyou.modelAccept.User_RoleAccept;
import com.zhiyou.modelAssocation.UserRoleAssocation;
import com.zhiyou.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping("/Query")
    public String find(@RequestParam(value="pageNum",defaultValue="1")int pageNum ,User_RoleAccept uRA,HttpServletRequest request) {
		PageHelper.startPage(pageNum, 3);
		List<UserRoleAssocation> list = service.findUsers(uRA);
		PageInfo<UserRoleAssocation> pageInfo = new PageInfo<>(list);
		request.setAttribute("firstPage",pageInfo.getFirstPage() );// 第一页
		request.setAttribute("lastPage",pageInfo.getLastPage() );// 最一页
		request.setAttribute("total",pageInfo.getTotal() );// 总条数
		request.setAttribute("pages",pageInfo.getPages() );// 总页数
		request.setAttribute("pageNum",pageInfo.getPageNum() );// 当前页
		request.setAttribute("User_RoleAccept",uRA );// 模糊查询字段
		request.setAttribute("list", list);
		return "forward:/WEB-INF/user/list.jsp";
	}
	@RequestMapping("/Delete")
	public String delete(int id) {
		Boolean deleteUser = service.delete(id);
 		System.out.println("是否成功: "+deleteUser);
		return "forward:/User/Query";
	}
	@RequestMapping("/AddTrain")
	public String addTrain(HttpServletRequest request) {
		List<Role> role = service.getRole();
		request.setAttribute("list", role);
		return "forward:/WEB-INF/user/add.jsp";
	}
	@RequestMapping("/Add")
	public String add(User_RoleAccept uRA) {
		System.out.println("======================="+uRA);
		Boolean addAction = service.add(uRA);
		System.out.println("是否添加成功: "+addAction);
		return "forward:/User/Query";
	}
	@RequestMapping(value="/Update",method=RequestMethod.GET)
	public String updateDetail(int id,HttpServletRequest request) {
		List<Role> role = service.getRole();
		request.setAttribute("list", role);
		UserRoleAssocation uRAssccation = service.findById(id); 
		request.setAttribute("uRAssccation", uRAssccation);
		return "forward:/WEB-INF/user/update.jsp";
	}
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	public String update(User_RoleAccept uRA,HttpServletRequest request) {
		System.out.println(uRA);
		return "forward:/User/Query";
	}
	
	

}
