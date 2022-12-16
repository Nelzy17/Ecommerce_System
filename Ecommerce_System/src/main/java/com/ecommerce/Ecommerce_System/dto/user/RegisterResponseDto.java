package com.ecommerce.Ecommerce_System.dto.user;

public class RegisterResponseDto {

	private String status;
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RegisterResponseDto(String status, String message) {
		this.status = status;
		this.message = message;
	}
}
