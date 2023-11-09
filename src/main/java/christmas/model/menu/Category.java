package christmas.model.menu;

public enum Category {
    APPETIZER, MAIN, DESSERT, DRINK;

    public boolean isMain() {
        return this == MAIN;
    }

    public boolean isDessert() {
        return this == DESSERT;
    }

    public boolean isDrink() {
        return this == DRINK;
    }
}
