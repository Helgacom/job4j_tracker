package ru.job4j.ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan Ivanovich");
        student.setGroup(114);
        student.setCreated(new Date());
        System.out.println("Student: " + student.getFullName() + ", " + "Gr.: " + student.getGroup() + ", "
                + "Data in: " + student.getCreated());
    }
}
