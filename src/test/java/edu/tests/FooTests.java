package edu.tests;

import edu.Foo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

// Test suite
public class FooTests {
    @Test
    public void bar_returns1(){
        int result = Foo.bar();

        assertThat(result).isEqualTo(1);
    }

    // Test case
    @ParameterizedTest
    @CsvSource("abc, 5")
    public void abc_5_test(String abc, int a){

    }
}
