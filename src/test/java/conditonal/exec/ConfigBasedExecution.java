package conditonal.exec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class ConfigBasedExecution {

    @Test
    @ExtendWith(ConfigBasedCondition.class)
    public void enabledBasedOnCustomCondition() {
        Assertions.assertTrue(true);
    }
}
