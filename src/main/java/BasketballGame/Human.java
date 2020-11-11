package BasketballGame;

import java.time.LocalDate;

public class Human {

    private final String name;
    private final LocalDate birthday;
    private final int age;
    private final String nationality;

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