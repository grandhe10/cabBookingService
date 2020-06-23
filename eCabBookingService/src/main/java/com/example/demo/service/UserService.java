package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

public interface UserService {
	
	public UserDto authenticateUser(LoginDto loginDto);
	
	public UserDto getUserDetails(Long userId);
	
	public boolean loginUser(LoginDto loginDto);


}
