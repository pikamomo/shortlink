package com.chi.shortlink.admin.toolkit;

import java.security.SecureRandom;

/**
 * generate random ID
 */
public final class RandomGenerator {

    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * generate random group id
     * @return group id
     */
    public static String generateRandom() {
        return generateRandom(6);
    }

    /**
     * 生成随机分组ID
     * @param length long of id
     */
    public static String generateRandom(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
