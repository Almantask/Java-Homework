package edu.solid;

public interface Flyer{
    void fly();
}

public interface Quacker{
    void quack();
}

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

public class RubberDuck implements Quacker{
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}


