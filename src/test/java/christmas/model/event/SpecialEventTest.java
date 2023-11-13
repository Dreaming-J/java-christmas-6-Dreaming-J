package christmas.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.reservation.date.Date;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SpecialEventTest {
    @ParameterizedTest(name = "[{index}] 날짜:{0}, 결과:{1}")
    @CsvSource(value = {"3,true", "17,true", "25,true", "1,false", "28,false"})
    void 조건_테스트(int date, boolean isFit) {
        Event specialEvent = new SpecialEvent(new Date(date), 10_000);
        assertEquals(specialEvent.canDiscount(), isFit);
    }
}
