package edu.Sugar;

import java.time.LocalDate;
import java.time.Period;

public class Human {
    private String name;
    private LocalDate birthday;

    public Human(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Human(String name) {
        this.name = name;
        this.birthday = null;
    }

    // if birthday is null, return -1.
    public int getAge(){
        // ternary operator
        return birthday == null
                ? -1
                : Period.between(birthday, LocalDate.now()).getYears();
    }

//    // the same as above
//    public int getAge(){
//        if(birthday == null){
//            return -1;
//        }
//        else{
//            return Period.between(birthday, LocalDate.now()).getYears();
//        }
//    }
}
