package edu;

import edu.encapsulation.ProgressBar;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class ProgressBarTest {


    @ParameterizedTest
    @ValueSource (ints = {0, -5})
    void addProgress_WhenZeroOrNegaviteIncrement_doesNothing(int increment) {
        ProgressBar progressBar = new ProgressBar(5, 100);

        progressBar.addProgress(increment);

        assertThat(progressBar.getProgress()).isEqualTo(0.05f);
    }


    @ParameterizedTest
    @CsvSource ({
            "0, 0",
            "-1, 0",
            "101, 1.00",
            "2, 0.02"
    })
    void new_SetsExpected_CurrentProgress(int currentProgress, float expectedOutput) {
       ProgressBar progressBar = new ProgressBar(currentProgress, 100);

       assertThat(progressBar.getProgress()).isEqualTo(expectedOutput);
    }
//
//    @ParameterizedTest
////    @CsvSource ({
////            "-1, 0",
////            "101, 1.00",
////            "2, 0.02"
////    })
//    void testToString(int currentProgress, String expectedString) {
//
//    }






















}