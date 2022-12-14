package com.ecommerce.Ecommerce_System.service.interfaces;

import com.ecommerce.Ecommerce_System.dto.user.SignInResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.SignUpResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.SigninDto;
import com.ecommerce.Ecommerce_System.dto.user.SignupDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.UserModel;

public interface IUserService {

	public SignUpResponseDto signUp(SignupDto signupDto) throws CustomException;

	public SignInResponseDto signIn(SigninDto signInDto) throws CustomException;

	public UserModel getUser(String userName);
}
