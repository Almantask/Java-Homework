package edu;

import edu.designpatterns.structural.*;
import edu.revision.*;
import edu.revision.temperature.*;

public class Demo {
    public static void main(String[] args) {
        demoRevision();
    }

    private static void demoSingleton(){
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.getData1());
    }

    private static void demoRevision() {
        OfCelsiusConverter[] converters = {new CelsiusConverter(), new FahrenheitConverter()};
        // TODO: add more converters
        TemperatureConverter converter = new TemperatureConverterImpl(converters);

        Temperature celsius = new Celsius(10);
        Temperature fahrenheit = converter.convert(celsius, Temperature.Unit.F);
        System.out.printf("%s = %s", celsius, fahrenheit);
        //converter.convert(new Fahrenheit(10), Temperature.Unit.Re);
        //converter.convert(new Reomur(10), Temperature.Unit.Ra);
    }
}
