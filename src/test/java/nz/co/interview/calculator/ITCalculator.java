package nz.co.interview.calculator;

import nz.co.interview.CalculatorApplication;
import nz.co.interview.calculator.factory.InputFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static nz.co.interview.calculator.model.Operator.ADD;
import static nz.co.interview.calculator.model.Operator.DIVIDE;
import static nz.co.interview.calculator.model.Operator.MULTIPLY;
import static nz.co.interview.calculator.model.Operator.SUBTRACT;
import static nz.co.interview.calculator.TestUtils.getRandomInteger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ITCalculator {

    private CalculatorApplication calculatorApplication;

    @BeforeEach
    void setUp() {
        calculatorApplication = new CalculatorApplication(new InputFactory());
    }

    @Test
    void Can_add_two_numbers() {
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // Given
        final String input = String.format( "%d %s %d", left, ADD.getOperatorValue(), right);

        // When
        final String actual = calculatorApplication.processExpression(input);

        // Then
        assertThat(actual, equalTo(valueOf(left + right)));
    }

    @Test
    void Can_subtract_two_numbers() {
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // Given
        final String input = String.format( "%d %s %d", left, SUBTRACT.getOperatorValue(), right);

        // When
        final String actual = calculatorApplication.processExpression(input);

        // Then
        assertThat(actual, equalTo(valueOf(left - right)));
    }

    @Test
    void Can_multiply_two_numbers() {
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // Given
        final String input = String.format( "%d %s %d", left, MULTIPLY.getOperatorValue(), right);

        // When
        final String actual = calculatorApplication.processExpression(input);

        // Then
        assertThat(actual, equalTo(valueOf(left * right)));
    }

    @Test
    void Can_divide_two_numbers() {
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // Given
        final String input = String.format( "%d %s %d", left, DIVIDE.getOperatorValue(), right);

        // When
        final String actual = calculatorApplication.processExpression(input);

        // Then
        assertThat(actual, equalTo(valueOf(left / right)));
    }

    @Test
    void Can_fail_to_divide_by_zero() {
        final int left = getRandomInteger();
        final int right = 0;

        // Given
        final String input = String.format( "%d %s %d", left, DIVIDE.getOperatorValue(), right);

        // When
        final IllegalArgumentException actual = assertThrows(
                IllegalArgumentException.class,
                () -> calculatorApplication.processExpression(input)
        );

        // Then
        assertThat(actual.getMessage(), is("Cannot divide by zero."));
    }

    @Test
    void Can_fail_to_perform_calculation_invalid_input() {
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // Given
        final String input = String.format( "%d %s %d", left, "@", right);

        // When
        final IllegalArgumentException actual = assertThrows(
                IllegalArgumentException.class,
                () -> calculatorApplication.processExpression(input)
        );

        // Then
        assertThat(actual, notNullValue());
        assertThat(actual.getMessage(), equalTo(format("The expression entered (%s) is not valid.", input)));
    }

}