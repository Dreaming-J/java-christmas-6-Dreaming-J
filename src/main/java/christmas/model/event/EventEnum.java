package christmas.model.event;

public enum EventEnum {
    CHRISTMAS_DDAY, WEEKDAY, WEEKEND, SPECIAL, GIVEAWAY;

    public boolean isDiscountEvent() {
        return this != GIVEAWAY;
    }
}
