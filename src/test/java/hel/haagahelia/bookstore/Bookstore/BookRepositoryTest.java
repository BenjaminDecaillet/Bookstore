package hel.haagahelia.bookstore.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import hel.haagahelia.bookstore.Bookstore.domain.Book;
import hel.haagahelia.bookstore.Bookstore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private BookRepository repository;

	@Test
	public void saveBook() {
		Book book = new Book("45643164164-4588","Lord of the rings: The Fellowship of the Ring" , "John Ronald Reuel Tolkin",1954,29.90);
		
		entityManager.persistAndFlush(book);

		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteBooks() {
		entityManager.persistAndFlush(new Book("45643164164-4588","Lord of the rings: The Fellowship of the Ring" , "John Ronald Reuel Tolkin",1954,29.90));
		entityManager.persistAndFlush(new Book("45643164164-4588","The Silmarillion" , "John Ronald Reuel Tolkin",1977,35.50));

		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();
	} 

}
