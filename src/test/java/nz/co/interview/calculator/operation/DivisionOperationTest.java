package nz.co.interview.calculator.operation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static nz.co.interview.calculator.TestUtils.getRandomInteger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DivisionOperationTest {

    private DivisionOperation operation;

    @BeforeEach
    void setUp() {
        operation = new DivisionOperation();
    }

    @Test
    void Can_calculate_division() {

        // Given
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // When
        final int actual = operation.calculate(left, right);

        // Then
        assertThat(actual, is(left / right));
    }

    @Test
    void Cannot_divide_by_zero() {

        // Given
        final int left = getRandomInteger();
        final int right = 0;

        // When
        final IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> operation.calculate(left, right));

        // Then
        assertThat(actual.getMessage(), is("Cannot divide by zero."));
    }
}