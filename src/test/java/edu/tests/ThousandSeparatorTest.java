package edu.tests;
import org.junit.jupiter.api.Test;
import static edu.ThousandSeparator.separate;
import static org.assertj.core.api.Assertions.assertThat;

public class ThousandSeparatorTest {

    @Test
    public void given_negative_return_empty_string(){
        String number = separate(-100);

        assertThat(number).isEqualTo("");
    }

    @Test
    public void given_0_return_0(){
        String number = separate(0);

        assertThat(number).isEqualTo("0");
    }

    @Test
    public void given_987_return_987(){
        String number = separate(987);

        assertThat(number).isEqualTo("987");
    }

    @Test
    public void given_1234_return_1point234(){
        String number = separate(1234);

        assertThat(number).isEqualTo("1.234");
    }

    @Test
    public void given_123456789_return_123point456point789(){
        String number = separate(123456789);

        assertThat(number).isEqualTo("123.456.789");
    }
}
