package ru.job4j.map;

import java.util.Objects;

public class Student {
    private String name;

    private String account;

    private String group;

    public Student(String name, String account, String group) {
        this.name = name;
        this.account = account;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Student student = (Student) o;
            return Objects.equals(account, student.account);
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(account);
    }
}
