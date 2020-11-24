package cooking_converter;

public class ValidationErrorException extends RuntimeException {
    public ValidationErrorException(String message) {
        super(message);
    }
}
