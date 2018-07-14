package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private ByteArrayOutputStream mOutContent = new ByteArrayOutputStream();
    private BibliotecaAPP mAPPController;
    private InputCommand cmd;
    @Before
    public final void before(){
        mAPPController = new BibliotecaAPP();
        System.setOut(new PrintStream(mOutContent));
        cmd = mock(InputCommand.class);

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
    public void shouldShowMainMenuAfterWelcome() throws IOException {
        when(cmd.input()).thenReturn("-1");
        mAPPController.play(cmd);
        assertTrue(systemOut().contains("0 : List Books\n"));
    }

    @Test
    public void shouldPrintMsgWhenCheckBookSuccess() throws IOException {
        when(cmd.input()).thenReturn("0").thenReturn("checkout name2").thenReturn("-1");
        mAPPController.begin();
        mAPPController.play(cmd);
        assertTrue(systemOut().contains("Thank you! Enjoy the book."));
    }

    @Test
    public void shouldRingMsgWhenCheckBookFail() throws IOException {
        when(cmd.input()).thenReturn("0").thenReturn("checkout name3").thenReturn("-1");
        mAPPController.begin();
        mAPPController.play(cmd);
        assertTrue(systemOut().contains("That book is not available."));
    }
}
