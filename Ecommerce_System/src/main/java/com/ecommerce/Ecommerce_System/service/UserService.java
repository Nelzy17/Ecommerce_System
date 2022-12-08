package com.ecommerce.Ecommerce_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Ecommerce_System.dao.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
}
