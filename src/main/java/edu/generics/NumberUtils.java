package edu.generics;

public class NumberUtils {
    public static <TFirst extends Number, TSecond extends Number>
    boolean IsFirstBigger(TFirst number1, TSecond number2){
        return number1.doubleValue() > number2.doubleValue();
    }
}
