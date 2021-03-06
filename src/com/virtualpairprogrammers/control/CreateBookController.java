package com.virtualpairprogrammers.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virtualpairprogrammers.domain.Book;
import com.virtualpairprogrammers.services.BookService;

@Controller
@RequestMapping("/addNewBook")
public class CreateBookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("/add-new-book.jsp", "book", new Book());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processForm(Book newBook) {
		bookService.registerNewBook(newBook);
		return new ModelAndView("/book-added.jsp", "title", newBook.getTitle());
	}
	
	
	
	

}
