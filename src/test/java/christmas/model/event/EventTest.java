package christmas.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.date.Date;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
