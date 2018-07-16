package com.twu.biblioteca;

import java.io.IOException;

public class BibliotecaAPP {

    private boolean isQuit = false;
    private boolean isLogin = false;
    private boolean isInLoginProcess = false;
    private DataManager mDataManager;

    public void begin(){
        System.out.print(GlobalInfo.WELCOME_MSG);
        mDataManager = new DataManager();
        mDataManager.mockBookAndMovie();
    }

    public void play(InputCommand command) throws IOException {
        if (!isQuit) {
            if (!isInLoginProcess) {
                showMainMenu();
                showExtraChoiceInMenu(isLogin);
            }
            print(parse(command.input()));
            play(command);
        } else {
            print(GlobalInfo.QUIT_MSG);
        }
    }

    private void showMainMenu(){
        for (int i = 0; i < GlobalInfo.commonMenu.length; i++) {
            print(i + " : " + GlobalInfo.commonMenu[i] + "\n");
        }
    }

    private void showExtraChoiceInMenu(boolean isLogin) {
        String[] temp = isLogin ? GlobalInfo.loginMenu : GlobalInfo.notLoginMenu;
        for (int i = 0; i < temp.length; i++) {
            print((i + GlobalInfo.commonMenu.length) + " : " + temp[i] + "\n");
        }
        print(GlobalInfo.QUIT_MENU_MSG);

    }

    private String parse(String input) {
        switch (input) {
            case GlobalInfo.MENU_SHOW_BOOK_LIST:
                mDataManager.showBooksList();
                return "\n";
            case GlobalInfo.MENU_SHOW_MOVIE_LIST:
                mDataManager.showMovieList();
                return "\n";
            case GlobalInfo.MENU_QUIT:
                if (isInLoginProcess) {
                    isInLoginProcess = false;
                } else {
                    isQuit = true;
                }
                return "\n";
            case GlobalInfo.MENU_SHOW_CHECKOUT_LIST_OR_SHOW_USER_INFO:
                if (isLogin) {
                    return mDataManager.getUser().printInfo();
                } else {
                    return "\n";
                }
            case GlobalInfo.MENU_LOGIN_IN_OR_OUT:
                if (isLogin) {
                    isLogin = !isLogin;
                    return GlobalInfo.LOGIN_OUT_SUCCESS_MSG;
                } else {
                    isInLoginProcess = true;
                    return GlobalInfo.LOGIN_IN_HINT_MSG;
                }
                default:
                    return checkInputVaild(input);

        }
    }

    private String checkInputVaild(String input) {
        return isInLoginProcess ? checkLoginIsSuccess(input) : mDataManager.processCheckOrReturn(input);
    }

    private String checkLoginIsSuccess(String input) {
        String[] strings = input.split(" ");
        if (strings[0].equals(GlobalInfo.USER_ACCOUNT) && strings[1].equals(GlobalInfo.USER_PASSWORD)) {
            isInLoginProcess = false;
            isLogin = true;
            mDataManager.mockUser();
            return GlobalInfo.LOGIN_IN_SUCCESS_MSG;
        }else{
            return GlobalInfo.LOGIN_IN_FAIL_MSG;
        }
    }
    private void print(String msg) {
        System.out.print(msg);
    }
}
