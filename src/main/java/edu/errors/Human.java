package edu.errors;

public class Human {
    private final String name;

    public Human(String name) throws InvalidHumanNameException {
        if(name == null || name.isEmpty()){
            throw new InvalidHumanNameException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
