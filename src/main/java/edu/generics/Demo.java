package edu.generics;

import edu.Revision.Student;
import edu.Revision.UniversityStudent;

import java.util.*;

public class Demo {
    public static void run(){
        System.out.println("------Demo generics------");

        List<Integer> list = new ArrayList<>();
        list.add(1);

        // Map
        Map<Integer, Integer> map = new HashMap<>();
        map.put(10011, 1);
        // Very fast
        int element = map.get(1001);

        Map<String, Student> studentsMap = new HashMap<>();
        studentsMap.put("tomas", new UniversityStudent("tomas"));

        // Array
        int[] arrayLikeMap = new int[10012];
        arrayLikeMap[10011] = 1;
        // Very fast
        int element2 = arrayLikeMap[10011];

        System.out.println("------Demo generics------");
    }
}
