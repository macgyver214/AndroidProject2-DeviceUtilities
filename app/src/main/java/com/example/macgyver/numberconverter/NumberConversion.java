package com.example.macgyver.numberconverter;

/**
 * Class to handle the base conversion of one int. It contains a constructor to set up instance variables and a method to handle the conversion.
 * Created by MacGyver on 9/7/2016.
 */
public class NumberConversion {

    String intArg = null;
    String baseArg = null;
    String newBase = null;

    private static final int BASE10 = 10;

    /**
     * Constructor for a NumberConversion object.
     * @param intArg the integer string passed from the EditText on the interface
     * @param baseArg the base of the number input passed from the EditText on the interface
     * @param newBase the desired base output passed from the EditText on the interface
     */
    public NumberConversion(String intArg, String baseArg, String newBase) {
        this.intArg = intArg;
        this.baseArg = baseArg;
        this.newBase = newBase;
    }

    /**
     * The convert method to switch bases of a given number. catches any NumberFormatException thrown by parseInt.
     * @return The string integer or a null string if parseInt throws an exception
     */
    public String baseConvert() {
        try {
            Integer parsedBase = Integer.parseInt(this.baseArg, BASE10);
            Integer parsedInt = Integer.parseInt(this.intArg, parsedBase);
            Integer parsedNewBase = Integer.parseInt(this.newBase, BASE10);
            String convertedInt = Integer.toString(parsedInt, parsedNewBase);

            return convertedInt;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
