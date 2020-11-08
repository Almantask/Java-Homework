package main.java;

import Numbers.PrimeNumbers;

public class Demo {
    public static void main(String[] args) {
        int[] primes = PrimeNumbers.findAll(100);
        System.out.println("All prime numbers: ");
        print(primes);
    }

    private static void print(int[] numbers){
        for (int i: numbers) {
            System.out.println(i);
        }
    }
}
