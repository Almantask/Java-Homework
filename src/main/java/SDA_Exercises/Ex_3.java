package SDA_Exercises;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.stream.Stream;

public class Ex_3 {
    public static void MapPrint (Map<String,Integer> map){
        String [] values = map.entrySet()
                .stream()
                .map(Entry -> "Key: " + Entry.getKey() + ", Value: "+ Entry.getValue())
                .toArray(String[] :: new);

        System.out.println(String.join(",\n", values) + ".");
    }
}
