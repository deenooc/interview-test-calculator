package nz.co.interview.calculator.operation;

public class DivisionOperation implements Operation {

    @Override
    public int calculate(int left, int right) {
        return left / right;
    }
}
