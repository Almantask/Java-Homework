package vat;

public enum VatKind {
    STANDARD,
    REDUCED,
    REDUCED1,
    REDUCED2,
    ZERO;


    public static boolean vatKindExists(String vatKind) {
        vatKind = vatKind.toUpperCase();
        Boolean exists = true;
        try {
            VatKind.valueOf(vatKind);
        } catch (IllegalArgumentException e) {
            System.out.println("VatKind does not exist: " + vatKind);
            exists = false;
        } finally {
            return exists;
        }
    }

}
