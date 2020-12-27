package edu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionBy {
    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        return people
                .stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 18));
    }

//    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
//        Map<Boolean, List<Person>> map = new HashMap<>();
//        map.put(true, new ArrayList<>());
//        map.put(false, new ArrayList<>());
//        for (Person person : people) {
//            map.get(person.getAge() >= 18).add(person);
//        }
//        return map;
//    }
}
