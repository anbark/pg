package com.fujitsu.fs.java.pg.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class SimplePasswordGenerator extends AbstractPasswordGenerator {

    public static final Character[] LETTERS =
        {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'j', 'l', 'm',
         'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static final Character[] LETTERS_UPPERCASE =
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'J', 'L', 'M',
         'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static final Character[] NUMBERS =
        {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static final Character[] SPECIAL_SYMBOLS =
        {'`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '\'', '"',
         ',', '.', ':', '<', '>'};

    public String generatePassword(int length, boolean useCase, boolean useLetters,
            boolean useNumbers, boolean useSpecialSymbols) {
        List<Character> chars = new ArrayList<Character>();
        if (useLetters) {
            chars.addAll((Arrays.asList(LETTERS)));
            if (useCase) {
                chars.addAll(Arrays.asList(LETTERS_UPPERCASE));
            }
        }
        if (useNumbers) {
            chars.addAll((Arrays.asList(NUMBERS)));
        }
        if (useSpecialSymbols) {
            chars.addAll((Arrays.asList(SPECIAL_SYMBOLS)));
        }
        return generatePassword(length, toPrimitiveArray(chars.toArray(new Character[]{})));
    }

    public String generatePassword(int length, char[] chars) {
        StringBuilder password = new StringBuilder(length);
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            password.append(rnd.nextInt(chars.length));
        }
        return password.toString();
    }

}
