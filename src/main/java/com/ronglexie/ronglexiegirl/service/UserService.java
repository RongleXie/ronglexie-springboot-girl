package com.ronglexie.ronglexiegirl.service;

import com.ronglexie.ronglexiegirl.entity.User;
import com.ronglexie.ronglexiegirl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ronglexie
 * @version 2018-2-8
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User findByUsername(String username){
		return userRepository.findByUsername(username);
	}
}
