package com.spring.service;

import java.util.List;

import com.spring.entity.Book;

public interface BookService {
	public Book addBook(Book book);
	public void edit(Book book);
	public void delete(int id);
	public List<Book> getAllBook();
}
