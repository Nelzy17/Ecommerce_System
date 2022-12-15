package com.ecommerce.Ecommerce_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Ecommerce_System.dto.order.AnalyticsDto;
import com.ecommerce.Ecommerce_System.exceptions.CustomException;
import com.ecommerce.Ecommerce_System.service.OrderService;
import com.ecommerce.Ecommerce_System.service.UserService;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<AnalyticsDto> getAnalysis() throws CustomException {

		int totalusers = userService.getAllUsers();
		AnalyticsDto analyticsDto = orderService.getAllAnalytics(totalusers);

		return new ResponseEntity<AnalyticsDto>(analyticsDto, HttpStatus.OK);
	}
}
