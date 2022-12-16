package com.ecommerce.Ecommerce_System.dto.user;

public class RegisterDto {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String address;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void getAddress(String address) {
		this.address = address;
	}
}
