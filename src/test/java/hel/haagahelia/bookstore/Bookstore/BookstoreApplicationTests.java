package hel.haagahelia.bookstore.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hel.haagahelia.bookstore.Bookstore.web.BookController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {
	 @Autowired
	 private BookController controller;

	  @Test
	  public void contextLoads() {
	    assertThat(controller).isNotNull();
	  }

}
