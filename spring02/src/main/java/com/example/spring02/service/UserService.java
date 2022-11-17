package com.example.spring02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring02.domain.User;
import com.example.spring02.dto.UserCreateDto;
import com.example.spring02.dto.UserUpdateDto;
import com.example.spring02.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserMapper userMapper;

	public List<User> read() {
		log.info("read()");
		return userMapper.selectOrderByIdDesc();
	}

	public int insert(UserCreateDto dto) {
		log.info("insert(dto={})", dto);
		return userMapper.insert(dto.toEntity());
	}

	public User selectById(Integer id) {
		log.info("read(id={})", id);
		return userMapper.selectById(id);
	}

	public int delete(Integer id) {
		log.info("delete(id={}", id);
		return userMapper.delete(id);
		
	}

	public int update(UserUpdateDto dto) {
		log.info("update(dto={})", dto);
		return userMapper.update(dto.toEntity());
	}

	public User signin(UserCreateDto dto) {
		log.info("signin");
		return userMapper.signIn(dto.toEntity());
	}

}
