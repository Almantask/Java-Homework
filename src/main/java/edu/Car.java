package edu;

public class Car {
    private String model;
    private String brand;
    private final FuelType fuelType;

    public Car(String model,String  brand, FuelType fuelType) {
        this.model = model;
        this.brand = brand;
        this.fuelType = fuelType;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", fuelType=" + fuelType.getDescription() +
                '}';
    }
}
