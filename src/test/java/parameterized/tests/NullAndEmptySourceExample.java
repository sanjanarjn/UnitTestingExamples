package parameterized.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class NullAndEmptySourceExample {
    @ParameterizedTest
    @NullSource
    public void testForNull(String input) {
        Assertions.assertTrue(input == null);
    }

    @ParameterizedTest
    @EmptySource
    public void testForEmpty(String input) {
        Assertions.assertTrue(input.isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testForEmptyAndNull(String input) {
        Assertions.assertTrue(input == null || input.isEmpty());
    }
}