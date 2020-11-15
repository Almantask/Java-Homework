package edu.tests;

import edu.Alarm;
import edu.Car;
import edu.Lights;
import edu.TypeARemoteCarController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TypeARemoteCarControllerTests {
    private Car car;
    private Alarm alarm;
    private Lights lights;
    private TypeARemoteCarController controller;

    @BeforeEach
    public void setupForWorking(){
        car = mock(Car.class);
        alarm = mock(Alarm.class);
        lights = mock(Lights.class);
        controller = new TypeARemoteCarController(alarm, car, lights);
    }

    @Test
    public void setup(){
        car = mock(Car.class);
        alarm = mock(Alarm.class);
        lights = mock(Lights.class);
        controller = new TypeARemoteCarController(alarm, car, lights);
    }

    @Test
    public void lock_when_carUnlocked_locks(){
        when(car.isLocked()).thenReturn(false);

        controller.lock();

        verify(car, times(1)).lock();
        verify(lights, atLeastOnce()).blink();
        verify(alarm, times(1)).toggle();
    }

    @Test
    public void lock_when_carLocked_blinksLights(){
        when(car.isLocked()).thenReturn(true);

        controller.lock();

        verify(car, never()).lock();
        verify(lights, atLeastOnce()).blink();
        verify(alarm, never()).toggle();
    }

    @Test
    public void unlock_when_carLocked_unlocks(){
        when(car.isLocked()).thenReturn(true);

        controller.unlock();

        verify(car, times(1)).unlock();
        verify(lights, atLeastOnce()).blink();
        verify(alarm, times(1)).toggle();
    }

    @Test
    public void unlock_when_unlocked_doesNothing(){
        when(car.isLocked()).thenReturn(false);

        controller.unlock();

        verify(car, never()).lock();
        verify(lights, atLeastOnce()).blink();
        verify(alarm, never()).toggle();
    }
}
