package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class BibliotecaAPP {

    private final String[] menu = {"List Books"};

    private ArrayList<Book> mBookArrayList = new ArrayList<Book>();

    private boolean isQuit = false;

    public void begin(){
        System.out.print(PrintMsg.WELCOME_MSG);
        mockBooks();
    }

    public void play(InputCommand command) throws IOException {
        if (!isQuit) {
            showMainMenu();
            System.out.print(parse(command.input()));
            play(command);
        } else {
            System.out.print(PrintMsg.QUIT_MSG);
        }
    }

    private void showMainMenu(){
        for (int i = 0; i < menu.length; i++) {
            System.out.print(i + " : " + menu[i] + "\n");
        }
        System.out.print(PrintMsg.QUIT_MENU_MSG);
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
            return "\n";
        }else if (input.equals("-1")){
            isQuit = true;
            return "\n";
        }else {
            return checkInputVaild(input);
        }
    }

    private String checkInputVaild(String input) {
        boolean isCheckout = input.startsWith("checkout");
        boolean isReturn = input.startsWith("return");
        if (isCheckout || isReturn) {
            String[] strings = input.split(" ");
            if (strings.length == 2) {
                Book bookTemp = new Book(strings[1]);
                for (Book book: mBookArrayList) {
                    if (book.equals(bookTemp) && book.isAvailable() && isCheckout) {
                        book.setAvailable(false);
                        return PrintMsg.CHECKOUT_SUCCESS_MSG;
                    } else if (book.equals(bookTemp) && !book.isAvailable() && isReturn) {
                        book.setAvailable(true);
                        return PrintMsg.RETURN_SUCCESS_MSG;
                    }
                }
            }

            return isCheckout ? PrintMsg.CHECKOUT_FAIL_MSG : PrintMsg.RETURN_FAIL_MSG;
        } else{
            return PrintMsg.SELECT_MENU_WRONG_MSG;
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
