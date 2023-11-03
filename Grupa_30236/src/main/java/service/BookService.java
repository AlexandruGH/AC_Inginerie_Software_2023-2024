package service;

import model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    boolean save(Book book);

    int getAgeOfBook(Long id);
}
