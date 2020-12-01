package edu;

public class TypeARemoteCarController {

    private Alarm alarm;
    private Car car;
    private Lights lights;

    public TypeARemoteCarController(Alarm alarm, Car car, Lights lights) {
        this.alarm = alarm;
        this.lights = lights;
        this.car = car;
    }

    public void lock(){
        if (!car.isLocked()){
            car.lock();
            alarm.toggle();
            lights.blink();
        }else {
            lights.blink();
        }
    }

    public void unlock(){
        if (car.isLocked()){
            car.unlock();
            lights.blink();
            alarm.toggle();
        }
    }
}
