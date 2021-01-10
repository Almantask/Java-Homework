package edu.revision;

import edu.revision.temperature.Temperature;

public interface TemperatureConverter {
    Temperature convert(Temperature temperature, Temperature.Unit unit);
}
