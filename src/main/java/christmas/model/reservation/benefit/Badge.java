package christmas.model.reservation.benefit;

import christmas.exception.Exception.BadgeException;
import java.util.stream.Stream;

public enum Badge {
    SANTA(20_000, "산타"),
    TREE(10_000, "트리"),
    STAR(5_000, "별"),
    NOTHING(0, "없음");

    private final int condition;
    private final String name;

    Badge(int condition, String name) {
        this.condition = condition;
        this.name = name;
    }

    public static Badge from(int discount) {
        return Stream.of(values())
                .filter(badge -> badge.isMoreCondition(discount))
                .findFirst()
                .orElseThrow(BadgeException::new);
    }

    private boolean isMoreCondition(int discount) {
        return discount >= this.condition;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
