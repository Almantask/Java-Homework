package Cooking;

public class CookingMeasurement {
    private float amount;
    private String unit;

    public CookingMeasurement(float amount, String unit) {
        this.amount = amount;
        this.unit = unit.toUpperCase();
    }

    public float getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }
}
