package edu.workingWithFiles.jsonxml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.protectedkeywordAndEnum.Car;
import edu.protectedkeywordAndEnum.FuelType;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

// Json is the most common data format for files
// It is used all around the web
// Also often used for configurations and data in general
// It's so good, because it's very lightweight
// newer
public class JsonExamples {

    public static void demoWriteCarToJson() throws IOException {
        //Car car = new Car("BMW", "X6", FuelType.PETROL);
        //JsonUtils.serialize(car, "target/carSerialized.json");
        // Based on what data we have ian  file, we will model our classes accordingly.
        List<Car> car = JsonUtils.deserializeCar("target/carSerialized.json");
        System.out.println(car);
    }

    public static void demoWithDates(){
        // Converting to json using jackson. Refer to pom.xml for dependencies
        ObjectMapper objectMapper = new ObjectMapper()

                // Dates gets serialized as objects.
                .enable(SerializationFeature.INDENT_OUTPUT);

        try{
            objectMapper.writeValue(new File("target/times-instant.json"), Instant.now());
            objectMapper.writeValue(new File("target/times-local.json"), LocalDateTime.now());
            objectMapper.writeValue(new File("target/times-zoned.json"), ZonedDateTime.now());
        }catch(Exception ex){

        }

    }
}
