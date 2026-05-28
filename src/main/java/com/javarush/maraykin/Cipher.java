package com.javarush.maraykin;

public class Cipher {
    private final char[] alphabet;
    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) {
        shift = normalizeShift(shift);
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            int position = Alphabet.getPosition(c);
            if (position != -1) {
                char encryptedChar = Alphabet.getCharAt(position + shift);
                result.append(encryptedChar);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String decrypt(String encryptedText, int shift) {
        shift = normalizeShift(shift);
        return encrypt(encryptedText, -shift);
    }

    private int normalizeShift(int shift) {
        int size = Alphabet.ALPHABET_SIZE;
        return ((shift % size) + size) % size;
    }
}