package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 2, "YES");
        Error error3 = new Error(true, 1, "YES");
        Error error4 = new Error(false, 0, "NO");
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
        error4.printInfo();
    }
}
