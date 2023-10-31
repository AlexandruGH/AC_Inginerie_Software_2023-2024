import database.JDBConnectionWrapper;
import model.Book;
import model.builder.BookBuilder;
import repository.book.BookRepository;
import repository.book.BookRepositoryMock;
import repository.book.BookRepositoryMySQL;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");

        JDBConnectionWrapper connectionWrapper = new JDBConnectionWrapper("test_library");



        BookRepository bookRepository = new BookRepositoryMySQL(connectionWrapper.getConnection());

        Book book = new BookBuilder()
                .setTitle("Fram Ursul Polar")
                .setAuthor("Cezar Petrescu")
                .setPublishedDate(LocalDate.of(2010, 6, 2))
                .build();

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());


    }
}
