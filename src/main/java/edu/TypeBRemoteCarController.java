package edu;
//TypeB- 1 function.
//        Toggle
//        - If a car is unlocked, locks the car and blinks car lights and turns on the alarm.
//        - If a car is locked, unlocks the car and blinks car lights and turns off the alarm.
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

