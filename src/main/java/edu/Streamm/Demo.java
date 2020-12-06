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
        Person oldest = people.max(Comparator.comparing(Person::getAge)).get();
        System.out.println(oldest);
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
