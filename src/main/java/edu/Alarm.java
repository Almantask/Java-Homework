package edu;

// Reads: AlarmSystem is a Beeper.
// Or better: can beep.
public class Alarm implements Beeper {
    private boolean isOn = false;

    // Needed to be able to test beep method.
    private final ConsoleWriter writer;

    public Alarm(ConsoleWriter writer){
        this.writer = writer;
    }

    public void toggle(){

    }

    @Override
    public void beep() {
        // but only beep if alarm is on
        writer.println("BEEP");
    }
}
