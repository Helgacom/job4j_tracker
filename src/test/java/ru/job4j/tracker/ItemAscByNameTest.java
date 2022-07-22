package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemAscByNameTest {

    @Test
    public void compareAsc() {
        Item itemFirst = new Item(2, "First");
        Item itemSecond = new Item(4, "Second");
        Item itemThird = new Item(3, "Third");
        List<Item> items = Arrays.asList(itemFirst, itemSecond, itemThird);

        Collections.sort(items, new ItemAscByName());

        List<Item> expected = Arrays.asList(itemFirst, itemSecond, itemThird);
        assertEquals(items, expected);
    }
}