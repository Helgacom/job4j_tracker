package ru.job4j.ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book tales = new Book("Tales", 211);
        Book stories = new Book("Stories", 158);
        Book dictionary = new Book("Dictionary", 481);
        Book cleanCode = new Book("Clean Code", 190);
        Book[] books = new Book[4];
        books[0] = tales;
        books[1] = stories;
        books[2] = dictionary;
        books[3] = cleanCode;
        for (int index = 0; index < books.length; index++) {
            Book ex = books[index];
            System.out.println(ex.getName() + ", " + ex.getNum());
        }

        System.out.println(System.lineSeparator() + "Replace elements:");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book ex = books[index];
            System.out.println(ex.getName() + ", " + ex.getNum());
        }

        System.out.println(System.lineSeparator() + "Book search:");
        for (int index = 0; index < books.length; index++) {
            Book ex = books[index];
            if ("Clean Code".equals(ex.getName())) {
                System.out.println(ex.getName());
            }
        }
    }
}
