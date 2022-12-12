package com.example.demo.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDto {

//	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid First Name(First Letter Should be in Upper Case and min 3 Characters.)")
	String firstName;
//	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{1,}$", message = "Invalid Last Name(First Letter Should be in Upper Case")
	String lastName;
	@NotEmpty(message = "Address Cannot be Empty")
	String address;
	@NotNull(message = "Email Address cannot be Null")
	String email;
//	@JsonFormat(pattern = "yyyy MM dd")
//	@NotNull(message = "Start Date cannot be Empty")
//	@Past(message = "Start Date should be past or present date")
	String DOB;
	@NotEmpty(message = "Password Cannot be Empty")
//	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*()-+=])([a-zA-Z0-9@._-]).{8,}$", message = "invalid password")
	String password;
	
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
