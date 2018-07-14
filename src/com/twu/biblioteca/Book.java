package com.twu.biblioteca;

public class Book {
    private Integer id;

    private String bookName;

    private String authorName;

    private Integer publishYear;

    private boolean available;

    public Book(int id, String bookName, String authorName, int publishYear, boolean available) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishYear = publishYear;
        this.available = available;
    }



    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void printInfo() {
        System.out.print(bookName + ", " + authorName + ", " + publishYear + ".\n");
    }

    @Override
    public boolean equals(Object obj) {
        return bookName.equals(((Book)obj).getBookName());
    }
}

