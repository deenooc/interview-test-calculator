package nz.co.interview.calculator.model;

import java.util.Objects;

public class CalculatorInput {

    private Integer right;
    private Integer left;
    private String operator;

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CalculatorInput)) {
            return false;
        }
        final CalculatorInput that = (CalculatorInput) o;
        return (right.equals(that.right))
                && (left.equals(that.left))
                && (operator.equals(that.operator));
    }

    @Override
    public int hashCode() {
        return Objects.hash(right, left, operator);
    }

    @Override
    public String toString() {
        return "CalculatorInput{" +
                "right=" + right +
                ", left=" + left +
                ", operator='" + operator + '\'' +
                '}';
    }
}
