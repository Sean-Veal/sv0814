package org.example.exception;

public class RentalDayException extends CheckoutException {
    public RentalDayException() {
        super();
    }

    public RentalDayException(int numberOfDays) {
        super("Rental Day Count Entered: " + numberOfDays + "\n Rental Day Count must at least be 1.");
    }

    public RentalDayException(String message) {
        super(message);
    }

    public RentalDayException(String message, Throwable cause) {
        super(message, cause);
    }

    public RentalDayException(Throwable cause) {
        super(cause);
    }

    protected RentalDayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
