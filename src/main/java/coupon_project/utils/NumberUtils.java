package coupon_project.utils;

public class NumberUtils {
    public static int getAmount() {
        final int MAX_AMOUNT = 25;
        final int MIN_AMOUNT = 10;
        return (int) (Math.random() * (MAX_AMOUNT - MIN_AMOUNT + 1)) + MIN_AMOUNT;
    }

    public static double getPrice() {
        final int MAX_PRICE = 90;
        final int MIN_PRICE = 20;
        return Math.random() * (MAX_PRICE - MIN_PRICE + 1) + MIN_PRICE;
    }
}
