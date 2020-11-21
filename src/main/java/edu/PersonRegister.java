package edu;

import java.util.HashMap;
import java.util.Map;

public class PersonRegister {
    private Map<Long, Person> people = new HashMap<>();


    public PersonRegister(Person[]people) {
        for (Person person:people) {
            add(person);
        }
    }
    public void add (Person person){
        people.put(person.getID(), person);
    }
    public Person get (Long ID){
       return people.get(ID);
    }
}
