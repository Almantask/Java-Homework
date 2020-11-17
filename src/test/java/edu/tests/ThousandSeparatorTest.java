package edu.tests;

import edu.ThousandSeparator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThousandSeparatorTest {

    @Test
    public void when_input_negative_returns_emptyString() {

        int number = -1;

        String s = ThousandSeparator.thousandSeparator(number);

        assertThat(s).isEqualTo("");
    }

    @Test
    public void when_input_threeNumbers_returns_thisNumbers() {

        int number = 123;

        String s = ThousandSeparator.thousandSeparator(number);

        assertThat(s).isEqualTo("123");
    }

    @Test
    public void when_input_fourNumbers_returns_stringWhitDotAfterFirstNumber() {

        int number = 1234;

        String s = ThousandSeparator.thousandSeparator(number);

        assertThat(s).isEqualTo("1.234");
    }

    @Test
    public void when_input_nineNumbers_returns_stringWhitDotAfterEveryThreeNumbers() {

        int number = 123456789;

        String s = ThousandSeparator.thousandSeparator(number);

        assertThat(s).isEqualTo("123.456.789");
    }

    @Test
    public void when_input_zero_returns_zero() {

        int number = 0;

        String s = ThousandSeparator.thousandSeparator(number);

        assertThat(s).isEqualTo("0");
    }
}
