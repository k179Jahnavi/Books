package com.book.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books {
	@Id
	
	private int book_id;
	
	private String book_name;
	private String book_author;
	private long author_contact;
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	
	public long getAuthor_contact() {
		return author_contact;
	}
	public void setAuthor_contact(long author_contact) {
		this.author_contact = author_contact;
	}
	
}
