package nz.co.interview.calculator.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class InputValidatorTest {

    private InputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputValidator();
    }

    @Test
    void Can_pass_validation() {
        // Given
        final String[] elements = new String[] {"10", "+", "10"};

        // When
        boolean actual = validator.validate(elements);

        // Then
        assertThat(actual, is(true));
    }

    @Test
    void Can_fail_validation_incorrect_operator() {
        // Given
        final String[] elements = new String[] {"10", "]", "10"};

        // When
        boolean actual = validator.validate(elements);

        // Then
        assertThat(actual, is(false));
    }

    @Test
    void Can_fail_validation_incorrect_number_of_elements() {
        // Given
        final String[] elements = new String[] {"20", "-", "10", "+", "8"};

        // When
        boolean actual = validator.validate(elements);

        // Then
        assertThat(actual, is(false));
    }

    @Test
    void Can_fail_validation_empty_array() {
        // Given
        final String[] elements = new String[] {};

        // When
        boolean actual = validator.validate(elements);

        // Then
        assertThat(actual, is(false));
    }

    @Test
    void Can_fail_validation_null_array() {
        // When
        boolean actual = validator.validate(null);

        // Then
        assertThat(actual, is(false));
    }

}