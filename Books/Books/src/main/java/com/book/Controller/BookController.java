package com.book.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.model.Books;
import com.book.service.BookService;

@Controller

public class BookController 
{
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/")
	public String get(Model mav)
	{
		List<Books> books=bookService.getAllBooks();
		mav.addAttribute("details",books);
		return "display";
	}

 @GetMapping("/bookSearch")
    public String searchBooks(@RequestParam String searchTerm, Model model) {
        
        List<Books> filteredBooks = bookService.searchBooks(searchTerm);
        model.addAttribute("details", filteredBooks);

       
        return "display";
    }
	@GetMapping("/form")
	public String gett() {
		return "addbook";
	}
	@PostMapping("/savebook") 
	public String addBook(@ModelAttribute Books books) {
		bookService.addBook(books);
		return "redirect:/";
	}
	
	@GetMapping("/remove")
	public String removeBook(@RequestParam("book_id") int id) {
		bookService.removeBook(id);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updateBook(@RequestParam int book_id,Model model) {
		Books books=bookService.getById(book_id);
		model.addAttribute("book",books);
		return "addbook";
	}
	
	@GetMapping("/back")
	public String gett(Model mav)
	{
		List<Books> books=bookService.getAllBooks();
		mav.addAttribute("details",books);
		return "display";
	}
	@PostMapping("/update/updatebook")
	public String update(@ModelAttribute Books  books)
	{
		bookService.updateBook(books);
		return "redirect:/";
	}
	
	
}
