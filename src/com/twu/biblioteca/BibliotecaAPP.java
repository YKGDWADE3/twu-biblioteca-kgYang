package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class BibliotecaAPP {

    private final String[] menu = {"List Books"};

    private ArrayList<Book> mBookArrayList = new ArrayList<Book>();

    private boolean isQuit = false;

    public void begin(){
        System.out.println("Welcome to the Library!");
        mockBooks();
    }

    public void play(InputCommand command) throws IOException {
        if (!isQuit) {
            showMainMenu();
            System.out.print(parse(command.input()) + "\n");
            play(command);
        } else {
            System.out.print("GoodBye!\n");
        }
    }

    private void showMainMenu(){
        for (int i = 0; i < menu.length; i++) {
            System.out.print(i + " : " + menu[i] + "\n");
        }
        System.out.print("-1 : Quit!\n\n");
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



    private String parse(String input) {
        if (input.equals("0")) {
            showBooksList();
            return "";
        }else if (input.equals("-1")){
            isQuit = true;
            return "";
        }else {
            return checkInputVaild(input);
        }
    }

    private String checkInputVaild(String input) {
        if (input.startsWith("checkout")) {
            String[] strings = input.split(" ");
            if (strings.length == 2) {
                Book bookTemp = new Book(strings[1]);
                for (Book book: mBookArrayList) {
                    if (book.equals(bookTemp) && book.isAvailable()) {
                        book.setAvailable(false);
                        return "Thank you! Enjoy the book.";
                    }
                }
            }
            return "That book is not available.";
        } else if (input.startsWith("return")) {
            String[] strings = input.split(" ");
            if (strings.length == 2) {
                Book bookTemp = new Book(strings[1]);
                for (Book book: mBookArrayList) {
                    if (book.equals(bookTemp) && !book.isAvailable()) {
                        book.setAvailable(true);
                        return "Thank you for returning the book.";
                    }
                }
            }
            return "That is not a valid book to return.";
        }else{
            return "Select a valid option!";
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
}
