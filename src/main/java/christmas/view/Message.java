package christmas.view;

public enum Message {
    START_PLANNER_MSG("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
