package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Book {
	private int bookCode;
	private String author;
	private String name;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBookCode() {
		return bookCode;
	}
	public Book() {
		super();
	}
	public Book(int bookCode, String author, String name) {
		super();
		this.bookCode = bookCode;
		this.author = author;
		this.name = name;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", author=" + author + ", name=" + name + "]";
	}
}
