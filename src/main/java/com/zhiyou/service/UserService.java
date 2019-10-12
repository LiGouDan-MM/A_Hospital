package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Role;
import com.zhiyou.modelAccept.User_RoleAccept;
import com.zhiyou.modelAssocation.UserRoleAssocation;

public interface UserService {

	List<UserRoleAssocation> findUsers(User_RoleAccept uRA);

	Boolean delete(int id);

	List<Role> getRole();

	Boolean add(User_RoleAccept uRA);

	UserRoleAssocation findById(int id);


}
