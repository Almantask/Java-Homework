package edu;

public class Demo {
    public static void main(String[] args) {
        Alarm alarm = new Alarm(new ConsoleWriter());
        Lights lights = new Lights();
        Car car = new Car(alarm, lights);

        TypeARemoteCarController controllerA = new TypeARemoteCarController(alarm, car, lights);
        TypeBRemoteCarController controllerB = new TypeBRemoteCarController(alarm, car, lights);

        // Make sure the scenarios are simulated below.
        controllerA.lock();
        car.open();
        controllerA.unlock();
        car.open();

        System.out.println("----------------Separation of controllers-----------------");

        controllerB.toggle();
        car.open();
        controllerB.toggle();
        car.open();
    }
}
