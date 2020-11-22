package edu;

public enum FuelType {
    ELECTRICITY("Needed 0 liters"),
    GASS(""),
    PETROL("Petrol"),
    DIESEL("");
    private final String description;
    FuelType(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
