package christmas.controller;

import christmas.view.OutputView;

public class EventPlannerController {
    private final OutputView outputView;

    public EventPlannerController() {
        outputView = new OutputView();
    }

    public void start() {
        outputView.printStartPlanner();
    }
}
