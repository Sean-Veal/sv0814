package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.util.FormatUtil;

import java.util.Date;

@Getter
@Setter
@Builder
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
                "\n Checkout date: " + FormatUtil.dateFormatter.format(checkoutDate) +
                "\n Due date: " + FormatUtil.dateFormatter.format(dueDate) +
                "\n Daily Rental Charge: " + FormatUtil.currencyFormatter.format(dailyRentalCharge) +
                "\n Charge days: " + chargeDays +
                "\n Pre Discount Charge: " + FormatUtil.currencyFormatter.format(preDiscountCharge) +
                "\n Discount Percent: " + FormatUtil.percentFormat.format(discountPercent / 100.0) +
                "\n Discount Amount: " + FormatUtil.currencyFormatter.format(discountAmount) +
                "\n Final Charge: " + FormatUtil.currencyFormatter.format(finalCharge);
        System.out.println("Rental Agreement\n " + printValue);
    }

    public static class RentalAgreementBuilder {
        public RentalAgreementBuilder() {}
    }


}
