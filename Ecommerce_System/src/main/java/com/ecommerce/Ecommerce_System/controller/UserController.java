package com.ecommerce.Ecommerce_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce_System.dto.user.SignInResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.SignUpResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.SigninDto;
import com.ecommerce.Ecommerce_System.dto.user.SignupDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.service.interfaces.IUserService;

@RequestMapping("user")
@RestController
public class UserController {

	@Autowired
	IUserService userService;

	@PostMapping("/signup")
	public SignUpResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
		return userService.signUp(signupDto);
	}

	@PostMapping("/signin")
	public SignInResponseDto SignIn(@RequestBody SigninDto signInDto) throws CustomException {
		return userService.signIn(signInDto);
	}
}
