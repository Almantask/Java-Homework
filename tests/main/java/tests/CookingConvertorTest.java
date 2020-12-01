package main.java.tests;

import static org.assertj.core.api.Assertions.assertThat;

import CookingConvertor.Amounts;
import CookingConvertor.CookingMeasurement;
import CookingConvertor.CookingMeasurementConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CookingConvertorTest {
    @Test
    public void entering_non_existing_value_returns_false() {
        String test = "Anything";

        boolean verify = Amounts.Validation(test);

        assertThat(verify).isEqualTo(false);
    }
    @Test
    public void convert_unit_returns_converted_unit(){
        CookingMeasurement original = new CookingMeasurement(1f,"TSP");

        CookingMeasurement converted = CookingMeasurementConverter.convert(new CookingMeasurement(5f, "ML"), "TSP");

        assertEquals(original.getAmount(), converted.getAmount());
        assertEquals(original.getUnit(), converted.getUnit());
    }

}
