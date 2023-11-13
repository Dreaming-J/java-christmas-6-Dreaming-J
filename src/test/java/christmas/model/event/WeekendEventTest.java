package christmas.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.reservation.date.Date;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WeekendEventTest {
    @ParameterizedTest(name = "[{index}] 날짜:{0}, 결과:{1}")
    @CsvSource(value = {"1,true", "2,true", "3,false", "4,false", "5,false", "6,false", "7,false"})
    void 조건_테스트(int date, boolean isFit) {
        Event weekendEvent = new WeekendEvent(new Date(date), 10_000);
        assertEquals(weekendEvent.canDiscount(), isFit);
    }
}
