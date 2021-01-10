package edu;

import edu.revision.*;
import edu.revision.temperature.*;

import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Stream<OfCelsiusConverter> converters = Stream.of(new CelsiusConverter(), new FahrenheitConverter());
        // TODO: add more converters
        TemperatureConverter converter = new TemperatureConverterImpl(converters);

        converter.convert(new Celsius(10), Temperature.Unit.F);
        converter.convert(new Fahrenheit(10), Temperature.Unit.Re);
        converter.convert(new Reomur(10), Temperature.Unit.Ra);
    }
}
