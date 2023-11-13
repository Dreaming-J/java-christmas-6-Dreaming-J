package christmas.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.Money;
import christmas.model.date.Date;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class GiveawayEventTest {
    @ParameterizedTest(name = "[{index}] 총주문금액:{0}, 결과:{1}")
    @CsvSource(value = {"119_999,false", "120_000,true"})
    void 조건_테스트(int amountDue, boolean isFit) {
        Event giveawayEvent = new GiveawayEvent(new Date(1), new Money(amountDue));
        assertEquals(giveawayEvent.canDiscount(), isFit);
    }

    @ParameterizedTest(name = "[{index}] 총주문금액:{0}, 결과:{1}")
    @MethodSource("generateData")
    void 할인_적용_테스트(int amountDue, String discount) {
        Event giveawayEvent = new GiveawayEvent(new Date(1), new Money(amountDue));
        giveawayEvent.applyBenefit(0);
        assertEquals(giveawayEvent.toString(), discount);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(119_999, ""),
                Arguments.of(120_000, "증정 이벤트: -25,000원")
        );
    }
}
