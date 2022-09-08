package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total1 = 0;
        for (int num : number) {
            int total = total1;
            total1 = add(
                    () -> total + num
            );
            System.out.println(total1);
        }
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
