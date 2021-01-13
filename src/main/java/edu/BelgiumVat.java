package edu;

public class BelgiumVat implements  CountriesWithVatNumber{
    @Override
    public String getCountry() {
        return "Belgium";
    }

    @Override
    public double getStandardTaxRatio() {
        return 1.21;
    }

    @Override
    public double getReduced1TaxRatio() {
        return 1.12;
    }

    @Override
    public double getReduced2TaxRatio() {
        return 1.06;
    }

    @Override
    public double getZeroTaxRatio() {
        return 1.00;
    }

    @Override
    public double getReducedTaxRatio() {
        return 0;
    }
}
