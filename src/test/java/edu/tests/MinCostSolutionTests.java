package edu.tests;


import edu.MinCostSolution;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MinCostSolutionTests {

    @Test
    public void check_for_one_pair () {
        int [] cost = {1,2,3,4,5};
        MinCostSolution solution = new MinCostSolution("abaac",cost);

        int answer = solution.solve();

        assertEquals(3, answer);
    }


    @Test
    public void check_for_two_pairs () {
        int [] cost = {1,2,3,4,1};
        MinCostSolution solution = new MinCostSolution("aabaa",cost);

        int answer = solution.solve();

        assertEquals(2, answer);
    }

    @Test
    public void check_for_to_pairs_and_tree_letters() {
        int [] cost = {9, 1, 2, 3, 4, 2, 6};
        MinCostSolution solution = new MinCostSolution("aabaaac",cost);

        int answer = solution.solve();

        assertEquals(6, answer);
    }

    @Test
    public void check_for_no_pairs() {
        int [] cost = {1,2,3};
        MinCostSolution solution = new MinCostSolution("abc",cost);

        int answer = solution.solve();

        assertEquals(0, answer);
    }
}
