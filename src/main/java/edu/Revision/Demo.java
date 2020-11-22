package edu.Revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    public static void run(){

        List<Integer> list = new ArrayList<>();
        list.add(1);

        // Map
        Map<Integer, Integer> map = new HashMap<>();
        map.put(10011, 1);
        // Very fast
        int element = map.get(10011);

        Map<String, Student> studentsMap = new HashMap<>();
        studentsMap.put("tomas", new UniversityStudent("tomas"));

        // Array
        int[] arrayLikeMap = new int[10012];
        arrayLikeMap[10011] = 1;
        // Very fast
        int element2 = arrayLikeMap[10011];

        Child child1 = new Child();
        Parent parent1 = new Parent();
        Child child2 = new Child();
        Parent parent2 = new Parent();
        Child child3 = new Child();
        Parent parent3 = new Parent();

        // Polymorphism
        Parent[] parents = {child1, parent1, child2, parent2, child3, parent3};
        for (Parent parent :
                parents) {
            parent.DoSomethingOfParent();
        }

        // Without polymorphism
        parent1.DoSomethingOfParent();
        child1.DoSomethingOfParent();
        parent2.DoSomethingOfParent();
        child2.DoSomethingOfParent();
        parent3.DoSomethingOfParent();
        child3.DoSomethingOfParent();

        Student student = new UniversityStudent();
    }
}
