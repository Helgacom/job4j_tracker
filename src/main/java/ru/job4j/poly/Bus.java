package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Move");
    }

    @Override
    public void passenger(int passenger) {
        System.out.println("Количество пассажиров " + passenger);
    }

    @Override
    public int price(int amount) {
        int rate = 15;
        return amount * rate;
    }
}
