package com.ecommerce.Ecommerce_System.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.dto.user.SignInResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.SignUpResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.SigninDto;
import com.ecommerce.Ecommerce_System.dto.user.SignupDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.UserModel;
import com.ecommerce.Ecommerce_System.repository.UserRepository;
import com.ecommerce.Ecommerce_System.service.interfaces.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepo;

	Logger logger = LoggerFactory.getLogger(UserService.class);

	public SignUpResponseDto signUp(SignupDto signupDto) throws CustomException {

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
			// save the User
			userRepo.save(user);
			// success in creating
			return new SignUpResponseDto("success", "user created successfully");
		} catch (Exception e) {
			// handle signup error
			throw new CustomException(e.getMessage());
		}
	}

	public SignInResponseDto signIn(SigninDto signInDto) throws CustomException {

		UserModel user = userRepo.findByUserName(signInDto.getUserName());
		if (!Objects.nonNull(user)) {
			throw new CustomException("User does not exist");
		}
		try {
			// check if password is right
			if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
				// passwords do not match
				throw new CustomException("Incorrect Password");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
			throw new CustomException(e.getMessage());
		}

		return new SignInResponseDto("success", user.getId(), user.getUserName());
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
}
