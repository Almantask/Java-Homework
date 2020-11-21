package edu.abstraction;

public class Dog implements Identifiable {
    private final String name;
    private final long id;

    public Dog(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public long getId() {
        return id;
    }
}
