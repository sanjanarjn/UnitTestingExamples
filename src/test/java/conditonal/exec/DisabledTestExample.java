package conditonal.exec;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
public class DisabledTestExample {
   @Test
   @Disabled("Disabled until issue #1234 fixed")
   public void thisIsADisabledTest() {
   }
   @Test
   public void thisIsAnEnabledTest() {
   } }