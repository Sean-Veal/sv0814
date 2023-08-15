package org.example.service;

import org.example.exception.CheckoutException;
import org.example.exception.DiscountPercentException;
import org.example.exception.RentalDayException;
import org.example.model.RentalAgreement;
import org.example.model.ToolCode;
import org.example.model.ToolInfo;
import org.example.util.CalendarUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CheckoutService {
    // discout percent
    // 0-100 ex 20 = 20%
    public RentalAgreement checkout(ToolCode toolCode, int rentalDayCount, int discountPercent, Date checkoutDate)
            throws CheckoutException {
        if (rentalDayCount <= 0) {
            throw new RentalDayException(rentalDayCount);
        }

        if (discountPercent < 0 || discountPercent > 100) {
            throw new DiscountPercentException(discountPercent);
        }

        ToolInfo toolInfo = ToolInfo.toolInfoMap().get(toolCode);
        Calendar dueDate = new GregorianCalendar();
        dueDate.setTime(checkoutDate);
        dueDate.add(Calendar.DAY_OF_MONTH, rentalDayCount);
        int chargeDays = CalendarUtil.getChargeDays(checkoutDate, toolInfo.getToolType(), rentalDayCount);
        double preDiscountCharge = chargeDays * toolInfo.getToolType().getDailyCharge();
        double discountAmount = discountPercent / 100.0 * preDiscountCharge;
        double finalCharge = preDiscountCharge - discountAmount;

        RentalAgreement.RentalAgreementBuilder rentalAgreementBuilder = new RentalAgreement.RentalAgreementBuilder();
        return rentalAgreementBuilder
                .toolCode(toolCode)
                .toolType(toolInfo.getToolType())
                .toolBrand(toolInfo.getToolBrand())
                .rentalDays(rentalDayCount)
                .checkoutDate(checkoutDate)
                .dueDate(dueDate.getTime())
                .dailyRentalCharge(toolInfo.getToolType().getDailyCharge())
                .chargeDays(chargeDays)
                .preDiscountCharge(preDiscountCharge)
                .discountPercent(discountPercent)
                .discountAmount(discountAmount)
                .finalCharge(finalCharge)
                .build();
    }
}
