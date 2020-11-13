import java.time.*;

public class Human {
    private String Name;
    private LocalDate Birthday;
    private int Age;
    private String Nationality;

    public Human(String Name, LocalDate Birthday, int Age, String Nationality) {
        if (Name == null || Name.isEmpty()){return;}
        this.Name = Name;
        this.Birthday = Birthday;
        this.Age = Age;
        this.Nationality = Nationality;
    }

    public String getName() {
        return Name;
    }

    public LocalDate getBirthday() {
        return Birthday;
    }

    public int getAge() {
        return Age;
    }

    public String getNationality() {
        return Nationality;
    }
}