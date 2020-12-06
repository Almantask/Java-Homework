package edu;

public class RecursionExample {
    public static void loop10Times(int time){
        System.out.println("Looping " + time);
        if(time < 10){
            loop10Times(++time);
        }
    }

    // 1 1 2 3 5 8
    public static int fibonacci(int n){
        return n < 3 ? 1
                     :fibonacci(n-1) + fibonacci(n-2);
    }

    // n = 4
    // fibonacci(3) + fibonacci(2)
    // 3

    // n = 3
    // fibonacci(2) + fibonacci(1)
    // 2

    // n = 2
    // 1

    // n = 1
    // 1
}
