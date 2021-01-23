package SDA_Exercises;

import java.util.*;

public class Ex_1 {

    public static List<String> sortZtoA(List<String> list){
        //Collections.sort(list);
        list.sort(String::compareTo);
        Collections.reverse(list);
        return list;
    }
}
