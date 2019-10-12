package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.modelAssocation.DispensingTotal;
import com.zhiyou.service.DispensingService;

@Controller
@RequestMapping("/Dispensing")
public class DispensingController {
	
	@Autowired
	private DispensingService service ;
	
	@RequestMapping("/Query")
	public String find(HttpServletRequest request) {
		List<DispensingTotal> list = service.find();
		request.setAttribute("list", list);
		return "forward:/WEB-INF/dispensing/list.jsp";
	}

}
