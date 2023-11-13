package christmas.model.reservation.order;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.exception.Exception.OrderException;
import christmas.model.order.Order;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OrderTest {
    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("generateData")
    void 다양한_주문_유효성_테스트(String orders, String message) {
        assertThatThrownBy(() -> new Order(orders))
                .isInstanceOf(OrderException.class);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("", "미입력 주문"),
                Arguments.of("양송이수프,5", "주문 형식이 다른 주문"),
                Arguments.of("제로콜라-1,레드와인-5", "음료만 주문"),
                Arguments.of("딸기케이크-5", "메뉴판에 없는 메뉴 주문"),
                Arguments.of("티본스테이크-1,레드와인-5,티본스테이크-1", "중복된 메뉴 주문"),
                Arguments.of("크리스마스파스타-열개", "숫자가 아닌 개수 주문"),
                Arguments.of("타파스-0,시저샐러드-5", "1 미만의 개수 주문"),
                Arguments.of("바비큐립-5,아이스크림-10,제로콜라-5,샴페인-1", "메뉴 합계 20개 초과 주문")
        );
    }

    @Test
    void 총주문_금액_계산_테스트() {
        Order order = new Order("양송이수프-2,티본스테이크-1,초코케이크-2,레드와인-1");
        assertEquals(order.amountDue(), 157_000);
    }

    @Test
    void 디저트_주문_개수_계산_테스트() {
        Order order = new Order("양송이수프-2,아이스크림-4,초코케이크-2,레드와인-1");
        assertEquals(order.countDessert(), 6);
    }

    @Test
    void 메인_주문_개수_계산_테스트() {
        Order order = new Order("양송이수프-2,티본스테이크-4,초코케이크-2,크리스마스파스타-1");
        assertEquals(order.countMain(), 5);
    }
}
