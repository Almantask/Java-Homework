public class CookingMeasurement {
    private float unit;
    private String amount;

    public CookingMeasurement(float unit, String amount){

        this.unit = unit;
        this.amount = amount;

    }

    public float getUnit() {
        return unit;
    }

    public String getAmount() {
        return amount;
    }

}