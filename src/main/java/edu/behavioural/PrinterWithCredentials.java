package edu.behavioural;

public class PrinterWithCredentials implements Printer {
    private final Printer printer;

    public PrinterWithCredentials(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String text) {
        if(isAuthenticateUser()){
            printer.print(text);
        }
    }

    private boolean isAuthenticateUser(){
        System.out.println("Authenticated");
        return true;
        // using credentials, authenticate, user
    }
}
