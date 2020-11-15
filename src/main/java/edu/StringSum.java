package edu;

public class StringSum {

    public int add(String numberString){

        if(numberString == null || numberString.isEmpty()){
            return 0;
        }

        String[] numbersArray = numberString.split("[+.:]");
        int result = 0;
        for (int i = 0; i < numbersArray.length; i++){
            result += Integer.parseInt(numbersArray[i]);
        }

        return result;
    }

}
