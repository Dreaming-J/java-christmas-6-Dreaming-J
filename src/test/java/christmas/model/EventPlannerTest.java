package christmas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.date.Date;
import christmas.model.order.Order;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EventPlannerTest {
    @ParameterizedTest(name = "[{index}] {2}")
    @MethodSource("generateData1")
    void 이벤트_혜택_내용_테스트(Date date, Order order, String actual) {
        EventPlanner eventPlanner = new EventPlanner(date, order);
        assertEquals(eventPlanner.toString(), actual);
    }

    private static Stream<Arguments> generateData1() {
        return Stream.of(
                Arguments.of(new Date(5),
                        new Order("타파스-1,제로콜라-1"),
                        "없음"),
                Arguments.of(new Date(29),
                        new Order("티본스테이크-1"),
                        "주말 할인: -2,023원"),
                Arguments.of(new Date(5),
                        new Order("아이스크림-2"),
                        "크리스마스 디데이 할인: -1,400원\n평일 할인: -4,046원"),
                Arguments.of(new Date(2),
                        new Order("티본스테이크-3"),
                        "크리스마스 디데이 할인: -1,100원\n주말 할인: -6,069원\n증정 이벤트: -25,000원"),
                Arguments.of(new Date(3),
                        new Order("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"),
                        "크리스마스 디데이 할인: -1,200원\n평일 할인: -4,046원\n특별 할인: -1,000원\n증정 이벤트: -25,000원")
        );
    }

    @Test
    void 총혜택_계산_테스트() {
        Date date = new Date(3);
        Order order = new Order("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        EventPlanner eventPlanner = new EventPlanner(date, order);
        assertEquals(eventPlanner.totalDiscountWithGiveaway().toString(), "-31,246원");
    }

    @Test
    void 할인_후_예상_결제_금액_계산_테스트() {
        Date date = new Date(3);
        Order order = new Order("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        EventPlanner eventPlanner = new EventPlanner(date, order);
        Money payment = order.amountDue().plus(eventPlanner.totalDiscountWithoutGiveaway());
        assertEquals(payment, new Money(135_754));
    }

    @ParameterizedTest
    @MethodSource("generateData2")
    void 이벤트_배지_부여_테스트(Date date, Order order, Badge badge) {
        EventPlanner eventPlanner = new EventPlanner(date, order);
        assertEquals(eventPlanner.createBadge(), badge);
    }

    private static Stream<Arguments> generateData2() {
        return Stream.of(
                Arguments.of(new Date(5), new Order("타파스-1,제로콜라-1"), Badge.NOTHING),
                Arguments.of(new Date(5), new Order("아이스크림-2"), Badge.STAR),
                Arguments.of(new Date(25), new Order("크리스마스파스타-1,아이스크림-4"), Badge.TREE),
                Arguments.of(new Date(3), new Order("티본스테이크-3"), Badge.SANTA)
        );
    }
}
