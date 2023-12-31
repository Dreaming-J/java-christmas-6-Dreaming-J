package christmas.model.event.subEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.date.Date;
import christmas.model.event.Event;
import christmas.model.order.Order;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class WeekdayEventTest {
    @ParameterizedTest(name = "[{index}] 날짜:{0}, 결과:{1}")
    @CsvSource(value = {"1,false", "2,false", "3,true", "4,true", "5,true", "6,true", "7,true"})
    void 조건_테스트(int date, boolean isFit) {
        Event weekdayEvent = new WeekdayEvent(new Date(date), new Order("아이스크림-2"));
        assertEquals(weekdayEvent.canDiscount(), isFit);
    }

    @ParameterizedTest(name = "[{index}] 디저트 개수:{0}, 결과:{1}")
    @MethodSource("generateData")
    void 할인_적용_테스트(Order order, String discount) {
        Event weekdayEvent = new WeekdayEvent(new Date(3), order);
        weekdayEvent.applyBenefit();
        assertEquals(weekdayEvent.toString(), discount);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new Order("타파스-1"), ""),
                Arguments.of(new Order("초코케이크-1"), "평일 할인: -2,023원"),
                Arguments.of(new Order("아이스크림-5"), "평일 할인: -10,115원")
        );
    }
}
