package ru.job4j.oop;

public class Station {
    public static void main(String[] args) {
        Vehicle express = new Train();
        Vehicle highSpeedTrain = new Train();
        Vehicle concord = new Plain();
        Vehicle boeing = new Plain();
        Vehicle passBus = new Bus();
        Vehicle schoolBus = new Bus();

        Vehicle[] vehicle = new Vehicle[] {express, highSpeedTrain, concord, boeing, passBus, schoolBus};
        for (Vehicle a: vehicle) {
            a.move();
        }
    }
}
