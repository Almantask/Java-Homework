package BasketballGames;

import java.time.LocalDate;
import java.time.Period;

public class Human {
    private String name;
    private String surname;
    private LocalDate birthday;
    private int age;
    private String nationality;

    public Human(String name, String surname, LocalDate birthday, String nationality) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        return Period.between(birthday,LocalDate.now()).getYears();
    }

    public String getNationality() {
        return nationality;
    }

}
