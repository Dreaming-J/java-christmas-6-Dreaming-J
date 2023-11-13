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
        Event event = new Event(new Date(1), amountDue) {
            @Override
            public void applyBenefit(int applicableTarget) {
            }
        };
        assertEquals(event.isFitCondition(), isFit);
    }

    @DisplayName("크리스마스 디데이 할인")
    @Nested
    class ChristmasDdayEventTest {
        @ParameterizedTest(name = "[{index}] 날짜:{1}, 결과:{2}")
        @CsvSource(value = {"1,10_000,true", "25,10_000,true", "30,10_000,false"})
        void 조건_테스트(int date, int amountDue, boolean isFit) {
            Event christmasDdayEvent = new ChristmasDdayEvent(new Date(date), amountDue);
            assertEquals(christmasDdayEvent.isFitCondition(), isFit);
        }

        @ParameterizedTest(name = "[{index}] 날짜:{1}, 결과:{2}")
        @MethodSource("generateData")
        void 할인_적용_테스트(int date, int amountDue, String discount) {
            Event christmasDdayEvent = new ChristmasDdayEvent(new Date(date), amountDue);
            christmasDdayEvent.applyBenefit(date);
            assertEquals(christmasDdayEvent.toString(), discount);
        }

        private static Stream<Arguments> generateData() {
            return Stream.of(
                    Arguments.of(1, 10_000, "크리스마스 디데이 할인: -1,000원"),
                    Arguments.of(25, 10_000, "크리스마스 디데이 할인: -3,400원"),
                    Arguments.of(30, 10_000, "")
            );
        }
    }
}
