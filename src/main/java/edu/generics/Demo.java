package edu.generics;

import edu.Revision.Student;
import edu.Revision.UniversityStudent;

import java.math.BigDecimal;
import java.util.*;

public class Demo {
    public static void run(){
        System.out.println("------Demo generics------");

        System.out.println("------Anything------");
        Cup cup = new Cup(100, 10);
        Tea tea15 = new Tea(15);
        Vodka vodka50 = new Vodka(50);
        cup.add(tea15);
        cup.add(vodka50);
        System.out.println(cup.isFull());
        cup.add(vodka50);
        System.out.println(cup.isFull());

        System.out.println("------Vodka------");
        CupOfVodka cupOfVodka = new CupOfVodka(100, 10);
        cupOfVodka.add(vodka50);
        System.out.println(cupOfVodka.isFull());
        cupOfVodka.add(vodka50);
        System.out.println(cupOfVodka.isFull());

        System.out.println("------Tea------");
        CupOfTea cupOfTea = new CupOfTea(100, 10);
        cupOfTea.add(tea15);
        System.out.println(cupOfTea.isFull());
        cupOfTea.add(tea15);
        System.out.println(cupOfTea.isFull());

        System.out.println("------Vodka------");
        CupOfVodka cupOfVodka1 = new CupOfVodka(100, 10);
        cupOfVodka.add(vodka50);
        System.out.println(cupOfVodka.isFull());
        cupOfVodka.add(vodka50);
        System.out.println(cupOfVodka.isFull());

        System.out.println("------Tea------");
        CupOfTea cupOfTea1 = new CupOfTea(100, 10);
        cupOfTea.add(tea15);
        System.out.println(cupOfTea.isFull());
        cupOfTea.add(tea15);
        System.out.println(cupOfTea.isFull());

        System.out.println("------Generic Vodka------");
        GenericCup<Vodka> genericCupOfVodka = new GenericCup<Vodka>(100, 10);
        genericCupOfVodka.add(vodka50);
        System.out.println(genericCupOfVodka.isFull());
        genericCupOfVodka.add(vodka50);
        System.out.println(genericCupOfVodka.isFull());

        System.out.println("------Generic Tea------");
        GenericCup<Tea> genericCupOfTea = new GenericCup<Tea>(100, 10);
        genericCupOfTea.add(tea15);
        System.out.println(genericCupOfTea.isFull());
        genericCupOfTea.add(tea15);
        System.out.println(genericCupOfTea.isFull());

        System.out.println("------Generic Coffee------");
        Coffee coffee = new Coffee(50);
        GenericCup<Coffee> genericCupOfCoffee = new GenericCup<Coffee>(100, 10);
        genericCupOfCoffee.add(coffee);
        System.out.println(genericCupOfCoffee.isFull());
        genericCupOfCoffee.add(coffee);
        System.out.println(genericCupOfCoffee.isFull());

        boolean res1 = NumberUtils.IsFirstBigger(1f, 2d);
        boolean res2 = NumberUtils.IsFirstBigger(new BigDecimal("1111"), 2d);
        boolean res3 = NumberUtils.IsFirstBigger(1L, 2d);

        System.out.printf("%s %s %s", res1, res2, res3);
        System.out.println();

        System.out.println("------Demo generics------");
    }
}
