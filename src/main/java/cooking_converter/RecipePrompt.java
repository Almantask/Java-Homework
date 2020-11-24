package cooking_converter;

import java.util.Scanner;
import java.util.function.Predicate;

import static cooking_converter.EValidationErrors.*;

public class RecipePrompt {
    private float amount;
    private EUnits unitFrom;
    private EUnits unitTo;

    public void run() {
        prompt("amount", amountFunction());
        prompt("unit from", unitFromFunction());
        prompt("unit to", unitToFunction());
    }

    private void prompt(String argumentName, Predicate<String> inputFunction) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.printf("Enter %s: ", argumentName);
                if (inputFunction.test(scanner.nextLine())) {
                    break;
                }
            } catch (ValidationErrorException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Predicate<String> amountFunction() {
        return input -> {
            try {
                float inputAmount = Float.parseFloat(input);
                if (amount < 0) {
                    ERR_AMOUNT_NEGATIVE.throwError();
                } else {
                    this.amount = inputAmount;
                    return true;
                }
            } catch (NumberFormatException e) {
                ERR_INVALID_NUMBER.throwError();
            }
            return false;
        };
    }

    private Predicate<String> unitFromFunction() {
        return input -> {
            this.unitFrom = EUnits.validateAndGet(input);
            return true;
        };
    }

    private Predicate<String> unitToFunction() {
        return input -> {
            EUnits validatedUnitTo = EUnits.validateAndGet(input);
            if (this.unitFrom.isVolumeAmount()) {
                if (!validatedUnitTo.isVolumeAmount()) {
                    ERR_NOT_VOLUME_UNIT.throwError(EUnits.getVolumeValues());
                }
            } else {
                if (validatedUnitTo.isVolumeAmount()) {
                    ERR_NOT_WEIGHT_UNIT.throwError(EUnits.getWeightValues());
                }
            }
            this.unitTo = validatedUnitTo;
            return true;
        };
    }

    public EUnits getUnitTo() {
        return this.unitTo;
    }

    public CookingMeasurement getMeasurementFrom() {
        return new CookingMeasurement(this.amount, this.unitFrom);
    }
}