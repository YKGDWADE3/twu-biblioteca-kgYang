package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaAPP {

    private final String[] menu = {"List Books"};

    public void begin(){
        System.out.println("Welcome to the Library!");
        Scanner scanner = new Scanner(System.in);
        showMainMenu();
        while (scanner.hasNext()) {

        }


    }

    private void showMainMenu(){
        for (int i = 0; i < menu.length; i++) {
            System.out.print(i + " : " + menu[i] + "\n");
        }
        System.out.print("-1 : Quit!\n");
    }
}
