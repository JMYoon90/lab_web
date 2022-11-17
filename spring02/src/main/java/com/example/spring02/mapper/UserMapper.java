package com.example.spring02.mapper;

import java.util.List;

import com.example.spring02.domain.User;

public interface UserMapper {

	User selectById(Integer id);

	List<User> selectOrderByIdDesc();

	int insert(User entity);

	int delete(Integer id);

	int update(User entity);
	
	User signIn(User user);

}
