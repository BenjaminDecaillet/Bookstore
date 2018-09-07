package hel.haagahelia.bookstore.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BookController {

	@RequestMapping(value = "/index")
	public String messages(Model model) {
		return "This is the main page";
//	return "index";
	}
}
