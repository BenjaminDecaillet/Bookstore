package hel.haagahelia.bookstore.Bookstore;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hel.haagahelia.bookstore.Bookstore.domain.Book;
import hel.haagahelia.bookstore.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	@Autowired 
	private BookRepository bookrepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	static String createISBN(){
		int x = (int)(Math.random()*((100000000-1000000)+1))+1000000;
		int y = (int)(Math.random()*((100-10)+1))+10;
		return x + "-"+y;
	}
	
	public void dosomething(){
		List<Book> books = (List<Book>) bookrepository.findAll();
	}
	
	@Bean
	CommandLineRunner runner(){
		return args -> {
			// Save demo data to database
			// Add books objects and save these to db
			Book book1 = new Book(createISBN(),"Lord of the rings: The Fellowship of the Ring" , "John Ronald Reuel Tolkin",1954,29.90);
			Book book2 = new Book(createISBN(),"Lord of the rings: The Two Towers" , "John Ronald Reuel Tolkin",1954,29.90);
			Book book3 = new Book(createISBN(),"Lord of the rings: The Return of the King" , "John Ronald Reuel Tolkin",1955,35.50);
			Book book4 = new Book(createISBN(),"The Silmarillion" , "John Ronald Reuel Tolkin",1977,35.50);
			bookrepository.save(book1);
			bookrepository.save(book2);
			bookrepository.save(book3);
			bookrepository.save(book4);
		};
	}
}
