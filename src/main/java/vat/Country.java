package vat;

public enum Country {
    AUSTRIA,
    BELGIUM,
    BULGARIA,
    LITHUANIA;

    public static boolean countryExists(String country) {
        country = country.toUpperCase();
        Boolean exists = true;
        try {
            Country.valueOf(country);
        } catch (IllegalArgumentException e) {
            System.out.println("Country does not exist: " + country);
            exists = false;
        } finally {
            return exists;
        }

    }
}

