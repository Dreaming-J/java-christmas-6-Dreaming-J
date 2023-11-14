package christmas.view;

import static christmas.util.Constant.LINE_BREAK;
import static christmas.view.Message.PRINT_AMOUNT_DUE_TITLE;
import static christmas.view.Message.PRINT_BADGE_TITLE;
import static christmas.view.Message.PRINT_BENEFIT_TITLE;
import static christmas.view.Message.PRINT_DISCOUNTED_AMOUNT_TITLE;
import static christmas.view.Message.PRINT_DISCOUNT_TITLE;
import static christmas.view.Message.PRINT_GIVEAWAY_TITLE;
import static christmas.view.Message.PRINT_ORDER_MENU_TITLE;
import static christmas.view.Message.PRINT_START_PLANNER_MSG;

import christmas.dto.Giveaway;
import christmas.model.Badge;
import christmas.model.EventPlanner;
import christmas.model.Money;
import christmas.model.date.Date;
import christmas.model.order.Order;

public class OutputView {
    public void printStartPlanner() {
        System.out.println(PRINT_START_PLANNER_MSG);
    }

    public void printDate(Date date) {
        System.out.println(date);
    }

    public void printOrder(Order order) {
        printMsg(PRINT_ORDER_MENU_TITLE, order);
    }

    public void printAmountDue(Money amountDue) {
        printMsg(PRINT_AMOUNT_DUE_TITLE, amountDue);
    }

    public void printGiveaway(Giveaway giveaway) {
        printMsg(PRINT_GIVEAWAY_TITLE, giveaway);
    }

    public void printBenefit(EventPlanner eventPlanner) {
        printMsg(PRINT_BENEFIT_TITLE, eventPlanner);
    }

    public void printDiscount(Money discount) {
        printMsg(PRINT_DISCOUNT_TITLE, discount);
    }

    public void printDiscountedAmount(Money discountedAmount) {
        printMsg(PRINT_DISCOUNTED_AMOUNT_TITLE, discountedAmount);
    }

    public void printBadge(Badge badge) {
        printMsg(PRINT_BADGE_TITLE, badge);
    }

    private <T> void printMsg(Message title, T object) {
        System.out.println(LINE_BREAK + title);
        System.out.println(object);
    }
}
