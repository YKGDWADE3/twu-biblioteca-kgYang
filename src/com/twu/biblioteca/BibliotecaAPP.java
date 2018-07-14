package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
            parse(command.input());
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



    private void parse(String input) {
        if (input.equals("0")) {
            showBooksList();
        }else if (input.equals("-1")){
            isQuit = true;
        }else {

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
