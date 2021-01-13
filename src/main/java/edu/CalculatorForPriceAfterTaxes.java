package edu;

import java.util.Arrays;
import java.util.List;

public class CalculatorForPriceAfterTaxes implements CalculatorForVat {

    private final List<CountriesWithVatNumber> calculateVat;

    public CalculatorForPriceAfterTaxes(CountriesWithVatNumber[] calculateVat) {
        this.calculateVat = Arrays.asList(calculateVat);
    }

    @Override
    public double returnValue(double price, String vatKind, String country) {
        for (CountriesWithVatNumber countriesWithVatNumber : calculateVat) {
            if (countriesWithVatNumber.getCountry().equalsIgnoreCase(country)) {
                    if (vatKind.equalsIgnoreCase("Standard")) {
                        return price * countriesWithVatNumber.getStandardTaxRatio();
                    } else if (vatKind.equalsIgnoreCase("Reduced1")) {
                        return price * countriesWithVatNumber.getReduced1TaxRatio();
                    } else if (vatKind.equalsIgnoreCase("Reduced2")) {
                        return price * countriesWithVatNumber.getReduced2TaxRatio();
                    }else if (vatKind.equalsIgnoreCase("Zero")) {
                        return price * countriesWithVatNumber.getZeroTaxRatio();
                    } else if (vatKind.equalsIgnoreCase("Reduced")) {
                        if (countriesWithVatNumber.getReducedTaxRatio() == 0) {
                            System.out.println(countriesWithVatNumber.getCountry() + " doesn't not have Reduced vatKind");
                        } else {
                            return price * countriesWithVatNumber.getReducedTaxRatio();
                        }
                    }
            }
        }
        return 0;
    }
}
