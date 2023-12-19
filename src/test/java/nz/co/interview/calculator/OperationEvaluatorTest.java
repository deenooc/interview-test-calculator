package nz.co.interview.calculator;


import nz.co.interview.calculator.operation.AdditionOperation;
import nz.co.interview.calculator.operation.DivisionOperation;
import nz.co.interview.calculator.operation.MultiplicationOperation;
import nz.co.interview.calculator.operation.Operation;
import nz.co.interview.calculator.operation.SubtractionOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationEvaluatorTest {

    private OperationEvaluator operationEvaluator;

    @BeforeEach
    void setUp() {
        operationEvaluator = new OperationEvaluator();
    }

    @Test
    void Can_evaluate_addition_operation() {
        // Given
        final String operatorValue = "+";

        // When
        final Operation actual = operationEvaluator.evaluateOperation(operatorValue);

        // Then
        assertThat(actual, instanceOf(AdditionOperation.class));
    }

    @Test
    void Can_evaluate_subtraction_operation() {
        // Given
        final String operatorValue = "-";

        // When
        final Operation actual = operationEvaluator.evaluateOperation(operatorValue);

        // Then
        assertThat(actual, instanceOf(SubtractionOperation.class));
    }

    @Test
    void Can_evaluate_multiplication_operation() {
        // Given
        final String operatorValue = "*";

        // When
        final Operation actual = operationEvaluator.evaluateOperation(operatorValue);

        // Then
        assertThat(actual, instanceOf(MultiplicationOperation.class));
    }

    @Test
    void Can_evaluate_division_operation() {
        // Given
        final String operatorValue = "/";

        // When
        final Operation actual = operationEvaluator.evaluateOperation(operatorValue);

        // Then
        assertThat(actual, instanceOf(DivisionOperation.class));
    }

    @Test
    void Can_fail_to_evaluate_operation() {
        // Given
        final String operatorValue = "0";

        // When
        final IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> operationEvaluator.evaluateOperation(operatorValue));

        // Then
        assertThat(actual.getMessage(), is("Cannot evaluate operation."));
    }
}