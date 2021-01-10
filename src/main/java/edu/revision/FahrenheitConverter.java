package edu.revision;

import edu.revision.temperature.Temperature;

public class FahrenheitConverter implements OfCelsiusConverter{
    @Override
    public Temperature toCelsius(Temperature temperature) {
        return new Temperature(temperature.getValue() * 1.04, Temperature.Unit.C);
    }

    @Override
    public Temperature fromCelsius(Temperature temperature) {
        return new Temperature(temperature.getValue() * 0.9, Temperature.Unit.F);
    }

    @Override
    public Temperature.Unit getUnit() {
        return Temperature.Unit.F;
    }
}
