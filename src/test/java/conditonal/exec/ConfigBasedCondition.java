package conditonal.exec;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigBasedCondition implements ExecutionCondition {

    private static final ConditionEvaluationResult ENABLED_BY_DEFAULT = ConditionEvaluationResult.enabled("Enabled by default");

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        boolean doNotNeedToRunTests = checkIfTestsNeedToRun();
        if (doNotNeedToRunTests) {
            return ConditionEvaluationResult.disabled("Tests are disabled by configuration");
        }
        return ENABLED_BY_DEFAULT;
    }

    private boolean checkIfTestsNeedToRun() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {

            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException();
        }

        String runTestsProp = properties.getProperty("run.tests");
        boolean needToRunTests = "false".equalsIgnoreCase(runTestsProp);
        return needToRunTests;
    }
}
