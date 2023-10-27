package model;

import java.util.Date;

// Java Bean
// POJO - Plain Old Java Object - nu extinde nicio clasă, nu implemnetează nicio interfață și nu are nicio adnotare

public class Book {

    private Long id;

    private String author;

    private String title;

    private Date publishedDate;

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

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
