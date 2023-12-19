package nz.co.interview.calculator;

import nz.co.interview.calculator.operation.Operation;
import nz.co.interview.calculator.validator.InputValidator;


public class Calculator {

    private final InputValidator inputValidator;
    private final OperationEvaluator operationEvaluator;

    public Calculator(final InputValidator inputValidator, final OperationEvaluator operationEvaluator) {
        this.inputValidator = inputValidator;
        this.operationEvaluator = operationEvaluator;
    }

    public String calculate(final String[] input) {

        if (!inputValidator.validate(input)) {
            throw new IllegalArgumentException("Cannot perform calculation, invalid input.");
        }

        return evaluateExpression(input);
    }

    private String evaluateExpression(final String[] input) {
        final int left = Integer.parseInt(input[0]);
        final int right = Integer.parseInt(input[2]);
        final Operation operation = operationEvaluator.evaluateOperation(input[1]);

        return Integer.toString(operation.calculate(left, right));
    }

}
