package christmas.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.model.date.Date;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class SpecialEventTest {
    @ParameterizedTest(name = "[{index}] 날짜:{0}, 결과:{1}")
    @CsvSource(value = {"3,true", "17,true", "25,true", "1,false", "28,false"})
    void 조건_테스트(int date, boolean isFit) {
        Event specialEvent = new SpecialEvent(new Date(date), 10_000);
        assertEquals(specialEvent.canDiscount(), isFit);
    }

    @ParameterizedTest(name = "[{index}] 디저트 개수:{0}, 결과:{1}")
    @MethodSource("generateData")
    void 할인_적용_테스트(int date, String discount) {
        Event specialEvent = new SpecialEvent(new Date(date), 10_000);
        specialEvent.applyBenefit(date);
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
