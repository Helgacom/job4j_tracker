package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HbmTrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenFindAll() {
        try (var tracker = new HbmTracker()) {
            var item1 = new Item();
            var item2 = new Item();
            item1.setName("test1");
            item2.setName("test2");
            tracker.add(item1);
            tracker.add(item2);
            List<Item> rsl = tracker.findAll();
            assertThat(rsl).hasSize(2);
            assertThat(rsl).containsExactly(item1, item2);
        }
    }

    @Test
    public void whenFindByName() {
        try (var tracker = new HbmTracker()) {
            var item1 = new Item();
            var item2 = new Item();
            item1.setName("test1");
            item2.setName("test2");
            tracker.add(item1);
            tracker.add(item2);
            List<Item> rsl = tracker.findByName("test1");
            assertThat(rsl).hasSize(1)
                    .containsExactly(item1);
        }
    }

    @Test
    public void whenFindById() {
        try (var tracker = new HbmTracker()) {
            var item = new Item();
            item.setName("test1");
            tracker.add(item);
            var rsl = item;
            assertThat(rsl).isEqualTo(tracker.findById(item.getId()));
        }
    }

    @Test
    public void whenReplace() {
        try (var tracker = new HbmTracker()) {
            var item1 = new Item("test1");
            var item2 = new Item("test2");
            tracker.add(item1);
            var rsl = tracker.replace(1, item2);
            assertThat(rsl).isTrue();
            assertThat(tracker.findById(item1.getId()).getName()).isEqualTo("test2");
        }
    }

    @Test
    public void whenDelete() {
        try (var tracker = new HbmTracker()) {
            var item1 = new Item();
            item1.setName("test1");
            tracker.add(item1);
            tracker.delete(item1.getId());
            assertThat(tracker.findByName("test1")).isEmpty();
        }
    }
}