package edu.tests;

import org.junit.jupiter.api.Test;
import static edu.ThousandSeparator.separator;
import static org.assertj.core.api.Assertions.assertThat;

public class ThousandSeparatorTest {

    @Test
    public void given_negative_return_error(){
        String number = separator(-50);

        assertThat(number).isEqualTo("Error");
    }
    @Test
    public void given_zero_returns_zero(){
        String number = separator(0);

        assertThat(number).isEqualTo("0");
    }
    @Test
    public void given_987_returns_987(){
        String number = separator(987);

        assertThat(number).isEqualTo("987");
    }
    @Test
    public void given_1234_returns_1dot234(){
        String number = separator(1234);

        assertThat(number).isEqualTo("1.234");
    }
    @Test
    public void given_123456789_returns_123dot456dot789(){
        String number = separator(123456789);

        assertThat(number).isEqualTo("123.456.789");
    }
}
