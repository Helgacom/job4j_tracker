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

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        char[] array = password.toCharArray();
        for (char el : array) {
            if (isUpperCase(el)) {
                count1++;
                break;
            }
        }

        if (count1 == 0) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }

        for (char el : array) {
            if (isLowerCase(el)) {
                count2++;
                break;
            }
        }

        if (count2 == 0) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }

        for (char el : array) {
            if (isDigit(el)) {
                count3++;
                break;
            }
        }

        if (count3 == 0) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }

        for (char el : array) {
            if (!isLetterOrDigit(el)) {
                count4++;
                break;
            }
        }

        if (count4 == 0) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
    }
}
