package parameterized.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExternalSourceExample {

    @ParameterizedTest
    @MethodSource("params.source.ExternalParamsProvider#veggieProvider")
    void testWithExternalMethodSource(String fruit) {
        assertNotNull(fruit);
    }
}
