package com.demo.ldap.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.ldap.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
