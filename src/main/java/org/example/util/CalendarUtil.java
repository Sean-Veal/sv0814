package org.example.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarUtil {
    public static void julyFourth(int year) {
        Calendar calendar = new GregorianCalendar(year, 7, 5);
        calendar.set(Calendar.DAY_OF_MONTH, 5);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(calendar.toString());
    }
}
