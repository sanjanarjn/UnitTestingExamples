package conditonal.exec;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.jupiter.api.condition.OS.*;

public class OsSpecificExecution {

    @Test
    @EnabledOnOs({MAC})
    public void runOnMac() {
    }

    @Test
    @DontTestOnMac
    public void doNotRunOnMac() {
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Test
@DisabledOnOs(MAC)
@interface DontTestOnMac {
}
