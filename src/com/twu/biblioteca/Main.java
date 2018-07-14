package com.twu.biblioteca;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BibliotecaAPP controller = new BibliotecaAPP();
        controller.begin();
        controller.play(new InputCommand());
    }
}
