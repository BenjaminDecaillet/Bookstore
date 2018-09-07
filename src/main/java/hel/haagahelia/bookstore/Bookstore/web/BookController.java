package hel.haagahelia.bookstore.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
