package edu.generics;

// Cup of ANY liquid.
// We can fill the cup, but only until it's full.
// This class should be polymorphic, because there is
// nothing that we would like to do with a specific liquid
// The problem with this cup is that we cannot do much
// other than a yucky validation if we wanted to only have
// the same type of liquid inside.
public class Cup {
    private final float capacity;
    private float current;

    public Cup(float capacity, float current) {
        this.capacity = capacity;
        this.current = current;
    }

    public void add(Liquid liquid){
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
