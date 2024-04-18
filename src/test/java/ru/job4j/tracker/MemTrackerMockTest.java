package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MemTrackerMockTest {

    @Test
    void whenItemWasFoundByName() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item for findByName action");
        tracker.add(item);
        FindByNameAction findItemByNameAction = new FindByNameAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        findItemByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        String expected = String.format("=== Find items by name ===%s%s%s", ln, item, ln);
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void whenItemWasNotFoundByName() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item for findByName action"));
        FindByNameAction findItemByNameAction = new FindByNameAction(output);
        String searchedItemName = "Searched item";
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(searchedItemName);
        findItemByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        String expected = String.format(
                "=== Find items by name ===%sЗаявки с именем: %s не найдены.%s",
                ln, searchedItemName, ln
        );
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void whenItemWasFoundById() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Item for findById action");
        tracker.add(item);
        FindByIdAction findItemByIdAction = new FindByIdAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findItemByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        String expected = String.format("=== Find item by id ===%s%s%s", ln, item, ln);
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void whenItemWasNotFoundById() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item for findById action"));
        FindByIdAction findItemByIdAction = new FindByIdAction(output);
        int searchedId = 5;
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(searchedId);
        findItemByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        String expected = String.format(
                "=== Find item by id ===%sЗаявка с введенным id: %d не найдена.%s",
                ln, searchedId, ln
        );
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void whenItemWasReplaced() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditAction replaceAction = new EditAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        replaceAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
        );
    }

    @Test
    void whenItemWasNotReplaced() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        EditAction replaceAction = new EditAction(output);
        Input input = mock(Input.class);
        replaceAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Edit item ===" + ln
                        + "Ошибка замены заявки." + ln
        );
    }

    @Test
    void whenItemWasDeleted() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item"));
        DeleteAction deleteAction = new DeleteAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete item ===" + ln
                        + "Заявка удалена успешно." + ln
        );
    }

    @Test
    void whenItemWasNotDeleted() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item"));
        DeleteAction deleteAction = new DeleteAction(output);
        Input input = mock(Input.class);
        deleteAction.execute(input, tracker);
        assertThat(tracker.findAll()).hasSize(1);
    }
}