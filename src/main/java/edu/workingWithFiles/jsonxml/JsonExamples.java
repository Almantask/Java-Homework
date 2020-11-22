package edu.workingWithFiles.jsonxml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

// Json is the most common data format for files
// It is used all around the web
// Also often used for configurations and data in general
// It's so good, because it's very lightweight
// newer
public class JsonExamples {

    public static void demoWithDates(){
        // Converting to json using jackson. Refer to pom.xml for dependencies
        ObjectMapper objectMapper = new ObjectMapper()

                // Dates gets serialized as objects.
                .enable(SerializationFeature.INDENT_OUTPUT)
                // If we want to serialize them as a formatted string- we need to do this:
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .registerModule(new JavaTimeModule());

        try{
            objectMapper.writeValue(new File("target/times-instant.json"), Instant.now());
            objectMapper.writeValue(new File("target/times-local.json"), LocalDateTime.now());
            objectMapper.writeValue(new File("target/times-zoned.json"), ZonedDateTime.now());
        }catch(Exception ex){

        }

    }
}
