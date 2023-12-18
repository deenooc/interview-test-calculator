package nz.co.interview.calculator.operation;

import org.junit.jupiter.api.Test;

import static nz.co.interview.calculator.TestUtils.getRandomInteger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MultiplicationOperationTest {

    @Test
    void Can_calculate_multiplication() {

        // Given
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // When
        final int actual = new MultiplicationOperation().calculate(left, right);

        // Then
        assertThat(actual, is(left * right));

    }
}