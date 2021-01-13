package edu;

public class AustriaVat implements  CountriesWithVatNumber{
    @Override
    public String getCountry() {
        return "Austria";
    }

    @Override
    public double getStandardTaxRatio() {
        return 1.20;
    }

    @Override
    public double getReduced1TaxRatio() {
        return 1.13;
    }

    @Override
    public double getReduced2TaxRatio() {
        return 1.10;
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
