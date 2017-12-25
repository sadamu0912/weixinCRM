package com.xjxspace.mapper;

import java.util.List;
import java.util.Map;

import com.xjxspace.model.User;


public interface UserMapper {
	 List<User> getAllUser();
	 List<User>  getUserByUserName (Map<String,Object> params);
}
