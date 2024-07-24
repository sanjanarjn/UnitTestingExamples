package parameterized.tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.DayOfWeek;

import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

public class EnumSourceExample {

    @ParameterizedTest
    @EnumSource(DayOfWeek.class)
    public void testEnumValue(DayOfWeek dayOfWeek) {
        Assertions.assertTrue(dayOfWeek instanceof DayOfWeek);
    }

    @ParameterizedTest
    @EnumSource(names = {"SUNDAY", "SATURDAY"})
    public void testEnumValueWeekend(DayOfWeek dayOfWeek) {
        Assertions.assertTrue(dayOfWeek instanceof DayOfWeek);
    }

    @ParameterizedTest
    @EnumSource(mode = EXCLUDE, names = {"SUNDAY", "SATURDAY"})
    public void testEnumValueWeekDay(DayOfWeek dayOfWeek) {
        Assertions.assertTrue(dayOfWeek instanceof DayOfWeek);
    }

}
