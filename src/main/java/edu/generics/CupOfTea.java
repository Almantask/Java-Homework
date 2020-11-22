package edu.generics;

// Cup of TEA-ONLY liquid.
public class CupOfTea {
    private final float capacity;
    private float current;

    public CupOfTea(float capacity, float current) {
        this.capacity = capacity;
        this.current = current;
    }

    public void add(Tea liquid){
        current += liquid.getAmount();
        if(current > capacity){
            current = capacity;
        }
    }

    public boolean isFull(){
        final float TOLERANCE = 0.001f;
        return Math.abs(capacity - current) < TOLERANCE;
    }
    // add isFullMethod
}
