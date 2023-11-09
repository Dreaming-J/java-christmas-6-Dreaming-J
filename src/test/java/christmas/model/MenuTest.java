package christmas.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import christmas.exception.Exception.OrderException;
import christmas.model.menu.Menu;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @Test
    void 이름으로_메뉴_찾기_테스트() {
        assertAll(
                () -> assertThatThrownBy(() -> Menu.from("라멘"))
                        .isInstanceOf(OrderException.class),
                () -> assertDoesNotThrow(() -> Menu.from("아이스크림"))
        );
    }
}
