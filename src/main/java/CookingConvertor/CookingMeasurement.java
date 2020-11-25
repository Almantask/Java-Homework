package CookingConvertor;

public class CookingMeasurement {

    private final float amount;
    private final String unit;

    public CookingMeasurement(float amount, String unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public float getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }
} 