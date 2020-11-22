package edu.protectedkeywordAndEnum;

public class Human {
    protected String name;
    private final Gender gender;

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
}
