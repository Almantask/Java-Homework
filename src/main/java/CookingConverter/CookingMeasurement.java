package CookingConverter;

public class CookingMeasurement {
    private final float amount;
    private final String unit;

    float getAmount() {
        return amount;
    }

    String getUnit() {
        return unit;
    }

    public CookingMeasurement(float amount, String unit) {
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