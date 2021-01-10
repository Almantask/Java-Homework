package edu.revision;

import edu.revision.temperature.Temperature;

import java.util.Arrays;
import java.util.List;

public class TemperatureConverterImpl implements TemperatureConverter{
    private final List<OfCelsiusConverter> converters;

    public TemperatureConverterImpl(OfCelsiusConverter[] converters) {
        this.converters = Arrays.asList(converters);
    }

    @Override
    public Temperature convert(Temperature temperature, Temperature.Unit neededUnit) {
        OfCelsiusConverter originalTemperatureConverter = getOfCelsiusConverter(temperature.getUnit());
        OfCelsiusConverter neededUnitCoverter = getOfCelsiusConverter(neededUnit);

        Temperature celsius = originalTemperatureConverter.toCelsius(temperature);
        return neededUnitCoverter.fromCelsius(celsius);
    }

    private OfCelsiusConverter getOfCelsiusConverter(Temperature.Unit unit) {
        return  converters
                .stream()
                .filter(c -> c.getUnit() == unit)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No converter found for unit " + unit));
    }
}
