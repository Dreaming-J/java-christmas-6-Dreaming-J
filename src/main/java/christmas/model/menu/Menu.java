package christmas.model.menu;

public enum Menu {
    MUSHROOM_CREAM_SOUP(Category.APPETIZER, "양송이수프", 6_000),
    TAPAS(Category.APPETIZER, "타파스", 5_500),
    CAESAR_SALAD(Category.APPETIZER, "시저샐러드", 8_000),
    T_BONE_STEAK(Category.MAIN, "티본스테이크", 55_000),
    BARBECUE_RIBS(Category.MAIN, "바비큐립", 54_000),
    SEAFOOD_PASTA(Category.MAIN, "해산물파스타", 35_000),
    CHRISTMAS_PASTA(Category.MAIN, "크리스마스파스타", 25_000),
    CHOCOLATE_CAKE(Category.DESSERT, "초코케이크", 15_000),
    ICECREAM(Category.DESSERT, "아이스크림", 5_000),
    COKE_ZERO(Category.DRINK, "제로콜라", 3_000),
    RED_WINE(Category.DRINK, "레드와인", 60_000),
    CHAMPAGNE(Category.DRINK, "샴페인", 25_000);

    private final Category category;
    private final String name;
    private final int price;

    Menu(Category category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }
}
