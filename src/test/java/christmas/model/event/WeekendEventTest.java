package christmas.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.reservation.date.Date;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class WeekendEventTest {
    @ParameterizedTest(name = "[{index}] 날짜:{0}, 결과:{1}")
    @CsvSource(value = {"1,true", "2,true", "3,false", "4,false", "5,false", "6,false", "7,false"})
    void 조건_테스트(int date, boolean isFit) {
        Event weekendEvent = new WeekendEvent(new Date(date), 10_000);
        assertEquals(weekendEvent.canDiscount(), isFit);
    }

    @ParameterizedTest(name = "[{index}] 디저트 개수:{0}, 결과:{1}")
    @MethodSource("generateData")
    void 할인_적용_테스트(int quantityOfMain, String discount) {
        Event weekendEvent = new WeekendEvent(new Date(1), 10_000);
        weekendEvent.applyBenefit(quantityOfMain);
        assertEquals(weekendEvent.toString(), discount);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(0, ""),
                Arguments.of(1, "주말 할인: -2,023원"),
                Arguments.of(5, "주말 할인: -10,115원")
        );
    }
}
