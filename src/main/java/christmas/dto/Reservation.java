package christmas.dto;

import christmas.model.date.Date;
import christmas.model.order.Order;

public record Reservation(Date date, Order order) {

}
