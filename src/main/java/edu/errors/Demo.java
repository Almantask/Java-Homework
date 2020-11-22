package edu.errors;

public class Demo {
    public static void run(){
        System.out.println("------Demo errors------");



        System.out.println("------Demo errors------");
    }

    // Error- critical application error, from which it cannot recover
    // Error cannot be caught.
    private static void criticalErrors() {
        throw new Error("ooops- I just crashed your app");
    }

    // Exception- base class for application errors which can be caught.
    // Method with almost any exceptions type need to be handled (marked as throws)
    private static void exposedException() throws Exception {
        throw new Exception("listen, I failed. HANDLE ME");
    }

    // RuntimeException- subtype of exceptions which don't have to be caught.
    // Therefore, a method which has them does not have to be marked with throws
    private static void hiddenException(){
        throw new RuntimeException("I failed. Handle me, but if you wish");
    }
}
