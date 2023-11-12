package christmas.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.reservation.date.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EventTest {
    @ParameterizedTest
    @CsvSource(value = {"9_999,false", "10_000,true"})
    void 총주문_금액_10000_적용_테스트(int amountDue, boolean isFit) {
        Event event = new Event(amountDue) {
            @Override
            public void applyBenefit() {
            }
        };
        assertEquals(event.isFitCondition(), isFit);
    }

    @DisplayName("크리스마스 디데이 할인")
    @Nested
    class ChristmasDdayEventTest {
        @ParameterizedTest(name = "[{index}] 날짜:{1}, 결과:{2}")
        @CsvSource(value = {"10_000,1,true", "10_000,25,true", "10_000,30,false"})
        void 조건_테스트(int amountDue, int date, boolean isFit) {
            Event christmasDdayEvent = new ChristmasDdayEvent(amountDue, new Date(date));
            assertEquals(christmasDdayEvent.isFitCondition(), isFit);
        }
    }
}
