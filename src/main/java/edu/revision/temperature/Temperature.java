package edu.revision.temperature;

public abstract class Temperature{
    public enum Unit{
        C,
        F,
        K,
        Re,
        Ra
    }

    private final double value;
    private final Unit unit;

    public Temperature(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }
}
