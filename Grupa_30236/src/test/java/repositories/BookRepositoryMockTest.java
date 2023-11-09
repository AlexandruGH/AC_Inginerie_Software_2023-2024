package repositories;

import model.Book;
import model.builder.BookBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.BookRepository;
import repository.BookRepositoryCacheDecorator;
import repository.BookRepositoryMock;
import repository.Cache;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookRepositoryMockTest {

    private static BookRepository bookRepository;

    @BeforeAll
    public static void setupClass(){
        bookRepository = new BookRepositoryCacheDecorator(
                new BookRepositoryMock(),
                new Cache<>()
        );
    }

    @Test
    public void findAll(){
        assertEquals(0, bookRepository.findAll().size());
    }

    @Test
    public void findById(){
        final Optional<Book> books = bookRepository.findById(1L);
        assertTrue(books.isEmpty());
    }

    @Test
    public void save(){
        Book book = new BookBuilder()
                .setAuthor("Author")
                .setTitle("Title")
                .build();

        assertTrue(bookRepository.save(book));
    }



}
