package nz.co.interview.calculator.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final String OPERATOR_VALIDATION_PATTERN = "[-+/*]";

    public boolean validate(String[] elements) {
        if (elements == null || elements.length == 0) {
            return false;
        }

        if (!checkCorrectNumberOfArguments(elements)) {
            return false;
        }

        return checkValidOperator(elements[1]);
    }

    private static boolean checkCorrectNumberOfArguments(String[] elements) {
        return (elements.length == 3);
    }

    private boolean checkValidOperator(final String operator) {
        final Pattern operatorsPattern = Pattern.compile(OPERATOR_VALIDATION_PATTERN);
        final Matcher matcher = operatorsPattern.matcher(operator);
        return matcher.find();
    }
}
