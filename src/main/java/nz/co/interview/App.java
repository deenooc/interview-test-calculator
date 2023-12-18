package nz.co.interview;

import nz.co.interview.calculator.Calculator;
import nz.co.interview.calculator.OperatorEvaluator;
import nz.co.interview.calculator.validator.InputValidator;


public class App
{
    public static void main( String[] args )
    {
        final InputValidator inputValidator = new InputValidator();
        final OperatorEvaluator operatorEvaluator = new OperatorEvaluator();
        final String result = new Calculator(inputValidator, operatorEvaluator).calculate(args);

        System.out.println(result);
    }
}
