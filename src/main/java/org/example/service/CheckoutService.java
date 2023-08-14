package org.example.service;

import org.example.exception.CheckoutException;
import org.example.model.RentalAgreement;
import org.example.model.ToolCode;

import java.util.Date;

public class CheckoutService {
    // discout percent
    // 0-100 ex 20 = 20%
    public RentalAgreement checkout(ToolCode toolCode, int rentalDayCount, int discountPercent, Date checkoutDate)
            throws CheckoutException {
        return null;
    }
}
