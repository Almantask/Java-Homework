package edu.generics;

public abstract class Liquid {
    private float amount;

    public Liquid(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}
