package edu;

public class Car {

    private boolean locked = false;
    private Alarm alarm;
    private Lights lights;

    public Car(Alarm alarm, Lights lights) {
        this.alarm = alarm;
        this.lights = lights;
    }

    public boolean isLocked( ){
        if (locked) {
            return true;
        } else
        return false;
    }

    public boolean lock(){
        if (!locked) {
            locked = true;
            alarm.toggle();
            lights.blink();
        }
        return false;
    }

    public boolean unlock(){
        if (!locked) {
            locked = false;
        }
        return true;
    }

    public void open(){
        if (locked) {
            alarm.beep();
        }
    }


}
