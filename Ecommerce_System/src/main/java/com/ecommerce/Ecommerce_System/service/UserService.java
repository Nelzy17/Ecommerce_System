package com.ecommerce.Ecommerce_System.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.dao.UserRepository;
import com.ecommerce.Ecommerce_System.dto.user.SignInResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.SignUpResponseDto;
import com.ecommerce.Ecommerce_System.dto.user.SigninDto;
import com.ecommerce.Ecommerce_System.dto.user.SignupDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.model.UserModel;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	Logger logger = LoggerFactory.getLogger(UserService.class);

	public SignUpResponseDto signUp(SignupDto signupDto) throws CustomException {
		// Check to see if the current email address has already been registered.
		if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
			// If the email address has been registered then throw an exception.
			throw new CustomException("User already exists");
		}
		// first encrypt the password
		String encryptedPassword = signupDto.getPassword();
		try {
			encryptedPassword = hashPassword(signupDto.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
		}

		UserModel user = new UserModel(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(),
				encryptedPassword);
		try {
			// save the User
			userRepository.save(user);
			// success in creating
			return new SignUpResponseDto("success", "user created successfully");
		} catch (Exception e) {
			// handle signup error
			throw new CustomException(e.getMessage());
		}
	}

	String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return myHash;
	}

	public SignInResponseDto signIn(SigninDto signInDto) throws CustomException {
		// first find User by email
		UserModel user = userRepository.findByEmail(signInDto.getEmail());
		if (!Objects.nonNull(user)) {
			throw new CustomException("user not present");
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

		return new SignInResponseDto("success");
	}
}
