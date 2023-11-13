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

public class GiveawayEventTest {
    @ParameterizedTest
    @CsvSource(value = {"초코케이크-7,false", "초코케이크-8,true"})
    void 조건_테스트(String menus, boolean isFit) {
        Event giveawayEvent = new GiveawayEvent(new Date(1), new Order(menus));
        assertEquals(giveawayEvent.canDiscount(), isFit);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 할인_적용_테스트(Order order, String discount) {
        Event giveawayEvent = new GiveawayEvent(new Date(1), order);
        giveawayEvent.applyBenefit();
        assertEquals(giveawayEvent.toString(), discount);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new Order("초코케이크-7"), ""),
                Arguments.of(new Order("초코케이크-8"), "증정 이벤트: -25,000원")
        );
    }
}
