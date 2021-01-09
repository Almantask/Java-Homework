package edu;

public class TemperatureConverter{

    public static double convertTemperature(Temperature temperature, String convertTo) {
        double convertedValue = temperature.toCelsius();
        temperature.setAmount(convertedValue);
        return temperature.fromCelsius(convertTo);
    }


    }

