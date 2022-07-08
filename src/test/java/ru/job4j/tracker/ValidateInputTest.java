package ru.job4j.tracker;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                asList("one", "1")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                singletonList("1")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenSeveralValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                asList("1", "4")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected, is(1));
        assertThat(selected1, is(4));

    }

    @Test
    public void whenInvalidMinusInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                singletonList("-5"));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-5));
    }
}