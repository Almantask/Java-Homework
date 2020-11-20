package edu;
//TypeA- 2 functions.
//        - Lock- used for locking and turning alarm on. Pressing this button again, does not unlock, but in either case, it blinks car lights.
//        - Unlock- used for unlocking and turning alarm off. Pressing this button when a car is locked- unlocks it, otherwise it does nothing.

public class TypeARemoteCarController {
    private Alarm alarm;
    private Car car;
    private Lights lights;

    public TypeARemoteCarController(Alarm alarm, Car car, Lights lights) {
        this.alarm = alarm;
        this.car = car;
        this.lights = lights;
    }

    public void lock(){

        if(!car.isLocked()) {
            car.lock();
            alarm.toggle();
        }
        lights.blink();
    }

    public void unlock(){

        if(car.isLocked()) {
            car.unlock();
            alarm.toggle();
            lights.blink();

        }
    }
}