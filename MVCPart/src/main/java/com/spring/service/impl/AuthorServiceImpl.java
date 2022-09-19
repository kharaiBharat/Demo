package com.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.entity.Author;
import com.spring.service.AuthorService;
@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	RestTemplate restTemplate;
	@Override
	public List<Author> getAuthors() {
		// TODO Auto-generated method stub
		String url="http://localhost:9090/authors";
		ResponseEntity<Author[]> response =
				  restTemplate.getForEntity(
				  url,
				  Author[].class);
		Author[] book=response.getBody();
		List<Author> result=new ArrayList<>();
		for(Author b:book) {
			System.out.println(b);
			result.add(b);
		}
		return result;
	}

}
