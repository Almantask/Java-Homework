package edu;

// Reads: AlarmSystem is a Beeper.
// Or better: can beep.
public class Alarm implements Beeper {
    private static boolean isOn = false;

    // Needed to be able to test beep method.
    private final ConsoleWriter writer;

    public Alarm(ConsoleWriter writer){
        this.writer = writer;
    }

    public void toggle(){
        this.isOn = !isOn;
    }

    @Override
    public void beep() {
        if (isOn) {
            writer.println("BEEP");
        } else
            return;
    }
}
