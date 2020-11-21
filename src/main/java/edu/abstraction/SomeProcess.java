package edu.abstraction;

public abstract class SomeProcess {
    public void execute(){
        prepare();
        run();
        cleanup();
    }

    protected abstract void prepare();
    protected abstract void run();
    protected abstract void cleanup();
}
