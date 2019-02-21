package com.ttn.assignment.feb_20.exercise1;

import java.util.Objects;

/**
 * This class is overriding equals and hashcode method of Object class to compare two objects of books on the basis
 * of their ISBN no.
 */
public class Book {
    private int ISBN;
    private String title;
    private String author;
    private float price;

    public Book(int ISBN, String title, String author, float price) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }
}
