package christmas.model.event;

public enum EventMsg {
    CHRISTMAS_DDAY_EVENT_MSG("크리스마스 디데이 할인: -%s원");


    private final String message;

    EventMsg(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
