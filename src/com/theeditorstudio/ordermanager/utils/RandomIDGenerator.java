package com.theeditorstudio.ordermanager.utils;

import java.util.Random;

/**
 * This help class will generate a random Base-36 ID to a new Order
 */
public class RandomIDGenerator {
    private static final String BASE36 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    /**
     * Get a random 4 characters long ID
     * @return String random id
     */
    public static String getRandomID(){
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 4) {
            int index = (int) (rnd.nextFloat() * BASE36.length());
            salt.append(BASE36.charAt(index));
        }
        return salt.toString();
    }
}
