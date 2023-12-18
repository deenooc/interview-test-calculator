package nz.co.interview.calculator;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TestUtilsTest {

    @Test
    void Can_get_random_integer_between_0_and_1000() {
        // When
        final int actual = TestUtils.getRandomInteger();

       // Then
        assertTrue(actual > 0);
        assertTrue(actual <= 1000);
    }
}