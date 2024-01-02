package nz.co.interview.calculator;

import nz.co.interview.calculator.model.CalculatorInput;
import nz.co.interview.calculator.operation.Operation;


public class Calculator {

    private final OperationEvaluator operationEvaluator;

    public Calculator(final OperationEvaluator operationEvaluator) {
        this.operationEvaluator = operationEvaluator;
    }

    public String calculate(final CalculatorInput input) {
        final Operation operation = operationEvaluator.evaluateOperation(input.getOperator());
        return Integer.toString(operation.calculate(input.getLeft(), input.getRight()));
    }

}
