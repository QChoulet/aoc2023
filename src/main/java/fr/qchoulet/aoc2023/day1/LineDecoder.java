package fr.qchoulet.aoc2023.day1;

import java.util.Optional;

public class LineDecoder {
    public int decodeLine(String line) {
        // There is probably more elegant/efficient ways to do it,
        // but we need the first and last index for the animation anyway,
        // so we may as well use it here
        int firstDigit = firstDigitIndex(line)
                .map(integer -> Character.getNumericValue(line.charAt(integer)))
                .orElse(0);
        int lastDigit = lastDigitIndex(line)
                .map(integer -> Character.getNumericValue(line.charAt(integer)))
                .orElse(0);
        return firstDigit * 10 + lastDigit;
    }

    public Optional<Integer> firstDigitIndex(String line) {
        for(int i = 0; i < line.length(); i++) {
            if(isCharADigit(line.charAt(i))) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public Optional<Integer> lastDigitIndex(String line) {
        for(int i = line.length() - 1; i >= 0; i--) {
            if(isCharADigit(line.charAt(i))) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    private boolean isCharADigit(char c) {
        return c >= '0' && c <= '9';
    }
}
