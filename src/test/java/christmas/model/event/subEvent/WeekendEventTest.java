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

public class WeekendEventTest {
    @ParameterizedTest(name = "[{index}] 날짜:{0}, 결과:{1}")
    @CsvSource(value = {"1,true", "2,true", "3,false", "4,false", "5,false", "6,false", "7,false"})
    void 조건_테스트(int date, boolean isFit) {
        Event weekendEvent = new WeekendEvent(new Date(date), new Order("티본스테이크-2"));
        assertEquals(weekendEvent.canDiscount(), isFit);
    }

    @ParameterizedTest(name = "[{index}] 디저트 개수:{0}, 결과:{1}")
    @MethodSource("generateData")
    void 할인_적용_테스트(Order order, String discount) {
        Event weekendEvent = new WeekendEvent(new Date(1), order);
        weekendEvent.applyBenefit();
        assertEquals(weekendEvent.toString(), discount);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new Order("양송이수프-1"), ""),
                Arguments.of(new Order("티본스테이크-1"), "주말 할인: -2,023원"),
                Arguments.of(new Order("해산물파스타-5"), "주말 할인: -10,115원")
        );
    }
}
