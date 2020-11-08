package main.java.tests;

import static org.assertj.core.api.Assertions.assertThat;

import Numbers.PrimeNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PrimeNumbersTests {
    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, true",
            "6, false"
    })
    void isPrime_returnsExpected(int n, boolean expectedIsPrime) {
        boolean isPrime = PrimeNumbers.isPrime(n);

        assertThat(isPrime).isEqualTo(expectedIsPrime);
    }

    // Get all prime numbers from 1 to 100

    @ParameterizedTest
    @MethodSource("primesInRange")
    void findAll_returns_expected(int rangeEnd, int[] expectedPrimes){
        int[] primes = PrimeNumbers.findAll(rangeEnd);

        assertThat(prime).contains(expectedPrimes);
    }

    private static Stream<Arguments> primesInRange() {
        return Stream.of(
                Arguments.of(1, new int[]{}),
                Arguments.of(2, new int[]{ 2 }),
                Arguments.of(4, new int[]{ 2, 3}),
                Arguments.of(6, new int[]{ 2, 3, 5})
        );
    }
}
