package edu.errors;

import java.math.BigDecimal;

public class Demo {
    public static void run() throws InvalidTransferException {
        System.out.println("------Demo errors------");

        BankAccount account1 = new BankAccount(new BigDecimal("500"));
        BankAccount account2 = new BankAccount(new BigDecimal("1000"));
        account1.transfer(account2, new BigDecimal("10000"));















        Human human2 = new Human("");
        try{
            Human human1 = new Human("");

            System.out.println(human1.getName());
            System.out.println("Human was created successfully");
        }
        catch(InvalidHumanNameException ex){

        }

        Human human;
        try{
            human = new Human("");
        }
//        catch(InvalidHumanNameException ex){
//            human = new Human("Caugh invalid human: " + ex.getMessage());
//            // Sometimes we might want to add extra info
//            // Therefore, we can rethrow
//            throw new InvalidHumanNameException("Was caught in the first block. Error: " + ex.getMessage());
//        }
        catch(Exception e){
            human = new Human("Caught any human");
            // Sometimes we don't want to handle an exception
            // However, we might want to do something in between
            System.out.println("WTF?!?!?!");
            throw e;
        }
        catch(Error err){
            System.out.println("Caught error");
        }
        finally{
            System.out.println("ghjgjhg");
        }







        try{
            criticalErrors();
        }
        catch(Exception ex){
            System.out.println("Error handled... or not");
        }

        System.out.println("------Demo errors------");
    }

    // Error- critical application error, from which it cannot recover
    // Error cannot be caught.
    private static void criticalErrors() {
        throw new Error("ooops- I just crashed your app");
    }

    // Exception- base class for application errors which can be caught.
    // Method with almost any exceptions type need to be handled (marked as throws)
    // This is a checked exception
    private static void exposedException() throws Exception {
        throw new Exception("listen, I failed. HANDLE ME");
    }

    // RuntimeException- subtype of exceptions which don't have to be caught.
    // Therefore, a method which has them does not have to be marked with throws
    // This is unchecked exception
    private static void hiddenException(){
        throw new RuntimeException("I failed. Handle me, but if you wish");
    }
}
