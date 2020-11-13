package edu.tests;

import edu.Alarm;
import edu.ConsoleWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AlarmTests {

    private ConsoleWriter writer;
    private Alarm alarm;

    @BeforeEach
    public void setup(){
        writer = mock(ConsoleWriter.class);
        alarm = new Alarm(writer);
    }

    @Test
    public void beep_when_alarmOn_beeps(){
        // Arrange
        alarm.toggle();

        // Act
        alarm.beep();

        // Assert
        verify(writer).println(eq("BEEP"));
    }

    @Test
    public void beep_when_alarmOff_doesNotBeep(){
        alarm.beep();

        verify(writer, never()).println(anyString());
    }
}
