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
        assertEquals(event.canDiscount(), isFit);
    }

    @DisplayName("크리스마스 디데이 할인")
    @Nested
    class ChristmasDdayEventTest {
        @ParameterizedTest(name = "[{index}] 날짜:{0}, 결과:{1}")
        @CsvSource(value = {"1,true", "25,true", "30,false"})
        void 조건_테스트(int date, boolean isFit) {
            Event christmasDdayEvent = new ChristmasDdayEvent(new Date(date), 10_000);
            assertEquals(christmasDdayEvent.canDiscount(), isFit);
        }

        @ParameterizedTest(name = "[{index}] 날짜:{0}, 결과:{1}")
        @MethodSource("generateData")
        void 할인_적용_테스트(int date, String discount) {
            Event christmasDdayEvent = new ChristmasDdayEvent(new Date(date), 10_000);
            christmasDdayEvent.applyBenefit(date);
            assertEquals(christmasDdayEvent.toString(), discount);
        }

        private static Stream<Arguments> generateData() {
            return Stream.of(
                    Arguments.of(1, "크리스마스 디데이 할인: -1,000원"),
                    Arguments.of(25, "크리스마스 디데이 할인: -3,400원"),
                    Arguments.of(30, "")
            );
        }
    }

    @DisplayName("평일 할인")
    @Nested
    class WeekdayEventTest {
        @ParameterizedTest(name = "[{index}] 날짜:{0}, 결과:{1}")
        @CsvSource(value = {"1,false", "2,false", "3,true", "4,true", "5,true", "6,true", "7,true"})
        void 조건_테스트(int date, boolean isFit) {
            Event weekdayEvent = new WeekdayEvent(new Date(date), 10_000);
            assertEquals(weekdayEvent.canDiscount(), isFit);
        }

        @ParameterizedTest(name = "[{index}] 디저트 개수:{0}, 결과:{1}")
        @MethodSource("generateData")
        void 할인_적용_테스트(int quantityOfDessert, String discount) {
            Event weekdayEvent = new WeekdayEvent(new Date(3), 10_000);
            weekdayEvent.applyBenefit(quantityOfDessert);
            assertEquals(weekdayEvent.toString(), discount);
        }

        private static Stream<Arguments> generateData() {
            return Stream.of(
                    Arguments.of(0, ""),
                    Arguments.of(1, "평일 할인: -2,023원"),
                    Arguments.of(5, "평일 할인: -10,115원")
            );
        }
    }
}
