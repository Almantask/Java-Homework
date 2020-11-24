package cooking_converter;

import org.junit.jupiter.api.Test;

import static cooking_converter.EUnits.GRAMS;
import static cooking_converter.EUnits.OZ;
import static org.junit.jupiter.api.Assertions.*;

class CookingMeasurementConverterTest {
    @Test
    void shouldReturnOneWhenUnitFromAndUnitToAreSame() {
        CookingMeasurement originalMeasurement = new CookingMeasurement(1F, GRAMS);
        CookingMeasurement result = CookingMeasurementConverter.convert(originalMeasurement, GRAMS);
        assertEquals(1F, result.getAmount());
        assertEquals(GRAMS, result.getUnit());
    }

    @Test
    void shouldReturnXValueWhenUnitFromAndUnitToAreDifferent() {
        CookingMeasurement originalMeasurement = new CookingMeasurement(1F, OZ);
        CookingMeasurement result = CookingMeasurementConverter.convert(originalMeasurement, GRAMS);
        assertEquals(0.035714287F, result.getAmount());
        assertEquals(GRAMS, result.getUnit());
    }
}