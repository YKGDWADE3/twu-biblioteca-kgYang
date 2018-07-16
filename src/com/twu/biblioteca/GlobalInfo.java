package com.twu.biblioteca;

public class GlobalInfo {
    public final static String MENU_SHOW_BOOK_LIST = "0";
    public final static String MENU_SHOW_MOVIE_LIST = "1";
    public final static String MENU_SHOW_CHECKOUT_LIST_OR_SHOW_USER_INFO = "2";
    public final static String MENU_LOGIN_IN_OR_OUT = "4";
    public final static String MENU_QUIT = "-1";
    public static final String USER_ACCOUNT = "ykg-1234";
    public static final String USER_PASSWORD = "123456";

    public static final String[] commonMenu = {"List Books", "List Movies"};

    public static final String[] notLoginMenu = {"Checkout list", "Login in"};

    public static final String[] loginMenu = {"Show user info", "Login out"};

    public static final String WELCOME_MSG = "Welcome to the Library!\n";
    public static final String QUIT_MSG = "GoodBye!\n";
    public static final String QUIT_MENU_MSG = "-1 : Quit!\n\n";
    public static final String CHECKOUT_SUCCESS_MSG = "Thank you! Enjoy the book.\n";
    public static final String CHECKOUT_FAIL_MSG = "That book is not available.\n";
    public static final String RETURN_SUCCESS_MSG = "Thank you for returning the book.\n";
    public static final String RETURN_FAIL_MSG = "That is not a valid book to return.\n";
    public static final String SELECT_MENU_WRONG_MSG = "Select a valid option!\n";

    public static final String LOGIN_IN_HINT_MSG = "please submit account name and password, divide by space.\n";
    public static final String LOGIN_IN_SUCCESS_MSG = "login in success.\n";
    public static final String LOGIN_OUT_SUCCESS_MSG = "login in success.\n";
    public static final String LOGIN_IN_FAIL_MSG = "login in fail, please check your account and password. Press -1 to cancel.\n";

}
