package ru.job4j.poly;

public interface Transport {

    void move();

    void passenger(int passenger);

    int price(int amount);
}
