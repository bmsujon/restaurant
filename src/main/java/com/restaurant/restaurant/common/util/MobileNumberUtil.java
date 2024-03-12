package com.restaurant.restaurant.common.util;


public class MobileNumberUtil {
    public static boolean isValidNumber(String mobileNumber) {

        if (mobileNumber.length() == 14 && mobileNumber.startsWith("+880")) {
            //Take the last 10 digit and check that it only contains number
            String subString = mobileNumber.substring(4, mobileNumber.length() - 1);
            return subString.matches("[0-9]+");
        }

        return false;
    }


}
