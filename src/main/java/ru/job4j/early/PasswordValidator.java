package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {

    public static String validate(String password) {

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        String[] arrayEx = new String[] {"qwerty", "12345", "password", "admin", "user"};
        for (String s : arrayEx) {
            if (password.toLowerCase().contains(s)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }

        int uppercaseCheck = 0;
        int lowercaseCheck = 0;
        int figureCheck = 0;
        int specialSymbolCheck = 0;
        char[] array = password.toCharArray();
        for (char el : array) {
            if (isUpperCase(el)) {
                uppercaseCheck++;
            }
            if (isLowerCase(el)) {
                lowercaseCheck++;
            }
            if (isDigit(el)) {
                figureCheck++;
            }
            if (!isLetterOrDigit(el)) {
                specialSymbolCheck++;
            }
        }

        if (uppercaseCheck == 0) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }

        if (lowercaseCheck == 0) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }

        if (figureCheck == 0) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }

        if (specialSymbolCheck == 0) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
    }
}
