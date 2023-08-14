package org.example.util;

public class MathUtil {
    public static double rounded(double entry) {
        return (double) Math.round(entry * 100) / 100;
    }
}
