package edu.revision;

import edu.revision.temperature.Temperature;

public interface OfCelsiusConverter {
    Temperature toCelsius(Temperature temperature);
    Temperature fromCelsius(Temperature temperature);
    Temperature.Unit getUnit();
}
