package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	Long userId;
	String firstName;
	String lastName;
	String address;
	@Column(name = "email")
	String email;
	String DOB;
	String password;
	private Boolean IsVerified = false;
	private Boolean IsLogin;

	public UserModel() {
		super();
	}

	
	public UserModel(Long userId, String firstName, String lastName, String address, String email, String dOB,
			String password, Boolean isVerified, Boolean isLogin) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		DOB = dOB;
		this.password = password;
		IsVerified = isVerified;
		IsLogin = isLogin;
	}


	public Boolean getIsVerified() {
		return IsVerified;
	}


	public void setIsVerified(Boolean isVerified) {
		IsVerified = isVerified;
	}


	public Boolean getIsLogin() {
		return IsLogin;
	}


	public void setIsLogin(Boolean isLogin) {
		IsLogin = isLogin;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
