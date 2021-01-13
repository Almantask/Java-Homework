package edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        demo();

    }

    private static void demo() {
        CountriesWithVatNumber[] countriesWithVat = {new LithuaniaVat(), new AustriaVat(), new BelgiumVat(), new BulgariaVat()};
        CalculatorForPriceAfterTaxes calculator = new CalculatorForPriceAfterTaxes(countriesWithVat);
        System.out.println(calculator.returnValue(10, "Reduced1", "Belgium"));
    }

}
