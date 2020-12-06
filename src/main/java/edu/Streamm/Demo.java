package edu.Streamm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Person p1 = new Person("p1",76);
        Person p2 = new Person("p2",44);
        Person p3 = new Person("p3",25);
        Person p4 = new Person("p4",33);

        Stream<Person> people = Stream.of(p1,p2,p3,p4);

        // A
        Person oldest1 = people.max(Comparator.comparing(Person::getAge)).get();

        // function personToInt passed as parameter
        int avg = people
                .mapToInt(Demo::personToInt)
                .sum() / (int)people.count();

        // z is input.
        // personToInt is what I do with input
        int avg1 = people
                .mapToInt(z -> personToInt(z))
                .sum() / (int)people.count();

        // for every person, get age. This is how from person we get age.
        int avg2 = people
                .mapToInt(z -> z.getAge())
                .sum() / (int)people.count();

        // pass getAge function as parameter.
        int avg3 = people
                .mapToInt(Person::getAge)
                .sum() / (int)people.count();

        System.out.println(oldest1);
    }

    private static int personToInt(Person z){
        return z.getAge();
    }

    //Get the oldest person from the collection



    private static void fromAnyManythingsToStream(){
        Integer[] numbers = {1,2,3,5};
        Stream<Integer> numbersStream = Arrays.stream(numbers);
    }

    private static void sumAllNumbes(Stream<Integer> numbers){
        // First way
        int sum = numbers.reduce(0, (a, b) -> a + b);
        // Second way
        sum = numbers.reduce(0, Integer::sum);
        // Third way
        sum = numbers
                .mapToInt(Integer::intValue)
                .sum();
        // and many more...
    }
}
