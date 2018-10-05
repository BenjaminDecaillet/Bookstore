package hel.haagahelia.bookstore.Bookstore.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hel.haagahelia.bookstore.Bookstore.domain.Book;
import hel.haagahelia.bookstore.Bookstore.domain.BookRepository;
import hel.haagahelia.bookstore.Bookstore.domain.CategoryRepository;


@Controller
public class BookController {
	
	static String createISBN(){
		int x = (int)(Math.random()*((100000000-1000000)+1))+1000000;
		int y = (int)(Math.random()*((100-10)+1))+10;
		return x + "-"+y;
	}
	
	@Autowired 
	private BookRepository bookrepository;
	@Autowired
	private CategoryRepository categoryrepository;
	
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
		model.addAttribute("categories", categoryrepository.findAll());
	return "addbook";
	}
	
	@RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
	public String editbook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookrepository.findById(bookId));
		model.addAttribute("categories", categoryrepository.findAll());
	return "editbook";
	}
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String savebook(Book book) {
		if(book.getIsbn() == null)
			book.setIsbn(createISBN());
		bookrepository.save(book);
	return "redirect:booklist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
		bookrepository.deleteById(bookId);
	return "redirect:../booklist";
	}
	
	/*
	 * REST METHODS
	 */
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookList() {
	return (List<Book>) bookrepository.findAll();
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Book findBook(@PathVariable("id") Long bookId) {
	return bookrepository.findById(bookId).get();
	}
}
