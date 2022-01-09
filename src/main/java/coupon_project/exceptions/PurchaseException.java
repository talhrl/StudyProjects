package coupon_project.exceptions;

public class PurchaseException extends Exception {
    public PurchaseException() {
        super("General Error");
    }

    public PurchaseException(String message) {
        super(message);
    }
}