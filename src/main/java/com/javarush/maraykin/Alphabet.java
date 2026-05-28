package com.javarush.maraykin;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {

    private static final String RUS = "ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    private static final String SYMBOLS = ".,”’:-!? ";
    public static final char[] ALPHABET = (RUS + RUS.toLowerCase() + SYMBOLS).toCharArray();
    public static final int ALPHABET_SIZE = ALPHABET.length;
    public static final Map<Character, Integer> index = new HashMap<>();

    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            index.put(ALPHABET[i], i);
        }
    }

    public static int getPosition(char c) {
        return index.getOrDefault(c, -1);
    }

    public static char getCharAt(int position) {
        int size = ALPHABET_SIZE;
        int normalizedPosition = ((position % size) + size) % size;
        return ALPHABET[normalizedPosition];
    }
}