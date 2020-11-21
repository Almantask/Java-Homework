package edu.abstraction;

// Abstract class cannot be initialized by itself
// Therefore it must be inherited by a another class
// And eventually, that class which defines how we create the parent
// must be non-abstract
public class LazWorker extends Worker{
    public LazWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println("Doing absolutely nothing.");
    }
}
