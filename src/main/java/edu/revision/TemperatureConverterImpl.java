package edu.revision;

import edu.revision.temperature.Temperature;

import java.util.stream.Stream;

public class TemperatureConverterImpl implements TemperatureConverter{
    private final Stream<OfCelsiusConverter> converters;

    public TemperatureConverterImpl(Stream<OfCelsiusConverter> converters) {
        this.converters = converters;
    }

    @Override
    public Temperature convert(Temperature temperature, Temperature.Unit neededUnit) {
        OfCelsiusConverter originalTemperatureConverter = getOfCelsiusConverter(temperature.getUnit());
        OfCelsiusConverter neededUnitCoverter = getOfCelsiusConverter(neededUnit);

        Temperature celsius = originalTemperatureConverter.toCelsius(temperature);
        return neededUnitCoverter.fromCelsius(celsius);
    }

    private OfCelsiusConverter getOfCelsiusConverter(Temperature.Unit unit) {
        return converters
                .filter(c -> c.getUnit() == unit)
                .findFirst()
                .get();
    }
}
