package christmas.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.date.Date;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GiveawayEventTest {
    @ParameterizedTest(name = "[{index}] 총주문금액:{0}, 결과:{1}")
    @CsvSource(value = {"119_999,false", "120_000,true"})
    void 조건_테스트(int amountDue, boolean isFit) {
        Event giveawayEvent = new GiveawayEvent(new Date(1), amountDue);
        assertEquals(giveawayEvent.canDiscount(), isFit);
    }
}
