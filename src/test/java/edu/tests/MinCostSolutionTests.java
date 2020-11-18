package edu.tests;

import edu.MinCostSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinCostSolutionTests {

    @Test
    @DisplayName("Check for one pair of letters")
    public void check_ForOnlyOnePair_ofLetters () {
        String key = "abaac";
        int [] cost = {1,2,3,4,5};

        int answer = MinCostSolution.solve(key,cost);

        assertEquals(3, answer);
    }

    @Test
    @DisplayName("Check for zero pairs of letters")
    public void check_for_nonePairs() {
        String key = "abc";
        int [] cost = {1,2,3};

        int answer = MinCostSolution.solve(key,cost);

        assertEquals(0, answer);
    }

    @Test
    @DisplayName("Check for two pairs of letters")
    public void checkFor_two_or_morePairs () {
        String key = "aabaa";
        int [] cost = {1,2,3,4,1};

        int answer = MinCostSolution.solve(key,cost);

        assertEquals(2, answer);
    }
}
