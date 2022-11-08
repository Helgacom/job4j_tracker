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

        if (password.toLowerCase().contains("qwerty")
                || password.contains("12345")
                || password.toLowerCase().contains("password")
                || password.toLowerCase().contains("admin")
                || password.toLowerCase().contains("user"))  {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        char[] array = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
            if (isUpperCase(array[i])) {
                count1++;
            }
        }

        if (count1 == 0) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }

        for (int i = 0; i < password.length(); i++) {
            if (isLowerCase(array[i])) {
                count2++;
            }
        }

        if (count2 == 0) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }

        for (int i = 0; i < password.length(); i++) {
            if (isDigit(array[i])) {
                count3++;
            }
        }

        if (count3 == 0) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }

        for (int i = 0; i < password.length(); i++) {
            if (!isLetterOrDigit(array[i])) {
                count4++;
            }
        }

        if (count4 == 0) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
    }
}
