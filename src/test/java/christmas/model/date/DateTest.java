package christmas.model.date;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import christmas.exception.Exception.DateException;
import org.junit.jupiter.api.Test;

public class DateTest {
    @Test
    void 날짜_유효성_테스트() {
        assertAll(
                () -> assertThatThrownBy(() -> new Date(0))
                        .isInstanceOf(DateException.class),
                () -> assertThatThrownBy(() -> new Date(32))
                        .isInstanceOf(DateException.class),
                () -> assertDoesNotThrow(() -> new Date(1)),
                () -> assertDoesNotThrow(() -> new Date(31))
        );
    }
}
