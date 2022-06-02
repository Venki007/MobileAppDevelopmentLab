package com.biet;

public class PasswordUtil {

    public static int MIN_LENGTH = 8;
    public static boolean validatePassword(String pwd){
        String password = pwd.trim();
        int sLen = password.length();

        //Min length check
        if (sLen < MIN_LENGTH) return false;
        //Check for special characters
        if (!(password.contains("@") || password.contains("#")
                || password.contains("!") || password.contains("~")
                || password.contains("$") || password.contains("%")
                || password.contains("^") || password.contains("&")
                || password.contains("*") || password.contains("(")
                || password.contains(")") || password.contains("-")
                || password.contains("+") || password.contains("/")
                || password.contains(":") || password.contains(".")
                || password.contains(", ") || password.contains("<")
                || password.contains(">") || password.contains("?")
                || password.contains("|")) ) return false;

        char[] pwdCharArray = password.toCharArray();
        int numCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        for (char ch : pwdCharArray) {
            if ('0' <= ch && ch <= '9') numCount++;
            if ( 'a' <= ch && ch <= 'z') lowerCount++;
            if( 'A' <= ch && ch <= 'Z') upperCount++;
        }
        //check for Numbers
        //check for lowercase letters
        //check for uppercase letters
        if(numCount == 0 || lowerCount==0 || upperCount == 0 )
            return false;

        return true;
    }
}
