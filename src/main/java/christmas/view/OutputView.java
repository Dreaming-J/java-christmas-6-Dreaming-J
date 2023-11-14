package christmas.view;

import static christmas.util.Constant.LINE_BREAK;
import static christmas.view.Message.PRINT_ORDER_MENU_TITLE;
import static christmas.view.Message.PRINT_START_PLANNER_MSG;

import christmas.model.date.Date;
import christmas.model.order.Order;

public class OutputView {
    public void printStartPlanner() {
        System.out.println(PRINT_START_PLANNER_MSG);
    }

    public void printDate(Date date) {
        System.out.println(date + LINE_BREAK);
    }

    public void printOrder(Order order) {
        System.out.println(PRINT_ORDER_MENU_TITLE);
        System.out.println(order);
    }
}
