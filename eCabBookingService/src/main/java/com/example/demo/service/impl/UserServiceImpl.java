package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	@Override
	public UserDto authenticateUser(LoginDto loginDto) {
		UserDto userDto = new UserDto();
		Optional<User> user =  userDao.findByUserNameAndPassword(loginDto.getUserName(),loginDto.getPassword());
		if(user.isPresent())
		{
			BeanUtils.copyProperties(user.get(), userDto);
		return userDto;
		}
		else
			return new UserDto(0L);
		
	}

	@Override
	public UserDto getUserDetails(Long userId) {
		UserDto userDto = new UserDto();
		Optional<User> user = userDao.findById(userId);
		if(user.isPresent())
		{
			BeanUtils.copyProperties(user.get(), userDto);
			return userDto;
			
		}
		else return new UserDto(0L);
	}

	@Override
	public boolean loginUser(LoginDto loginDto) {
		Optional<User> user =  userDao.findByUserNameAndPassword(loginDto.getUserName(),loginDto.getPassword());
		if(user.isPresent())
	
		return true;
		
		else
			return false;
	}

}
