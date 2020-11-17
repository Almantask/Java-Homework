package edu;

import java.text.NumberFormat;
import java.util.Locale;

public class ThousandSeparator {
    public static String thousandSeparator(int n) {

        if (n <0 ){
            return "";
        }

        String numberWithSeparator = NumberFormat.getIntegerInstance(Locale.GERMAN).format(n);

        return numberWithSeparator;
    }
}
