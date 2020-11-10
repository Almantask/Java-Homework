package BasketballGame;

import java.time.LocalDate;

public class Human{

    private String name;
    private LocalDate birthday;
    private int age;
    private String nationality;

    public Human(String name, LocalDate birthday, int age, String nationality) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }
}