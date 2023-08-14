package org.example.exception;

public class DiscountPercentException extends CheckoutException {
    public DiscountPercentException() {
        super();
    }

    public DiscountPercentException(int discountPercent) {
        super("The discount percent you've entered: " + discountPercent + "\n " +
                "Please enter a discount percent between 0 and 100");
    }

    public DiscountPercentException(String message) {
        super(message);
    }

    public DiscountPercentException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiscountPercentException(Throwable cause) {
        super(cause);
    }

    protected DiscountPercentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
