package edu.revision;

import edu.revision.temperature.Temperature;

public class CelsiusConverter implements OfCelsiusConverter{

    @Override
    public Temperature toCelsius(Temperature temperature) {
        return temperature;
    }

    @Override
    public Temperature fromCelsius(Temperature temperature) {
        return temperature;
    }

    @Override
    public Temperature.Unit getUnit() {
        return Temperature.Unit.C;
    }
}
