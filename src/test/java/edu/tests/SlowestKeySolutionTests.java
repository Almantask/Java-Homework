package edu.tests;

import edu.SlowestKeySolution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SlowestKeySolutionTests {
    @ParameterizedTest
    @MethodSource("createSlowestKeyExpectations")
    public void Test(int[] releaseTimes, String keysPressed, char expectedSlowestKey, String description) {
        char slowestKey = SlowestKeySolution.solve(releaseTimes, keysPressed);

        assertThat(slowestKey)
                .as(description)
                .isEqualTo(expectedSlowestKey);
    }

    private static Stream<Arguments> createSlowestKeyExpectations() {
        return Stream.concat(
                createInvalidKeyExpectations(),
                createValidKeyExpectations()
        );
    }

    private static Stream<Arguments> createInvalidKeyExpectations() {
        Stream<Arguments> invalidKeyExpectations = Stream.of(
                Arguments.of(
                        new int[]{},
                        "a",
                        SlowestKeySolution.INVALID,
                        "Not existing key press durations should return invalid output"
                ),
                Arguments.of(
                        null,
                        "a",
                        SlowestKeySolution.INVALID,
                        "Not existing key press durations should return invalid output"
                ),
                Arguments.of(
                        new int[]{1},
                        "",
                        SlowestKeySolution.INVALID,
                        "Not existing key presses should return invalid output"
                ),
                Arguments.of(
                        new int[]{1},
                        null,
                        SlowestKeySolution.INVALID,
                        "Not existing key presses should return invalid output"
                ),
                Arguments.of(
                        new int[]{1, 2},
                        "a",
                        SlowestKeySolution.INVALID,
                        "Times for 2 presses register, but only 1 key pressed should return invalid output"
                ),
                Arguments.of(
                        new int[]{1},
                        "ab",
                        SlowestKeySolution.INVALID,
                        "Times for 1 presses register, but only 2 keys pressed should return invalid output"
                )
        );

        return invalidKeyExpectations;
    }

    private static Stream<Arguments> createValidKeyExpectations() {
        Stream<Arguments> invalidKeyExpectations = Stream.of(
                Arguments.of(
                        new int[]{10},
                        "a",
                        'a',
                        "A is the only key pressed, therefore it should be returned"
                ),
                Arguments.of(
                        new int[]{1, 3},
                        "ab",
                        'b',
                        "'a' was pressed for 1 second, 'b' was pressed for 2 seconds. Should return 'b', because it was pressed for longer"
                ),
                Arguments.of(
                        new int[]{2, 3},
                        "ab",
                        'a',
                        "'a' was pressed for 2 seconds, 'b' was pressed for 1 seconds. Should return 'a', because it was pressed for longer"
                ),
                Arguments.of(
                        new int[]{1, 2},
                        "ba",
                        'b',
                        "When both keys have been pressed for the same amount of time, should return the first one- 'b'"
                ),
                Arguments.of(
                        new int[]{9, 29, 49, 50},
                        "cbcd",
                        'c',
                        "'c' has been pressed for '29' seconds int total, b- 20 seconds, 'd'- 1 second. Should return 'c', because it has been pressed for the longest IN TOTAL"
                ),
                Arguments.of(
                        // if both chars pressed for 1s, return first.
                        new int[]{12, 23, 36, 46, 62},
                        "spuda",
                        'a',
                        "'s' -12s, 'p'- 11s, 'u'- 13s, 'd'- 10s, 'a'- 16s. Should return 'a', because it has been pressed the longest"
                )
        );

        return invalidKeyExpectations;
    }
}
