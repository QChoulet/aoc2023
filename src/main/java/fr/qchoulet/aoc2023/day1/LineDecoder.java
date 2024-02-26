package fr.qchoulet.aoc2023.day1;

import java.util.Optional;

public class LineDecoder {
    public int decodeLine(String line) {
        // There is probably more elegant/efficient ways to do it,
        // but we need the first and last index for the animation anyway,
        // so we may as well use it here
        int firstDigit = firstDigit(line).getValue();
        int lastDigit = lastDigit(line).getValue();
        return firstDigit * 10 + lastDigit;
    }

    public Digit firstDigit(String line) {
        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(isCharADigit(c)) {
                return new Digit(i, Character.getNumericValue(c));
            }
        }
        return new Digit(-1, 0);
    }

    public Digit lastDigit(String line) {
        for(int i = line.length() - 1; i >= 0; i--) {
            char c = line.charAt(i);
            if(isCharADigit(c)) {
                return new Digit(i, Character.getNumericValue(c));
            }
        }
        return new Digit(-1, 0);
    }

    private boolean isCharADigit(char c) {
        return c >= '0' && c <= '9';
    }
}
