package cooking_converter;

public enum EValidationErrors {
    ERR_AMOUNT_NEGATIVE("ERROR. Amount can't be negative. Please enter valid amount."),
    ERR_INVALID_NUMBER("ERROR. Invalid number. Please enter valid number."),
    ERR_INVALID_UNIT("ERROR. Unit isn't valid. Please enter valid unit. %s"),
    ERR_NOT_WEIGHT_UNIT("ERROR. Unit isn't weight unit. Please enter weight unit. %s"),
    ERR_NOT_VOLUME_UNIT("ERROR. Unit isn't volume unit. Please enter volume unit. %s");

    private final String errorText;

    EValidationErrors(String errorText) {
        this.errorText = errorText;
    }

    public void throwError(Object... objects) {
        throw new ValidationErrorException(String.format(this.errorText, objects));
    }

    public ValidationErrorException getError(Object... objects) {
        return new ValidationErrorException(String.format(this.errorText, objects));
    }
}