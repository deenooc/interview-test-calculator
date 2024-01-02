package nz.co.interview.calculator.factory;

import nz.co.interview.calculator.model.CalculatorInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static nz.co.interview.calculator.TestUtils.getRandomCharacter;
import static nz.co.interview.calculator.TestUtils.getRandomInteger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class InputFactoryTest {

    private InputFactory factory;

    @BeforeEach
    void setUp() {
        factory = new InputFactory();
    }

    @Test
    void Can_create_input() {
        final int left = getRandomInteger();
        final int right = getRandomInteger();
        final String operator = getRandomCharacter();

        // Given
        final String input = String.format( "%d %s %d", left, operator, right);

        // When
        final CalculatorInput actual = factory.createInput(input);

        // Then
        assertThat(actual, notNullValue());
        assertThat(actual.getOperator(), is(operator));
        assertThat(actual.getLeft(), is(left));
        assertThat(actual.getRight(), is(right));
    }


}