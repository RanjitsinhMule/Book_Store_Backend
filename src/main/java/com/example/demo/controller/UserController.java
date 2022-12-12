package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.LoginDto;
import com.example.demo.DTO.UserDto;
import com.example.demo.service.IUserService;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/User")
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	IUserService userService;

	@PostMapping("/insertUser")
	public ResponseEntity AddAddressDetails(@RequestBody UserDto userDto) {
		ResponseEntity user = userService.add(userDto);
		return new ResponseEntity(user, "User added succesfully");
	}

	@GetMapping("/findAllUser")
	public ResponseEntity findAllDetails() {
		List<UserDto> userList = userService.findAll();
		return new ResponseEntity(userList, "All user list");
	}

	@GetMapping("/getUser/{Id}")
	public ResponseEntity FindById(@PathVariable Long Id) {
		UserDto user = userService.findById(Id);
		return new ResponseEntity(user, "Find successfully");
	}

	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity getDataByEmail(@PathVariable String email) {
		UserDto user = userService.getUserByEmail(email);
		return new ResponseEntity(user, "Find successfully");
	}

	@PutMapping("/edit/{email_address}")
	public ResponseEntity updateByEmail(@PathVariable String email_address, @RequestBody UserDto userDto) {
		UserDto user = userService.editUserByEmail(email_address, userDto);
		return new ResponseEntity(user, "Updated successfully");
	}

	@PostMapping("/login")
	public ResponseEntity loginUser(@RequestBody LoginDto loginDto) {
		String login = userService.loginUser(loginDto);
		return new ResponseEntity(login, "Login successfully");
	}

	@GetMapping("/logout")
	public ResponseEntity logout(@RequestHeader String token) {
		UserDto logout = userService.logout(token);
		return new ResponseEntity(logout, "Logout successfully");
	}

//	@PostMapping("/forgotPassword")
//	public ResponseEntity forgotPassword(@RequestBody UserDto userDto) {
//		String password = userService.forgotPassword(userDto);
//		return new ResponseEntity(password, "Checking password for emailId");
//	}

	@PostMapping("/resetPassword")
	public ResponseEntity resetPassword(@RequestBody UserDto userDto) {
		String password = userService.resetPassword(userDto);
		return new ResponseEntity(password, "Reset password successfully");
	}
	
	@GetMapping("/getuserbytoken")
	public ResponseEntity getUserByLogin(@RequestHeader String token) {
		UserDto userDto = userService.getUserByLogin(token);
		return new ResponseEntity(userDto, "Fetched user details");
	}

}
