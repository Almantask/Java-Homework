package edu.abstraction;

// If class and an interface had a baby- it would be an abstract class
// Abstract class has some implementation and some methods to be implemented
// Abstract class is incomplete
// Abstract class cannot be initialized
public abstract class Worker {
    private final String name;

    protected Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void work();
}
