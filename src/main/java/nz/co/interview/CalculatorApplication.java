package nz.co.interview;

import nz.co.interview.calculator.Calculator;
import nz.co.interview.calculator.model.CalculatorInput;
import nz.co.interview.calculator.factory.InputFactory;
import nz.co.interview.calculator.OperationEvaluator;
import nz.co.interview.calculator.validator.InputValidator;

import java.util.Scanner;


public class CalculatorApplication
{
    final InputFactory inputFactory;

    public CalculatorApplication(final InputFactory inputFactory) {
        this.inputFactory = inputFactory;
    }

    public static void main(String[] args )
    {
        final Scanner in = new Scanner(System.in);
        System.out.println("Please enter an arithmetic expression to evaluate: ");
        final String arithmeticExpression = in.nextLine();

        final CalculatorApplication application = new CalculatorApplication(new InputFactory());
        final String result = application.processExpression(arithmeticExpression);
        System.out.println(arithmeticExpression + ": " + result);
    }

    public String processExpression(final String arithmeticExpression) {
        final InputValidator inputValidator = new InputValidator();
        if (!inputValidator.isExpressionValid(arithmeticExpression)) {
            throw new IllegalArgumentException(String.format("The expression entered (%s) is not valid.", arithmeticExpression));
        }

        final OperationEvaluator operationEvaluator = new OperationEvaluator();
        final Calculator calculator = new Calculator(operationEvaluator);
        final CalculatorInput calculatorInput = inputFactory.createInput(arithmeticExpression);
        return calculator.calculate(calculatorInput);
    }

}
