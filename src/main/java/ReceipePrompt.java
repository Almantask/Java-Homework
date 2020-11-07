import java.util.Scanner;

public class ReceipePrompt {

    float amount;
    String unit;


    public static void main(String[] args) {
        ReceipePrompt prompt = new ReceipePrompt();
        prompt.run();
    }
    public void run() {
        promptAmount();
        promptUnit();

    }

    public void promptAmount() {

        float amountFromUser;
        System.out.println("Enter the amount of unit");
        Scanner amount = new Scanner((System.in));
        amountFromUser = amount.nextFloat();

        if(amountFromUser>0 && amountFromUser != 0){
            this.amount = amountFromUser;
        } else{
            System.out.println("Wrong amount, please enter valid amount");
            promptAmount();
        }

    }

    public void promptUnit() {

        String unitName ;
        System.out.println("Enter a unit Name");
        Scanner unit = new Scanner(System.in);
        unitName = unit.nextLine();

        if(!unitName.isEmpty() && Cooking.Units.isValid(unitName.toUpperCase())){  //
            this.unit = unit.nextLine().toUpperCase();
        }else {
            System.out.println("Wrong unit name, please enter valid amount");
            promptUnit();
        }

    }
}