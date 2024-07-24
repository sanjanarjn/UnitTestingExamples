package parameterized.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

public class ArgumentsSourceExample {

    @ParameterizedTest
    @ArgumentsSource(StringArgProvider.class)
    public void testArgumentsSource(String meal) {
        Assertions.assertNotNull(meal);
    }
}

class StringArgProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext
                                                        extensionContext) {
        return Stream.of(
                Arguments.of("tacos"),
                Arguments.of("burrito")
        );
    }
}