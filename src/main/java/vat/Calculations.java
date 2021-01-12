package vat;

import java.util.stream.Stream;

import static vat.Country.countryExists;
import static vat.VatKind.vatKindExists;

public class Calculations {

    public double calculatePrice(double price, String vatKind, String country) {
        double vatTaxRatio = 0;
        country = country.toUpperCase();
        vatKind = vatKind.toUpperCase();
        if (countryExists(country) && vatKindExists(vatKind)) {
            vatTaxRatio = getVatTaxRatio(vatKind, country);
            return price * vatTaxRatio;
       } return 0;
    }

    private double getVatTaxRatio(String vatKind, String country) {
         return Stream.of(VatTaxRatio.values())
                .filter(value -> value.getCountry().equals(Country.valueOf(country)))
                .filter(value -> value.getVatKind().equals(VatKind.valueOf(vatKind)))
                .findFirst()
                .orElse(null).getTaxRatio();
    }

}
