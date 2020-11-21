package edu;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProgressBarTest {

    @ParameterizedTest
    @ValueSource(ints ={0, -5})
// paduodant viena parametra
    void addProgress_zero_or_negative_increment_doesNothing(int increment) {
        ProgressBar progress = new ProgressBar(5,100);

        progress.addProgress(increment);

        assertThat(progress.getProgress()).isEqualTo(0.05f);
    }

    @ParameterizedTest
    // paduodant daugiau nei viena parametra
    @CsvSource({
            "0, 0",
            "-1, 0",
            "101, 1",
            "2, 0.02"
    })
    void newCurrentProgress_setsExpectedCurrentProgress(int currentProgress, float expectedOutput) {
        ProgressBar progress = new ProgressBar(currentProgress, 100);

        assertThat(progress.getProgress()).isEqualTo(expectedOutput);
    }
//    @ParameterizedTest
//    @CsvSource({
//            "0, 0",
//            "-1, 0",
//            "101, 1",
//            "2, 0.02"
//    })
//    void testToString(int currentProgress, String expectedString) {
//    }
}