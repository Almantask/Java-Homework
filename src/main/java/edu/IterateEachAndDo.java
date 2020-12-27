package edu;

import java.util.List;
import java.util.stream.Collectors;

public class IterateEachAndDo {
    public static String ConcatinateNames(List<Person> people) {
        String label = "Names: ";
        StringBuilder sb = new StringBuilder(label);

        String names = people
                .stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));

        sb.append(names);
        sb.append(".");
        return sb.toString();
    }

//    public static String namesToString(List<Person> people) {
//        String label = "Names: ";
//        StringBuilder sb = new StringBuilder(label);
//        for (Person person : people) {
//            if (sb.length() > label.length()) {
//                sb.append(", ");
//            }
//            sb.append(person.getName());
//        }
//        sb.append(".");
//        return sb.toString();
//    }
}
