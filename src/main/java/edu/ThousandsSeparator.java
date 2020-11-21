package edu;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThousandsSeparator {
    private String input;


    public ThousandsSeparator(Long input) {

        if(0 > input || input > Math.pow(2,31)) {
            return;
        }
        System.out.println(separate(Integer.toString(Math.toIntExact(input))));


    }
    private String separate(String input) {
        int length = input.length();
        int separatingCharactersCount = (int) Math.floor(length / 3);
        int extractionCount = length/3 + ((length % 3 == 0) ? 0 : 1);
        String[] extractedByThree = new String[extractionCount];
        String result = "";
        int smaller = length - separatingCharactersCount*3;

        if(length < 4)
            return input;

        for(int i=0;i<extractionCount;i++) {
            if(i==0) {
                extractedByThree[0] = input.substring(0,smaller);
            } else {
                int start = smaller + ((i - 1) * 3);
                extractedByThree[i] = input.substring(start, start + 3);
            }
        }
        for(int n=0;n<extractedByThree.length;n++) {
            result += extractedByThree[n];
            if(extractedByThree.length-1 != n)
                result += ".";
        }
        return result;
    }
}
