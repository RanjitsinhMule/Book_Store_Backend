package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.LoginDto;
import com.example.demo.DTO.UserDto;
import com.example.demo.exceptions.BookException;
import com.example.demo.model.UserModel;
import com.example.demo.repository.IUserRepo;
import com.example.demo.utility.JavaEmailService;
import com.example.demo.utility.JwtTokenUtil;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepo userRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Autowired
	JavaEmailService javaEmailService;

	@Override
	public ResponseEntity add(UserDto userDto) {
		try {
			if (userRepo.findByEmail(userDto.getEmail()).isPresent()) {
			System.out.println("Registered");
			throw new BookException("User already exist");
		} else {
			System.out.println("Pass1 ");
			String token = jwtTokenUtil.generateToken(userDto.getEmail(), userDto.getPassword());
			System.out.println("Pass2 ");
			javaEmailService.sendSimpleMail(userDto.getEmail(), token, "Verification");
			System.out.println("Pass3 ");
			UserModel addUser = modelMapper.map(userDto, UserModel.class);
			System.out.println("Pass4 ");
			userRepo.save(addUser);
			System.out.println("Pass5 ");
			System.out.println("Registering is done");
			return new ResponseEntity(userDto, "One user added");

		}
			
		} catch (Exception e) {
			System.out.println("exception"+e);
		}
		return null;
		
	}

	@Override
	public List<UserDto> findAll() {
		return userRepo.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto findById(Long Id) {
		Optional<UserModel> user = userRepo.findById(Id);
		if (user.isEmpty()) {
			throw new BookException(" User Id does not exist");
		}
		UserDto userDto = modelMapper.map(user.get(), UserDto.class);
		return userDto;
	}

	@Override
	public UserDto getUserByEmail(String email) {
		Optional<UserModel> user = userRepo.findByEmail(email);
		if (user.isEmpty()) {
			throw new BookException(" User Email does not exist");
		}
		UserDto userDto = modelMapper.map(user.get(), UserDto.class);
		return userDto;
	}

	@Override
	public UserDto editUserByEmail(String email_address, UserDto userDto) {
		UserModel editUser = userRepo.findByEmail(email_address).orElse(null);
		if (editUser != null) {
			UserModel user = modelMapper.map(userDto, UserModel.class);
			user.setEmail(email_address);
			userRepo.save(editUser);
			return userDto;
		} else {
			throw new BookException("Email:" + email_address + " is not present");
		}
	}

	@Override
	public String loginUser(LoginDto loginDto) {
		Optional<UserModel> user = userRepo.findByEmailAndPassword(loginDto.getEmail_address(), loginDto.getPassword());
		if (user.isEmpty()) {
			Optional<UserModel> userEmail = userRepo.findByEmail(loginDto.getEmail_address());
			Optional<UserModel> userPassword = userRepo.findByPassword(loginDto.getPassword());
			if (userEmail.isEmpty()) {
				throw new BookException("Email is incorrect,Give correct Email");
			} else if (userPassword.isEmpty()) {
				throw new BookException("Password is incorrect,Give correct password");
			}
		}
		String token = jwtTokenUtil.generateToken(loginDto);
		user.get().setIsLogin(true);
		userRepo.save(user.get());
//		System.out.println("Check the user is login or not " + user.get().getIsLogin());
		return token;
	}


	@Override
	public UserDto logout(String token) {
		LoginDto userDto = jwtTokenUtil.decode(token);
		Optional<UserModel> checkUserDetails = userRepo.findByEmailAndPassword(userDto.getEmail_address(),
				userDto.getPassword());
		UserDto logout = modelMapper.map(checkUserDetails, UserDto.class);
		checkUserDetails.get().setIsLogin(false);
		userRepo.save(checkUserDetails.get());
		return logout;
	}

//	@Override
//	public String forgotPassword(UserDto userDto) {
//		Optional<UserModel> user = userRepo.findByEmail(userDto.getEmail());
//		if(user != null) {
//			javaEmailService.sendSimpleMail(user.getEmail, "Login", "http");
//		}
//		return null;
//	}



	@Override
	public String resetPassword(UserDto userDto) {
		Optional<UserModel> user = userRepo.findByEmail(userDto.getEmail());
		String password = userDto.getPassword();
		if(user.isPresent()) {
			user.get().setPassword(password);
			userRepo.save(user.get());
			return "Password Changed";
		}else {
		return "Password is not Valid";
		}
	}
	
	@Override
	   public UserDto getUserByLogin(String token) {
		   LoginDto loginDto = jwtTokenUtil.decode(token);
			Optional<UserModel> userModel = userRepo.findByEmailAndPassword(loginDto.getEmail_address(), loginDto.getPassword());
			if (userModel.get().getIsLogin().equals(true)) {
				UserDto userDto = modelMapper.map(userModel.get(), UserDto.class);
				System.out.println("Get the data successfully ");
				return userDto;
			} else {
				throw new BookException("Data not found");
			}
		}
}
