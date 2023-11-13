package christmas.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.date.Date;
import christmas.model.order.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EventTest {
    @ParameterizedTest
    @CsvSource(value = {"양송이수프-1,false", "아이스크림-2,true"})
    void 총주문_금액_10000_적용_테스트(String order, boolean isFit) {
        Event event = new Event(new Date(1), new Order(order)) {
            @Override
            public void applyBenefit() {
            }
        };
        assertEquals(event.canDiscount(), isFit);
    }
}
