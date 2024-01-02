package nz.co.interview.calculator;

import nz.co.interview.calculator.model.Operator;
import nz.co.interview.calculator.operation.Operation;

public class OperationEvaluator {

    public Operation evaluateOperation(final String operatorValue) {
        final Operator operator = Operator.getOperator(operatorValue);

        if (operator != null) {
            return operator.getOperation();
        }
        throw new IllegalArgumentException("Cannot evaluate operation.");
    }
}
