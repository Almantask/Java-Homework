package edu;

public class Temperature implements ITemperatureActions {

    private String temperatureName;
    private double amount;

    public Temperature(String temperatureName, double amount) {
        this.temperatureName = temperatureName;
        this.amount = amount;
    }

    @Override
    public double toCelsius() {
        switch (this.getTemperatureName()) {
            case "C":
                return this.getAmount() * 1;
            case "F":
                return (this.getAmount() - 32) / 1.800;
            case "K":
                return this.getAmount() - 273.15;
            case "Re":
                return this.getAmount() * (5.0/4.0);
            case "Ra":
                return (this.getAmount() -491.67) * (5.0/9.0);
            default:
                return -1;
        }
    }

    @Override
    public double fromCelsius(String convertTo) {
        switch (convertTo) {
            case "C":
                return this.getAmount() * 1;
            case "F":
                return this.getAmount() * 1.8000 + 32;
            case "K":
                return this.getAmount() + 273.15;
            case "Re":
                return this.getAmount() * 0.8;
            case "Ra":
                return (this.getAmount() + 273.15) * 1.8;
            default:
                return -1;
        }
    }

    public String getTemperatureName() {
        return temperatureName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
