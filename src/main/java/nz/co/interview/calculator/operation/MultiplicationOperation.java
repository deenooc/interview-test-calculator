package nz.co.interview.calculator.operation;

public class MultiplicationOperation implements Operation {

    @Override
    public int calculate(final int left, final int right) {
        return left * right;
    }

}
