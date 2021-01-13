package edu;

public class BulgariaVat implements CountriesWithVatNumber {
    @Override
    public String getCountry() {
        return "Bulgaria";
    }

    @Override
    public double getStandardTaxRatio() {
        return 1.20;
    }

    @Override
    public double getReduced1TaxRatio() {
        return 1.09;
    }

    @Override
    public double getReduced2TaxRatio() {
        return 1.09;
    }

    @Override
    public double getZeroTaxRatio() {
        return 1.09;
    }

    @Override
    public double getReducedTaxRatio() {
        return 1.00;
    }
}
