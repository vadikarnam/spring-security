package com.demo.ldap.service;

import java.util.List;

import com.demo.ldap.dto.UserDto;
import com.demo.ldap.model.User;

public interface UserService {

	List<UserDto> findAll();

	User findOne(long id);

}
