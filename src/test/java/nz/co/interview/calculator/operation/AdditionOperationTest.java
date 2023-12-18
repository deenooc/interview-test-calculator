package nz.co.interview.calculator.operation;

import org.junit.jupiter.api.Test;

import static nz.co.interview.calculator.TestUtils.getRandomInteger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AdditionOperationTest {

    @Test
    void Can_calculate_addition() {

        // Given
        final int left = getRandomInteger();
        final int right = getRandomInteger();

        // When
        final int actual = new AdditionOperation().calculate(left, right);

        // Then
        assertThat(actual, is(left + right));
    }
}