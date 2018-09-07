package hel.haagahelia.bookstore.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hel.haagahelia.bookstore.Bookstore.domain.Book;
import hel.haagahelia.bookstore.Bookstore.domain.BookRepository;


@Controller
public class BookController {
	
	@Autowired 
	private BookRepository bookrepository;
	
	@RequestMapping(value={"/index"})
	public String messages(Model model) {
		return "redirect:index";
	}
	
	@RequestMapping(value = "/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", (List<Book>) bookrepository.findAll());
	return "booklist";
	}
	
	@RequestMapping(value = "/addbook")
	public String addbook(Model model) {
		model.addAttribute("book", new Book());
	return "addbook";
	}
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String savebook(Book book) {
		bookrepository.save(book);
	return "redirect:booklist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
		bookrepository.deleteById(bookId);
	return "redirect:../booklist";
	}
}
