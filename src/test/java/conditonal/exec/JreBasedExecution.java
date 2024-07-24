package conditonal.exec;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;

import static org.junit.jupiter.api.condition.JRE.*;
import static org.junit.jupiter.api.condition.JRE.JAVA_15;

public class JreBasedExecution {

    @Test
    @EnabledOnJre(JAVA_21)
    void enabledForJava21() {
    }

    @Test
    @EnabledOnJre({JAVA_20})
    void enabledForJava20AndJava21() {
    }

    @Test
    @EnabledForJreRange(max=JAVA_21)
    void enabledUntilJava21() {
    }

    @Test
    @EnabledForJreRange(min = JAVA_8, max=JAVA_15)
    void enabledForJava8ToJava15() {
    }


}

