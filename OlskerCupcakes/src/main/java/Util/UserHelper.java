package Util;

import java.util.Locale;
import java.util.Random;

/**
 * Genererer et RNG password
 * @author Alexander Pihl, Mick Larsen, Morten Rahbek, Per Kringelbach
 */

public class UserHelper {

    /**
     *
     * @param length bestemmer længden af det genererede kodeord
     * @return randomSTR
     */
    public static String randomCode(int length) {
        char[] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randomStr = sb.toString();

        return randomStr;
    }

}
