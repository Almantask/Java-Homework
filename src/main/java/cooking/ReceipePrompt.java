package cooking;

import java.util.Scanner;

public class ReceipePrompt {

    private float amount;
    private String unit;

    public float getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }


    public void run() {
        promptAmount();
        promptUnit();
    }

    private void promptAmount() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter amount :");
        amount = myObj.nextFloat();
    }


    public void promptUnit() {
        Scanner myObj1 = new Scanner(System.in);
        System.out.println("Enter one of these elements:" +
                "TSP  TBSP  FL_OUNCE  CUP  PINT  QUART  GALLON  OZ  POUND ");
        unit = myObj1.nextLine().toUpperCase();


    }
}


