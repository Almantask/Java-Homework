package BasketballGames;

import java.time.LocalDate;

public class Human {

    //    ### 0- Human (EASY):very member of a team has a name, birthday, age, nationality.
    private String name;
    private LocalDate birthday;
    private int age;
    private String nationality;

    public static Human(String name, LocalDate birthday, int age, String nationality) {
        this.name = name;
        this.birthday = birthday;

    }


}
