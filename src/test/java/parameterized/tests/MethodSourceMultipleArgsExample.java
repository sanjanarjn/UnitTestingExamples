package parameterized.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MethodSourceMultipleArgsExample {

    @ParameterizedTest
    @MethodSource("multipleArguments")
    void testMultipleArguments(int id, String name,
                               List<String> contacts) {
        assertTrue(id > 0);
        assertNotNull(name);
        assertNotNull(contacts);
    }

    static List<Arguments> multipleArguments() {
        return Arrays.asList(
                arguments(1, "John", Arrays.asList("123451", "123452")),
                arguments(2, "Doe", Arrays.asList("678901", "678902"))
        );
    }
}
