package edu.behavioural;

public class PrinterWithColors implements Printer{
    private final Printer printer;

    public PrinterWithColors(Printer printer) {
        this.printer = printer;
    }


    @Override
    public void print(String text) {
        selectColor();
        printer.print(text);
    }

    private void selectColor(){
        System.out.println("Selecting color");
        // set color to print with
    }
}
