package com.ss.lms.model;

import com.ss.lms.model.Author;

import javax.persistence.*;

@Entity
@Table(name = "tbl_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn( name = "authId",nullable = false)
    private Author author;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pubId", nullable = false)
    private Publisher publisher;


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
