package edu.abstraction;

public class Process1 extends SomeProcess {
    @Override
    protected void prepare() {
        System.out.println("Preparation 1");
    }

    @Override
    protected void run() {
        System.out.println("rurnfurinrdgivdfngd");
    }

    @Override
    protected void cleanup() {
        System.out.println("Cleaning up");
    }
}
