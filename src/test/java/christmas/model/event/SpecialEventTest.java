package christmas.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.date.Date;
import christmas.model.order.Order;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class SpecialEventTest {
    private static Order order;

    @BeforeAll
    static void beforeAll() {
        order = new Order("아이스크림-2");
    }

    @ParameterizedTest
    @CsvSource(value = {"3,true", "17,true", "25,true", "1,false", "28,false"})
    void 조건_테스트(int date, boolean isFit) {
        Event specialEvent = new SpecialEvent(new Date(date), order);
        assertEquals(specialEvent.canDiscount(), isFit);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 할인_적용_테스트(int date, String discount) {
        Event specialEvent = new SpecialEvent(new Date(date), order);
        specialEvent.applyBenefit();
        assertEquals(specialEvent.toString(), discount);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(5, ""),
                Arguments.of(10, "특별 할인: -1,000원"),
                Arguments.of(25, "특별 할인: -1,000원"),
                Arguments.of(31, "특별 할인: -1,000원")
        );
    }
}
