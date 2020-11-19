package edu.tests;

import edu.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TypeBRemoteCarControllerTests {
    private Car car;
    private Alarm alarm;
    private Lights lights;
    private TypeBRemoteCarController controller;

    @Test
    public void setup(){
        car = mock(Car.class);
        alarm = mock(Alarm.class);
        lights = mock(Lights.class);
        controller = new TypeBRemoteCarController(alarm, car, lights);
    }

    @Test
    public void toggle_when_carUnlocked_locks(){
        when(car.isLocked()).thenReturn(false);

     controller.toggle();
//
//        verify(car, times(1)).lock();
//        verify(lights, atLeastOnce()).blink();
//        verify(alarm, times(1)).toggle();
    }

    @Test
    public void toggle_when_carLocked_unlocks(){
        when(car.isLocked()).thenReturn(true);

        controller.toggle();

        verify(car, times(1)).unlock();
        verify(lights, atLeastOnce()).blink();
        verify(alarm, times(1)).toggle();
    }
}
