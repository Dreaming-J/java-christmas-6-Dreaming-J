package christmas.model.event;

public enum EventMsg {
    CHRISTMAS_DDAY_EVENT_MSG("크리스마스 디데이 할인: %s"),
    WEEKDAY_EVENT_MSG("평일 할인: %s"),
    WEEKEND_EVENT_MSG("주말 할인: %s"),
    SPECIAL_EVENT_MSG("특별 할인: %s"),
    GIVEAWAY_EVENT_MSG("증정 이벤트: %s");


    private final String message;

    EventMsg(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
