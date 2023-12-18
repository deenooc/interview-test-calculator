package nz.co.interview.calculator.operation;


public class SubtractionOperation implements Operation {

    @Override
    public int calculate(final int left, final int right) {
        return left - right;
    }
}
