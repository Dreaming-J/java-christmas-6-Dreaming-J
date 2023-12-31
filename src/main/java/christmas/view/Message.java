package christmas.view;

public enum Message {
    READ_DATE_MSG("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    READ_ORDER_MSG("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PRINT_START_PLANNER_MSG("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    PRINT_ORDER_MENU_TITLE("<주문 메뉴>"),
    PRINT_AMOUNT_DUE_TITLE("<할인 전 총주문 금액>"),
    PRINT_GIVEAWAY_TITLE("<증정 메뉴>"),
    PRINT_BENEFIT_TITLE("<혜택 내역>"),
    PRINT_DISCOUNT_TITLE("<총혜택 금액>"),
    PRINT_DISCOUNTED_AMOUNT_TITLE("<할인 후 예상 결제 금액>"),
    PRINT_BADGE_TITLE("<12월 이벤트 배지>");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
