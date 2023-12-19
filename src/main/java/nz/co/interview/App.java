package nz.co.interview;

import nz.co.interview.calculator.Calculator;
import nz.co.interview.calculator.OperationEvaluator;
import nz.co.interview.calculator.validator.InputValidator;


public class App
{
    public static void main( String[] args )
    {
        final InputValidator inputValidator = new InputValidator();
        final OperationEvaluator operationEvaluator = new OperationEvaluator();
        final String result = new Calculator(inputValidator, operationEvaluator).calculate(args);

        System.out.println(result);
    }
}
