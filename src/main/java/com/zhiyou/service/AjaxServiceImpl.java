package com.zhiyou.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zhiyou.controller.ResponseObject;
import com.zhiyou.model.Doctor;
import com.zhiyou.model.User;

@Service
public class AjaxServiceImpl implements AjaxService {

	@Override
	public String checkedUser(String usernameJosn) {
		/*
		 * 只要用户名不是admin,都可以注册
		 * 
		 */
		String code = null;
		if(usernameJosn != null && usernameJosn !="" && !usernameJosn.equals("admin")) {
			//可以注册
			 code="{\"code\":\"200\"}";
		}else {
			// 不可以注册
			code="{\"code\":\"404\"}";
		}
		System.out.println("业务层"+code);
		return code;
	}

	@Override
	public ResponseObject checkedUser2(String usernameJosn) {
		ResponseObject obj = new ResponseObject();
		if(usernameJosn != null && usernameJosn !="" && !usernameJosn.equals("admin")) {
			//可以注册
			obj.setCode("200");
			obj.setMsg("可以");
		}else {
			// 不可以注册
			obj.setCode("404");
			obj.setMsg("不可以");
		}
		System.out.println("业务层"+obj);
		return obj;
	}

	@Override
	public ResponseObject findUserById(String id) {
		// 假设直接能查到
		User user = new User();
		user.setUser_name("张三");
		user.setPassword("123456");
		user.setEmail("1729375118@qq.com");
		ResponseObject obj = new ResponseObject("200","成功",user);
		return obj;
	}

	@Override
	public ResponseObject findDoctorBySectionID(String sectionId) {
		ArrayList<Doctor> list = new ArrayList<Doctor>();
		if (sectionId!=null && sectionId!="") {
			if(sectionId.equals("1")) {
				Doctor doctor = new Doctor();
				doctor.setName("1张三");
				Doctor doctor2 = new Doctor();
				doctor2.setName("1lisi");
				Doctor doctor3 = new Doctor();
				doctor3.setName("1wangwu");
				list.add(doctor);
				list.add(doctor2);
				list.add(doctor3);
			} else if (sectionId.equals("2")) {
				Doctor doctor = new Doctor();
				doctor.setName("2张三");
				Doctor doctor2 = new Doctor();
				doctor2.setName("2lisi");
				Doctor doctor3 = new Doctor();
				doctor3.setName("2wangwu");
				list.add(doctor);
				list.add(doctor2);
				list.add(doctor3);
			} else if (sectionId.equals("3")) {
				Doctor doctor = new Doctor();
				doctor.setName("3张三");
				Doctor doctor2 = new Doctor();
				doctor2.setName("3lisi");
				Doctor doctor3 = new Doctor();
				doctor3.setName("3wangwu");
				list.add(doctor);
				list.add(doctor2);
				list.add(doctor3);
			}
		}
		ResponseObject obj = new ResponseObject("200","成功",list);
		System.out.println(obj);
		return obj;
	}

}
