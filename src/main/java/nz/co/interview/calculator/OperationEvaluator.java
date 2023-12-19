package nz.co.interview.calculator;

import nz.co.interview.calculator.operation.AdditionOperation;
import nz.co.interview.calculator.operation.DivisionOperation;
import nz.co.interview.calculator.operation.MultiplicationOperation;
import nz.co.interview.calculator.operation.Operation;
import nz.co.interview.calculator.operation.SubtractionOperation;

import java.util.HashMap;
import java.util.Map;

public class OperationEvaluator {

    public enum Operator {
        ADD("+") {
            @Override
            public Operation getOperation() {
                return new AdditionOperation();
            }
        },
        SUBTRACT("-") {
            @Override
            public Operation getOperation() {
                return new SubtractionOperation();
            }
        },
        MULTIPLY("*") {
            @Override
            public Operation getOperation() {
                return new MultiplicationOperation();
            }
        },
        DIVIDE("/") {
            @Override
            public Operation getOperation() {
                return new DivisionOperation();
            }
        };

        final String operatorValue;
        private static Map<String, Operator> operatorMap;

        Operator(final String operatorValue) {
            this.operatorValue = operatorValue;
        }

        public static Operator getOperator(final String operatorValue) {
            if (operatorMap == null) {
                initialiseMapping();
            }
            if (operatorMap.containsKey(operatorValue)) {
                return operatorMap.get(operatorValue);
            }
            return null;
        }

        private static void initialiseMapping() {
            operatorMap = new HashMap<>();
            for (Operator operator : Operator.values()) {
                operatorMap.put(operator.operatorValue, operator);
            }
        }

        public abstract Operation getOperation();
    }

    public Operation evaluateOperation(final String operatorValue) {
        final Operator operator = Operator.getOperator(operatorValue);

        if (operator != null) {
            return operator.getOperation();
        }
        throw new IllegalArgumentException("Cannot evaluate operation.");
    }
}
