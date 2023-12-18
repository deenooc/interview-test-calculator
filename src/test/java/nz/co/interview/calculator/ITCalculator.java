package nz.co.interview.calculator;

import nz.co.interview.calculator.validator.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.String.valueOf;
import static nz.co.interview.calculator.TestUtils.getRandomInteger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ITCalculator {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        final InputValidator inputValidator = new InputValidator();
        final OperatorEvaluator operatorEvaluator = new OperatorEvaluator();
        calculator = new Calculator(inputValidator, operatorEvaluator);
    }

    @Test
    void Can_add_two_numbers() {
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // Given
        final String[] input = new String[] { Integer.toString(left) , "+", Integer.toString(right) };

        // When
        final String actual = calculator.calculate(input);

        // Then
        assertThat(actual, equalTo(valueOf(left + right)));
    }

    @Test
    void Can_subtract_two_numbers() {
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // Given
        final String[] input = new String[] { Integer.toString(left) , "-", Integer.toString(right) };

        // When
        final String actual = calculator.calculate(input);

        // Then
        assertThat(actual, equalTo(valueOf(left - right)));
    }

    @Test
    void Can_multiply_two_numbers() {
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // Given
        final String[] input = new String[] { Integer.toString(left) , "*", Integer.toString(right) };

        // When
        final String actual = calculator.calculate(input);

        // Then
        assertThat(actual, equalTo(valueOf(left * right)));
    }

    @Test
    void Can_divide_two_numbers() {
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // Given
        final String[] input = new String[] { Integer.toString(left) , "/", Integer.toString(right) };

        // When
        final String actual = calculator.calculate(input);

        // Then
        assertThat(actual, equalTo(valueOf(left / right)));
    }

    @Test
    void Can_fail_to_perform_calculation_invalid_input() {
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // Given
        final String[] input = new String[] { Integer.toString(left) , "@", Integer.toString(right) };

        // When
        final IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> calculator.calculate(input));

        // Then
        assertThat(actual, notNullValue());
        assertThat(actual.getMessage(), equalTo("Cannot perform calculation, invalid input."));
    }

}