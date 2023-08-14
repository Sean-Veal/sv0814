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

    private double dailyRentalCharge;

    // Count of chargeable days, from day AFTER checkout through and including due date
    // Excluding no charge days
    private int chargeDays;

    // Charge Days X Daily Rental Charge.
    // Cents Rounded ex 44.899 -> 44.90
    private double preDiscountCharge;

    // Checkout
    private int discountPercent;

    // Resulted from discount percent and pre discount charge
    // Cents rounded
    private double discountAmount;

    // Pre discount charge - discount amount
    private double finalCharge;

    public void print() {
              String printValue = "Tool code: " + toolCode +
                "\n Tool type: " + toolType +
                "\n Tool brand: " + toolBrand +
                "\n Rental days: " + rentalDays +
                "\n Checkout date: " + checkoutDate +
                "\n Due date: " + dueDate +
                "\n Daily Rental Charge: " + dailyRentalCharge +
                "\n Charge days: " + chargeDays +
                "\n Pre Discount Charge: " + preDiscountCharge +
                "\n Discount Percent: " + discountPercent +
                "\n Discount Amount: " + discountAmount +
                "\n Final Charge: " + finalCharge;
    }
}
