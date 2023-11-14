package christmas.view;

import static christmas.util.Constant.LINE_BREAK;
import static christmas.view.Message.PRINT_START_PLANNER_MSG;

import christmas.model.date.Date;

public class OutputView {
    public void printStartPlanner() {
        System.out.println(PRINT_START_PLANNER_MSG);
    }

    public void printDate(Date date) {
        System.out.println(date + LINE_BREAK);
    }
}
