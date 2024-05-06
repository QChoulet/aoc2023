package fr.qchoulet.aoc2023.day2;

import java.util.List;

public record Game(int id, List<Set> sets) {
    public record Set(int red, int green, int blue) {
        public int power() {
            return red * green * blue;
        }
    }
}
