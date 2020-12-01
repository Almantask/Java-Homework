package edu;

public class Car {

    private Alarm alarm;
    private Lights lights;
    private boolean isLocked;

    public Car(Alarm alarm, Lights lights) {
        this.alarm = alarm;
        this.lights = lights;
    }

    public boolean isLocked(){
        return isLocked;
    }

    public void lock(){
        if (!isLocked){
            isLocked = true;
        }
    }

    public void unlock(){
        if (isLocked){
            isLocked = false;
        }
    }

    public void open(){
        if (isLocked){
            alarm.beep();
        }
    }
}
