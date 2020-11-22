package edu.protectedkeywordAndEnum;

public class Car {
    private final String brand;
    private final String model;
    private final FuelType fueltype;

    public Car(String brand, String model, FuelType fueltype) {
        this.brand = brand;
        this.model = model;
        this.fueltype = fueltype;

    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public FuelType getFueltype() {
        return fueltype;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", description=" + fueltype.getDescription() +
                '}';
    }
}
