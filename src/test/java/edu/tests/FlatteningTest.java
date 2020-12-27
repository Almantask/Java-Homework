package edu.tests;

import edu.Flattening;
import org.junit.jupiter.api.Test;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class FlatteningTest {
    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        assertThat(Flattening.transform(collection)).hasSameElementsAs(expected);
    }
}
