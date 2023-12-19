package nz.co.interview.calculator;


import nz.co.interview.calculator.operation.Operation;
import nz.co.interview.calculator.validator.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static nz.co.interview.calculator.TestUtils.getRandomInteger;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

class CalculatorTest {

    private InputValidator inputValidator;
    private Calculator calculator;
    private OperationEvaluator operationEvaluator;

    @BeforeEach
    void setUp() {
        inputValidator = mock(InputValidator.class);
        operationEvaluator = mock(OperationEvaluator.class);
        calculator = new Calculator(inputValidator, operationEvaluator);
    }

    @Test
    void Can_calculate_arithmetic_expression() {
        final String left = Integer.toString(getRandomInteger());
        final String right = Integer.toString(getRandomInteger());
        final String operator = "+";
        final String[] input = new String[] { left, operator, right};
        final Operation operation = mock(Operation.class);
        final int result = getRandomInteger();

        // Given
        given(inputValidator.validate(input)).willReturn(true);
        given(operationEvaluator.evaluateOperation(operator)).willReturn(operation);
        given(operation.calculate(Integer.parseInt(left), Integer.parseInt(right))).willReturn(result);

        // When
        final String actual = calculator.calculate(input);

        // Then
        assertThat(actual, is(Integer.toString(result)));
    }

    @Test
    void Can_fail_to_calculate_arithmetic_expression() {
        final String left = Integer.toString(getRandomInteger());
        final String right = Integer.toString(getRandomInteger());
        final String operator = "+";
        final String[] input = new String[] { left, operator, right};

        // Given
        given(inputValidator.validate(input)).willReturn(false);

        // When
        final IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> calculator.calculate(input));

        // Then
        assertThat(actual.getMessage(), is("Cannot perform calculation, invalid input."));
        verifyNoInteractions(operationEvaluator);
    }
}