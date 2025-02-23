package main.java.homeworks.homework08.util;

public class ProcessingDataInput {

    public static int parseCount (String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException ("Невалидное значение метода parseCount");
        }
    }

    public static int validateCount (String str) {
        try {
            return parseCount(str);
        } catch (NumberFormatException e) {
            throw new  IllegalArgumentException ("Невалидное значение метода validateCount");
        }
    }

    public static double parseNumber (String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение метода parseNumber");
        }
    }

    public static double validateNumber (String str) {
        try {
            return parseNumber(str);
        } catch (NumberFormatException e) {
            throw new  IllegalArgumentException ("Невалидное значение метода validateNumber");
        }
    }
}
