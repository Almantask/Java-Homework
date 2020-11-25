package CookingConvertor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookingMeasurementConverterTest {

    @Test
    void convert_zeroNumberCheck() {
        CookingMeasurement forCheck = new CookingMeasurement(0, "TSP");

        CookingMeasurement converted = CookingMeasurementConverter.convert(new CookingMeasurement(0, "ML"), "TSP");

        assertEquals(forCheck.getAmount(), converted.getAmount());
        assertEquals(forCheck.getUnit(), converted.getUnit());
    }

    @Test
    void convert_CheckIfConversionIsCorrect() {
        CookingMeasurement forCheck = new CookingMeasurement(1, "TSP");

        CookingMeasurement converted = CookingMeasurementConverter.convert(new CookingMeasurement(5, "ML"), "TSP");

        assertEquals(forCheck.getAmount(), converted.getAmount());
        assertEquals(forCheck.getUnit(), converted.getUnit());
    }
}