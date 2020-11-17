package edu;

public class TypeBRemoteCarController {
    private final Alarm alarm;
    private final Car car;
    private final Lights lights;

    public TypeBRemoteCarController(Alarm alarm, Car car, Lights lights) {
        this.alarm = alarm;
        this.car = car;
        this.lights = lights;
    }

    public void toggle() {
        if (car.isLocked()) {
            car.lock();
            if (alarm.getIsOn()) {
                alarm.toggle();
            }

        } else {
            car.unlock();
            if (!alarm.getIsOn()) {
                alarm.toggle();
            }
        }
        lights.blink();
    }
}