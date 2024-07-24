package parameterized.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MethodSourceExample {

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String fruit) {
        assertNotNull(fruit);
    }
    static List<String> stringProvider() {
        return Arrays.asList("apple", "banana");
    }

    @ParameterizedTest
    @MethodSource
    void testImplicitMethodSource(String vehicle) {
        assertNotNull(vehicle);
    }

    static List<String> testImplicitMethodSource() {
        return Arrays.asList("car", "truck");
    }
}
