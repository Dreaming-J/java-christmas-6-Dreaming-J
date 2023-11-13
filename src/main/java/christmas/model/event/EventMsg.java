package christmas.model.event;

public enum EventMsg {
    CHRISTMAS_DDAY_EVENT_MSG("크리스마스 디데이 할인: -%s원"),
    WEEKDAY_EVENT_MSG("평일 할인: -%s원"),
    WEEKEND_EVENT_MSG("주말 할인: -%s원"),
    SPECIAL_EVENT_MSG("특별 할인: -%s원"),
    GIVEAWAY_EVENT_MSG("증정 이벤트: -%s원");


    private final String message;

    EventMsg(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
