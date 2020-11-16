package edu;

public class TypeBRemoteCarController {
    private Alarm alarm;
    private Car car;
    private Lights lights;

    public TypeBRemoteCarController(Alarm alarm, Car car, Lights lights) {
        this.alarm = alarm;
        this.car = car;
        this.lights = lights;
    }

    public void toggle(){
        if (car.isLocked()) {
            car.unlock();
        } else car.lock();
        lights.blink();
        alarm.toggle();
    }
}
