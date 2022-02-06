package coupon_project.utils;

public class NumberUtils {
    public static int getAmount() {
        final int MAX_AMOUNT = 25;
        final int MIN_AMOUNT = 10;
        return (int) (Math.random() * (MAX_AMOUNT - MIN_AMOUNT + 1)) + MIN_AMOUNT;
    }

    public static double getPrice() {
        final int MAX_PRICE = 100;
        final int MIN_PRICE = 20;
        return (int)(Math.random() * (MAX_PRICE*100 - MIN_PRICE*100 + 1) + MIN_PRICE*100)/100.00;
    }
}
