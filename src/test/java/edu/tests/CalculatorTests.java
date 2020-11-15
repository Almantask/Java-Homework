/**
 * Demonstrates parameterised tests
 */

package edu.tests;

import edu.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTests {

    @ParameterizedTest
    @MethodSource("addExpectations")
    public void add_1plus2_returns_3_______Version2(int a, int b, int expectedResult){
        int result = Calculator.add(a, b);

        assertThat(result).isEqualTo(expectedResult);
    }

    // Instead of repeating yourself, use input that expresses the differences
    @ParameterizedTest(name = "{0}+{1}={2}")
    @CsvSource({
        "1,2,3",
        "1,0,1"
    })
    @DisplayName("Sum tests")
    public void add_1plus2_returns_3_______Version1(int a, int b, int expectedResult){
        int result = Calculator.add(a, b);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void add_1plus2_returns_3(){
        int a = 1;
        int b = 2;

        int result = Calculator.add(a, b);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void add_1plus0_returns_1(){
        int a = 1;
        int b = 0;

        int result = Calculator.add(a, b);

        assertThat(result).isEqualTo(1);
    }

    public static Stream<Arguments> addExpectations(){
        return Stream.of(
                Arguments.of(1,2,3),
                Arguments.of(1,0,1)
        );
    }
}
