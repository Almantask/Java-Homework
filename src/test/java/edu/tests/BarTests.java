package edu.tests;

import edu.Bar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BarTests {
    @Test
    public void foo_returns_null(){
        String result = Bar.foo();

        assertThat(result).isEqualTo(null);
    }
}
