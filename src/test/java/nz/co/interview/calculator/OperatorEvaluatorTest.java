package nz.co.interview.calculator;

import nz.co.interview.calculator.operation.AdditionOperation;
import nz.co.interview.calculator.operation.DivisionOperation;
import nz.co.interview.calculator.operation.MultiplicationOperation;
import nz.co.interview.calculator.operation.Operation;
import nz.co.interview.calculator.operation.SubtractionOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class OperatorEvaluatorTest {

    private OperationEvaluator operationEvaluator;

    @BeforeEach
    void setUp() {
        operationEvaluator = new OperationEvaluator();
    }

    @Test
    void can_evaluate_default_operation() {

        // When
        final Operation actual = operationEvaluator.evaluateOperation("+");

        // Then
        assertInstanceOf(AdditionOperation.class, actual);
    }

    @Test
    void can_evaluate_subtraction_operation() {
        // When
        final Operation actual = operationEvaluator.evaluateOperation("-");

        // Then
        assertInstanceOf(SubtractionOperation.class, actual);
    }

    @Test
    void can_evaluate_multiplication_operation() {
        // When
        final Operation actual = operationEvaluator.evaluateOperation("*");

        // Then
        assertInstanceOf(MultiplicationOperation.class, actual);
    }

    @Test
    void can_evaluate_division_operation() {

        // When
        final Operation actual = operationEvaluator.evaluateOperation("/");

        // Then
        assertInstanceOf(DivisionOperation.class, actual);
    }
}