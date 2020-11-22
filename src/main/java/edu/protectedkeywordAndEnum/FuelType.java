package edu.protectedkeywordAndEnum;

public enum FuelType {
    ELECTRICITY("Needed 0 liters of petrol."),
    DEASEL("String"),
    GASS("String"),
    PETROL("String");

    private final String description;

    FuelType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
