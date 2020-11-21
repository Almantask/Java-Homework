//- Opening a locked door rings an alarm. This should call `alarm.Beep()` method.
//        - Opening a unlocked door does not trigger anything.

package edu;

public class Car {
        private Alarm alarm;
        private Lights lights;
        private boolean isLocked = false;
    public Car(Alarm alarm, Lights lights) {
        this.alarm = alarm;
        this.lights = lights;
    }

    public boolean isLocked(){
        return isLocked;
    }

    public void lock(){
        isLocked = true;
    }

    public void unlock(){
        isLocked = false;
    }

    public void open(){
        if(isLocked) {
            alarm.beep();
        }
    }
}
