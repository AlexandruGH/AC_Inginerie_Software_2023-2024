import database.DatabaseConnectionFactory;
import database.JDBConnectionWrapper;
import model.Book;
import model.builder.BookBuilder;
import repository.*;
import service.BookService;
import service.BookServiceImpl;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");

        BookRepository bookRepository = new BookRepositoryCacheDecorator(
                new BookRepositoryMySQL(DatabaseConnectionFactory.getConnectionWrapper(true).getConnection()),
                new Cache<>()
        );

        BookService bookService = new BookServiceImpl(bookRepository);

        Book book = new BookBuilder()
                .setAuthor("Cezar Petrescu")
                .setTitle("Fram Ursul Polar")
                .setPublishedDate(LocalDate.of(2010, 6, 2))
                .build();

        bookService.save(book);

        System.out.println(bookService.findAll());

        System.out.println(bookService.findAll());
        System.out.println(bookService.getAgeOfBook(2L));
    }
}
