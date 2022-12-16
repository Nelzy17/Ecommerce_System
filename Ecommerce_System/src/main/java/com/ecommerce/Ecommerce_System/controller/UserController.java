package com.ecommerce.Ecommerce_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce_System.dto.user.LoginResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.RegisterResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.LoginDto;
import com.ecommerce.Ecommerce_System.dto.user.RegisterDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.service.interfaces.IUserService;

@RequestMapping("user")
@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("/signup")
	public RegisterResponseDto Signup(@RequestBody RegisterDto signupDto) throws CustomException {
		return userService.signUp(signupDto);
	}

	@PostMapping("/signin")
	public LoginResponseDto SignIn(@RequestBody LoginDto signInDto) throws CustomException {
		return userService.signIn(signInDto);
	}
}
