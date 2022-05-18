package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int num) {
        return sum(num) + minus(num) + multiply(num) + divide(num);
    }

    public static void main(String[] args) {
        int result1 = sum(10);
        System.out.println(result1);
        int result2 = minus(10);
        System.out.println(result2);
        Calculator calculator = new Calculator();
        int rsl1 = calculator.multiply(5);
        System.out.println(rsl1);
        int rsl2 = calculator.divide(5);
        System.out.println(rsl2);
        int rsl3 = calculator.sumAllOperation(10);
        System.out.println(rsl3);
    }
}