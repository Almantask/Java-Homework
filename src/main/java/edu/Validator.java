package edu;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object object){
        Class aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for(Field field : fields){
            Annotation annotation = field.getAnnotation(RequiredAnnotation.class);
            if(annotation instanceof RequiredAnnotation){
                field.setAccessible(true);
                try {
                    Object value = field.get(object);
                    if(value == null){
                        throw new RuntimeException(field.getName() + " of class "+ aClass.getName() +" was marked as required, but was null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
