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

    public CalculatorApplication(InputFactory inputFactory) {
        this.inputFactory = inputFactory;
    }

    public static void main(String[] args )
    {
        final Scanner in = new Scanner(System.in);
        System.out.println("Please enter an expression to evaluate: ");
        final String expression = in.nextLine();

        final CalculatorApplication application = new CalculatorApplication(new InputFactory());
        final String result = application.processExpression(expression);
        System.out.println(expression + ": " + result);
    }

    public String processExpression(final String expression) {
        final InputValidator inputValidator = new InputValidator();
        if (!inputValidator.isExpressionValid(expression)) {
            throw  new IllegalArgumentException(String.format("The expression entered (%s) is not valid.", expression));
        }

        final OperationEvaluator operationEvaluator = new OperationEvaluator();
        final Calculator calculator = new Calculator(operationEvaluator);
        final CalculatorInput calculatorInput = inputFactory.createInput(expression);
        return calculator.calculate(calculatorInput);
    }

}
