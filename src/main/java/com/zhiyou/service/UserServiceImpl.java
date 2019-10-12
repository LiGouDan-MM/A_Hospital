package com.zhiyou.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.Role;
import com.zhiyou.modelAccept.User_RoleAccept;
import com.zhiyou.modelAssocation.UserRoleAssocation;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserMapper mapper;
	@Override
	public List<UserRoleAssocation> findUsers(User_RoleAccept uRA) {
		return mapper.findUsers(uRA);
	}
	@Override
	public Boolean delete(int id) {
		// 先删除user_role角色用户表里的信息  
		int iRUL = mapper.deleteUL(id);
		int iRUser = mapper.delete(id) ;
		if (iRUser > 0 && iRUL > 0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Role> getRole() {
		return mapper.getRole() ;
	}
	@Override
	public Boolean add(User_RoleAccept uRA) {
		int iRUser = mapper.addUser(uRA);
		int userid = mapper.addGetid(uRA);// 获得插入后的id
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("userId", userid);
		map.put("roleId", uRA.getRole_id());// 获取role_id
		int iRUser_role = mapper.addUser_role(map);
		if (iRUser > 0 && userid > 0 && iRUser_role > 0) {
			return true;
		}
		return false;
	}
	@Override
	public UserRoleAssocation findById(int id) {
		return mapper.findById(id);
	}
	

}
