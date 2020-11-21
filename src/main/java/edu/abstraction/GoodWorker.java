package edu.abstraction;

public class GoodWorker extends Worker{
    public GoodWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println("Working");
    }
}
