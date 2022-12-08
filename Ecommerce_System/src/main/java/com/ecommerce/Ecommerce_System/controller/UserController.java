package com.ecommerce.Ecommerce_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce_System.service.UserService;

@RequestMapping("user")
@RestController
public class UserController {

	@Autowired
	UserService userService;
}
