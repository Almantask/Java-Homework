package edu.tests;

import edu.Foo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FooTests {
    @Test
    public void bar_returns1(){
        int result = Foo.bar();

        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource("abc, 5")
    public void abc_5_test(String abc, int a){
        assertThat(abc).isEqualTo("abc");
        assertThat(a).isEqualTo(5);
    }
}
