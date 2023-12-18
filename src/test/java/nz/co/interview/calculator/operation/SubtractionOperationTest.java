package nz.co.interview.calculator.operation;

import org.junit.jupiter.api.Test;

import static nz.co.interview.calculator.TestUtils.getRandomInteger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class SubtractionOperationTest {

    @Test
    void Can_calculate_subtraction() {

        // Given
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // When
        final int actual = new SubtractionOperation().calculate(left, right);

        // Then
        assertThat(actual, is(left - right));
    }
}