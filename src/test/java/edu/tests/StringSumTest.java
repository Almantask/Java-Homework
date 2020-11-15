import edu.StringSum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSumTest {

    @Test
    public void add_when_Empty_Returns_0(){
        StringSum s = new StringSum();

        int sum = s.add("");

        assertThat(sum).isEqualTo(0);
    }

    //kitu var
    @Test
    public void gien_empty_when_add_returns_0(){
        StringSum s = new StringSum();

        int sum = s.add("");

        assertThat(sum).isEqualTo(0);
    }



    @Test
    public void add_given_Null_Returns_0(){
        StringSum s = new StringSum();

        int sum = s.add(null);

        assertThat(sum).isEqualTo(0);
    }

    @Test
    public void checkSinglePositiveNumber(){
        StringSum s = new StringSum();

        int sum = s.add("10");

        assertThat(sum).isEqualTo(10);
    }

    @Test
    public void checkSingleNegativeNumber(){
        StringSum s = new StringSum();

        int sum = s.add("-10");

        assertThat(sum).isEqualTo(-10);
    }


    @ParameterizedTest
    @ValueSource(strings = {"10+20+30", "10.20.30", "10:20:30"})

    public void add_given_Any_Seperator(String strings){
        StringSum s = new StringSum();

        int sum = s.add(strings);

        assertThat(sum).isEqualTo(60);
    }
   /* @Test
    public void checkSumming_colomnSeperator(){
        StringSum s = new StringSum();

        int sum = s.add("10:20:30");

        assertThat(sum).isEqualTo(60);
    }
    @Test
    public void checkSumming_colomnSeperator(){
        StringSum s = new StringSum();

        int sum = s.add("10;20;30");

        assertThat(sum).isEqualTo(60);
    }
    @Test
    public void checkSumming_minusSeperator(){
        StringSum s = new StringSum();

        int sum = s.add("10-20-30");

        assertThat(sum).isEqualTo(60);*/
    }

