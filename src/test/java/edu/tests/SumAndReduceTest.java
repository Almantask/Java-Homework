package edu.tests;

import edu.SumAndReduce;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class SumAndReduceTest {
    @Test
    public void calculateShouldSumAllNumbers() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        assertThat(SumAndReduce.calculate(numbers)).isEqualTo(1 + 2 + 3 + 4 + 5);
    }
}
