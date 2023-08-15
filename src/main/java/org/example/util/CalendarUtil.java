package org.example.util;

import org.example.model.ToolType;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarUtil {
    public static Calendar independenceDay(int year) {
        Calendar calendar = new GregorianCalendar(year, Calendar.JULY, 5);
        calendar.set(Calendar.DAY_OF_MONTH, 5);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return calendar;
    }

    public static Calendar laborDay(int year) {
        Calendar calendar = new GregorianCalendar(year, Calendar.SEPTEMBER, 1);
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return calendar;
    }

    public static int getChargeDays(Date checkoutDate, ToolType toolType, int rentalDays) {
        int chargeDays = 0;
        Calendar days = new GregorianCalendar();
        days.setTime(checkoutDate);
        for (int i = 0; i < rentalDays; i++) {
            days.add(Calendar.DAY_OF_MONTH, 1);
            if (0 == days.compareTo(laborDay(days.get(Calendar.YEAR))) || 
                    0 == days.compareTo(independenceDay(days.get(Calendar.YEAR)))) {
                if (toolType.isHolidayCharge()) {
                    chargeDays++;
                }
            } else if (days.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                    days.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                if (toolType.isWeekendCharge()) {
                    chargeDays++;
                }
            } else if (toolType.isWeekdayCharge()) {
                chargeDays++;
            }
        }

        return chargeDays;
    }
}
