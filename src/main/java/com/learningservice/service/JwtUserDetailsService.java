package com.learningservice.service;

import java.util.ArrayList;

import com.learningservice.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findUserByname(userName);
		if (user != null && user.getUsername().equals(userName)) {
			return user;
		} else {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
	}

}