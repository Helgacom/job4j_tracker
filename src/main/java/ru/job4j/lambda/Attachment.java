package ru.job4j.lambda;

public class Attachment {
    private String name;
    private int size;

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}