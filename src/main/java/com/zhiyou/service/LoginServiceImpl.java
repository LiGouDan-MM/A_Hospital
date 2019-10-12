package com.zhiyou.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.LoginMapper;
import com.zhiyou.model.User;

@Service
public class LoginServiceImpl implements LoginService {
    
	@Autowired
	private LoginMapper mapper;
	
	@Override
	public boolean findUser(String user_name, String password) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("user_name",user_name);
		map.put("password",password );
		User user = mapper.findUser(map);
		if (user != null) {
			return true;
		}
		return false;
	}

}
