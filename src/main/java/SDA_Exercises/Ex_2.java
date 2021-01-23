package SDA_Exercises;

import java.util.Collections;
import java.util.List;

public class Ex_2 {
    public static List<String> sortZtoACaseInsensitive(List<String> list){
        //Collections.sort(list);
        //Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        list.sort(String::compareToIgnoreCase);
        return list;
    }
}
