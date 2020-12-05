package edu.Revision;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Rev {
    static Person person;

    public static void run(){
        List<Integer> list = new ArrayList();

        LocalDate now = LocalDate.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));

        try{
            person.equals(person);
        }
        catch(NullPointerException ex){
            System.out.println("Ooops");
        }

        long a = 1000l * 1000 * 1000 * 1000 * 1000;
        long div = a / (a + 1);
        String text = null;
        boolean isTrue = text != null && text.length() > 0;

        System.out.println(isTrue);
    }

    private static boolean isOk() throws Exception {
        throw new Exception("oops");
    }
}
