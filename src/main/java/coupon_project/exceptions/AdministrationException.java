package coupon_project.exceptions;

public class AdministrationException extends Exception {
    public AdministrationException() {
        super("General Error");
    }

    public AdministrationException(String message) {
        super(message);
    }
}
