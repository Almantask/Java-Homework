package vat;

public class Main {
    public static void main(String[] args) {
        Calculations calc = new Calculations();
        System.out.println("Price: " + calc.calculatePrice(2, "standard", "LITHUANIA"));
    }
}
