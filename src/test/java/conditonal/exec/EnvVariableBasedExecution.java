package conditonal.exec;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;


public class EnvVariableBasedExecution {

    @Test
    @EnabledIfEnvironmentVariable(named = "MY_ENV_VAR", matches = "true")
    void testEnabledIfEnvVarSet() {
        System.out.println("This test runs if MY_ENV_VAR is set to true");
    }
}
