package com.fujitsu.fs.java.pg.generator;

public abstract class AbstractPasswordGenerator implements PasswordGenerator {

    public static final int DEFAULT_LENGTH = 8;

    public String generatePassword() {
        return generatePassword(DEFAULT_LENGTH);
    }

    public String generatePassword(int length) {
        return generatePassword(length, true);
    }

    public String generatePassword(int length, boolean useCase) {
        return generatePassword(length, useCase, true, false, true);
    }

    protected char[] toPrimitiveArray(Character[] array) {
        char[] primitiveArray = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            primitiveArray[i] = array[i];
        }
        return primitiveArray;
    }


}
