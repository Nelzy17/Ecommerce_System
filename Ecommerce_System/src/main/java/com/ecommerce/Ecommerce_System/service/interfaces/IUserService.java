package com.ecommerce.Ecommerce_System.service.interfaces;

import com.ecommerce.Ecommerce_System.dto.user.LoginResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.RegisterResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.LoginDto;
import com.ecommerce.Ecommerce_System.dto.user.RegisterDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.UserModel;

public interface IUserService {

	public RegisterResponseDto signUp(RegisterDto signupDto) throws CustomException;

	public LoginResponseDto signIn(LoginDto signInDto) throws CustomException;

	public UserModel getUser(String userName);

	public int getAllUsers();
}
