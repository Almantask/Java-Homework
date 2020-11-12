package BasketballGames;

import java.time.LocalDate;
import java.time.Period;

public class Human {
    private String name;
    private LocalDate birthday;

    private String nationality;

    public Human(String name, LocalDate birthday, String nationality) {
        this.name = name;
        this.birthday = birthday;

        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return Period.between(LocalDate.now(), birthday).getYears();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age=" + getAge() +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}