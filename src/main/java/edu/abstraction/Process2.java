package edu.abstraction;

public class Process2 extends SomeProcess {
    @Override
    protected void prepare() {
        System.out.println("Preparation 2");
    }

    @Override
    protected void run() {
        System.out.println("huh?");
    }

    @Override
    protected void cleanup() {
        System.out.println("clrs");
    }
}
