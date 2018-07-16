package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;

public class DataManager {
    private ArrayList<Book> mBookArrayList;

    private ArrayList<Movie> mMovieArrayList;

    private User mUser;

    public DataManager() {
    }

    public void showBooksList() {
        for (int i = 0; i < mBookArrayList.size(); i++) {
            if (mBookArrayList.get(i).isAvailable()) {
                mBookArrayList.get(i).printInfo();
            }else{
                continue;
            }
        }
    }

    public void showMovieList() {
        for (int i = 0; i < mMovieArrayList.size(); i++) {
            if (mMovieArrayList.get(i).getAvavilable()) {
                mMovieArrayList.get(i).printInfo();
            } else {
                continue;
            }
        }
    }

    public String processCheckOrReturn(String input) {
        boolean isCheckout = input.startsWith("checkout");
        boolean isReturn = input.startsWith("return");
        if (isCheckout || isReturn) {
            String[] strings = input.split(" ");
            if (strings.length == 2) {
                Book bookTemp = new Book(strings[1]);
                for (Book book: mBookArrayList) {
                    if (book.equals(bookTemp) && book.isAvailable() && isCheckout) {
                        book.setAvailable(false);
                        return GlobalInfo.CHECKOUT_SUCCESS_MSG;
                    } else if (book.equals(bookTemp) && !book.isAvailable() && isReturn) {
                        book.setAvailable(true);
                        return GlobalInfo.RETURN_SUCCESS_MSG;
                    }
                }
            }

            return isCheckout ? GlobalInfo.CHECKOUT_FAIL_MSG : GlobalInfo.RETURN_FAIL_MSG;
        } else{
            return GlobalInfo.SELECT_MENU_WRONG_MSG;
        }
    }

    public void mockBookAndMovie() {
        mBookArrayList = new ArrayList<Book>();
        Book book1 = new Book(1, "name1", "author1", 2018,true);
        Book book2 = new Book(2, "name2", "author2", 2018, true);
        Book book3 = new Book(3, "name3", "author3", 2005, false);
        mBookArrayList.add(book1);
        mBookArrayList.add(book2);
        mBookArrayList.add(book3);

        mMovieArrayList = new ArrayList<Movie>();
        Movie movie1 = new Movie(1, "movieName1", 2018, "director1", 10,true);
        Movie movie2 = new Movie(2, "movieName2", 2018, "director2", 10,true);
        Movie movie3 = new Movie(3, "movieName3", 2018, "director3", 10, false);
        mMovieArrayList.add(movie1);
        mMovieArrayList.add(movie2);
        mMovieArrayList.add(movie3);
    }

    public void mockUser() {
        mUser = new User(1,"YKG","123@tw.com","wuhan","9527");
    }

    public ArrayList<Book> getBookArrayList() {
        return mBookArrayList;
    }

    public ArrayList<Movie> getMovieArrayList() {
        return mMovieArrayList;
    }

    public User getUser() {
        return mUser;
    }
}
