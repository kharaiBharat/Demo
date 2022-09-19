package com.spring.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.Author;
import com.spring.entity.Book;
import com.spring.entity.User;
import com.spring.service.AuthorService;
import com.spring.service.BookService;
import com.spring.service.LoginService;

@RestController
public class HomeController {
	@Autowired
	LoginService login;
	@Autowired
	BookService book;
	
	@Autowired
	AuthorService author;
	
	@RequestMapping("/login")
	public ModelAndView logIn(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ModelAndView mv = new ModelAndView();
		User u=login.getLogin(username);
		System.out.println(u);
		if(u!=null&&u.getPassword().equals(password)) {
			HttpSession session=request.getSession();
			List<Book> list=book.getAllBook();
			for(Book book:list) {
				System.out.println(book);
			}
			session.setAttribute("tableDetails", list);
			mv.setViewName("welcome.jsp");
		}else {
			mv.setViewName("Login.jsp");
		}
		
		
		return mv;
	}
	@RequestMapping("/add")
	public ModelAndView addForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Author> list=author.getAuthors();
		HttpSession session=request.getSession();
		session.setAttribute("authors", list);
		mv.setViewName("add.jsp");
		return mv;
	}
	@RequestMapping("/addBook")
	public ModelAndView addBook(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		int code=Integer.parseInt(request.getParameter("bookCode"));
		String name=request.getParameter("bookName");
		String author=request.getParameter("author");
		String date=request.getParameter("date");
		Book b=new Book();
		b.setAuthor(author);
		b.setDate(date);
		b.setBookCode(code);
		b.setName(name);
		book.addBook(b);
		List<Book> ll=book.getAllBook();
		HttpSession session=request.getSession();
		session.setAttribute("tableDetails", ll);
		mv.setViewName("welcome.jsp");
		return mv;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Enumeration<String> enumeration=request.getParameterNames();
		String type=enumeration.nextElement();
		String[] item=type.split("-");
		int id=Integer.parseInt(item[1]);
		List<Author> list=author.getAuthors();
		HttpSession session=request.getSession();
		session.setAttribute("authors", list);
		HttpSession nn=request.getSession();
		nn.setAttribute("id", id);
		mv.setViewName("edit.jsp");
		return mv;
	}
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Enumeration<String> enumeration=request.getParameterNames();
		String type=enumeration.nextElement();
		String[] item=type.split("-");
		int id=Integer.parseInt(item[1]);
		book.delete(id);
		List<Book> ll=book.getAllBook();
		HttpSession session=request.getSession();
		session.setAttribute("tableDetails", ll);
		mv.setViewName("welcome.jsp");
		return mv;
	}
}
