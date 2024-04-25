package com.book.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/*import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.model.Books;


@Repository
public class BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Books> getAllBooks() {
	
	    Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	    CriteriaQuery<Books> criteriaQuery = criteriaBuilder.createQuery(Books.class);
	    Root<Books> root = criteriaQuery.from(Books.class);
	    criteriaQuery.select(root);
	    Query<Books> query = session.createQuery(criteriaQuery);

	    return query.getResultList();
	}
	 public List<Books> searchBooks(String searchTerm) {
	        try (Session session = sessionFactory.openSession()) {
	           
	            String query = "FROM Books WHERE " +
	                    "LOWER(book_name) LIKE :searchTerm OR " +
	                    "LOWER(book_author) LIKE :searchTerm";

	            return session.createQuery(query, Books.class)
	                    .setParameter("searchTerm", "%" + searchTerm.toLowerCase() + "%")
	                    .getResultList();
	        }
	    }

	public void addBook(Books books) {
		System.out.println("hello");
		Session session = sessionFactory.getCurrentSession();
		session.save(books);

	}

	public void removeBook(int id) {
		Session session = sessionFactory.getCurrentSession();
		Books books = session.byId(Books.class).load(id);
		session.delete(books);

	}
	
	public Books getById(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		Books books = session.byId(Books.class).load(id);
		return books;
	}
	public void updateBook(Books books) {
		sessionFactory.getCurrentSession().merge(books);
		

	}

}
