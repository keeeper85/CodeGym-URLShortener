package com.codegym.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {

    public static String generateRandomString(){
//        the code generates a random BigInteger with 130 bits of length using a secure random number generator
//        and then converts that BigInteger into a string using base-32 encoding.
//        The resulting string will consist of characters from the set of 0-9 and a-z
//        (digits and lowercase alphabet letters). This can be useful, for example,
//        when you need to generate a random string with a larger character set for cryptographic purposes.

        return new BigInteger(130, new SecureRandom()).toString(32);

//        String ALLOWED_CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyz";
//        SecureRandom secureRandom = new SecureRandom();
//        BigInteger randomLength = new BigInteger(130, secureRandom);
//        StringBuilder randomString = new StringBuilder();
//
//        for (int i = 0; i < randomLength.longValue(); i++) {
//            int randomIndex = secureRandom.nextInt(ALLOWED_CHARACTERS.length());
//            randomString.append(ALLOWED_CHARACTERS.charAt(randomIndex));
//        }
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

}
