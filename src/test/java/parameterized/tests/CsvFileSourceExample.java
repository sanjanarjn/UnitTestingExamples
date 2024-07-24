package parameterized.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CsvFileSourceExample {

    @ParameterizedTest
    @CsvFileSource(resources = "/persons.csv", numLinesToSkip = 1)
    public void testCsvFileSource(int id, String name) {
        assertTrue(id > 0);
        assertNotNull(name);
    }
}
