package edu.abstraction;

// Bird can fly
public class Bird implements Flyer, Identifiable {
    private final long id;

    public Bird(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public void fly(){
        System.out.println("Bird is flying");
    }
}
