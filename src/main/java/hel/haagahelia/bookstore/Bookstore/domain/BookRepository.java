package hel.haagahelia.bookstore.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByAuthor(String author);
	
	List<Book> findByTitle(String title);

	List<Book> findByPrice(double price);
	
	List<Book> findByYear(int year);

}
