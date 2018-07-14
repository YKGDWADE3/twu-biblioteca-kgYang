package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {


    @Test
    public void shouldPrintWelcome() {
        assertTrue(systemOut().startWith("Welcome to the Library!"));
    }

}
