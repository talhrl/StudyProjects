package coupon_project.utils;

public class NumberUtils {
    public static int getAmount() {
        return (int) (Math.random() * 16) + 10;
    }

    public static double getPrice() {
        return Math.random() * 71 + 20;
    }
}
