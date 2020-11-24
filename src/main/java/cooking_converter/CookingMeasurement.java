package cooking_converter;

public class CookingMeasurement {
    private final float amount;
    private final EUnits unit;

    public float getAmount() {
        return amount;
    }

    public EUnits getUnit() {
        return unit;
    }

    public CookingMeasurement(float amount, EUnits unit) {
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Result: " +
                "amount = " + amount +
                " with units = " + unit;
    }
}