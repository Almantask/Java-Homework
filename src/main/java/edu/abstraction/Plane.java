package edu.abstraction;

// Plane can fly
public class Plane implements Flyer, Identifiable{
    private final long id;

    public Plane(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public void fly(){
        System.out.println("Plane is flying.");
    }
}
