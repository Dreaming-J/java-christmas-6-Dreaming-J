package christmas.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.exception.Exception.OrderException;
import christmas.model.menu.Menu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MenuTest {
    @Test
    void 이름으로_메뉴_찾기_테스트() {
        assertAll(
                () -> assertThatThrownBy(() -> Menu.from("라멘"))
                        .isInstanceOf(OrderException.class),
                () -> assertDoesNotThrow(() -> Menu.from("아이스크림"))
        );
    }

    @ParameterizedTest
    @CsvSource(value =
            {"바비큐립,true,false,false",
                    "초코케이크,false,true,false",
                    "레드와인,false,false,true",
                    "타파스,false,false,false"})
    void 카테고리_판단_테스트(String food, boolean isMain, boolean isDessert, boolean isDrink) {
        assertAll(
                () -> assertEquals(Menu.from(food).isMain(), isMain),
                () -> assertEquals(Menu.from(food).isDessert(), isDessert),
                () -> assertEquals(Menu.from(food).isDrink(), isDrink)
        );
    }
}
