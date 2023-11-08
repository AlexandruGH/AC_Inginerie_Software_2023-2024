package model;

import java.time.LocalDate;
import java.util.Date;

// Java Bean
// POJO - Plain Old Java Object - nu extinde nicio clasă, nu implemnetează nicio interfață și nu are nicio adnotare

public class Book {

    private Long id;

    private String author;

    private String title;

    private LocalDate publishedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString(){
        return String.format("Book ID: %d | Author: %s | Title: %s | Published Date: %s", id, author, title, publishedDate);
    }
}
