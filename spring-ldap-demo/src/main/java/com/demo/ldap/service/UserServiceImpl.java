package com.demo.ldap.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.ldap.dao.UserDao;
import com.demo.ldap.dto.UserDto;
import com.demo.ldap.model.User;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<UserDto> findAll() {
		List<UserDto> userDtos = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(user -> userDtos.add(user.toUserDto()));
		return userDtos;
	}

	@Override
	public User findOne(long id) {
		return userDao.findById(id).get();
	}

}
