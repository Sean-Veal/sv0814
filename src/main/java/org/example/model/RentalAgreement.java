package org.example.model;

import java.util.Date;

public class RentalAgreement {
    // Specified at checkout
    private ToolCode toolCode;
    // From Tool Info
    private ToolType toolType;
    private ToolBrand toolBrand;
    // Checkout
    private int rentalDays;
    private Date checkoutDate;

    // Calculated from rental Days and checkout date
    private Date dueDate;
    
}
