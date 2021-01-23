package SDA_Exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static SDA_Exercises.Ex_3.MapPrint;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Almantas");
        list.add("almantas");
        list.add("Arnas");
        list.add("Jolita");
        //Ex_1
        list = Ex_1.sortZtoA(list);
        System.out.println(list);

        //Ex_2

        list = Ex_2.sortZtoACaseInsensitive(list);
        System.out.println(list);

        //Ex_3
        Map<String,Integer> map = new HashMap<>();
        map.put("Java", 18);
        map.put("Python", 1);
        map.put("PHP", 0);
        MapPrint(map);

    }
}
