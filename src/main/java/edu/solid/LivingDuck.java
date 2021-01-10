package edu.solid;

public class LivingDuck implements Flyer, Quacker{

    @Override
    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
