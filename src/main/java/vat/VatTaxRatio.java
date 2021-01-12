package vat;

public enum VatTaxRatio {
    AT_STANDARD(Country.AUSTRIA, VatKind.STANDARD, 1.20d),
    AT_REDUCED1(Country.AUSTRIA, VatKind.REDUCED1, 1.13d),
    AT_REDUCED2(Country.AUSTRIA, VatKind.REDUCED2, 1.10d),
    AT_ZERO(Country.AUSTRIA, VatKind.ZERO, 1.00d),

    BE_STANDARD(Country.BELGIUM, VatKind.STANDARD, 1.21d),
    BE_REDUCED1(Country.BELGIUM, VatKind.REDUCED1, 1.12d),
    BE_REDUCED2(Country.BELGIUM, VatKind.REDUCED2, 1.06d),
    BE_ZERO(Country.BELGIUM, VatKind.ZERO, 1.00d),

    BG_STANDARD(Country.BULGARIA, VatKind.STANDARD, 1.20d),
    BG_REDUCED1(Country.BULGARIA, VatKind.REDUCED1, 1.09d),
    BG_REDUCED2(Country.BULGARIA, VatKind.REDUCED2, 1.09d),
    BG_REDUCED(Country.BULGARIA, VatKind.REDUCED, 1.09d),
    BG_ZERO(Country.BULGARIA, VatKind.ZERO, 1.00d),

    LT_STANDARD(Country.LITHUANIA, VatKind.STANDARD, 1.20d),
    LT_REDUCED1(Country.LITHUANIA, VatKind.REDUCED1, 1.09d),
    LT_REDUCED2(Country.LITHUANIA, VatKind.REDUCED2, 1.05d),
    LT_ZERO(Country.LITHUANIA, VatKind.ZERO, 1.00d);


    private final Country country;
    private final VatKind vatKind;
    private final double taxRatio;

    VatTaxRatio(Country country, VatKind vatKind, double taxRatio) {
        this.country = country;
        this.vatKind = vatKind;
        this.taxRatio = taxRatio;
    }

    public Country getCountry() {
        return country;
    }

    public VatKind getVatKind() {
        return vatKind;
    }

    public double getTaxRatio() {
        return taxRatio;
    }
}