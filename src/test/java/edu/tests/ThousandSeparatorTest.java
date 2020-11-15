package edu.tests;

import edu.ThousandSeparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThousandSeparatorTest {

    @Test
    void nineNumbersToString() {
        int numbers = 123456789;
        ThousandSeparator thousandSeparator = new ThousandSeparator();

        assertEquals("123,456,789", thousandSeparator.thousandSeparator(numbers));
    }

    @Test
    void threeNumbersToString() {
        int numbers = 123;
        ThousandSeparator thousandSeparator = new ThousandSeparator();

        assertEquals("123", thousandSeparator.thousandSeparator(numbers));
    }

    @Test
    void fourNumbersToString() {
        int numbers = 1234;
        ThousandSeparator thousandSeparator = new ThousandSeparator();

        assertEquals("1,234", thousandSeparator.thousandSeparator(numbers));
    }

    @Test
    void number_do_not_match_input() {
        int numbers = -1;
        ThousandSeparator thousandSeparator = new ThousandSeparator();

        assertEquals("", thousandSeparator.thousandSeparator(numbers));
    }


}