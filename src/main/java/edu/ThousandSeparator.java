package edu;

public class ThousandSeparator {
    public static String separate (int number){
        if (number < 0){
            return "";
        }

        int temp = number;
        String numberString = "";
        while (temp > 1000){
            numberString = "." + String.valueOf(temp % 1000) + numberString;
            temp = temp/1000;
        }
        numberString = String.valueOf(temp) + numberString;

        return numberString;
    }


}
