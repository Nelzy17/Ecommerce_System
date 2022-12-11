package com.ecommerce.Ecommerce_System.dto.user;

public class SignInResponseDto {

	private String status;
	private int userId;
	private String userName;

	public SignInResponseDto(String status, int userId, String userName) {
		this.status = status;
		this.userId = userId;
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
