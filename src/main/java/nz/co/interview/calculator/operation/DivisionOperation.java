package nz.co.interview.calculator.operation;

public class DivisionOperation implements Operation {

    @Override
    public int calculate(int left, int right) {
        if (right == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return left / right;
    }
}
