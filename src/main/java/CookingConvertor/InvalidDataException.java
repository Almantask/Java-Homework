package CookingConvertor;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String error){
        super(error);
    }

    public InvalidDataException(){
        super("Amount must be more than 0");
    }
}
