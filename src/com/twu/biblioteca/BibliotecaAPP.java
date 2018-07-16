package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;

import java.io.IOException;
import java.util.ArrayList;

public class BibliotecaAPP {



    private ArrayList<Book> mBookArrayList = new ArrayList<Book>();

    private ArrayList<Movie> mMovieArrayList = new ArrayList<Movie>();

    private boolean isQuit = false;
    private boolean isLogin = false;
    private boolean isInLogin = false;

    public void begin(){
        System.out.print(GlobalInfo.WELCOME_MSG);
        mockBooks();
        mockMovies();
    }

    public void play(InputCommand command) throws IOException {
        if (!isQuit) {
            if (!isInLogin) {
                showMainMenu();
                showExtraChoiceInMenu(isLogin);
            }
            print(parse(command.input()));
            play(command);
        } else {
            print(GlobalInfo.QUIT_MSG);
        }
    }

    private void showMainMenu(){
        for (int i = 0; i < GlobalInfo.commonMenu.length; i++) {
            print(i + " : " + GlobalInfo.commonMenu[i] + "\n");
        }
    }

    private void showExtraChoiceInMenu(boolean isLogin) {
        String[] temp = isLogin ? GlobalInfo.loginMenu : GlobalInfo.notLoginMenu;
        for (int i = 0; i < temp.length; i++) {
            print((i + GlobalInfo.commonMenu.length) + " : " + temp[i] + "\n");
        }
        print(GlobalInfo.QUIT_MENU_MSG);

    }

    private void showBooksList() {
        for (int i = 0; i < mBookArrayList.size(); i++) {
            if (mBookArrayList.get(i).isAvailable()) {
                mBookArrayList.get(i).printInfo();
            }else{
                continue;
            }
        }
    }

    private void showMovieList() {
        for (int i = 0; i < mMovieArrayList.size(); i++) {
            if (mMovieArrayList.get(i).getAvavilable()) {
                mMovieArrayList.get(i).printInfo();
            } else {
                continue;
            }
        }
    }



    private String parse(String input) {
        if (input.equals("0")) {
            showBooksList();
        }else if(input.equals("1")){
            showMovieList();
        } else if (input.equals("-1")){
            if (isInLogin) {
                isInLogin = false;
            } else {
                isQuit = true;
            }

        } else if (input.equals("2")) {

        } else if (input.equals("3")) {
            if (isLogin) {
                isLogin = !isLogin;
            } else {
                isInLogin = true;
                return GlobalInfo.LOGIN_IN_HINT_MSG;
            }
        } else {
            return checkInputVaild(input);
        }
        return "\n";
    }

    private String checkInputVaild(String input) {
        if (isInLogin) {
            String[] strings = input.split(" ");
            if (strings[0].equals(GlobalInfo.USER_ACCOUNT) && strings[1].equals(GlobalInfo.USER_PASSWORD)) {
                isInLogin = false;
                isLogin = true;
                return GlobalInfo.LOGIN_IN_SUCCESS_MSG;
            }else{
                return GlobalInfo.LOGIN_IN_FAIL_MSG;
            }
        }
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

    private void mockBooks(){
        Book book1 = new Book(1, "name1", "author1", 2018,true);
        Book book2 = new Book(2, "name2", "author2", 2018, true);
        Book book3 = new Book(3, "name3", "author3", 2005, false);
        mBookArrayList.add(book1);
        mBookArrayList.add(book2);
        mBookArrayList.add(book3);
    }

    private void mockMovies() {
        Movie movie1 = new Movie(1, "movieName1", 2018, "director1", 10,true);
        Movie movie2 = new Movie(2, "movieName2", 2018, "director2", 10,true);
        Movie movie3 = new Movie(3, "movieName3", 2018, "director3", 10, false);
        mMovieArrayList.add(movie1);
        mMovieArrayList.add(movie2);
        mMovieArrayList.add(movie3);
    }

    private void print(String msg) {
        System.out.print(msg);
    }
}
