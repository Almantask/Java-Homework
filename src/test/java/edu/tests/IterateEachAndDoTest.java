package edu.tests;

import edu.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.IterateEachAndDo.ConcatinateNames;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class IterateEachAndDoTest {
    @Test
    public void concatinateNamesShouldReturnPeopleNamesSeparatedByComma() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, viktor, eva);
        assertThat(ConcatinateNames(collection))
                .isEqualTo("Names: Sara, Viktor, Eva.");
    }
}
