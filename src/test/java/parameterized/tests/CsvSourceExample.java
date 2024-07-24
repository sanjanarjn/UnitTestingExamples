package parameterized.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CsvSourceExample {

    @ParameterizedTest
    @CsvSource({
            "0, John",
            "2, Doe"
    })
    public void testCsvSource(int id, String name) {
        assertTrue(id > 0);
        assertNotNull(name);
    }
}
