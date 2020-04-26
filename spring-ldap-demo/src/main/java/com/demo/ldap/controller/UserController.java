package com.demo.ldap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ldap.dto.ApiResponse;
import com.demo.ldap.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);

	public static final String SUCCESS = "success";

	@Autowired
	private UserService userService;

	@GetMapping
	public ApiResponse listUser() {
		log.info("received request to list user");
		return new ApiResponse(HttpStatus.OK, SUCCESS, userService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ApiResponse getUser(@PathVariable long id) {
		log.info("received request to update user %s");
		return new ApiResponse(HttpStatus.OK, SUCCESS, userService.findOne(id));
	}

}
