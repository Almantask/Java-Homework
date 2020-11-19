package edu;

public class ThousandSeparator {
    public static String separator(int number){
        if (number < 0){
            return "Error";
        }
        else if (number == 0){
            return "0";
        }
        else {
            String separatedNumber = "";
            int temporaryNumber = number;
            while (temporaryNumber > 1000){
                separatedNumber = "." + String.valueOf(temporaryNumber % 1000) + separatedNumber;
                temporaryNumber = temporaryNumber / 1000;
            }
            separatedNumber = String.valueOf(temporaryNumber) + separatedNumber;

            return separatedNumber;
        }
    }
}
