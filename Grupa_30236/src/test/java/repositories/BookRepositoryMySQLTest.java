package repositories;

import database.DatabaseConnectionFactory;
import model.Book;
import model.builder.BookBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.BookRepository;
import repository.BookRepositoryCacheDecorator;
import repository.BookRepositoryMySQL;
import repository.Cache;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookRepositoryMySQLTest {

    private static BookRepository bookRepository;

    @BeforeAll
    public static void setupClass(){
        bookRepository = new BookRepositoryCacheDecorator(
                new BookRepositoryMySQL(
                        DatabaseConnectionFactory.getConnectionWrapper(true).getConnection()
                ),
                new Cache<>()
        );
    }

    @BeforeEach
    public void cleanUp(){
        bookRepository.removeAll();
    }

    @Test
    public void findAll(){
        List<Book> books = bookRepository.findAll();
        assertEquals(0, books.size());
    }

    @Test
    public void findAllWhenNotEmpty(){
        Book book = new BookBuilder()
                .setTitle("TitleTest")
                .setAuthor("AuthorTest")
                .setPublishedDate(LocalDate.of(2010, 6, 2))
                .build();

        bookRepository.save(book);
        bookRepository.save(book);
        bookRepository.save(book);

        List<Book> books = bookRepository.findAll();

        assertEquals(3, books.size());
    }

    @Test
    public void findById(){

    }

    @Test
    public void save(){
        assertTrue(bookRepository.save(
                new BookBuilder()
                        .setTitle("TitleTest")
                        .setAuthor("AuthorTest")
                        .setPublishedDate(LocalDate.of(2010, 6, 2))
                        .build()
        ));
    }

    @Test
    public void removeAll(){

    }

}
