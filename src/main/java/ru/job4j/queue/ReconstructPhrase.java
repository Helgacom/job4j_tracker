package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        var rsl = new StringBuilder();
        int count = evenElements.size();
        for (int i = 0; i < count; i++) {
            Character currentEl = evenElements.pollFirst();
            if (i % 2 == 0) {
                rsl.append(currentEl);
            }
        }
        return rsl.toString();
    }

    private String getDescendingElements() {
        var rsl = new StringBuilder();
        int count = descendingElements.size();
        for (int i = 0; i < count; i++) {
            rsl.append(descendingElements.pollLast());
        }
        return rsl.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
