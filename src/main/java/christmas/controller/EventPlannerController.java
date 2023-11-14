package christmas.controller;

import christmas.model.date.Date;
import christmas.model.order.Order;
import christmas.module.RepeatModule;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController extends RepeatModule {
    private final InputView inputView;
    private final OutputView outputView;

    public EventPlannerController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        outputView.printStartPlanner();
        reserve();
    }

    private void reserve() {
        Date reserveDate = repeat(() -> {
            int date = inputView.readDate();
            return new Date(date);
        });
        Order reserveOrder = repeat(() -> {
            String order = inputView.readOrder();
            return new Order(order);
        });
    }
}
