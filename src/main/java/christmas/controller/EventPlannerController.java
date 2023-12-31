package christmas.controller;

import christmas.dto.Reservation;
import christmas.model.EventPlanner;
import christmas.model.Money;
import christmas.model.date.Date;
import christmas.model.order.Order;
import christmas.module.RepeatModule;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController extends RepeatModule {
    private final InputView inputView;
    private final OutputView outputView;
    private Reservation reservation;

    public EventPlannerController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        outputView.printStartPlanner();
        reserve();
        showReserve();
        previewEvent();
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
        reservation = new Reservation(reserveDate, reserveOrder);
    }

    private void showReserve() {
        outputView.printDate(reservation.date());
        outputView.printOrder(reservation.order());
        outputView.printAmountDue(reservation.order().amountDue());
    }

    private void previewEvent() {
        EventPlanner eventPlanner = new EventPlanner(reservation.date(), reservation.order());
        outputView.printGiveaway(eventPlanner.getGiveaway());
        outputView.printBenefit(eventPlanner);
        outputView.printDiscount(eventPlanner.totalDiscountWithGiveaway());
        Money discountedAmount = reservation.order()
                .amountDue()
                .plus(eventPlanner.totalDiscountWithoutGiveaway());
        outputView.printDiscountedAmount(discountedAmount);
        outputView.printBadge(eventPlanner.createBadge());
    }
}
