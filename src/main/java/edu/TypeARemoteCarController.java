package edu;

public class TypeARemoteCarController {
    private final Alarm alarm;
    private final Car car;
    private final Lights lights;

    public TypeARemoteCarController(Alarm alarm, Car car, Lights lights) {
        this.alarm = alarm;
        this.car = car;
        this.lights = lights;
    }

    public void lock() {
        if (!alarm.getIsOn()) {
            alarm.toggle();
        }
        if (!car.isLocked()) {
            car.lock();
        }
        lights.blink();
    }

    public void unlock() {
        if (alarm.getIsOn()) {
            alarm.toggle();
        }
        if (car.isLocked()) {
            car.unlock();
        }
        if (car.isLocked()) {
            lights.blink();
        }
    }
}