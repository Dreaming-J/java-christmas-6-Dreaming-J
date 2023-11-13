package christmas.model.event.subEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.date.Date;
import christmas.model.event.Event;
import christmas.model.order.Order;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ChristmasDdayEventTest {
    private static Order order;

    @BeforeAll
    static void beforeAll() {
        order = new Order("아이스크림-2");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "25,true", "30,false"})
    void 조건_테스트(int date, boolean isFit) {
        Event christmasDdayEvent = new ChristmasDdayEvent(new Date(date), order);
        assertEquals(christmasDdayEvent.canDiscount(), isFit);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 할인_적용_테스트(int date, String discount) {
        Event christmasDdayEvent = new ChristmasDdayEvent(new Date(date), order);
        christmasDdayEvent.applyBenefit();
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
