package com.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.entity.User;
import com.spring.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public User getLogin(String userName) {
		// TODO Auto-generated method stub
		String url="http://localhost:9090/user/"+userName;
		
		return restTemplate.getForObject(url, User.class);
	}

}
