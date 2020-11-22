package edu.workingWithFiles.jsonxml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.protectedkeywordAndEnum.Car;
import edu.protectedkeywordAndEnum.FuelType;
import edu.protectedkeywordAndEnum.Human;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static void serialize(Object o, String file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(file), o);
    }

    public static List<Car> deserializeCar(String file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // We need to specify the type that we are deserializing to
        // The type contains a description, so we can deserialize to it.
        List<Car> cars = objectMapper.readValue(new File(file), new TypeReference<List<Car>>(){});

        return cars;
    }

    public static List<Human> deserializeHuman(String file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // We need to specify the type that we are deserializing to
        // The type contains a description, so we can deserialize to it.
        List<Human> cars = objectMapper.readValue(new File(file), new TypeReference<List<Human>>(){});

        return cars;
    }
}
