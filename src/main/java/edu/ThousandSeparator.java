package edu;

public class ThousandSeparator {

    public String thousandSeparator (int number) {
        if (number <0) {
            return "";
        }
        return String.format("%,d", number);
    }

}
