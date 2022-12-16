package com.ecommerce.Ecommerce_System.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.dto.user.LoginDto;
import com.ecommerce.Ecommerce_System.dto.user.LoginResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.RegisterDto;
import com.ecommerce.Ecommerce_System.dto.user.RegisterResponseDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.UserModel;
import com.ecommerce.Ecommerce_System.repository.UserRepository;
import com.ecommerce.Ecommerce_System.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepo;

	Logger logger = LoggerFactory.getLogger(UserService.class);

	public RegisterResponseDto signUp(RegisterDto signupDto) throws CustomException {

		UserModel userFlag = userRepo.findByUserName(signupDto.getUserName());
		if (Objects.nonNull(userFlag)) {
			throw new CustomException("User already exists");
		}

		String encryptedPassword = signupDto.getPassword();
		try {
			encryptedPassword = hashPassword(signupDto.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
		}

		UserModel user = new UserModel(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getUserName(),
				encryptedPassword, signupDto.getAddress());
		try {
			userRepo.save(user);
			return new RegisterResponseDto("success", "user created successfully");
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	public LoginResponseDto signIn(LoginDto signInDto) throws CustomException {

		UserModel user = userRepo.findByUserName(signInDto.getUserName());
		if (!Objects.nonNull(user)) {
			throw new CustomException("User does not exist");
		}
		try {
			if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
				throw new CustomException("Incorrect Password");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
			throw new CustomException(e.getMessage());
		}

		return new LoginResponseDto("success", user.getId(), user.getUserName());
	}

	private String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return myHash;
	}

	public UserModel getUser(String userName) {
		UserModel user = userRepo.findByUserName(userName);
		if (Objects.nonNull(user)) {
			return user;
		}
		return null;
	}

	public int getAllUsers() {
		int totalUsers = (int) userRepo.count();
		return totalUsers;

	}
}
