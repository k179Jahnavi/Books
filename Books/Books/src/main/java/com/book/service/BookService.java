package com.book.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.DAO.BookDao;
import com.book.model.Books;

@Service
@Transactional

public class  BookService{

	@Autowired
	private BookDao bookService;
	

	public List<Books> getAllBooks() {
		List<Books> books=bookService.getAllBooks();
		return books;
	}
	 public List<Books> searchBooks(String searchTerm) {
	      
	        return bookService.searchBooks(searchTerm);
	    }
	
	public void addBook(Books books) {
		bookService.addBook(books);
		
		
	}

	

	public void removeBook(int id) {
		bookService.removeBook(id);
		
	}
	
	public Books getById(int id) {
		return bookService.getById(id);
		
	}

	
	
	public void updateBook(Books books) {
		bookService.updateBook(books);
		
	}

}
