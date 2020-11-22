package edu.generics;

// Cup of ANYTHING but without mixing different liquids.
public class GenericCup<TLiquid extends Liquid> {
    private final float capacity;
    private float current;

    public GenericCup(float capacity, float current) {
        this.capacity = capacity;
        this.current = current;
    }

    public void add(TLiquid liquid){
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
