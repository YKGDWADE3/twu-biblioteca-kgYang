package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

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

    private void APPStart() throws IOException {
        mAPPController.begin();
        mAPPController.play(cmd);
    }

    private String systemOut(){
        return mOutContent.toString();
    }
    @Test
    public void shouldPrintWelcome() {
        mAPPController.begin();
        assertTrue(systemOut().startsWith(GlobalInfo.WELCOME_MSG));
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
        APPStart();
        assertTrue(systemOut().contains(GlobalInfo.CHECKOUT_SUCCESS_MSG));
    }

    @Test
    public void shouldPrintMsgWhenCheckBookHasCheckOut() throws IOException {
        when(cmd.input()).thenReturn("0").thenReturn("checkout name3").thenReturn("-1");
        APPStart();
        assertTrue(systemOut().contains(GlobalInfo.CHECKOUT_FAIL_MSG));
    }

    @Test
    public void shouldPrintMsgWhenReturnBookSuccess() throws IOException {
        when(cmd.input()).thenReturn("0").thenReturn("return name3").thenReturn("-1");
        APPStart();
        assertTrue(systemOut().contains(GlobalInfo.RETURN_SUCCESS_MSG));
    }

    @Test
    public void shouldPrintMsgWhenReturnBookHasReturned() throws IOException {
        when(cmd.input()).thenReturn("0").thenReturn("return name1").thenReturn("-1");
        APPStart();
        assertTrue(systemOut().contains(GlobalInfo.RETURN_FAIL_MSG));
    }

    @Test
    public void shouldPrintMsgWhenSelectMenuWrong() throws IOException {
        when(cmd.input()).thenReturn("1").thenReturn("-1");
        APPStart();
        assertTrue(systemOut().contains(GlobalInfo.SELECT_MENU_WRONG_MSG));
    }

    @Test
    public void shouldHaveMovieListChoiceInMenu() throws IOException {
        when(cmd.input()).thenReturn("-1");
        APPStart();
        assertTrue(systemOut().contains("0 : List Books\n" + "1 : List Movies\n"));
    }

    @Test
    public void shouldShowMovieListWhenChooseInMenu() throws IOException {
        when(cmd.input()).thenReturn("1").thenReturn("-1");
        APPStart();
        assertTrue(systemOut().contains("movieName1, 2018, director1, 10.\n"));
    }

    @Test
    public void shouldShowCheckOutListChoiceInMenuWhenNotLogin() throws IOException {
        when(cmd.input()).thenReturn("-1");
        APPStart();
        assertTrue(systemOut().contains(("0 : List Books\n" + "1 : List Movies\n" + "2 : Checkout list\n")));

    }

    @Test
    public void shouldReturnMsgWhenLoginSuccess() throws IOException {
        when(cmd.input()).thenReturn("3").thenReturn("ykg-1234 123456").thenReturn("-1");
        APPStart();
        assertTrue(systemOut().contains(GlobalInfo.LOGIN_IN_SUCCESS_MSG));
    }
}
