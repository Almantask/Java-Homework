package cooking_converter;

import java.util.Arrays;
import java.util.List;

import static cooking_converter.EValidationErrors.ERR_INVALID_UNIT;

public enum EUnits {
    GRAMS(1F, false),
    OZ(28F, false),
    POUND(454F, false),
    TSP(5F, true),
    ML(1F, true),
    TBSP(15F, true),
    FL_OUNCE(30F, true),
    CUP(237F, true),
    PINT(473F, true),
    QUART(0.95F, true),
    GALLON(3.80F, true);

    private final float amount;
    private final boolean volumeAmount;

    EUnits(float amount, boolean volumeAmount) {
        this.amount = amount;
        this.volumeAmount = volumeAmount;
    }

    public static EUnits validateAndGet(String unitName) {
        return getValues()
                .stream()
                .filter(unit -> unit.name().equalsIgnoreCase(unitName))
                .findAny()
                .orElseThrow(() -> ERR_INVALID_UNIT.getError(EUnits.getValues()));
    }

    public static List<EUnits> getWeightValues() {
        return Arrays.asList(
                GRAMS, OZ, POUND);
    }

    public static List<EUnits> getVolumeValues() {
        return Arrays.asList(
                ML, GALLON, QUART, PINT, CUP, FL_OUNCE, TBSP, TSP);
    }

    public static List<EUnits> getValues() {
        return Arrays.asList(EUnits.values());
    }

    public float getAmount() {
        return amount;
    }

    public boolean isVolumeAmount() {
        return volumeAmount;
    }
}