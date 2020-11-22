package edu.errors;

public class InvalidHumanNameException extends RuntimeException {
    public InvalidHumanNameException(String error){
        super(error);
    }

    public InvalidHumanNameException(){
        super("Human must have a name with 1 or more characters.");
    }
}
