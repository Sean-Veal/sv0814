package org.example.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class FormatUtil {
    public static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
}
