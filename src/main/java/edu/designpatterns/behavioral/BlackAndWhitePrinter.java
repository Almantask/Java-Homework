package edu.designpatterns.behavioral;

public class BlackAndWhitePrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
