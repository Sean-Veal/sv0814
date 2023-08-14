package org.example.service;

import org.example.exception.CheckoutException;
import org.example.model.ToolCode;

import java.util.Date;

public class CheckoutService {
    // discout percent
    // 0-100 ex 20 = 20%
    public void checkout(ToolCode toolCode, int rentalDayCount, int discountPercent, Date checkoutDate)
            throws CheckoutException {

    }
}
