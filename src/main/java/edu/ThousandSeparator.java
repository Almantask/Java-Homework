package edu;

public class ThousandSeparator {

    public String thousandSeparator (int number) {
        if (number <0) {
            return null;
        }
        return String.format("%,d", number);
    }

}
