package nz.co.interview.calculator;

import nz.co.interview.calculator.operation.AdditionOperation;
import nz.co.interview.calculator.operation.DivisionOperation;
import nz.co.interview.calculator.operation.MultiplicationOperation;
import nz.co.interview.calculator.operation.Operation;
import nz.co.interview.calculator.operation.SubtractionOperation;

public class OperatorEvaluator {


    public Operation evaluateOperation(final String operator) {

        switch (operator.trim()) {
            case "-":
                return new SubtractionOperation();
            case "*":
                return new MultiplicationOperation();
            case "/":
                return new DivisionOperation();
            default:
                return new AdditionOperation();
        }
    }
}
