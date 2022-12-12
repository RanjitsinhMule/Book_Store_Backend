package com.example.demo.service;

import java.util.List;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.LoginDto;
import com.example.demo.DTO.UserDto;


public interface IUserService {

	ResponseEntity add(UserDto userDto);

	List<UserDto> findAll();

	UserDto findById(Long Id);

	UserDto getUserByEmail(String email);

	UserDto editUserByEmail(String email_address, UserDto userDto);

	String loginUser(LoginDto loginDto);

	UserDto logout(String token);

//	String forgotPassword(UserDto userDto);

	String resetPassword(UserDto userDto);

	UserDto getUserByLogin(String token);

}
