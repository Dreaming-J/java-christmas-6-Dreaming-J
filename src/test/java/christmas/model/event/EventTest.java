package christmas.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.reservation.date.Date;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

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

        @ParameterizedTest(name = "[{index}] 날짜:{1}, 결과:{2}")
        @MethodSource("generateData")
        void 할인_적용_테스트(int amountDue, int date, String discount) {
            Event christmasDdayEvent = new ChristmasDdayEvent(amountDue, new Date(date));
            christmasDdayEvent.applyBenefit();
            assertEquals(christmasDdayEvent.toString(), discount);
        }

        private static Stream<Arguments> generateData() {
            return Stream.of(
                    Arguments.of(10_000, 1, "크리스마스 디데이 할인: -1,000원"),
                    Arguments.of(10_000, 25, "크리스마스 디데이 할인: -3,400원"),
                    Arguments.of(10_000, 30, "")
            );
        }
    }
}
