package nz.co.interview.calculator.factory;

import nz.co.interview.calculator.model.CalculatorInput;

public class InputFactory {

    public CalculatorInput createInput(final String expression) {
        final String[] operands = expression.split(" ");
        final CalculatorInput calculatorInput = new CalculatorInput();
        calculatorInput.setLeft(Integer.valueOf(operands[0]));
        calculatorInput.setOperator(operands[1]);
        calculatorInput.setRight(Integer.valueOf(operands[2]));
        return calculatorInput;
    }
}
