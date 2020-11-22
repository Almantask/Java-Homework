package edu.protectedkeywordAndEnum;

import java.util.Scanner;

public class Demo {
    public static void run(){
        System.out.println("------Demo protectedkeywordAndEnum------");

        Teacher teacher = new Teacher("ka", Gender.FEMALE);
        teacher.name = "";

        demoConversion();


        System.out.println("------Demo protectedkeywordAndEnum------");

        Car car1 = new Car("BMW","X5", FuelType.PETROL);
        System.out.println(car1.toString());
    }

    private static void demoConversion() {
        Scanner in = new Scanner(System.in);
        //System.out.println("Enter what unit you want");
        //String input = in.next().toUpperCase();
        //Unit unit = Unit.valueOf(input);
        //System.out.printf("1 %s is equal to %d ML", input, unit.getMl());

        System.out.println("=======Table of units======");
        for (Unit unit1 : Unit.values()) {
            System.out.printf("=========%s = %dML======", unit1.name(), unit1.getMl());
            System.out.println();
        }
        System.out.println("===========================");
    }


}
