package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@RequestMapping("/Login")
	public String login(HttpServletRequest request,String user_name,String password) {
		boolean boo = service.findUser(user_name,password);
		if (boo==true) {
		    // 登录成功
			request.setAttribute("user_name",user_name);
			return "forward:/WEB-INF/index.jsp";	  
		}
		// 登录失败
		request.setAttribute("ErrMessage","用户名或者密码错误");
		return "forward:/login.jsp";
		
	}

}
