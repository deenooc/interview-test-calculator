package nz.co.interview.calculator.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final String OPERATOR_VALIDATION_PATTERN = "[-+/*]";
    private static final String EXPRESSION_VALIDATION_PATTERN = "\\d [-+/*] \\d";

    public boolean validate(String[] elements) {
        if (elements == null || elements.length == 0) {
            return false;
        }

        if (!checkCorrectNumberOfArguments(elements)) {
            return false;
        }

        return isPatternMatched(elements[1], OPERATOR_VALIDATION_PATTERN);
    }

    private static boolean checkCorrectNumberOfArguments(String[] elements) {
        return (elements.length == 3);
    }

    private boolean isPatternMatched(final String operator, final String validationPattern) {
        final Pattern operatorsPattern = Pattern.compile(validationPattern);
        final Matcher matcher = operatorsPattern.matcher(operator);
        return matcher.find();
    }

    public boolean isExpressionValid(final String expression) {
        if (expression != null) {
            return isPatternMatched(expression, EXPRESSION_VALIDATION_PATTERN);
        }
        return false;
    }
}
