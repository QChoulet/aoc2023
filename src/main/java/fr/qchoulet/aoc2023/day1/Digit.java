package fr.qchoulet.aoc2023.day1;

public class Digit {
    private final int indexInString;
    private final int value;

    public Digit(int indexInString, int value) {
        this.indexInString = indexInString;
        this.value = value;
    }

    public int getIndexInString() {
        return indexInString;
    }

    public int getValue() {
        return value;
    }
}
