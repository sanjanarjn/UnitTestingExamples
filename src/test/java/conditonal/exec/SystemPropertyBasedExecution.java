package conditonal.exec;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

public class SystemPropertyBasedExecution {

    static {
        System.setProperty("my.property", "value-1");
    }

    @Test
    @EnabledIfSystemProperty(named = "my.property", matches = "value-[0-9]+")
    void testEnabledIfPropertySetRegex() {
    }

    @Test
    @EnabledIfSystemProperty(named = "my.property", matches = "value")
    void testEnabledIfPropertySet() {
    }
}
