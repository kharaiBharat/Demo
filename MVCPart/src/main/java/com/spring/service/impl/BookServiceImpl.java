package com.spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.entity.Book;
import com.spring.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		String Url="http://localhost:9090/books";
		return this.restTemplate.postForObject(Url, book, Book.class);
	}

	@Override
	public void edit(Book book) {
		// TODO Auto-generated method stub
		String url="http://localhost:9090/";
		this.restTemplate.put(url, book);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String url="http://localhost:9090/books/"+id;
		restTemplate.delete(url);
		
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		String url="http://localhost:9090/books";
		ResponseEntity<Book[]> response =
				  restTemplate.getForEntity(
				  url,
				  Book[].class);
		Book[] book=response.getBody();
		List<Book> result=new ArrayList<>();
		for(Book b:book) {
			System.out.println(b);
			result.add(b);
		}
		return result;
	}

}
