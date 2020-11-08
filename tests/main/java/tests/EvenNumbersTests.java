package main.java.tests;

import Numbers.NumbersCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EvenNumbersTests {
    @Test
    void isEven_givenEvenNumber_returnsTrue(){
        // Arrange
        int n = 4;

        // Act
        boolean isEven = NumbersCategory.isEven(n);

        // Assert
        assertThat(isEven).isTrue();
    }

    @Test
    void isEven_givenNotEvenNumber_returnsFalse(){
        int n = 3;

        boolean isEven = NumbersCategory.isEven(n);

        assertThat(isEven).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "4, true",
            "3, false"
    })
    void isEven_returnsExpected(int n, boolean expectedIsEven){
        boolean isEven = NumbersCategory.isEven(n);

        assertThat(isEven).isEqualTo(expectedIsEven);
    }
}
