package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    private ByteArrayOutputStream mOutContent = new ByteArrayOutputStream();
    private BibliotecaAPP mAPPController;

    @Before
    public final void before(){
        mAPPController = new BibliotecaAPP();
        System.setOut(new PrintStream(mOutContent));
    }

    private String systemOut(){
        return mOutContent.toString();
    }
    @Test
    public void shouldPrintWelcome() {
        mAPPController.begin();
        assertTrue(systemOut().startsWith("Welcome to the Library!"));
    }

    @Test
    public void shouldShowMainMenuAfterWelcome() {
        mAPPController.begin();
        assertTrue(systemOut().contains("0 : List Books\n"));
    }
}
