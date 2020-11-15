/**
 * Demonstrate optional test steps, the need for starting fresh on every test case.
 */

package edu.tests;

import edu.CrappyCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CrappyCalculatorTest {
    private static CrappyCalculator calculator;

    // Before each is a more common one.
    // This one is better, because
    // we want to start with a new calculator every time.
    //    @BeforeEach
    //    public void setupEach(){
    //        calculator = new Calculator();
    //    }

    // If we didn't recreate a calculator every time,
    // Then we would have to clean up the existing one.
    @BeforeAll
    public static void setupOnce(){
        calculator = new CrappyCalculator();
    }

    @Test
    public void add_addsPlusToDisplay(){
        calculator.add();

        assertThat(calculator.getDisplay()).endsWith("+");
    }

    @Test
    public void minus_addsMinusToDisplay(){
        calculator.minus();

        assertThat(calculator.getDisplay()).endsWith("-");
    }

    @Test
    public void div_throwsException(){
        assertThatThrownBy(() -> calculator.div())
                .hasMessage("Div is not implemented");
    }

    @Test
    public void number1_adds1ToDisplay(){
        calculator.number(1);

        assertThat(calculator.getDisplay()).endsWith("1");
    }

    @Test
    public void number0_when_first_doesNotChangeDisplay(){
        calculator.number(0);

        assertThat(calculator.getDisplay()).doesNotEndWith("0");
    }

    @Test
    public void number0_when_notFirst_adds0ToDisplay(){
        // Given
        calculator.number(1);

        // When
        calculator.number(0);

        // Then
        assertThat(calculator.getDisplay()).endsWith("0");
    }

    @Test
    public void equal_1Plus2_returns_3(){
        // Given
        calculator.number(1);
        calculator.add();
        calculator.number(2);

        // When
        calculator.equal();

        // Then
        assertThat(calculator.getDisplay()).endsWith("3");
    }

    @Test
    public void equal_1Plus0_returns_1(){
        // Given
        calculator.number(1);
        calculator.add();
        calculator.number(0);

        // When
        calculator.equal();

        // Then
        assertThat(calculator.getDisplay()).endsWith("1");
    }

    @Test
    public void equal_1minus0_returns_1(){
        // Given
        calculator.number(1);
        calculator.minus();
        calculator.number(0);

        // When
        calculator.equal();

        // Then
        assertThat(calculator.getDisplay()).endsWith("1");
    }

    @Test
    public void equal_1minus2_returns_Minus1(){
        // Given
        calculator.number(1);
        calculator.minus();
        calculator.number(2);

        // When
        calculator.equal();

        // Then
        assertThat(calculator.getDisplay()).endsWith("-1");
    }

    @Test
    public void equal_1minus_returns_1(){
        // Given
        calculator.number(1);
        calculator.minus();

        // When
        calculator.equal();

        // Then
        assertThat(calculator.getDisplay()).endsWith("1");
    }

    // In case setup once was used,
    // Calculator should be reset.
    @AfterEach
    public void teardown(){
        calculator.reset();
    }
}
