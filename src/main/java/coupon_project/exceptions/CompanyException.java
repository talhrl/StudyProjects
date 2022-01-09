package coupon_project.exceptions;

public class CompanyException extends Exception {
    public CompanyException() {
        super("General Error");
    }

    public CompanyException(String message) {
        super(message);
    }
}
