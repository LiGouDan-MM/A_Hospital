package com.zhiyou.mapper;

import java.util.Map;

import com.zhiyou.model.User;

public interface LoginMapper {

	User findUser(Map<String,String> map);

}
