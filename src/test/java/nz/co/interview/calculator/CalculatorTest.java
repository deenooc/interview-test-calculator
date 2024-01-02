package nz.co.interview.calculator;


import nz.co.interview.calculator.model.CalculatorInput;
import nz.co.interview.calculator.operation.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static nz.co.interview.calculator.model.Operator.ADD;
import static nz.co.interview.calculator.TestUtils.getRandomInteger;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CalculatorTest {

    private Calculator calculator;
    private OperationEvaluator operationEvaluator;

    @BeforeEach
    void setUp() {
        operationEvaluator = mock(OperationEvaluator.class);
        calculator = new Calculator(operationEvaluator);
    }

    @Test
    void Can_calculate_arithmetic_expression() {
        final CalculatorInput input = getCalculatorInput(ADD.getOperatorValue());

        final Operation operation = mock(Operation.class);
        final int result = getRandomInteger();

        // Given
        given(operationEvaluator.evaluateOperation(input.getOperator())).willReturn(operation);
        given(operation.calculate(input.getLeft(), input.getRight())).willReturn(result);

        // When
        final String actual = calculator.calculate(input);

        // Then
        assertThat(actual, is(Integer.toString(result)));
    }

    private CalculatorInput getCalculatorInput(final String operator) {
        final CalculatorInput calculatorInput = new CalculatorInput();
        calculatorInput.setLeft(getRandomInteger());
        calculatorInput.setRight(getRandomInteger());
        calculatorInput.setOperator(operator);

        return calculatorInput;
    }
}