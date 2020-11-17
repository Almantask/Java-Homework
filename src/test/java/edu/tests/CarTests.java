package edu.tests;

import edu.Alarm;
import edu.Car;
import edu.Lights;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CarTests {
    private Alarm alarm;
    private Lights lights;
    private Car car;

    @BeforeEach
    public void setup() {
        alarm = mock(Alarm.class);
        lights = mock(Lights.class);
        car = new Car(alarm, lights);
    }

    @Test
    public void open_when_carIsLocked_beeps() {
        // Arrange
        car.lock();
        when(alarm.getIsOn()).thenReturn(true);
        // Act
        car.open();

        // Assert
        verify(alarm, atLeastOnce()).beep();
    }

    @Test
    public void open_when_carIsUnlocked_doesNotBeep() {
        // Arrange
        car.unlock();

        // Act
        car.open();

        // Assert
        verify(alarm, never()).beep();
    }

    @Test
    public void lock_setsIsLocked_toTrue() {
        car.lock();

        assertThat(car.isLocked()).isEqualTo(true);
    }

    @Test
    public void unlock_setsIsLocked_toFalse() {
        car.unlock();

        assertThat(car.isLocked()).isEqualTo(false);
    }
}
