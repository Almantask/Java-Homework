package CookingConvertor;


import java.util.Scanner;

public class ReceipePrompt {


    public void run() {
        Scanner scanner = new Scanner(System.in);
        menu();
        System.out.println("Choose number: ");
        int action = scanner.nextInt();
        scanner.nextLine();
        switch (action) {
            case 1:
                float amount = promptAmount();
                String unit = promptUnit();
                System.out.println(CookingMeasurementConverter.convert(new CookingMeasurement(amount, unit.toUpperCase())));
                break;
            case 2:
                break;
        }
    }

    private float promptAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of unit:");
        float amount = scanner.nextFloat();
        scanner.nextLine();
        return amount;

    }

    private String promptUnit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter unit:");
        String unit = scanner.nextLine();
        return unit;
    }

    private void menu () {
        System.out.println("1 - basic conversion of a measurement\n" +
                "2 - recipe processing");
    }
}

