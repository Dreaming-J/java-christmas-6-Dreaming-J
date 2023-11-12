package christmas.model.reservation.date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DayTest {
    @ParameterizedTest
    @MethodSource("generateData")
    void 요일_계산_테스트(int num, Day day) {
        assertEquals(Day.from(num), day);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(1, Day.FRIDAY),
                Arguments.of(23, Day.SATURDAY),
                Arguments.of(17, Day.SUNDAY),
                Arguments.of(25, Day.MONDAY),
                Arguments.of(5, Day.TUESDAY),
                Arguments.of(20, Day.WEDNESDAY),
                Arguments.of(7, Day.THURSDAY)
        );
    }

    @Test
    void 평일_테스트() {
        assertTrue(Day.from(1)
                .isWeekday());
    }

    @Test
    void 주말_테스트() {
        assertTrue(Day.from(24)
                .isWeekend());
    }
}
