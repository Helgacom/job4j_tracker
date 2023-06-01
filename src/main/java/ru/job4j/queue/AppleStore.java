package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private  final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String rsl = "";
        int residue = count;
        for (int i = 0; i < queue.size(); i++) {
            if (residue == 1) {
                rsl = queue.poll().name();
                break;
            } else {
                residue--;
                queue.poll();
            }
        }
        return rsl;
    }

    public String getFirstUpsetCustomer() {
        getLastHappyCustomer();
        return queue.poll().name();
    }
}
