package edu;

public class Car {
    private boolean carIsLocked = true;
    private final Alarm alarm;

    public Car(Alarm alarm, Lights lights) {
        this.alarm = alarm;
    }

    public boolean isLocked() {
        return carIsLocked;
    }

    public void lock() {
        carIsLocked = true;
    }

    public void unlock() {
        carIsLocked = false;
    }

    public void open() {
        if (alarm.getIsOn()) {
            alarm.beep();
        }
    }
}