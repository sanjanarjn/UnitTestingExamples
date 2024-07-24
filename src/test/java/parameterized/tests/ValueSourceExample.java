package parameterized.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValueSourceExample {
    @ParameterizedTest
    @ValueSource(strings = {"abbc", "abc"})
    public void testString(String input) {
        Assertions.assertTrue(input.startsWith("a"));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20, 31})
    public void testInteger(int val) {
        Assertions.assertTrue(val % 10 == 0);
    }
}