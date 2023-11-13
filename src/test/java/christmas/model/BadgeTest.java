package christmas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BadgeTest {
    @ParameterizedTest(name = "[{index}] 할인금액: {0}증정 배지: {1}")
    @MethodSource("generateData")
    void 이벤트_배지_부여_테스트(int discount, Badge badge) {
        assertEquals(Badge.from(new Money(discount)), badge);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(3_000, Badge.NOTHING),
                Arguments.of(5_000, Badge.STAR),
                Arguments.of(10_000, Badge.TREE),
                Arguments.of(20_000, Badge.SANTA)
        );
    }
}
