package com.zhiyou.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou.model.Role;
import com.zhiyou.modelAccept.User_RoleAccept;
import com.zhiyou.modelAssocation.UserRoleAssocation;

public interface UserMapper {

	List<UserRoleAssocation> findUsers(User_RoleAccept uRA);

	int delete(int id);

	int deleteUL(int id);

	List<Role> getRole();

	int addUser(User_RoleAccept uRA);

	int addGetid(User_RoleAccept uRA);

	int addUser_role(Map<String, Integer> map);

	UserRoleAssocation findById(int id);

}
