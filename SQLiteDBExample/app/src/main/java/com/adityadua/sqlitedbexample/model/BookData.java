package com.adityadua.sqlitedbexample.model;

/**
 * Created by AdityaDua on 30/06/18.
 */

public class BookData {

    // Android Fro Beginners - X Person - ISBN - id
    private int id;
    private String bookName;
    private String bookAuthor;
    private String bookid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }


}
