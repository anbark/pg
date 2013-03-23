package com.fujitsu.fs.java.pg.generator;

public interface PasswordGenerator {

    String generatePassword();

    String generatePassword(int length);

    String generatePassword(int length, boolean useCase);

    String generatePassword(int length, boolean useCase, boolean useLetters,
            boolean useNumbers, boolean useSpecialSymbols);

    String generatePassword(int length, char[] chars);

}
