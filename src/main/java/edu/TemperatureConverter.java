package edu;

public class TemperatureConverter{

    public static double convertTemperature(Temperature temperature, String convertTo) {
        temperature.setAmount(temperature.toCelsius());
        return temperature.fromCelsius(convertTo);
    }


    }

