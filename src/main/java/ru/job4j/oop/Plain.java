package ru.job4j.oop;

public class Plain implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " moves through the air");
    }
}
