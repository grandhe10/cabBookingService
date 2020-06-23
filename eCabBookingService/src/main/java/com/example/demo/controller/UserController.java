package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/users/logins")
	public ResponseEntity<String> loginUser(LoginDto loginDto) {

		if (userService.loginUser(loginDto))
			return new ResponseEntity<String>("User logged in successfully", HttpStatus.OK);
		else
			throw new InvalidCredentialsException("Invalid credentials!!!");

	}

	@PostMapping("/users/login")
	public ResponseEntity<UserDto> loginUser1(@RequestBody LoginDto loginDto) {
		UserDto userDto = userService.authenticateUser(loginDto);
		if (userDto.getUserId() == 0L)
			throw new InvalidCredentialsException("Invalid Credentials!!!");
		else
			return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);

	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId) {
		UserDto userDto = userService.getUserDetails(userId);
		if (userDto.getUserId() == 0L)
			throw new ResourceNotFoundException("Invalid Credentials!!!");
		else
			return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);

	}

}
