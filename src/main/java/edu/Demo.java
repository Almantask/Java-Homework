package edu;

import edu.behavioural.*;
import edu.designpatterns.structural.*;
import edu.revision.*;
import edu.revision.temperature.*;

import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        //demoRevision();
        //demoAdapter();
        //demoCommand();
        demoDecorator();
    }

    private static void demoDecorator(){
        Printer basicPrinter = new BasicPrinter();
        Printer printerWithColor = new PrinterWithColors(basicPrinter);
        Printer printerWithCredentialsAndColor = new PrinterWithCredentials(printerWithColor);
        printerWithCredentialsAndColor.print("Hello world");
    }

    private static void demoAdapter() {
        SimpleList<Integer> numbers = new SimpleListImp<>();
        numbers.insert(1);
        numbers.get(0);
        numbers.delete(0);
    }

    private static void demoCommand(){
        Stream<Command> commands = Stream.of(
                new MoveTargetCommand(new Object(), new Object()),
                new WriteTextCommand("Hei", null)
        );

        commands
                .forEach(cmd -> {
                    cmd.execute();
                    cmd.undo();
                });
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
