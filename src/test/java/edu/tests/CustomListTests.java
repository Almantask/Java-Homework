package edu.tests;

import edu.CustomList;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// Other possible names:
// TestCustomList
// CustomListTest
public class CustomListTests {
    /*
    add(int number) - adds a number at the end of a list;
    removeAt(int index)- removes number at specified index of a list;
    + getAll()- gets all elements inside the list
    + any()- returns true if list has any elements
     */

    @Test
    public void getAll_given_emptyList_returns_emptyArray(){
        // Given
        CustomList list = new CustomList();

        // When
        int[] array = list.getAll();

        // Then
        assertThat(array).isEmpty();
    }

    @Test
    public void getAll_given_withSomeElements_returns_thoseElements(){
        // Given
        int[] initialArray = {1,2};
        CustomList list = new CustomList(initialArray);

        // When
        int[] array = list.getAll();

        // Then
        assertThat(array).contains(initialArray);
    }

    @Test
    public void any_given_emptyList_return_false(){
        // Given - preparation
        CustomList list = new CustomList();

        // When - call
        boolean isAny = list.any();

        // Then - assert
        assertThat(isAny).isFalse();
    }

    @Test
    public void any_given_withSomeElements_return_true(){
        // Given - preparation
        CustomList list = new CustomList(new int[] {1});

        // When - call
        boolean isAny = list.any();

        // Then - assert
        assertThat(isAny).isTrue();
    }
}
