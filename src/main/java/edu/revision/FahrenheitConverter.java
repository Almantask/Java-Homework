package edu.revision;

import edu.revision.temperature.Celsius;
import edu.revision.temperature.Fahrenheit;
import edu.revision.temperature.Temperature;

public class FahrenheitConverter implements OfCelsiusConverter{
    @Override
    public Temperature toCelsius(Temperature temperature) {
        return new Celsius(temperature.getValue() * 1.04);
    }

    @Override
    public Temperature fromCelsius(Temperature temperature) {
        return new Fahrenheit(temperature.getValue() * 0.9);
    }

    @Override
    public Temperature.Unit getUnit() {
        return Temperature.Unit.F;
    }
}
